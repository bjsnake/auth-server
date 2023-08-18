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
@TableName("org")
public class Org  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("org_id")
    private String orgId;

    /**
     * 上级部门ID
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 组织树路径
     */
    @TableField("org_id_path")
    private String orgIdPath;

    /**
     * 部门名称
     */
    @TableField("org_name")
    private String orgName;

    /**
     * 排序
     */
    @TableField("order_num")
    private Integer orderNum;

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
     * 组织类型(0-租户,1-组织)
     */
    @TableField("type")
    private Integer type;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private String tenantId;


}






