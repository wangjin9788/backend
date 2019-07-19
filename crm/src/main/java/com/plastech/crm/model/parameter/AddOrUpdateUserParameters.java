package com.plastech.crm.model.parameter;

import java.io.Serializable;

/**
 * @author 王进
 *
 */
public class AddOrUpdateUserParameters implements Serializable {

  private static final long serialVersionUID = 1L;
  private String name;
  private Long roleId;
  private String roleName;
  private String mail;
  private String phone;


  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * @return the roleId
   */
  public Long getRoleId() {
    return roleId;
  }

  /**
   * @param roleId the roleId to set
   */
  public void setRoleId(final Long roleId) {
    this.roleId = roleId;
  }

  /**
   * @return the mail
   */
  public String getMail() {
    return mail;
  }

  /**
   * @param mail the mail to set
   */
  public void setMail(final String mail) {
    this.mail = mail;
  }

  /**
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * @param phone the phone to set
   */
  public void setPhone(final String phone) {
    this.phone = phone;
  }

  /**
   * @return the roleName
   */
  public String getRoleName() {
    return roleName;
  }

  /**
   * @param roleName the roleName to set
   */
  public void setRoleName(final String roleName) {
    this.roleName = roleName;
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
    result = prime * result + ((mail == null) ? 0 : mail.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((phone == null) ? 0 : phone.hashCode());
    result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
    result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
    final AddOrUpdateUserParameters other = (AddOrUpdateUserParameters) obj;
    if (mail == null) {
      if (other.mail != null)
        return false;
    } else if (!mail.equals(other.mail))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (phone == null) {
      if (other.phone != null)
        return false;
    } else if (!phone.equals(other.phone))
      return false;
    if (roleId == null) {
      if (other.roleId != null)
        return false;
    } else if (!roleId.equals(other.roleId))
      return false;
    if (roleName == null) {
      if (other.roleName != null)
        return false;
    } else if (!roleName.equals(other.roleName))
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
    return "AddOrUpdateUserParameters [name=" + name + ", roleId=" + roleId
        + ", roleName=" + roleName + ", mail=" + mail + ", phone=" + phone
        + "]";
  }


}
