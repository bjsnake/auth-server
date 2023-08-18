package com.landongnet.auth.security.service;

import com.github.snake.rock.common.constants.StringPool;
import com.landongnet.auth.enums.AccountStatusEnum;
import com.landongnet.auth.mapper.AccountMapper;
import com.landongnet.auth.mapper.MenuMapper;
import com.landongnet.auth.model.entity.Account;
import com.landongnet.auth.model.entity.Menu;
import com.landongnet.auth.security.model.AuthUser;
import com.landongnet.auth.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * @author snake
 * @description
 * @since 2023/8/17 22:37
 */
@Service
@RequiredArgsConstructor
public class UsernameAndPwdUserDetailsService implements UserDetailsService {

    private final AccountMapper accountMapper;

    private final IMenuService menuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 查询默认账号
        Account defaultAccount = accountMapper.getEmpDefaultAccount(username);
        if(Objects.isNull(defaultAccount)){
            throw new UsernameNotFoundException("账号不存在");
        }
        // 根据员工查询权限信息
        List<Menu> menus = menuService.getPermissions(defaultAccount);
        String permissions = menus.stream().map(Menu::getPerms).collect(Collectors.joining(StringPool.COMMA));
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.NO_AUTHORITIES;
        if (StringUtils.isNotBlank(permissions)) {
            grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(permissions);
        }
        Boolean notLocked = defaultAccount.getStatus().equals(AccountStatusEnum.NORMAL.getCode())?Boolean.TRUE:Boolean.FALSE;
        AuthUser authUser = new AuthUser(defaultAccount.getTenantId(),defaultAccount.getChannel(),defaultAccount.getAccount(), defaultAccount.getPassword(), true, true, true, notLocked, grantedAuthorities);
        return authUser;
    }

}
