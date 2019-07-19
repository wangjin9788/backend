package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年3月26日 下午6:53:29
 *
 */
public class SaCommodityPurchaseDetail implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long cuid;
  private Long gid;
  private String year;
  private String cuName;
  private Double salesVolume;

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
   * @return the year
   */
  public String getYear() {
    return year;
  }

  /**
   * @param year the year to set
   */
  public void setYear(final String year) {
    this.year = year;
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
   * @return the salesVolume
   */
  public Double getSalesVolume() {
    return salesVolume;
  }

  /**
   * @param salesVolume the salesVolume to set
   */
  public void setSalesVolume(final Double salesVolume) {
    this.salesVolume = salesVolume;
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
    result = prime * result + ((cuName == null) ? 0 : cuName.hashCode());
    result = prime * result + ((cuid == null) ? 0 : cuid.hashCode());
    result = prime * result + ((gid == null) ? 0 : gid.hashCode());
    result =
        prime * result + ((salesVolume == null) ? 0 : salesVolume.hashCode());
    result = prime * result + ((year == null) ? 0 : year.hashCode());
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
    final SaCommodityPurchaseDetail other = (SaCommodityPurchaseDetail) obj;
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
    if (salesVolume == null) {
      if (other.salesVolume != null)
        return false;
    } else if (!salesVolume.equals(other.salesVolume))
      return false;
    if (year == null) {
      if (other.year != null)
        return false;
    } else if (!year.equals(other.year))
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
    return "SaCommodityPurchaseDetail [cuid=" + cuid + ", gid=" + gid
        + ", year=" + year + ", cuName=" + cuName + ", salesVolume="
        + salesVolume + "]";
  }


}
