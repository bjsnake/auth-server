package com.landongnet.auth.security.aspect;

import com.github.snake.rock.web.model.R;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AuthAspectAround {

  @Around("execution(* org.springframework.security.oauth2.provider.endpoint.TokenEndpoint.postAccessToken(..))")
  public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
    // 放行
    R result = new R();
    Object proceed = pjp.proceed();
    if (proceed != null) {
      ResponseEntity<OAuth2AccessToken> responseEntity = (ResponseEntity<OAuth2AccessToken>)proceed;
      OAuth2AccessToken body = responseEntity.getBody();
      if (responseEntity.getStatusCode().is2xxSuccessful()) {
        result =  R.success(body);
      } else {
        log.error("error:{}", responseEntity.getStatusCode());
        result.setCode(400);
        result.setMessage("授权失败");
      }
    }
    return ResponseEntity.status(200).body(result);
  }
}