package com.landongnet.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.landongnet.auth.model.entity.Account;
import com.landongnet.auth.model.entity.Menu;

import java.util.List;

/**
 * @author snake
 * @since 2023-08-17
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 查询账号对应的权限
     * @param account
     * @return
     */
    List<Menu> getPermissions(Account account) ;
}
