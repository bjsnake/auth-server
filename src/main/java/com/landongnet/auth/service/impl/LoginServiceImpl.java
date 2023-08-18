package com.landongnet.auth.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.snake.rock.common.exception.BaseException;
import com.github.snake.rock.common.utils.RequestUtils;
import com.github.snake.rock.common.utils.ResponseUtils;
import com.github.snake.rock.security.constant.GrantTypeConstant;
import com.github.snake.rock.web.model.R;
import com.github.snake.rock.web.utils.ApiResultUtils;
import com.landongnet.auth.constants.OauthClientCons;
import com.landongnet.auth.constants.ParamsCons;
import com.landongnet.auth.model.bo.LoginBO;
import com.landongnet.auth.model.dto.LoginDTO;
import com.landongnet.auth.security.rest.OauthEndpointClient;
import com.landongnet.auth.service.LoginService;
import com.landongnet.auth.utils.BasicUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author snake
 * @description
 * @since 2023/8/17 22:24
 */
@Slf4j
@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final OauthEndpointClient oauthEndpointClient;

    @Override
    public LoginDTO login(LoginBO loginBO) {
        Map<String,String> map = new HashMap<>();
        map.put("username",loginBO.getUsername());
        map.put("password",loginBO.getPassword());
        map.put(ParamsCons.GRANT_TYPE, GrantTypeConstant.PASSWORD);
        String basicToken = BasicUtil.encode(OauthClientCons.PC_CLIENT_ID, OauthClientCons.PC_CLIENT_ID);
        ResponseEntity<R<LoginDTO>> responseEntity = oauthEndpointClient.oauthToken(basicToken,map);
        if(responseEntity.getStatusCode().value()!=HttpServletResponse.SC_OK){
            ResponseUtils.writeValueAsJson(RequestUtils.getResponse(),R.error(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"获取token异常"));
        }
        return ApiResultUtils.getResultData(responseEntity.getBody());
    }

    @Override
    public LoginDTO refreshToken(String refreshToken) {
        Map<String,String> map = new HashMap<>();
        map.put("grant_type",GrantTypeConstant.REFRESH_TOKEN);
        map.put("refresh_token", refreshToken.replace("bearer","").trim());
        String basicToken = BasicUtil.encode(OauthClientCons.PC_CLIENT_ID, OauthClientCons.PC_CLIENT_ID);
        ResponseEntity<R<LoginDTO>> responseEntity = oauthEndpointClient.oauthToken(basicToken,map);
        R<LoginDTO> body = responseEntity.getBody();
        if(responseEntity.getStatusCode().value()==HttpServletResponse.SC_INTERNAL_SERVER_ERROR){
            throw new BaseException("刷新token失败");
        }
        return body.getData();
    }
}

