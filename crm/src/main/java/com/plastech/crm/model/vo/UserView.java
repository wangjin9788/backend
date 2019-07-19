package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * user info for app
 *
 * @author yemin
 *
 */
public class UserView implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long uid;
  private String uname;
  private String uphone;
  private String umail;
  private String position;
  private String ustatus;
  private Long roleid;
  private String rolename;

  private String unumber;
  private String token;
  private String ucode;
  private String pwd;

  /**
   * @return the uid
   */
  public Long getUid() {
    return uid;
  }

  /**
   * @param uid the uid to set
   */
  public void setUid(final Long uid) {
    this.uid = uid;
  }

  /**
   * @return the uname
   */
  public String getUname() {
    return uname;
  }

  /**
   * @param uname the uname to set
   */
  public void setUname(final String uname) {
    this.uname = uname;
  }

  /**
   * @param uphone the uphone to set
   */
  public void setUphone(final String uphone) {
    this.uphone = uphone;
  }

  /**
   * @return the uphone
   */
  public String getUphone() {
    return uphone;
  }

  /**
   * @return the umail
   */
  public String getUmail() {
    return umail;
  }

  /**
   * @return the position
   */
  public String getPosition() {
    return position;
  }

  /**
   * @param umail the umail to set
   */
  public void setUmail(final String umail) {
    this.umail = umail;
  }

  /**
   * @param position the position to set
   */
  public void setPosition(final String position) {
    this.position = position;
  }

  /**
   * @return the ustatus
   */
  public String getUstatus() {
    return ustatus;
  }

  /**
   * @param ustatus the ustatus to set
   */
  public void setUstatus(final String ustatus) {
    this.ustatus = ustatus;
  }

  /**
   * @return the rolename
   */
  public String getRolename() {
    return rolename;
  }

  /**
   * @param rolename the rolename to set
   */
  public void setRolename(final String rolename) {
    this.rolename = rolename;
  }

  /**
   * @return the unumber
   */
  public String getUnumber() {
    return unumber;
  }

  /**
   * @param unumber the unumber to set
   */
  public void setUnumber(final String unumber) {
    this.unumber = unumber;
  }

  /**
   * @return the token
   */
  public String getToken() {
    return token;
  }

  /**
   * @param token the token to set
   */
  public void setToken(final String token) {
    this.token = token;
  }

  /**
   * @return the ucode
   */
  public String getUcode() {
    return ucode;
  }

  /**
   * @param ucode the ucode to set
   */
  public void setUcode(final String ucode) {
    this.ucode = ucode;
  }

  /**
   * @return the pwd
   */
  public String getPwd() {
    return pwd;
  }

  /**
   * @param pwd the pwd to set
   */
  public void setPwd(final String pwd) {
    this.pwd = pwd;
  }

  /**
   * @return the roleid
   */
  public Long getRoleid() {
    return roleid;
  }

  /**
   * @param roleid the roleid to set
   */
  public void setRoleid(final Long roleid) {
    this.roleid = roleid;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((position == null) ? 0 : position.hashCode());
    result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
    result = prime * result + ((roleid == null) ? 0 : roleid.hashCode());
    result = prime * result + ((rolename == null) ? 0 : rolename.hashCode());
    result = prime * result + ((token == null) ? 0 : token.hashCode());
    result = prime * result + ((ucode == null) ? 0 : ucode.hashCode());
    result = prime * result + ((uid == null) ? 0 : uid.hashCode());
    result = prime * result + ((umail == null) ? 0 : umail.hashCode());
    result = prime * result + ((uname == null) ? 0 : uname.hashCode());
    result = prime * result + ((unumber == null) ? 0 : unumber.hashCode());
    result = prime * result + ((uphone == null) ? 0 : uphone.hashCode());
    result = prime * result + ((ustatus == null) ? 0 : ustatus.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final UserView other = (UserView) obj;
    if (position == null) {
      if (other.position != null)
        return false;
    } else if (!position.equals(other.position))
      return false;
    if (pwd == null) {
      if (other.pwd != null)
        return false;
    } else if (!pwd.equals(other.pwd))
      return false;
    if (roleid == null) {
      if (other.roleid != null)
        return false;
    } else if (!roleid.equals(other.roleid))
      return false;
    if (rolename == null) {
      if (other.rolename != null)
        return false;
    } else if (!rolename.equals(other.rolename))
      return false;
    if (token == null) {
      if (other.token != null)
        return false;
    } else if (!token.equals(other.token))
      return false;
    if (ucode == null) {
      if (other.ucode != null)
        return false;
    } else if (!ucode.equals(other.ucode))
      return false;
    if (uid == null) {
      if (other.uid != null)
        return false;
    } else if (!uid.equals(other.uid))
      return false;
    if (umail == null) {
      if (other.umail != null)
        return false;
    } else if (!umail.equals(other.umail))
      return false;
    if (uname == null) {
      if (other.uname != null)
        return false;
    } else if (!uname.equals(other.uname))
      return false;
    if (unumber == null) {
      if (other.unumber != null)
        return false;
    } else if (!unumber.equals(other.unumber))
      return false;
    if (uphone == null) {
      if (other.uphone != null)
        return false;
    } else if (!uphone.equals(other.uphone))
      return false;
    if (ustatus == null) {
      if (other.ustatus != null)
        return false;
    } else if (!ustatus.equals(other.ustatus))
      return false;
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "UserView [uid=" + uid + ", uname=" + uname + ", uphone=" + uphone
        + ", umail=" + umail + ", position=" + position + ", ustatus=" + ustatus
        + ", roleid=" + roleid + ", rolename=" + rolename + ", unumber="
        + unumber + ", token=" + token + ", ucode=" + ucode + ", pwd=" + pwd
        + "]";
  }



}
