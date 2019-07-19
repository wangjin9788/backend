package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年3月25日 上午11:32:47
 *
 */
public class SaManufacturerTotalDataView implements Serializable {

  private static final long serialVersionUID = 1L;

  private String gName;// 客户名称
  private String lName;// 忠诚度名称
  private String mfName;// 生产商名称
  private String ctName;//品类名称
  private String annualPurchaseVolume;// 年购买量
  private Integer buyingFrequency;

  /**
   * @return the gName
   */
  public String getgName() {
    return gName;
  }

  /**
   * @param gName the gName to set
   */
  public void setgName(final String gName) {
    this.gName = gName;
  }

  /**
   * @return the lName
   */
  public String getlName() {
    return lName;
  }

  /**
   * @param lName the lName to set
   */
  public void setlName(final String lName) {
    this.lName = lName;
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
   * @return the annualPurchaseVolume
   */
  public String getAnnualPurchaseVolume() {
    return annualPurchaseVolume;
  }

  /**
   * @param annualPurchaseVolume the annualPurchaseVolume to set
   */
  public void setAnnualPurchaseVolume(final String annualPurchaseVolume) {
    this.annualPurchaseVolume = annualPurchaseVolume;
  }

  /**
   * @return the buyingFrequency
   */
  public Integer getBuyingFrequency() {
    return buyingFrequency;
  }

  /**
   * @param buyingFrequency the buyingFrequency to set
   */
  public void setBuyingFrequency(final Integer buyingFrequency) {
    this.buyingFrequency = buyingFrequency;
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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((annualPurchaseVolume == null) ? 0
        : annualPurchaseVolume.hashCode());
    result = prime * result
        + ((buyingFrequency == null) ? 0 : buyingFrequency.hashCode());
    result = prime * result + ((ctName == null) ? 0 : ctName.hashCode());
    result = prime * result + ((gName == null) ? 0 : gName.hashCode());
    result = prime * result + ((lName == null) ? 0 : lName.hashCode());
    result = prime * result + ((mfName == null) ? 0 : mfName.hashCode());
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
    final SaManufacturerTotalDataView other = (SaManufacturerTotalDataView) obj;
    if (annualPurchaseVolume == null) {
      if (other.annualPurchaseVolume != null)
        return false;
    } else if (!annualPurchaseVolume.equals(other.annualPurchaseVolume))
      return false;
    if (buyingFrequency == null) {
      if (other.buyingFrequency != null)
        return false;
    } else if (!buyingFrequency.equals(other.buyingFrequency))
      return false;
    if (ctName == null) {
      if (other.ctName != null)
        return false;
    } else if (!ctName.equals(other.ctName))
      return false;
    if (gName == null) {
      if (other.gName != null)
        return false;
    } else if (!gName.equals(other.gName))
      return false;
    if (lName == null) {
      if (other.lName != null)
        return false;
    } else if (!lName.equals(other.lName))
      return false;
    if (mfName == null) {
      if (other.mfName != null)
        return false;
    } else if (!mfName.equals(other.mfName))
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
    return "SaManufacturerTotalDataView [gName=" + gName + ", lName=" + lName
        + ", mfName=" + mfName + ", ctName=" + ctName
        + ", annualPurchaseVolume=" + annualPurchaseVolume
        + ", buyingFrequency=" + buyingFrequency + "]";
  }



}
