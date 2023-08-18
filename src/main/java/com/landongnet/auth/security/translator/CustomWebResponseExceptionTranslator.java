package com.landongnet.auth.security.translator;

import cn.hutool.core.util.StrUtil;
import com.github.snake.rock.web.model.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.*;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author snake
 * @description
 * @since 2023/8/17 16:21
 */
@Slf4j
@Component
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {

    @Override
    public ResponseEntity<R> translate(Exception e) {
        ResponseEntity.BodyBuilder status = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        String message = "认证失败";
        R result = R.builder().build();
        result.setSuccess(Boolean.TRUE);
        result.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        result.setMessage(message);
        log.error(message, e);
        if (e instanceof UnsupportedGrantTypeException) {
            message = "不支持该认证类型";
            result.setMessage(message);
            return status.body(result);
        }
        if (e instanceof InvalidTokenException
                && StrUtil.containsIgnoreCase(e.getMessage(), "Invalid refresh token (expired)")) {
            message = "刷新令牌已过期，请重新登录";
            result.setMessage(message);
            return status.body(result);
        }
        if (e instanceof InvalidScopeException) {
            message = "不是有效的scope值";
            result.setMessage(message);
            return status.body(result);
        }
        if (e instanceof RedirectMismatchException) {
            message = "redirect_uri值不正确";
            result.setMessage(message);
            return status.body(result);
        }
        if (e instanceof BadClientCredentialsException) {
            message = "client值不合法";
            result.setMessage(message);
            return status.body(result);
        }
        if (e instanceof UnsupportedResponseTypeException) {
            String code = StringUtils.substringBetween(e.getMessage(), "[", "]");
            message = code + "不是合法的response_type值";
            result.setMessage(message);
            return status.body(result);
        }
        if (e instanceof InvalidGrantException) {
            if (StringUtils.containsIgnoreCase(e.getMessage(), "Invalid refresh token")) {
                message = "refresh token无效";
                result.setMessage(message);
                return status.body(result);
            }
            if (StringUtils.containsIgnoreCase(e.getMessage(), "Invalid authorization code")) {
                String code = StringUtils.substringAfterLast(e.getMessage(), ": ");
                message = "授权码" + code + "不合法";
                result.setMessage(message);
                return status.body(result);
            }
            if (StringUtils.containsIgnoreCase(e.getMessage(), "locked")) {
                message = "用户已被锁定，请联系管理员";
                result.setMessage(message);
                return status.body(result);
            }
            message = "用户名或密码错误";
            result.setMessage(message);
            return status.body(result);
        }
        return status.body(result);
    }
}

