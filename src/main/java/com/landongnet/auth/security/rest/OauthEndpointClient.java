package com.landongnet.auth.security.rest;

import com.github.snake.rock.security.constant.EndpointConstant;
import com.github.snake.rock.web.model.R;
import com.landongnet.auth.constants.ServiceNameCons;
import com.landongnet.auth.model.dto.LoginDTO;
import feign.Logger;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

/**
 * @author snake
 */
@FeignClient(name = ServiceNameCons.AUTH_SERVER,configuration = OauthEndpointClient.FormSupportConfig.class)
public interface OauthEndpointClient {

  /**
   * 获取token
   * @param token
   * @param queryParam
   * @return
   */
  @PostMapping(value = EndpointConstant.OAUTH_TOKEN,
    consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE}
  )
  ResponseEntity<R<LoginDTO>> oauthToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, Map<String, ?> queryParam);


  class FormSupportConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;
    // new一个form编码器，实现支持form表单提交
    @Bean
    public Encoder feignFormEncoder() {
      return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }
    // 开启Feign的日志
    @Bean
    public Logger.Level logger() {
      return Logger.Level.FULL;
    }
  }


}
