package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年2月21日 下午3:11:32
 *
 */
public class SaCommodityAnalysisView implements Serializable {


  private static final long serialVersionUID = 1L;
  private Long ctid;
  private Long mfid;
  private String ctName;
  private String mfName;
  private Integer customersCount;
  private Double saleaVolume;
  private Integer month;
  private String year;
  private String totalSalesVolume;
  private Integer totalCustomerNumber;

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
   * @return the customersCount
   */
  public Integer getCustomersCount() {
    return customersCount;
  }

  /**
   * @param customersCount the customersCount to set
   */
  public void setCustomersCount(final Integer customersCount) {
    this.customersCount = customersCount;
  }

  /**
   * @return the saleaVolume
   */
  public Double getSaleaVolume() {
    return saleaVolume;
  }

  /**
   * @param saleaVolume the saleaVolume to set
   */
  public void setSaleaVolume(final Double saleaVolume) {
    this.saleaVolume = saleaVolume;
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
   * @return the totalSalesVolume
   */
  public String getTotalSalesVolume() {
    return totalSalesVolume;
  }

  /**
   * @param totalSalesVolume the totalSalesVolume to set
   */
  public void setTotalSalesVolume(final String totalSalesVolume) {
    this.totalSalesVolume = totalSalesVolume;
  }

  /**
   * @return the totalCustomerNumber
   */
  public Integer getTotalCustomerNumber() {
    return totalCustomerNumber;
  }

  /**
   * @param totalCustomerNumber the totalCustomerNumber to set
   */
  public void setTotalCustomerNumber(final Integer totalCustomerNumber) {
    this.totalCustomerNumber = totalCustomerNumber;
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
    result = prime * result + ((ctName == null) ? 0 : ctName.hashCode());
    result = prime * result + ((ctid == null) ? 0 : ctid.hashCode());
    result = prime * result
        + ((customersCount == null) ? 0 : customersCount.hashCode());
    result = prime * result + ((mfName == null) ? 0 : mfName.hashCode());
    result = prime * result + ((mfid == null) ? 0 : mfid.hashCode());
    result = prime * result + ((month == null) ? 0 : month.hashCode());
    result =
        prime * result + ((saleaVolume == null) ? 0 : saleaVolume.hashCode());
    result = prime * result
        + ((totalCustomerNumber == null) ? 0 : totalCustomerNumber.hashCode());
    result = prime * result
        + ((totalSalesVolume == null) ? 0 : totalSalesVolume.hashCode());
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
    final SaCommodityAnalysisView other = (SaCommodityAnalysisView) obj;
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
    if (saleaVolume == null) {
      if (other.saleaVolume != null)
        return false;
    } else if (!saleaVolume.equals(other.saleaVolume))
      return false;
    if (totalCustomerNumber == null) {
      if (other.totalCustomerNumber != null)
        return false;
    } else if (!totalCustomerNumber.equals(other.totalCustomerNumber))
      return false;
    if (totalSalesVolume == null) {
      if (other.totalSalesVolume != null)
        return false;
    } else if (!totalSalesVolume.equals(other.totalSalesVolume))
      return false;
    if (year == null) {
      if (other.year != null)
        return false;
    } else if (!year.equals(other.year))
      return false;
    return true;
  }


}
