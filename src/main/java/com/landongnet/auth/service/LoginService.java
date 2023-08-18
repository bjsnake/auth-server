package com.landongnet.auth.service;

import com.landongnet.auth.model.bo.LoginBO;
import com.landongnet.auth.model.dto.LoginDTO;

/**
 * @author snake
 * @description
 * @since 2023/8/17 22:22
 */
public interface LoginService {

    /**
     * web端登录
     * @param loginBO
     * @return
     */
    LoginDTO login(LoginBO loginBO);

    /**
     * web端刷新token
     * @param refreshToken
     * @return
     */
    LoginDTO refreshToken(String refreshToken);
}
