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
@ApiModel("Emp业务对象")
public class EmpBO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String empId;

    private String avatar;

    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    private String personId;

    private String tenantId;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    public interface Insert {}

    public interface Update {}

}






