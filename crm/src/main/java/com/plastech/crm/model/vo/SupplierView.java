package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月10日 下午5:07:44
 *
 */
public class SupplierView implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private Long suid;

  private String suName;

  private String companyName;

  private Integer linkmanCount;

  private Integer status;

  private String note;

  private String fullName;

  private String address;

  /**
   * @return the suid
   */
  public Long getSuid() {
    return suid;
  }

  /**
   * @param suid the suid to set
   */
  public void setSuid(Long suid) {
    this.suid = suid;
  }

  /**
   * @return the suName
   */
  public String getSuName() {
    return suName;
  }

  /**
   * @param suName the suName to set
   */
  public void setSuName(String suName) {
    this.suName = suName;
  }

  /**
   * @return the companyName
   */
  public String getCompanyName() {
    return companyName;
  }

  /**
   * @param companyName the companyName to set
   */
  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  /**
   * @return the linkmanCount
   */
  public Integer getLinkmanCount() {
    return linkmanCount;
  }

  /**
   * @param linkmanCount the linkmanCount to set
   */
  public void setLinkmanCount(Integer linkmanCount) {
    this.linkmanCount = linkmanCount;
  }

  /**
   * @return the status
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(Integer status) {
    this.status = status;
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
  public void setNote(String note) {
    this.note = note;
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
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
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
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result =
        prime * result + ((companyName == null) ? 0 : companyName.hashCode());
    result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
    result =
        prime * result + ((linkmanCount == null) ? 0 : linkmanCount.hashCode());
    result = prime * result + ((note == null) ? 0 : note.hashCode());
    result = prime * result + ((status == null) ? 0 : status.hashCode());
    result = prime * result + ((suName == null) ? 0 : suName.hashCode());
    result = prime * result + ((suid == null) ? 0 : suid.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SupplierView other = (SupplierView) obj;
    if (address == null) {
      if (other.address != null)
        return false;
    } else if (!address.equals(other.address))
      return false;
    if (companyName == null) {
      if (other.companyName != null)
        return false;
    } else if (!companyName.equals(other.companyName))
      return false;
    if (fullName == null) {
      if (other.fullName != null)
        return false;
    } else if (!fullName.equals(other.fullName))
      return false;
    if (linkmanCount == null) {
      if (other.linkmanCount != null)
        return false;
    } else if (!linkmanCount.equals(other.linkmanCount))
      return false;
    if (note == null) {
      if (other.note != null)
        return false;
    } else if (!note.equals(other.note))
      return false;
    if (status == null) {
      if (other.status != null)
        return false;
    } else if (!status.equals(other.status))
      return false;
    if (suName == null) {
      if (other.suName != null)
        return false;
    } else if (!suName.equals(other.suName))
      return false;
    if (suid == null) {
      if (other.suid != null)
        return false;
    } else if (!suid.equals(other.suid))
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
    return "SupplierView [suid=" + suid + ", suName=" + suName
        + ", companyName=" + companyName + ", linkmanCount=" + linkmanCount
        + ", status=" + status + ", note=" + note + ", fullName=" + fullName
        + ", address=" + address + "]";
  }



}
