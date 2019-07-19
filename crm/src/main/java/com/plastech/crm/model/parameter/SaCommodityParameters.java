package com.plastech.crm.model.parameter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangJin
 *
 * @date 2019年2月26日 下午2:27:22
 *
 */
public class SaCommodityParameters implements Serializable {

  private static final long serialVersionUID = 1L;

  //其他名称
  private String name;
  private Long ctid;
  private Long mfid;
  //品类名称
  private String ctName;
  //最终客户数量
  private Long customersCount;
  //生产商名称
  private String mfName;
  // 销售量或采购量
  private Double quantity;
  //年
  private String year;
  //月
  private Integer month;
  //创建时间
  private Date createTime;
  //品类数量
  private Integer commodityCount;
  //最总客户id
  private Long gid;

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
   * @return the ctid
   */
  public Long getCtid() {
    return ctid;
  }

  /**
   * @param ctid the ctid to set
   */
  public void setCtid(final Long ctid) {
    this.ctid = ctid;
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
   * @return the ctName
   */
  public String getCtName() {
    return ctName;
  }

  /**
   * @param ctName the ctName to set
   */
  public void setCtName(final String ctName) {
    this.ctName = ctName;
  }

  /**
   * @return the customersCount
   */
  public Long getCustomersCount() {
    return customersCount;
  }

  /**
   * @param customersCount the customersCount to set
   */
  public void setCustomersCount(final Long customersCount) {
    this.customersCount = customersCount;
  }

  /**
   * @return the mfName
   */
  public String getMfName() {
    return mfName;
  }

  /**
   * @param mfName the mfName to set
   */
  public void setMfName(final String mfName) {
    this.mfName = mfName;
  }

  /**
   * @return the quantity
   */
  public Double getQuantity() {
    return quantity;
  }

  /**
   * @param quantity the quantity to set
   */
  public void setQuantity(final Double quantity) {
    this.quantity = quantity;
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
  public Integer getMonth() {
    return month;
  }

  /**
   * @param month the month to set
   */
  public void setMonth(final Integer month) {
    this.month = month;
  }

  /**
   * @return the createTime
   */
  public Date getCreateTime() {
    return createTime;
  }

  /**
   * @param createTime the createTime to set
   */
  public void setCreateTime(final Date createTime) {
    this.createTime = createTime;
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

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((commodityCount == null) ? 0 : commodityCount.hashCode());
    result =
        prime * result + ((createTime == null) ? 0 : createTime.hashCode());
    result = prime * result + ((ctName == null) ? 0 : ctName.hashCode());
    result = prime * result + ((ctid == null) ? 0 : ctid.hashCode());
    result = prime * result
        + ((customersCount == null) ? 0 : customersCount.hashCode());
    result = prime * result + ((gid == null) ? 0 : gid.hashCode());
    result = prime * result + ((mfName == null) ? 0 : mfName.hashCode());
    result = prime * result + ((mfid == null) ? 0 : mfid.hashCode());
    result = prime * result + ((month == null) ? 0 : month.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
    result = prime * result + ((year == null) ? 0 : year.hashCode());
    return result;
  }

  /* (non-Javadoc)
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
    final SaCommodityParameters other = (SaCommodityParameters) obj;
    if (commodityCount == null) {
      if (other.commodityCount != null)
        return false;
    } else if (!commodityCount.equals(other.commodityCount))
      return false;
    if (createTime == null) {
      if (other.createTime != null)
        return false;
    } else if (!createTime.equals(other.createTime))
      return false;
    if (ctName == null) {
      if (other.ctName != null)
        return false;
    } else if (!ctName.equals(other.ctName))
      return false;
    if (ctid == null) {
      if (other.ctid != null)
        return false;
    } else if (!ctid.equals(other.ctid))
      return false;
    if (customersCount == null) {
      if (other.customersCount != null)
        return false;
    } else if (!customersCount.equals(other.customersCount))
      return false;
    if (gid == null) {
      if (other.gid != null)
        return false;
    } else if (!gid.equals(other.gid))
      return false;
    if (mfName == null) {
      if (other.mfName != null)
        return false;
    } else if (!mfName.equals(other.mfName))
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
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (quantity == null) {
      if (other.quantity != null)
        return false;
    } else if (!quantity.equals(other.quantity))
      return false;
    if (year == null) {
      if (other.year != null)
        return false;
    } else if (!year.equals(other.year))
      return false;
    return true;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "SaCommodityParameters [name=" + name + ", ctid=" + ctid + ", mfid="
        + mfid + ", ctName=" + ctName + ", customersCount=" + customersCount
        + ", mfName=" + mfName + ", quantity=" + quantity + ", year=" + year
        + ", month=" + month + ", createTime=" + createTime
        + ", commodityCount=" + commodityCount + ", gid=" + gid + "]";
  }


}
