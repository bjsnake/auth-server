package com.landongnet.auth.service.impl;

import com.github.snake.rock.common.constants.CommonCons;
import com.github.snake.rock.common.exception.ValidateCodeException;
import com.github.snake.rock.common.utils.RequestUtils;
import com.github.snake.rock.redis.service.ICacheService;
import com.github.snake.rock.web.spring.ApplicationUtils;
import com.landongnet.auth.constants.ImageTypeCons;
import com.landongnet.auth.constants.ParamsCons;
import com.landongnet.auth.security.configuration.properties.AuthProperties;
import com.landongnet.auth.security.configuration.properties.ValidateCodeProperties;
import com.landongnet.auth.service.ValidateCodeService;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author snake
 * @description
 * @since 2023/8/17 15:55
 */
@Service
@RequiredArgsConstructor
public class ValidateCodeServiceImpl implements ValidateCodeService {

    private final ICacheService<String> cacheService;
    private final AuthProperties properties;

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        String key = request.getParameter(ParamsCons.VALIDATE_CODE_KEY);
        if (StringUtils.isBlank(key)) {
            throw new ValidateCodeException("验证码key不能为空");
        }
        ValidateCodeProperties code = properties.getCode();
        setHeader(response, code.getType());

        Captcha captcha = createCaptcha(code);
        cacheService.set(CommonCons.CODE_PREFIX + key, StringUtils.lowerCase(captcha.text()), code.getTime());
        captcha.out(response.getOutputStream());
    }

    @Override
    public void check(String key, String value) throws ValidateCodeException {
        HttpServletRequest httpServletRequest = RequestUtils.getRequest();
        HttpServletResponse httpServletResponse = RequestUtils.getResponse();
        HandlerExceptionResolver handlerExceptionResolver = ApplicationUtils.getBean(HandlerExceptionResolver.class);
        Object codeInRedis = cacheService.get(CommonCons.CODE_PREFIX + key);
        if (StringUtils.isBlank(value)) {
            handlerExceptionResolver.resolveException(httpServletRequest, httpServletResponse,null,new ValidateCodeException("请输入验证码"));
            return;
        }
        if (codeInRedis == null) {
            handlerExceptionResolver.resolveException(httpServletRequest, httpServletResponse,null,new ValidateCodeException("验证码已过期"));
            return;
        }
        if (!StringUtils.equalsIgnoreCase(value, String.valueOf(codeInRedis))) {
            handlerExceptionResolver.resolveException(httpServletRequest, httpServletResponse,null,new ValidateCodeException("验证码不正确"));
            return;
        }
    }

    private Captcha createCaptcha(ValidateCodeProperties code) {
        Captcha captcha = null;
        if (StringUtils.equalsIgnoreCase(code.getType(), ImageTypeCons.GIF)) {
            captcha = new GifCaptcha(code.getWidth(), code.getHeight(), code.getLength());
        } else {
            captcha = new SpecCaptcha(code.getWidth(), code.getHeight(), code.getLength());
        }
        captcha.setCharType(code.getCharType());
        return captcha;
    }

    private void setHeader(HttpServletResponse response, String type) {
        if (StringUtils.equalsIgnoreCase(type, ImageTypeCons.GIF)) {
            response.setContentType(MediaType.IMAGE_GIF_VALUE);
        } else {
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
        }
        response.setHeader(HttpHeaders.PRAGMA, "No-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "No-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, 0L);
    }
}

