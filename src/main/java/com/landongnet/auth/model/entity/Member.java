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
@TableName("member")
public class Member  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 会员Id
     */
    @TableField("member_id")
    private String memberId;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 性别(1:男,2,女,3保密)
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 会员类型
     */
    @TableField("type")
    private String type;

    /**
     * 注册时间
     */
    @TableField("register_time")
    private LocalDateTime registerTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}






