package com.landongnet.auth.model.dto;


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
@ApiModel("EmpOrg传输对象")
public class EmpOrgDTO  implements Serializable {

     private static final long serialVersionUID = 1L;

     private Long id;

     private String empId;

     private String orgId;

     @ApiModelProperty(value = "租户ID")
     private String tenantId;
}






