package com.landongnet.auth.service;

import com.landongnet.auth.model.bo.EmpLoginBO;
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
    LoginDTO login(EmpLoginBO loginBO);

    /**
     * web端刷新token
     * @param refreshToken
     * @return
     */
    LoginDTO refreshToken(String refreshToken);
}
