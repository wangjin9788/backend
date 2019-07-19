package com.plastech.crm.model.parameter;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangJin
 *
 * @date 2019年1月23日 下午4:44:26
 *
 */
public class AddOrUpdateCustomerParameters implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long gid;

  private String cuName;

  private String cuAddress;

  private String note;

  private List<AddOrUpdateLinkmanParameter> linkmanList;

  /**
   * @return the gid
   */
  public Long getGid() {
    return gid;
  }

  /**
   * @param gid the gid to set
   */
  public void setGid(final Long gid) {
    this.gid = gid;
  }

  /**
   * @return the cuName
   */
  public String getCuName() {
    return cuName;
  }

  /**
   * @param cuName the cuName to set
   */
  public void setCuName(final String cuName) {
    this.cuName = cuName;
  }

  /**
   * @return the cuAddress
   */
  public String getCuAddress() {
    return cuAddress;
  }

  /**
   * @param cuAddress the cuAddress to set
   */
  public void setCuAddress(final String cuAddress) {
    this.cuAddress = cuAddress;
  }

  /**
   * @return the linkmanList
   */
  public List<AddOrUpdateLinkmanParameter> getLinkmanList() {
    return linkmanList;
  }

  /**
   * @param linkmanList the linkmanList to set
   */
  public void setLinkmanList(
      final List<AddOrUpdateLinkmanParameter> linkmanList) {
    this.linkmanList = linkmanList;
  }

  /**
   * @return the note
   */
  public String getNote() {
    return note;
  }

  /**
   * @param note the note to set
   */
  public void setNote(final String note) {
    this.note = note;
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
    result = prime * result + ((cuAddress == null) ? 0 : cuAddress.hashCode());
    result = prime * result + ((cuName == null) ? 0 : cuName.hashCode());
    result = prime * result + ((gid == null) ? 0 : gid.hashCode());
    result =
        prime * result + ((linkmanList == null) ? 0 : linkmanList.hashCode());
    result = prime * result + ((note == null) ? 0 : note.hashCode());
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
    final AddOrUpdateCustomerParameters other = (AddOrUpdateCustomerParameters) obj;
    if (cuAddress == null) {
      if (other.cuAddress != null)
        return false;
    } else if (!cuAddress.equals(other.cuAddress))
      return false;
    if (cuName == null) {
      if (other.cuName != null)
        return false;
    } else if (!cuName.equals(other.cuName))
      return false;
    if (gid == null) {
      if (other.gid != null)
        return false;
    } else if (!gid.equals(other.gid))
      return false;
    if (linkmanList == null) {
      if (other.linkmanList != null)
        return false;
    } else if (!linkmanList.equals(other.linkmanList))
      return false;
    if (note == null) {
      if (other.note != null)
        return false;
    } else if (!note.equals(other.note))
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
    return "AddOrUpdateCustomerParameters [gid=" + gid + ", cuName=" + cuName
        + ", cuAddress=" + cuAddress + ", note=" + note + ", linkmanList="
        + linkmanList + "]";
  }

}
