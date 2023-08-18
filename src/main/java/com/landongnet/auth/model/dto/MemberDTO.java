package com.landongnet.auth.model.dto;


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
@ApiModel("Member传输对象")
public class MemberDTO  implements Serializable {

     private static final long serialVersionUID = 1L;

     @ApiModelProperty(value = "主键")
     private Long id;

     @ApiModelProperty(value = "会员Id")
     private String memberId;

     @ApiModelProperty(value = "手机号")
     private String phone;

     @ApiModelProperty(value = "头像")
     private String avatar;

     @ApiModelProperty(value = "昵称")
     private String nickname;

     @ApiModelProperty(value = "性别(1:男,2,女,3保密)")
     private Integer gender;

     @ApiModelProperty(value = "会员类型")
     private String type;

     @ApiModelProperty(value = "注册时间")
     private LocalDateTime registerTime;

     @ApiModelProperty(value = "创建时间")
     private LocalDateTime createTime;

     @ApiModelProperty(value = "更新时间")
     private LocalDateTime modifyTime;

     @ApiModelProperty(value = "备注")
     private String remark;
}






