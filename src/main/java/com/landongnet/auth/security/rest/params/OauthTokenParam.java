package com.landongnet.auth.security.rest.params;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author snake
 */
@Data
@Accessors(chain = true)
public class OauthTokenParam {

  private String username;

  private String password;

  @JsonProperty("grant_type")
  private String grantType;
}