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
public final class WebLoginParameters implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "ucode", example = "idpzfk007")
  private String ucode;

  @ApiModelProperty(value = "password", example = "R234658778")
  private String password;

  @ApiModelProperty(value = "user language code", example = "HK")
  private String language;

  public WebLoginParameters() {
    super();
  }

  public WebLoginParameters(final String ucode, final String password,
      final String language) {
    super();
    this.ucode = ucode;
    this.password = password;
    this.language = language;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(final String language) {
    this.language = language;
  }

  public String getUcode() {
    return ucode;
  }

  public void setUcode(final String ucode) {
    this.ucode = ucode;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((language == null) ? 0 : language.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((ucode == null) ? 0 : ucode.hashCode());
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
    final WebLoginParameters other = (WebLoginParameters) obj;
    if (language == null) {
      if (other.language != null) {
        return false;
      }
    } else if (!language.equals(other.language)) {
      return false;
    }
    if (password == null) {
      if (other.password != null) {
        return false;
      }
    } else if (!password.equals(other.password)) {
      return false;
    }
    if (ucode == null) {
      if (other.ucode != null) {
        return false;
      }
    } else if (!ucode.equals(other.ucode)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "WebLoginParameters [ucode=" + ucode + ", password=" + password
        + ", language=" + language + "]";
  }

}
