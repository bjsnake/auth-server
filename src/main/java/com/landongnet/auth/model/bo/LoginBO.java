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
public class LoginBO {

  @ApiModelProperty("账号")
  @NotBlank(message = "请输入账号",groups = {Login.class})
  private String username;

  @ApiModelProperty("密码")
  @NotBlank(message = "请输入密码",groups = {Login.class})
  private String password;

  @ApiModelProperty("渠道")
  private Integer channel;

  @ApiModelProperty("登录方式")
  private Integer logWay;

  @ApiModelProperty("用户授权码")
  private String code;

  @ApiModelProperty("微信appId")
  private String appId;

  public interface Login{

  }
}
