package com.landongnet.auth.model.bo;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author snake
 * @since 2023-08-17
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel("EmpOrg业务对象")
public class EmpOrgBO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String empId;

    private String orgId;

    @ApiModelProperty(value = "租户ID")
    private String tenantId;

    public interface Insert {}

    public interface Update {}

}






