package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 销售经理年度销售数据统计
 *
 * @author : yemin
 * @date : 2019年2月25日 上午10:37:48
 *
 */
public class SalesManagerAnalysisYearStView implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private int year = 0;// 年份
  private int managerCount = 0;// 经理数量
  private Double annualSalesTotal = 0d;// 年销售总量
  private int annualGroupCountTotal = 0;// 年成交客户数
  private int annualCommodityCountTotal = 0;// 年销售品类数

  private List<SalesManagerAnalysisYearStData> dataList;// 销售数据

  public final void setYear(final int year) {
    this.year = year;
  }

  public final List<SalesManagerAnalysisYearStData> getDataList() {
    return dataList;
  }

  public final void setDataList(
      final List<SalesManagerAnalysisYearStData> dataList) {
    this.dataList = dataList;
  }

  public final int getManagerCount() {
    return managerCount;
  }

  public final void setManagerCount(final int managerCount) {
    this.managerCount = managerCount;
  }

  public final Double getAnnualSalesTotal() {
    return annualSalesTotal;
  }

  public final void setAnnualSalesTotal(final Double annualSalesTotal) {
    this.annualSalesTotal = annualSalesTotal;
  }

  public final int getAnnualGroupCountTotal() {
    return annualGroupCountTotal;
  }

  public final void setAnnualGroupCountTotal(final int annualGroupCountTotal) {
    this.annualGroupCountTotal = annualGroupCountTotal;
  }

  public final int getAnnualCommodityCountTotal() {
    return annualCommodityCountTotal;
  }

  public final void setAnnualCommodityCountTotal(
      final int annualCommodityCountTotal) {
    this.annualCommodityCountTotal = annualCommodityCountTotal;
  }

  public final int getYear() {
    return year;
  }

}
