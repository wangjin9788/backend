package com.plastech.crm.model.vo;

import java.io.Serializable;

public class RoleView implements Serializable {

  private Long roleid;

  private String rolename;

  private String code;

  private static final long serialVersionUID = 1L;

  public final String getCode() {
    return code;
  }

  public final void setCode(final String code) {
    this.code = code;
  }

  public final Long getRoleid() {
    return roleid;
  }

  public final void setRoleid(final Long roleid) {
    this.roleid = roleid;
  }

  public final String getRolename() {
    return rolename;
  }

  public final void setRolename(final String rolename) {
    this.rolename = rolename;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((roleid == null) ? 0 : roleid.hashCode());
    result = prime * result + ((rolename == null) ? 0 : rolename.hashCode());
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
    final RoleView other = (RoleView) obj;
    if (roleid == null) {
      if (other.roleid != null) {
        return false;
      }
    } else if (!roleid.equals(other.roleid)) {
      return false;
    }
    if (rolename == null) {
      if (other.rolename != null) {
        return false;
      }
    } else if (!rolename.equals(other.rolename)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "RoleView [roleid=" + roleid + ", rolename=" + rolename + "]";
  }

}
