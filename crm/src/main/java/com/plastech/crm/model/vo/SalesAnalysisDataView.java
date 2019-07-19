package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 *
 *
 * @author : yemin
 * @date : 2019年2月21日 下午1:57:51
 *
 */
public class SalesAnalysisDataView implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private String month = "";// 月份

  private String yearMonth = "";// 年月
  private Double salesTotal = 0d;// 月销售总量
  private int groupCount = 0;// 月成交客户数
  private int commodityCount = 0;// 月销售品类数
  private int manufacturerCount;

  private String previousYearMonth = "";// 年月
  private Double previousSalesTotal = 0d;// 上一年同月销售总量
  private int previousGroupCount = 0;// 上一年同月成交客户数
  private int previousCommodityCount = 0;// 上一年同月销售品类数

  public SalesAnalysisDataView() {
    super();
  }

  public SalesAnalysisDataView(final String month) {
    super();
    this.month = month;
  }

  public final String getMonth() {
    return month;
  }

  public final void setMonth(final String month) {
    this.month = month;
  }

  public final String getPreviousYearMonth() {
    return previousYearMonth;
  }

  public final void setPreviousYearMonth(final String previousYearMonth) {
    this.previousYearMonth = previousYearMonth;
  }

  public final Double getPreviousSalesTotal() {
    return previousSalesTotal;
  }

  public final void setPreviousSalesTotal(final Double previousSalesTotal) {
    this.previousSalesTotal = previousSalesTotal;
  }

  public final int getPreviousGroupCount() {
    return previousGroupCount;
  }

  public final void setPreviousGroupCount(final int previousGroupCount) {
    this.previousGroupCount = previousGroupCount;
  }

  public final int getPreviousCommodityCount() {
    return previousCommodityCount;
  }

  public final void setPreviousCommodityCount(
      final int previousCommodityCount) {
    this.previousCommodityCount = previousCommodityCount;
  }

  public final String getYearMonth() {
    return yearMonth;
  }

  public final void setYearMonth(final String yearMonth) {
    this.yearMonth = yearMonth;
  }

  public final Double getSalesTotal() {
    return salesTotal;
  }

  public final void setSalesTotal(final Double salesTotal) {
    this.salesTotal = salesTotal;
  }

  public final int getGroupCount() {
    return groupCount;
  }

  public final void setGroupCount(final int groupCount) {
    this.groupCount = groupCount;
  }

  public final int getCommodityCount() {
    return commodityCount;
  }

  public final void setCommodityCount(final int commodityCount) {
    this.commodityCount = commodityCount;
  }

  /**
   * @return the manufacturerCount
   */
  public int getManufacturerCount() {
    return manufacturerCount;
  }

  /**
   * @param manufacturerCount the manufacturerCount to set
   */
  public void setManufacturerCount(final int manufacturerCount) {
    this.manufacturerCount = manufacturerCount;
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
    result = prime * result + commodityCount;
    result = prime * result + groupCount;
    result = prime * result + manufacturerCount;
    result = prime * result + ((month == null) ? 0 : month.hashCode());
    result = prime * result + previousCommodityCount;
    result = prime * result + previousGroupCount;
    result = prime * result
        + ((previousSalesTotal == null) ? 0 : previousSalesTotal.hashCode());
    result = prime * result
        + ((previousYearMonth == null) ? 0 : previousYearMonth.hashCode());
    result =
        prime * result + ((salesTotal == null) ? 0 : salesTotal.hashCode());
    result = prime * result + ((yearMonth == null) ? 0 : yearMonth.hashCode());
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
    final SalesAnalysisDataView other = (SalesAnalysisDataView) obj;
    if (commodityCount != other.commodityCount)
      return false;
    if (groupCount != other.groupCount)
      return false;
    if (manufacturerCount != other.manufacturerCount)
      return false;
    if (month == null) {
      if (other.month != null)
        return false;
    } else if (!month.equals(other.month))
      return false;
    if (previousCommodityCount != other.previousCommodityCount)
      return false;
    if (previousGroupCount != other.previousGroupCount)
      return false;
    if (previousSalesTotal == null) {
      if (other.previousSalesTotal != null)
        return false;
    } else if (!previousSalesTotal.equals(other.previousSalesTotal))
      return false;
    if (previousYearMonth == null) {
      if (other.previousYearMonth != null)
        return false;
    } else if (!previousYearMonth.equals(other.previousYearMonth))
      return false;
    if (salesTotal == null) {
      if (other.salesTotal != null)
        return false;
    } else if (!salesTotal.equals(other.salesTotal))
      return false;
    if (yearMonth == null) {
      if (other.yearMonth != null)
        return false;
    } else if (!yearMonth.equals(other.yearMonth))
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
    return "SalesAnalysisDataView [month=" + month + ", yearMonth=" + yearMonth
        + ", salesTotal=" + salesTotal + ", groupCount=" + groupCount
        + ", commodityCount=" + commodityCount + ", manufacturerCount="
        + manufacturerCount + ", previousYearMonth=" + previousYearMonth
        + ", previousSalesTotal=" + previousSalesTotal + ", previousGroupCount="
        + previousGroupCount + ", previousCommodityCount="
        + previousCommodityCount + "]";
  }



}
