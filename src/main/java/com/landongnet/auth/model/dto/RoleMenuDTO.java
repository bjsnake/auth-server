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
@ApiModel("RoleMenu传输对象")
public class RoleMenuDTO  implements Serializable {

     private static final long serialVersionUID = 1L;

     @ApiModelProperty(value = "主键")
     private Long id;

     private String roleId;

     private String menuId;

     private String tenantId;
}






