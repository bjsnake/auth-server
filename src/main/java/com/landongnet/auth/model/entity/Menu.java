package com.landongnet.auth.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author snake
 * @since 2023-08-17
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("menu")
public class Menu  implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜单/按钮ID
     */
    @TableField("menu_id")
    private String menuId;

    /**
     * 上级菜单ID
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 菜单/按钮名称
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 对应路由path
     */
    @TableField("path")
    private String path;

    /**
     * 对应路由组件component
     */
    @TableField("component")
    private String component;

    /**
     * 权限标识
     */
    @TableField("perms")
    private String perms;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 类型 0菜单 1按钮,2目录
     */
    @TableField("type")
    private Integer type;

    /**
     * 排序
     */
    @TableField("order_num")
    private Long orderNum;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

    @TableField("tenant_id")
    private String tenantId;


}






