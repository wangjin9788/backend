package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年1月23日 下午1:14:25
 *
 */
public class UserPurchaseFrequencyView implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer years;
  private Integer monthCount;
  private Long gid;
  private Long mfid;

  /**
   * @return the years
   */
  public Integer getYears() {
    return years;
  }

  /**
   * @param years the years to set
   */
  public void setYears(final Integer years) {
    this.years = years;
  }

  /**
   * @return the monthCount
   */
  public Integer getMonthCount() {
    return monthCount;
  }

  /**
   * @param monthCount the monthCount to set
   */
  public void setMonthCount(final Integer monthCount) {
    this.monthCount = monthCount;
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
   * @return the mfid
   */
  public Long getMfid() {
    return mfid;
  }

  /**
   * @param mfid the mfid to set
   */
  public void setMfid(final Long mfid) {
    this.mfid = mfid;
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
    result = prime * result + ((gid == null) ? 0 : gid.hashCode());
    result = prime * result + ((mfid == null) ? 0 : mfid.hashCode());
    result =
        prime * result + ((monthCount == null) ? 0 : monthCount.hashCode());
    result = prime * result + ((years == null) ? 0 : years.hashCode());
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
    final UserPurchaseFrequencyView other = (UserPurchaseFrequencyView) obj;
    if (gid == null) {
      if (other.gid != null)
        return false;
    } else if (!gid.equals(other.gid))
      return false;
    if (mfid == null) {
      if (other.mfid != null)
        return false;
    } else if (!mfid.equals(other.mfid))
      return false;
    if (monthCount == null) {
      if (other.monthCount != null)
        return false;
    } else if (!monthCount.equals(other.monthCount))
      return false;
    if (years == null) {
      if (other.years != null)
        return false;
    } else if (!years.equals(other.years))
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
    return "UserPurchaseFrequencyView [years=" + years + ", monthCount="
        + monthCount + ", gid=" + gid + ", mfid=" + mfid + "]";
  }



}
