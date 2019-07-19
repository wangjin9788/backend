package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年1月24日 下午1:14:33
 *
 */
public class ContractGradeView implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long cgid;
  // 牌号名称 品类 供应商
  private String gradeName;
  private String commName;
  private String supName;
  // 销售量
  private Double salesVolume;
  // 销售总金额
  private Double salesTotal;
  // 销售毛利
  private Double cgGrossProfit;
  // 开船时间
  private String shipmtDate;
  // 销售单价
  private Double cgSalesUnitPrice;
  // 货币种类
  private String cgCurrencyType;
  // 生产商名称
  private String mfName;

  /**
   * @return the cgid
   */
  public Long getCgid() {
    return cgid;
  }

  /**
   * @param cgid the cgid to set
   */
  public void setCgid(final Long cgid) {
    this.cgid = cgid;
  }

  /**
   * @return the gradeName
   */
  public String getGradeName() {
    return gradeName;
  }

  /**
   * @param gradeName the gradeName to set
   */
  public void setGradeName(final String gradeName) {
    this.gradeName = gradeName;
  }

  /**
   * @return the commName
   */
  public String getCommName() {
    return commName;
  }

  /**
   * @param commName the commName to set
   */
  public void setCommName(final String commName) {
    this.commName = commName;
  }

  /**
   * @return the supName
   */
  public String getSupName() {
    return supName;
  }

  /**
   * @param supName the supName to set
   */
  public void setSupName(final String supName) {
    this.supName = supName;
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
   * @return the cgGrossProfit
   */
  public Double getCgGrossProfit() {
    return cgGrossProfit;
  }

  /**
   * @param cgGrossProfit the cgGrossProfit to set
   */
  public void setCgGrossProfit(final Double cgGrossProfit) {
    this.cgGrossProfit = cgGrossProfit;
  }

  /**
   * @return the shipmtDate
   */
  public String getShipmtDate() {
    return shipmtDate;
  }

  /**
   * @param shipmtDate the shipmtDate to set
   */
  public void setShipmtDate(final String shipmtDate) {
    this.shipmtDate = shipmtDate;
  }

  /**
   * @return the cgSalesUnitPrice
   */
  public Double getCgSalesUnitPrice() {
    return cgSalesUnitPrice;
  }

  /**
   * @param cgSalesUnitPrice the cgSalesUnitPrice to set
   */
  public void setCgSalesUnitPrice(final Double cgSalesUnitPrice) {
    this.cgSalesUnitPrice = cgSalesUnitPrice;
  }

  /**
   * @return the cgCurrencyType
   */
  public String getCgCurrencyType() {
    return cgCurrencyType;
  }

  /**
   * @param cgCurrencyType the cgCurrencyType to set
   */
  public void setCgCurrencyType(final String cgCurrencyType) {
    this.cgCurrencyType = cgCurrencyType;
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
        + ((cgCurrencyType == null) ? 0 : cgCurrencyType.hashCode());
    result = prime * result
        + ((cgGrossProfit == null) ? 0 : cgGrossProfit.hashCode());
    result = prime * result
        + ((cgSalesUnitPrice == null) ? 0 : cgSalesUnitPrice.hashCode());
    result = prime * result + ((cgid == null) ? 0 : cgid.hashCode());
    result = prime * result + ((commName == null) ? 0 : commName.hashCode());
    result = prime * result + ((gradeName == null) ? 0 : gradeName.hashCode());
    result = prime * result + ((mfName == null) ? 0 : mfName.hashCode());
    result =
        prime * result + ((salesTotal == null) ? 0 : salesTotal.hashCode());
    result =
        prime * result + ((salesVolume == null) ? 0 : salesVolume.hashCode());
    result =
        prime * result + ((shipmtDate == null) ? 0 : shipmtDate.hashCode());
    result = prime * result + ((supName == null) ? 0 : supName.hashCode());
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
    final ContractGradeView other = (ContractGradeView) obj;
    if (cgCurrencyType == null) {
      if (other.cgCurrencyType != null)
        return false;
    } else if (!cgCurrencyType.equals(other.cgCurrencyType))
      return false;
    if (cgGrossProfit == null) {
      if (other.cgGrossProfit != null)
        return false;
    } else if (!cgGrossProfit.equals(other.cgGrossProfit))
      return false;
    if (cgSalesUnitPrice == null) {
      if (other.cgSalesUnitPrice != null)
        return false;
    } else if (!cgSalesUnitPrice.equals(other.cgSalesUnitPrice))
      return false;
    if (cgid == null) {
      if (other.cgid != null)
        return false;
    } else if (!cgid.equals(other.cgid))
      return false;
    if (commName == null) {
      if (other.commName != null)
        return false;
    } else if (!commName.equals(other.commName))
      return false;
    if (gradeName == null) {
      if (other.gradeName != null)
        return false;
    } else if (!gradeName.equals(other.gradeName))
      return false;
    if (mfName == null) {
      if (other.mfName != null)
        return false;
    } else if (!mfName.equals(other.mfName))
      return false;
    if (salesTotal == null) {
      if (other.salesTotal != null)
        return false;
    } else if (!salesTotal.equals(other.salesTotal))
      return false;
    if (salesVolume == null) {
      if (other.salesVolume != null)
        return false;
    } else if (!salesVolume.equals(other.salesVolume))
      return false;
    if (shipmtDate == null) {
      if (other.shipmtDate != null)
        return false;
    } else if (!shipmtDate.equals(other.shipmtDate))
      return false;
    if (supName == null) {
      if (other.supName != null)
        return false;
    } else if (!supName.equals(other.supName))
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
    return "ContractGradeView [cgid=" + cgid + ", gradeName=" + gradeName
        + ", commName=" + commName + ", supName=" + supName + ", salesVolume="
        + salesVolume + ", salesTotal=" + salesTotal + ", cgGrossProfit="
        + cgGrossProfit + ", shipmtDate=" + shipmtDate + ", cgSalesUnitPrice="
        + cgSalesUnitPrice + ", cgCurrencyType=" + cgCurrencyType + ", mfName="
        + mfName + "]";
  }



}
