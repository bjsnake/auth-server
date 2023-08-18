package com.landongnet.auth.security.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;

/**
 * @author snake
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AuthUser extends User {

  private String tenantId;

  private Integer channel;

  private String userId;

  private String realName;

  private String avatar;

  private String email;

  private String mobile;

  private Integer gender;

  private Date lastLoginTime;

  private Integer status;

  private String orgIds;

  private String roleIds;

  public AuthUser(String tenantId, Integer channel, String username, String password, String  avatar, Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
    this.tenantId = tenantId;
    this.channel = channel;
    this.avatar = avatar;
  }

  public AuthUser(String tenantId,Integer channel,String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    this.tenantId = tenantId;
    this.channel = channel;
  }
}
