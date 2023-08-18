package com.landongnet.auth.model.bo;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author snake
 * @since 2023-08-17
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel("Account业务对象")
public class AccountBO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String tenantId;

    @ApiModelProperty(value = "用户ID(会员/员工)")
    private String userId;

    private String account;

    private String password;

    @ApiModelProperty(value = "是否默认租户")
    private Integer defaultTenant;

    @ApiModelProperty(value = "是否锁定(0-否，1-是)")
    private Integer status;

    private String personId;

    @ApiModelProperty(value = "微信appId")
    private String appId;

    @ApiModelProperty(value = "第三方登录授权openId")
    private String openId;

    @ApiModelProperty(value = "账号渠道（1:员工，2：会员）")
    private Integer channel;

    @ApiModelProperty(value = "登录方式（1:PC,2:微信小程序，3:公众号，4：APP）")
    private Integer loginWay;

    @ApiModelProperty(value = "是否租户超级管理员(1-是,0-否)")
    private Integer supperAdmin;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifyTime;

    @ApiModelProperty(value = "最后登录时间")
    private LocalDateTime lastLoginTime;

    public interface Insert {}

    public interface Update {}

}






