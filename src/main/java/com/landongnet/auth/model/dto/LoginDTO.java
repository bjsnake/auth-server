package com.landongnet.auth.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "登录响应结果")
@Accessors(chain = true)
public class LoginDTO  {

  @ApiModelProperty("访问令牌")
  @JsonAlias("access_token")
  private String accessToken;

  @ApiModelProperty("令牌类型")
  @JsonAlias("token_type")
  private String tokenType;

  @ApiModelProperty("刷新令牌")
  @JsonAlias("refresh_token")
  private String refreshToken;

  @ApiModelProperty("令牌有效时长")
  @JsonAlias("expires_in")
  private Long expiresIn;

  @ApiModelProperty("授权范围")
  private String scope;

  private String jti;
}