package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年3月25日 下午2:49:57
 *
 */
public class SynchronousSalseDataView implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long uid;
  private Long mfid;
  private String year;// 年
  private String month;// 月
  private Double salesTotal;// 销售量
  private Integer groupCount;// 最终客户数量
  private Integer commodityCount;// 品类数量

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
   * @return the month
   */
  public String getMonth() {
    return month;
  }

  /**
   * @param month the month to set
   */
  public void setMonth(final String month) {
    this.month = month;
  }

  /**
   * @return the salesTotal
   */
  public Double getSalesTotal() {
    return salesTotal;
  }

  /**
   * @param salesTotal the salesTotal to set
   */
  public void setSalesTotal(final Double salesTotal) {
    this.salesTotal = salesTotal;
  }

  /**
   * @return the groupCount
   */
  public Integer getGroupCount() {
    return groupCount;
  }

  /**
   * @param groupCount the groupCount to set
   */
  public void setGroupCount(final Integer groupCount) {
    this.groupCount = groupCount;
  }

  /**
   * @return the commodityCount
   */
  public Integer getCommodityCount() {
    return commodityCount;
  }

  /**
   * @param commodityCount the commodityCount to set
   */
  public void setCommodityCount(final Integer commodityCount) {
    this.commodityCount = commodityCount;
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
    result = prime * result
        + ((commodityCount == null) ? 0 : commodityCount.hashCode());
    result =
        prime * result + ((groupCount == null) ? 0 : groupCount.hashCode());
    result = prime * result + ((mfid == null) ? 0 : mfid.hashCode());
    result = prime * result + ((month == null) ? 0 : month.hashCode());
    result =
        prime * result + ((salesTotal == null) ? 0 : salesTotal.hashCode());
    result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
    final SynchronousSalseDataView other = (SynchronousSalseDataView) obj;
    if (commodityCount == null) {
      if (other.commodityCount != null)
        return false;
    } else if (!commodityCount.equals(other.commodityCount))
      return false;
    if (groupCount == null) {
      if (other.groupCount != null)
        return false;
    } else if (!groupCount.equals(other.groupCount))
      return false;
    if (mfid == null) {
      if (other.mfid != null)
        return false;
    } else if (!mfid.equals(other.mfid))
      return false;
    if (month == null) {
      if (other.month != null)
        return false;
    } else if (!month.equals(other.month))
      return false;
    if (salesTotal == null) {
      if (other.salesTotal != null)
        return false;
    } else if (!salesTotal.equals(other.salesTotal))
      return false;
    if (uid == null) {
      if (other.uid != null)
        return false;
    } else if (!uid.equals(other.uid))
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
    return "SynchronousSalseDataView [uid=" + uid + ", mfid=" + mfid + ", year="
        + year + ", month=" + month + ", salesTotal=" + salesTotal
        + ", groupCount=" + groupCount + ", commodityCount=" + commodityCount
        + "]";
  }


}
