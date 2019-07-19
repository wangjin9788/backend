package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年1月23日 下午3:36:15
 *
 */
public class CustomerView implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long cuid;

  private Long gid;

  private Integer status;

  private String cuName;

  private String note;

  private String companyName;

  private String cuAddress;

  private Integer linkmanCount;

  private Integer canDel;

  /**
   * @return the cuid
   */
  public Long getCuid() {
    return cuid;
  }

  /**
   * @param cuid the cuid to set
   */
  public void setCuid(final Long cuid) {
    this.cuid = cuid;
  }

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
   * @return the status
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(final Integer status) {
    this.status = status;
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
   * @return the companyName
   */
  public String getCompanyName() {
    return companyName;
  }

  /**
   * @param companyName the companyName to set
   */
  public void setCompanyName(final String companyName) {
    this.companyName = companyName;
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
   * @return the linkmanCount
   */
  public Integer getLinkmanCount() {
    return linkmanCount;
  }

  /**
   * @param linkmanCount the linkmanCount to set
   */
  public void setLinkmanCount(final Integer linkmanCount) {
    this.linkmanCount = linkmanCount;
  }

  /**
   * @return the canDel
   */
  public Integer getCanDel() {
    return canDel;
  }

  /**
   * @param canDel the canDel to set
   */
  public void setCanDel(final Integer canDel) {
    this.canDel = canDel;
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
    result = prime * result + ((canDel == null) ? 0 : canDel.hashCode());
    result =
        prime * result + ((companyName == null) ? 0 : companyName.hashCode());
    result = prime * result + ((cuAddress == null) ? 0 : cuAddress.hashCode());
    result = prime * result + ((cuName == null) ? 0 : cuName.hashCode());
    result = prime * result + ((cuid == null) ? 0 : cuid.hashCode());
    result = prime * result + ((gid == null) ? 0 : gid.hashCode());
    result =
        prime * result + ((linkmanCount == null) ? 0 : linkmanCount.hashCode());
    result = prime * result + ((note == null) ? 0 : note.hashCode());
    result = prime * result + ((status == null) ? 0 : status.hashCode());
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
    final CustomerView other = (CustomerView) obj;
    if (canDel == null) {
      if (other.canDel != null)
        return false;
    } else if (!canDel.equals(other.canDel))
      return false;
    if (companyName == null) {
      if (other.companyName != null)
        return false;
    } else if (!companyName.equals(other.companyName))
      return false;
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
    if (cuid == null) {
      if (other.cuid != null)
        return false;
    } else if (!cuid.equals(other.cuid))
      return false;
    if (gid == null) {
      if (other.gid != null)
        return false;
    } else if (!gid.equals(other.gid))
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
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "CustomerView [cuid=" + cuid + ", gid=" + gid + ", status=" + status
        + ", cuName=" + cuName + ", note=" + note + ", companyName="
        + companyName + ", cuAddress=" + cuAddress + ", linkmanCount="
        + linkmanCount + ", canDel=" + canDel + "]";
  }


}
