package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wangJin
 *
 * @date 2019年1月24日 下午1:47:13
 *
 */
public class ContractListView implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long coid;
  // 合同编号
  private String number;
  // 客户分公司名称
  private String cuName;
  // 经理名称
  private String managerName;
  // 客户公司
  private String gName;
  // 签署日期
  private String signingTime;
  // 总销售额
  private Double grossSales;
  // 总净利
  private Double totalNetProfit;
  // 总毛利
  private Double grossProfit;

  private List<ContractGradeView> contraList;

  /**
   * @return the coid
   */
  public Long getCoid() {
    return coid;
  }

  /**
   * @param coid the coid to set
   */
  public void setCoid(final Long coid) {
    this.coid = coid;
  }

  /**
   * @return the number
   */
  public String getNumber() {
    return number;
  }

  /**
   * @param number the number to set
   */
  public void setNumber(final String number) {
    this.number = number;
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
   * @return the managerName
   */
  public String getManagerName() {
    return managerName;
  }

  /**
   * @param managerName the managerName to set
   */
  public void setManagerName(final String managerName) {
    this.managerName = managerName;
  }

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
   * @return the signingTime
   */
  public String getSigningTime() {
    return signingTime;
  }

  /**
   * @param signingTime the signingTime to set
   */
  public void setSigningTime(final Date signingTime) {
    this.signingTime = signingTime.getTime()+"";
  }

  /**
   * @return the grossSales
   */
  public Double getGrossSales() {
    return grossSales;
  }

  /**
   * @param grossSales the grossSales to set
   */
  public void setGrossSales(final Double grossSales) {
    this.grossSales = grossSales;
  }

  /**
   * @return the totalNetProfit
   */
  public Double getTotalNetProfit() {
    return totalNetProfit;
  }

  /**
   * @param totalNetProfit the totalNetProfit to set
   */
  public void setTotalNetProfit(final Double totalNetProfit) {
    this.totalNetProfit = totalNetProfit;
  }

  /**
   * @return the grossProfit
   */
  public Double getGrossProfit() {
    return grossProfit;
  }

  /**
   * @param grossProfit the grossProfit to set
   */
  public void setGrossProfit(final Double grossProfit) {
    this.grossProfit = grossProfit;
  }

  /**
   * @return the contraList
   */
  public List<ContractGradeView> getContraList() {
    return contraList;
  }

  /**
   * @param contraList the contraList to set
   */
  public void setContraList(final List<ContractGradeView> contraList) {
    this.contraList = contraList;
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
    result = prime * result + ((coid == null) ? 0 : coid.hashCode());
    result =
        prime * result + ((contraList == null) ? 0 : contraList.hashCode());
    result = prime * result + ((cuName == null) ? 0 : cuName.hashCode());
    result = prime * result + ((gName == null) ? 0 : gName.hashCode());
    result =
        prime * result + ((grossProfit == null) ? 0 : grossProfit.hashCode());
    result =
        prime * result + ((grossSales == null) ? 0 : grossSales.hashCode());
    result =
        prime * result + ((managerName == null) ? 0 : managerName.hashCode());
    result = prime * result + ((number == null) ? 0 : number.hashCode());
    result =
        prime * result + ((signingTime == null) ? 0 : signingTime.hashCode());
    result = prime * result
        + ((totalNetProfit == null) ? 0 : totalNetProfit.hashCode());
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
    final ContractListView other = (ContractListView) obj;
    if (coid == null) {
      if (other.coid != null)
        return false;
    } else if (!coid.equals(other.coid))
      return false;
    if (contraList == null) {
      if (other.contraList != null)
        return false;
    } else if (!contraList.equals(other.contraList))
      return false;
    if (cuName == null) {
      if (other.cuName != null)
        return false;
    } else if (!cuName.equals(other.cuName))
      return false;
    if (gName == null) {
      if (other.gName != null)
        return false;
    } else if (!gName.equals(other.gName))
      return false;
    if (grossProfit == null) {
      if (other.grossProfit != null)
        return false;
    } else if (!grossProfit.equals(other.grossProfit))
      return false;
    if (grossSales == null) {
      if (other.grossSales != null)
        return false;
    } else if (!grossSales.equals(other.grossSales))
      return false;
    if (managerName == null) {
      if (other.managerName != null)
        return false;
    } else if (!managerName.equals(other.managerName))
      return false;
    if (number == null) {
      if (other.number != null)
        return false;
    } else if (!number.equals(other.number))
      return false;
    if (signingTime == null) {
      if (other.signingTime != null)
        return false;
    } else if (!signingTime.equals(other.signingTime))
      return false;
    if (totalNetProfit == null) {
      if (other.totalNetProfit != null)
        return false;
    } else if (!totalNetProfit.equals(other.totalNetProfit))
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
    return "ContractListView [coid=" + coid + ", number=" + number + ", cuName="
        + cuName + ", managerName=" + managerName + ", gName=" + gName
        + ", signingTime=" + signingTime + ", grossSales=" + grossSales
        + ", totalNetProfit=" + totalNetProfit + ", grossProfit=" + grossProfit
        + ", contraList=" + contraList + "]";
  }

}
