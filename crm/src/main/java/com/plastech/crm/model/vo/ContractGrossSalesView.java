package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年1月25日 上午11:26:54
 *
 */
public class ContractGrossSalesView implements Serializable {

  private static final long serialVersionUID = 1L;
  // 销售总额
  private String salesTotal;
  // 总净利
  private String netProfit;
  // 总毛利
  private String grossProfit;

  /**
   * @return the salesTotal
   */
  public String getSalesTotal() {
    return salesTotal;
  }

  /**
   * @param salesTotal the salesTotal to set
   */
  public void setSalesTotal(final String salesTotal) {
    this.salesTotal = salesTotal;
  }

  /**
   * @return the netProfit
   */
  public String getNetProfit() {
    return netProfit;
  }

  /**
   * @param netProfit the netProfit to set
   */
  public void setNetProfit(final String netProfit) {
    this.netProfit = netProfit;
  }

  /**
   * @return the grossProfit
   */
  public String getGrossProfit() {
    return grossProfit;
  }

  /**
   * @param grossProfit the grossProfit to set
   */
  public void setGrossProfit(final String grossProfit) {
    this.grossProfit = grossProfit;
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
        prime * result + ((grossProfit == null) ? 0 : grossProfit.hashCode());
    result = prime * result + ((netProfit == null) ? 0 : netProfit.hashCode());
    result =
        prime * result + ((salesTotal == null) ? 0 : salesTotal.hashCode());
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
    final ContractGrossSalesView other = (ContractGrossSalesView) obj;
    if (grossProfit == null) {
      if (other.grossProfit != null)
        return false;
    } else if (!grossProfit.equals(other.grossProfit))
      return false;
    if (netProfit == null) {
      if (other.netProfit != null)
        return false;
    } else if (!netProfit.equals(other.netProfit))
      return false;
    if (salesTotal == null) {
      if (other.salesTotal != null)
        return false;
    } else if (!salesTotal.equals(other.salesTotal))
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
    return "ContractGrossSalesView [salesTotal=" + salesTotal + ", netProfit="
        + netProfit + ", grossProfit=" + grossProfit + "]";
  }



}
