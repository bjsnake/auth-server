package com.landongnet.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.snake.rock.common.exception.ServiceException;
import com.github.snake.rock.web.exception.BizException;
import com.landongnet.auth.enums.ChannelEnum;
import com.landongnet.auth.enums.SupperAdminEnum;
import com.landongnet.auth.mapper.MenuMapper;
import com.landongnet.auth.model.entity.Account;
import com.landongnet.auth.model.entity.Menu;
import com.landongnet.auth.service.IMenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author snake
 * @since 2023-08-17
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    private final MenuMapper menuMapper;

    @Override
    public List<Menu> getPermissions(Account account) {
        if(account.getChannel().equals(ChannelEnum.EMP.getCode())){
            if(account.getSupperAdmin().equals(SupperAdminEnum.SUPPER.getCode())){
                return menuMapper.getPermissionsBySupperAdmin(account.getTenantId());
            }else{
                return menuMapper.getPermissionsByEmpId(account.getTenantId(),account.getUserId());
            }
        }else{
            throw new BizException("不支持非员工权限查询");
        }
    }
}
