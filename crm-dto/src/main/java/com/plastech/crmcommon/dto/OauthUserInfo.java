package com.plastech.crmcommon.dto;

import java.io.Serializable;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月8日 下午4:56:25
 *
 */
public class OauthUserInfo implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public OauthUserInfo() {
    super();
  }

  public OauthUserInfo(final Long uid, final String uname, final String unumber) {
    super();
    this.uid = uid;
    this.uname = uname;
    this.unumber = unumber;
  }

  private Long uid;
  private String uname;
  private String unumber;

  public final Long getUid() {
    return uid;
  }

  public final void setUid(final Long uid) {
    this.uid = uid;
  }

  public final String getUname() {
    return uname;
  }

  public final void setUname(final String uname) {
    this.uname = uname;
  }

  public final String getUnumber() {
    return unumber;
  }

  public final void setUnumber(final String unumber) {
    this.unumber = unumber;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((uid == null) ? 0 : uid.hashCode());
    result = prime * result + ((uname == null) ? 0 : uname.hashCode());
    result = prime * result + ((unumber == null) ? 0 : unumber.hashCode());
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
    final OauthUserInfo other = (OauthUserInfo) obj;
    if (uid == null) {
      if (other.uid != null) {
        return false;
      }
    } else if (!uid.equals(other.uid)) {
      return false;
    }
    if (uname == null) {
      if (other.uname != null) {
        return false;
      }
    } else if (!uname.equals(other.uname)) {
      return false;
    }
    if (unumber == null) {
      if (other.unumber != null) {
        return false;
      }
    } else if (!unumber.equals(other.unumber)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "OauthUserInfo [uid=" + uid + ", uname=" + uname + ", unumber="
        + unumber + "]";
  }

}
