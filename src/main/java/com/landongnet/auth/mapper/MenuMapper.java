package com.landongnet.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.landongnet.auth.model.dto.MenuDTO;
import com.landongnet.auth.model.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author snake
 * @since 2023-08-17
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据员工ID查询权限信息
     * @param tenantId
     * @param empId
     * @return
     */
    List<Menu> getPermissionsByEmpId(@Param("tenantId") String tenantId, @Param("empId") String empId);

    /**
     * 查询超级管理员权限信息
     * @param tenantId
     * @return
     */
    List<Menu> getPermissionsBySupperAdmin(@Param("tenantId") String tenantId);
}
