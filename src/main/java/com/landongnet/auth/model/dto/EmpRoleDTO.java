package com.landongnet.auth.model.dto;


import io.swagger.annotations.ApiModel;
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
@ApiModel("EmpRole传输对象")
public class EmpRoleDTO  implements Serializable {

     private static final long serialVersionUID = 1L;

     private Long id;

     private String empId;

     private String roleId;

     private String tenantId;
}






