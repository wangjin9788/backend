package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * authority
 *
 * @author : yemin
 * @date : 2018年12月25日 下午5:41:20
 *
 */
public class Authority implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String uri;// 请求url（正则）
  private String method;// 请求方式
  private String roles;// 多个角色，以逗号分隔
  private Integer tokenPermissive;// 0：校验token且必须校验通过，1：校验token但允许校验不通过，2：不会去校验token

  public final String getMethod() {
    return method;
  }

  public final void setMethod(final String method) {
    this.method = method;
  }

  public final Integer getTokenPermissive() {
    return tokenPermissive;
  }

  public final void setTokenPermissive(final Integer tokenPermissive) {
    this.tokenPermissive = tokenPermissive != null ? tokenPermissive : 0;
  }

  public final String getUri() {
    return uri;
  }

  public final void setUri(final String uri) {
    this.uri = uri;
  }

  public final String getRoles() {
    return roles;
  }

  public final void setRoles(final String roles) {
    this.roles = roles;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((roles == null) ? 0 : roles.hashCode());
    result = prime * result + ((uri == null) ? 0 : uri.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Authority other = (Authority) obj;
    if (roles == null) {
      if (other.roles != null) {
        return false;
      }
    } else if (!roles.equals(other.roles)) {
      return false;
    }
    if (uri == null) {
      if (other.uri != null) {
        return false;
      }
    } else if (!uri.equals(other.uri)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Authority [uri=" + uri + ", roles=" + roles + "]";
  }

}
