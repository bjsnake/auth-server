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
@TableName("account")
public class Account  implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("tenant_id")
    private String tenantId;

    /**
     * 用户ID(会员/员工)
     */
    @TableField("user_id")
    private String userId;

    @TableField("account")
    private String account;

    @TableField("password")
    private String password;

    /**
     * 是否默认租户
     */
    @TableField("default_tenant")
    private Integer defaultTenant;

    /**
     * 是否锁定(0-否，1-是)
     */
    @TableField("status")
    private Integer status;

    @TableField("person_id")
    private String personId;

    /**
     * 微信appId
     */
    @TableField("app_id")
    private String appId;

    /**
     * 第三方登录授权openId
     */
    @TableField("open_id")
    private String openId;

    /**
     * 账号渠道（1:员工，2：会员）
     */
    @TableField("channel")
    private Integer channel;

    /**
     * 登录方式（1:PC,2:微信小程序，3:公众号，4：APP）
     */
    @TableField("login_way")
    private Integer loginWay;

    /**
     * 是否租户超级管理员(1-是,0-否)
     */
    @TableField("supper_admin")
    private Integer supperAdmin;

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

    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;


}






