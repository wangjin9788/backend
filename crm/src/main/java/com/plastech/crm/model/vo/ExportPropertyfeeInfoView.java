package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年3月7日 上午10:32:12
 *
 */
public class ExportPropertyfeeInfoView implements Serializable {

  private static final long serialVersionUID = 1L;
  // 品类名称
  private String ctName;
  // 生产商名称
  private String mfName;
  // 客户名称
  private String cuName;
  // 1-12月金额
  private Double januaryMoney;
  private Double februaryMoney;
  private Double marchMoney;
  private Double aprilMoney;
  private Double mayMoney;
  private Double juneMoney;
  private Double julyMoney;
  private Double augustMoney;
  private Double septemberMoney;
  private Double octoberMoney;
  private Double novemberMoney;
  private Double decemberMoney;
  // 列金额
  private Double columnMoney;
  // 行金额
  private String lineMoney;

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
   * @return the januaryMoney
   */
  public Double getJanuaryMoney() {
    return januaryMoney;
  }

  /**
   * @param januaryMoney the januaryMoney to set
   */
  public void setJanuaryMoney(final Double januaryMoney) {
    this.januaryMoney = januaryMoney;
  }

  /**
   * @return the februaryMoney
   */
  public Double getFebruaryMoney() {
    return februaryMoney;
  }

  /**
   * @param februaryMoney the februaryMoney to set
   */
  public void setFebruaryMoney(final Double februaryMoney) {
    this.februaryMoney = februaryMoney;
  }

  /**
   * @return the marchMoney
   */
  public Double getMarchMoney() {
    return marchMoney;
  }

  /**
   * @param marchMoney the marchMoney to set
   */
  public void setMarchMoney(final Double marchMoney) {
    this.marchMoney = marchMoney;
  }

  /**
   * @return the aprilMoney
   */
  public Double getAprilMoney() {
    return aprilMoney;
  }

  /**
   * @param aprilMoney the aprilMoney to set
   */
  public void setAprilMoney(final Double aprilMoney) {
    this.aprilMoney = aprilMoney;
  }

  /**
   * @return the mayMoney
   */
  public Double getMayMoney() {
    return mayMoney;
  }

  /**
   * @param mayMoney the mayMoney to set
   */
  public void setMayMoney(final Double mayMoney) {
    this.mayMoney = mayMoney;
  }

  /**
   * @return the juneMoney
   */
  public Double getJuneMoney() {
    return juneMoney;
  }

  /**
   * @param juneMoney the juneMoney to set
   */
  public void setJuneMoney(final Double juneMoney) {
    this.juneMoney = juneMoney;
  }

  /**
   * @return the julyMoney
   */
  public Double getJulyMoney() {
    return julyMoney;
  }

  /**
   * @param julyMoney the julyMoney to set
   */
  public void setJulyMoney(final Double julyMoney) {
    this.julyMoney = julyMoney;
  }

  /**
   * @return the augustMoney
   */
  public Double getAugustMoney() {
    return augustMoney;
  }

  /**
   * @param augustMoney the augustMoney to set
   */
  public void setAugustMoney(final Double augustMoney) {
    this.augustMoney = augustMoney;
  }

  /**
   * @return the septemberMoney
   */
  public Double getSeptemberMoney() {
    return septemberMoney;
  }

  /**
   * @param septemberMoney the septemberMoney to set
   */
  public void setSeptemberMoney(final Double septemberMoney) {
    this.septemberMoney = septemberMoney;
  }

  /**
   * @return the octoberMoney
   */
  public Double getOctoberMoney() {
    return octoberMoney;
  }

  /**
   * @param octoberMoney the octoberMoney to set
   */
  public void setOctoberMoney(final Double octoberMoney) {
    this.octoberMoney = octoberMoney;
  }

  /**
   * @return the novemberMoney
   */
  public Double getNovemberMoney() {
    return novemberMoney;
  }

  /**
   * @param novemberMoney the novemberMoney to set
   */
  public void setNovemberMoney(final Double novemberMoney) {
    this.novemberMoney = novemberMoney;
  }

  /**
   * @return the decemberMoney
   */
  public Double getDecemberMoney() {
    return decemberMoney;
  }

  /**
   * @param decemberMoney the decemberMoney to set
   */
  public void setDecemberMoney(final Double decemberMoney) {
    this.decemberMoney = decemberMoney;
  }

  /**
   * @return the columnMoney
   */
  public Double getColumnMoney() {
    return columnMoney;
  }

  /**
   * @param columnMoney the columnMoney to set
   */
  public void setColumnMoney(final Double columnMoney) {
    this.columnMoney = columnMoney;
  }

  /**
   * @return the lineMoney
   */
  public String getLineMoney() {
    return lineMoney;
  }

