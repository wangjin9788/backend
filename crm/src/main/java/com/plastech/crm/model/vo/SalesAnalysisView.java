package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author : yemin
 * @date : 2019年2月21日 下午1:57:51
 *
 */
public class SalesAnalysisView implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private int year = 0;// 年份
  private Double annualSalesTotal = 0d;// 年销售总量
  private int annualGroupCount = 0;// 年成交客户数
  private int annualCommodityCount = 0;// 年销售品类数
  private  int annualManufacturerCount=0;// 年销售品类数
  private List<SalesAnalysisDataView> dataList = new ArrayList<>();// 销售数据同比
  private List<SaCommodityAnalysisView> commList = new ArrayList<>();// 品类数据

  public final List<SalesAnalysisDataView> getDataList() {
    return dataList;
  }

  public final void setDataList(final List<SalesAnalysisDataView> dataList) {
    this.dataList = dataList;
  }

  public final int getYear() {
    return year;
  }

  public final void setYear(final int year) {
    this.year = year;
  }

  public final Double getAnnualSalesTotal() {
    return annualSalesTotal;
  }

  public final void setAnnualSalesTotal(final Double annualSalesTotal) {
    this.annualSalesTotal = annualSalesTotal;
  }

  public final int getAnnualGroupCount() {
    return annualGroupCount;
  }

  public final void setAnnualGroupCount(final int annualGroupCount) {
    this.annualGroupCount = annualGroupCount;
  }

  public final int getAnnualCommodityCount() {
    return annualCommodityCount;
  }

  public final void setAnnualCommodityCount(final int annualCommodityCount) {
    this.annualCommodityCount = annualCommodityCount;
  }

  /**
   * @return the commList
   */
  public List<SaCommodityAnalysisView> getCommList() {
    return commList;
  }

  /**
   * @param commList the commList to set
   */
  public void setCommList(final List<SaCommodityAnalysisView> commList) {
    this.commList = commList;
  }



  /**
   * @return the annualManufacturerCount
   */
  public int getAnnualManufacturerCount() {
    return annualManufacturerCount;
  }

  /**
   * @param annualManufacturerCount the annualManufacturerCount to set
   */
  public void setAnnualManufacturerCount(final int annualManufacturerCount) {
    this.annualManufacturerCount = annualManufacturerCount;
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
    result = prime * result + annualCommodityCount;
    result = prime * result + annualGroupCount;
    result = prime * result + annualManufacturerCount;
    result = prime * result
        + ((annualSalesTotal == null) ? 0 : annualSalesTotal.hashCode());
    result = prime * result + ((commList == null) ? 0 : commList.hashCode());
    result = prime * result + ((dataList == null) ? 0 : dataList.hashCode());
    result = prime * result + year;
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
    final SalesAnalysisView other = (SalesAnalysisView) obj;
    if (annualCommodityCount != other.annualCommodityCount)
      return false;
    if (annualGroupCount != other.annualGroupCount)
      return false;
    if (annualManufacturerCount != other.annualManufacturerCount)
      return false;
    if (annualSalesTotal == null) {
      if (other.annualSalesTotal != null)
        return false;
    } else if (!annualSalesTotal.equals(other.annualSalesTotal))
      return false;
    if (commList == null) {
      if (other.commList != null)
        return false;
    } else if (!commList.equals(other.commList))
      return false;
    if (dataList == null) {
      if (other.dataList != null)
        return false;
    } else if (!dataList.equals(other.dataList))
      return false;
    if (year != other.year)
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
    return "SalesAnalysisView [year=" + year + ", annualSalesTotal="
        + annualSalesTotal + ", annualGroupCount=" + annualGroupCount
        + ", annualCommodityCount=" + annualCommodityCount
        + ", annualManufacturerCount=" + annualManufacturerCount + ", dataList="
        + dataList + ", commList=" + commList + "]";
  }



}
