package com.landongnet.auth.filter;

import com.github.snake.rock.common.exception.ValidateCodeException;
import com.github.snake.rock.security.constant.EndpointConstant;
import com.github.snake.rock.security.constant.GrantTypeConstant;
import com.landongnet.auth.constants.ParamsCons;
import com.landongnet.auth.service.ValidateCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.annotation.Nonnull;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码过滤器
 * @author snake
 * @since 2023/8/17 15:44
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ValidateCodeFilter extends OncePerRequestFilter {
    private final ValidateCodeService validateCodeService;

    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest httpServletRequest, @Nonnull HttpServletResponse httpServletResponse,
                                    @Nonnull FilterChain filterChain) throws ServletException, IOException {
        RequestMatcher matcher = new AntPathRequestMatcher(EndpointConstant.OAUTH_TOKEN, HttpMethod.POST.toString());
        if(matcher.matches(httpServletRequest) && StringUtils.equalsIgnoreCase(httpServletRequest.getParameter(ParamsCons.GRANT_TYPE), GrantTypeConstant.PASSWORD)) {
            //验证码校验
//            validateCode(httpServletRequest);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }else{
            filterChain.doFilter(httpServletRequest, httpServletResponse);

        }
    }

    private void  validateCode(HttpServletRequest httpServletRequest) throws ValidateCodeException {
        String code = httpServletRequest.getParameter(ParamsCons.VALIDATE_CODE_CODE);
        String key = httpServletRequest.getParameter(ParamsCons.VALIDATE_CODE_KEY);
        validateCodeService.check(key, code);

    }
}

