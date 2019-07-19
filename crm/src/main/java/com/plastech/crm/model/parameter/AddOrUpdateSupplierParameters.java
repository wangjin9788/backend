package com.plastech.crm.model.parameter;

import java.io.Serializable;
import java.util.List;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月14日 下午1:27:49
 *
 */
public class AddOrUpdateSupplierParameters implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String suName;// 供应商名称

  private String suAddress;// 地址

  private String note;// 备注

  private String fullName;

  private List<AddOrUpdateLinkmanParameter> linkmanList;

  /**
   * @return the suName
   */
  public String getSuName() {
    return suName;
  }

  /**
   * @param suName the suName to set
   */
  public void setSuName(final String suName) {
    this.suName = suName;
  }

  /**
   * @return the suAddress
   */
  public String getSuAddress() {
    return suAddress;
  }

  /**
   * @param suAddress the suAddress to set
   */
  public void setSuAddress(final String suAddress) {
    this.suAddress = suAddress;
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
   * @return the fullName
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * @param fullName the fullName to set
   */
  public void setFullName(final String fullName) {
    this.fullName = fullName;
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
    result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
    result =
        prime * result + ((linkmanList == null) ? 0 : linkmanList.hashCode());
    result = prime * result + ((note == null) ? 0 : note.hashCode());
    result = prime * result + ((suAddress == null) ? 0 : suAddress.hashCode());
    result = prime * result + ((suName == null) ? 0 : suName.hashCode());
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
    final AddOrUpdateSupplierParameters other = (AddOrUpdateSupplierParameters) obj;
    if (fullName == null) {
      if (other.fullName != null)
        return false;
    } else if (!fullName.equals(other.fullName))
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
    if (suAddress == null) {
      if (other.suAddress != null)
        return false;
    } else if (!suAddress.equals(other.suAddress))
      return false;
    if (suName == null) {
      if (other.suName != null)
        return false;
    } else if (!suName.equals(other.suName))
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
    return "AddOrUpdateSupplierParameters [suName=" + suName + ", suAddress="
        + suAddress + ", note=" + note + ", fullName=" + fullName
        + ", linkmanList=" + linkmanList + "]";
  }



}
