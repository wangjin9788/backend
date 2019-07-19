package com.plastech.crm.model.parameter;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

/**
 * accept the parameters when user login
 *
 * @author : yemin
 * @date : 2018年6月4日 下午4:22:14
 *
 */
public class ChangePasswordParameters implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "old password", required = true,
      example = "P123456789")
  private String oldPassword;

  @ApiModelProperty(value = "new password", required = true,
      example = "K1234567")
  private String newPassword;

  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(final String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(final String newPassword) {
    this.newPassword = newPassword;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result =
        prime * result + ((newPassword == null) ? 0 : newPassword.hashCode());
    result =
        prime * result + ((oldPassword == null) ? 0 : oldPassword.hashCode());
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
    final ChangePasswordParameters other = (ChangePasswordParameters) obj;
    if (newPassword == null) {
      if (other.newPassword != null) {
        return false;
      }
    } else if (!newPassword.equals(other.newPassword)) {
      return false;
    }
    if (oldPassword == null) {
      if (other.oldPassword != null) {
        return false;
      }
    } else if (!oldPassword.equals(other.oldPassword)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ChangePasswordParameters [oldPassword=" + oldPassword
        + ", newPassword=" + newPassword + "]";
  }

}
