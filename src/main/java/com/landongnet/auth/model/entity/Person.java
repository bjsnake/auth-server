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
@TableName("person")
public class Person  implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 自然人ID
     */
    @TableField("person_id")
    private String personId;

    /**
     * 联系电话
     */
    @TableField("mobile")
    private String mobile;

    @TableField("gender")
    private Integer gender;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    @TableField("tenant_id")
    private String tenantId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;


}






