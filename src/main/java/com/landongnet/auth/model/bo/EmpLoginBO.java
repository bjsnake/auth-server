package com.landongnet.auth.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @author snake
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "登录请求参数")
@Accessors(chain = true)
public class EmpLoginBO {

  @ApiModelProperty("账号")
  @NotBlank(message = "请输入账号",groups = {EmpLoginBO.class})
  private String username;

  @ApiModelProperty("密码")
  @NotBlank(message = "请输入密码",groups = {EmpLoginBO.class})
  private String password;

  @ApiModelProperty("渠道")
  private Integer channel;

  @ApiModelProperty("登录方式")
  private Integer logWay;

  public interface Login{

  }
}
