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
@ApiModel("Org业务对象")
public class OrgBO  implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    private String orgId;

    @ApiModelProperty(value = "上级部门ID")
    private String parentId;

    @ApiModelProperty(value = "组织树路径")
    private String orgIdPath;

    @ApiModelProperty(value = "部门名称")
    private String orgName;

    @ApiModelProperty(value = "排序")
    private Integer orderNum;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifyTime;

    @ApiModelProperty(value = "组织类型(0-租户,1-组织)")
    private Integer type;

    @ApiModelProperty(value = "租户ID")
    private String tenantId;

    public interface Insert {}

    public interface Update {}

}