  /**
   * @param lineMoney the lineMoney to set
   */
  public void setLineMoney(final String lineMoney) {
    this.lineMoney = lineMoney;
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
    result =
        prime * result + ((aprilMoney == null) ? 0 : aprilMoney.hashCode());
    result =
        prime * result + ((augustMoney == null) ? 0 : augustMoney.hashCode());
    result =
        prime * result + ((columnMoney == null) ? 0 : columnMoney.hashCode());
    result = prime * result + ((ctName == null) ? 0 : ctName.hashCode());
    result = prime * result + ((cuName == null) ? 0 : cuName.hashCode());
    result = prime * result
        + ((decemberMoney == null) ? 0 : decemberMoney.hashCode());
    result = prime * result
        + ((februaryMoney == null) ? 0 : februaryMoney.hashCode());
    result =
        prime * result + ((januaryMoney == null) ? 0 : januaryMoney.hashCode());
    result = prime * result + ((julyMoney == null) ? 0 : julyMoney.hashCode());
    result = prime * result + ((juneMoney == null) ? 0 : juneMoney.hashCode());
    result = prime * result + ((lineMoney == null) ? 0 : lineMoney.hashCode());
    result =
        prime * result + ((marchMoney == null) ? 0 : marchMoney.hashCode());
    result = prime * result + ((mayMoney == null) ? 0 : mayMoney.hashCode());
    result = prime * result + ((mfName == null) ? 0 : mfName.hashCode());
    result = prime * result
        + ((novemberMoney == null) ? 0 : novemberMoney.hashCode());
    result =
        prime * result + ((octoberMoney == null) ? 0 : octoberMoney.hashCode());
    result = prime * result
        + ((septemberMoney == null) ? 0 : septemberMoney.hashCode());
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
    final ExportPropertyfeeInfoView other = (ExportPropertyfeeInfoView) obj;
    if (aprilMoney == null) {
      if (other.aprilMoney != null)
        return false;
    } else if (!aprilMoney.equals(other.aprilMoney))
      return false;
    if (augustMoney == null) {
      if (other.augustMoney != null)
        return false;
    } else if (!augustMoney.equals(other.augustMoney))
      return false;
    if (columnMoney == null) {
      if (other.columnMoney != null)
        return false;
    } else if (!columnMoney.equals(other.columnMoney))
      return false;
    if (ctName == null) {
      if (other.ctName != null)
        return false;
    } else if (!ctName.equals(other.ctName))
      return false;
    if (cuName == null) {
      if (other.cuName != null)
        return false;
    } else if (!cuName.equals(other.cuName))
      return false;
    if (decemberMoney == null) {
      if (other.decemberMoney != null)
        return false;
    } else if (!decemberMoney.equals(other.decemberMoney))
      return false;
    if (februaryMoney == null) {
      if (other.februaryMoney != null)
        return false;
    } else if (!februaryMoney.equals(other.februaryMoney))
      return false;
    if (januaryMoney == null) {
      if (other.januaryMoney != null)
        return false;
    } else if (!januaryMoney.equals(other.januaryMoney))
      return false;
    if (julyMoney == null) {
      if (other.julyMoney != null)
        return false;
    } else if (!julyMoney.equals(other.julyMoney))
      return false;
    if (juneMoney == null) {
      if (other.juneMoney != null)
        return false;
    } else if (!juneMoney.equals(other.juneMoney))
      return false;
    if (lineMoney == null) {
      if (other.lineMoney != null)
        return false;
    } else if (!lineMoney.equals(other.lineMoney))
      return false;
    if (marchMoney == null) {
      if (other.marchMoney != null)
        return false;
    } else if (!marchMoney.equals(other.marchMoney))
      return false;
    if (mayMoney == null) {
      if (other.mayMoney != null)
        return false;
    } else if (!mayMoney.equals(other.mayMoney))
      return false;
    if (mfName == null) {
      if (other.mfName != null)
        return false;
    } else if (!mfName.equals(other.mfName))
      return false;
    if (novemberMoney == null) {
      if (other.novemberMoney != null)
        return false;
    } else if (!novemberMoney.equals(other.novemberMoney))
      return false;
    if (octoberMoney == null) {
      if (other.octoberMoney != null)
        return false;
    } else if (!octoberMoney.equals(other.octoberMoney))
      return false;
    if (septemberMoney == null) {
      if (other.septemberMoney != null)
        return false;
    } else if (!septemberMoney.equals(other.septemberMoney))
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
    return "ExportPropertyfeeInfoView [ctName=" + ctName + ", mfName=" + mfName
        + ", cuName=" + cuName + ", januaryMoney=" + januaryMoney
        + ", februaryMoney=" + februaryMoney + ", marchMoney=" + marchMoney
        + ", aprilMoney=" + aprilMoney + ", mayMoney=" + mayMoney
        + ", juneMoney=" + juneMoney + ", julyMoney=" + julyMoney
        + ", augustMoney=" + augustMoney + ", septemberMoney=" + septemberMoney
        + ", octoberMoney=" + octoberMoney + ", novemberMoney=" + novemberMoney
        + ", decemberMoney=" + decemberMoney + ", columnMoney=" + columnMoney
        + ", lineMoney=" + lineMoney + "]";
  }


}
