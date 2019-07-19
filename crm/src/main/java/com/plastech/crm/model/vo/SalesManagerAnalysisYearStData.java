package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * 销售经理年度销售数据统计
 *
 * @author : yemin
 * @date : 2019年2月25日 上午10:37:48
 *
 */
public class SalesManagerAnalysisYearStData implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private Long uid;
  private String uname;
  private int year;// 年份
  private Double salesTotal;// 年销售总量
  private Double previousSalesTotal;// 同比年销售总量（去年的）
  private int groupCount;// 年成交客户数
  private int commodityCount;// 年销售品类数

  public final Double getSalesTotal() {
    return salesTotal;
  }

  public final void setSalesTotal(final Double salesTotal) {
    this.salesTotal = salesTotal;
  }

  public final Double getPreviousSalesTotal() {
    return previousSalesTotal;
  }

  public final void setPreviousSalesTotal(final Double previousSalesTotal) {
    this.previousSalesTotal = previousSalesTotal;
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

  public final void setYear(final int year) {
    this.year = year;
  }

  public final Long getUid() {
    return uid;
  }

  public final void setUid(final Long uid) {
    this.uid = uid;
  }

  public final String getUname() {
    return uname;
  }

  public final void setUname(final String uname) {
    this.uname = uname;
  }

  public final int getYear() {
    return year;
  }

}
