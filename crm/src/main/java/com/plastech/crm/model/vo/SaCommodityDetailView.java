package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangJin
 *
 * @date 2019年2月25日 下午4:30:48
 *
 */
public class SaCommodityDetailView implements Serializable {

  private static final long serialVersionUID = 1L;

  //品类名称
  private String ctName;
  //生产商名称
  private String mfName;
  //年销售量
  private String totalSalesVolume;
  //用户数量
  private Integer totalCustomerNumber;
  private List<SalesAnalysisDataView> monthyList;

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

  /**
   * @return the monthyList
   */
  public List<SalesAnalysisDataView> getMonthyList() {
    return monthyList;
  }

  /**
   * @param monthyList the monthyList to set
   */
  public void setMonthyList(final List<SalesAnalysisDataView> monthyList) {
    this.monthyList = monthyList;
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
    result = prime * result + ((mfName == null) ? 0 : mfName.hashCode());
    result =
        prime * result + ((monthyList == null) ? 0 : monthyList.hashCode());
    result = prime * result
        + ((totalCustomerNumber == null) ? 0 : totalCustomerNumber.hashCode());
    result = prime * result
        + ((totalSalesVolume == null) ? 0 : totalSalesVolume.hashCode());
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
    final SaCommodityDetailView other = (SaCommodityDetailView) obj;
    if (ctName == null) {
      if (other.ctName != null)
        return false;
    } else if (!ctName.equals(other.ctName))
      return false;
    if (mfName == null) {
      if (other.mfName != null)
        return false;
    } else if (!mfName.equals(other.mfName))
      return false;
    if (monthyList == null) {
      if (other.monthyList != null)
        return false;
    } else if (!monthyList.equals(other.monthyList))
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
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "SaCommodityDetailView [ctName=" + ctName + ", mfName=" + mfName
        + ", totalSalesVolume=" + totalSalesVolume + ", totalCustomerNumber="
        + totalCustomerNumber + ", monthyList=" + monthyList + "]";
  }

}
