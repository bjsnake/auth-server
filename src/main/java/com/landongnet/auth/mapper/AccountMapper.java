package com.landongnet.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.landongnet.auth.model.entity.Account;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author snake
 * @since 2023-08-17
 */
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 获取默认员工账号
     * @param account
     * @param account
     * @return
     */
    Account getEmpDefaultAccount(@Param("account") String account);
}
