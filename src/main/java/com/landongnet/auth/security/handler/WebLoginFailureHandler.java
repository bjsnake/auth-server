package com.landongnet.auth.security.handler;

import com.github.snake.rock.common.utils.ResponseUtils;
import com.github.snake.rock.web.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author snake
 * @description
 * @since 2023/8/17 16:24
 */
@Slf4j
@Component
public class WebLoginFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String message;
        if (exception instanceof BadCredentialsException) {
            message = "用户名或密码错误！";
        } else if (exception instanceof LockedException) {
            message = "用户已被锁定！";
        } else {
            message = "认证失败，请联系网站管理员！";
        }
        R<Object> build = R.builder().code(400).message(message).build();
        ResponseUtils.writeValueAsJson(response, build);
    }
}
