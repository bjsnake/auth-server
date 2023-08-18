package com.landongnet.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.landongnet.auth.mapper.AccountMapper;
import com.landongnet.auth.model.entity.Account;
import com.landongnet.auth.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author snake
 * @since 2023-08-17
 */
@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
