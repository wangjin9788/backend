package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sa_manufacturer")
public class SaManufacturer implements Serializable {
  /**
   * 生产商表id
   */
  @Id
  private Long smid;

  /**
   * 生产商id
   */
  private Long mfid;

  /**
   * 品类id
   */
  private Long ctid;

  /**
   * 客户最终公司（集团）客户数量
   */
  @Column(name = "customers_count")
  private Long customersCount;

  /**
   * 生产商名字
   */
  @Column(name = "mf_name")
  private String mfName;

  /**
   * 销售量
   */
  @Column(name = "sales_total")
  private Double salesTotal;

  /**
   * 年份（如：2019）
   */
  private String year;

  /**
   * 月份（如：02代表2月，若为全年的统计数据，月份值为13）
   */
  private String month;

  /**
   * 创建时间
   */
  @Column(name = "create_time")
  private Date createTime;

  /**
   * 最后更新时间
   */
  @Column(name = "last_update_time")
  private Date lastUpdateTime;

  /**
   * 最后更新时间
   */
  @Column(name = "commodity_count")
  private Integer commodityCount;

  /**
   * 备注
   */
  private String note;

  private static final long serialVersionUID = 1L;

  /**
   * 获取生产商表id
   *
   * @return smid - 生产商表id
   */
  public Long getSmid() {
    return smid;
  }

  /**
   * 设置生产商表id
   *
   * @param smid 生产商表id
   */
  public void setSmid(final Long smid) {
    this.smid = smid;
  }

  /**
   * 获取生产商id
   *
   * @return mfid - 生产商id
   */
  public Long getMfid() {
    return mfid;
  }

  /**
   * 设置生产商id
   *
   * @param mfid 生产商id
   */
  public void setMfid(final Long mfid) {
    this.mfid = mfid;
  }

  /**
   * 获取品类id
   *
   * @return ctid - 品类id
   */
  public Long getCtid() {
    return ctid;
  }

  /**
   * 设置品类id
   *
   * @param ctid 品类id
   */
  public void setCtid(final Long ctid) {
    this.ctid = ctid;
  }

  /**
   * 获取客户最终公司（集团）客户数量
   *
   * @return customers_count - 客户最终公司（集团）客户数量
   */
  public Long getCustomersCount() {
    return customersCount;
  }

  /**
   * 设置客户最终公司（集团）客户数量
   *
   * @param customersCount 客户最终公司（集团）客户数量
   */
  public void setCustomersCount(final Long customersCount) {
    this.customersCount = customersCount;
  }

  /**
   * 获取生产商名字
   *
   * @return mf_name - 生产商名字
   */
  public String getMfName() {
    return mfName;
  }

  /**
   * 设置生产商名字
   *
   * @param mfName 生产商名字
   */
  public void setMfName(final String mfName) {
    this.mfName = mfName;
  }

  /**
   * 获取销售量
   *
   * @return sales_total - 销售量
   */
  public Double getSalesTotal() {
    return salesTotal;
  }

  /**
   * 设置销售量
   *
   * @param salesTotal 销售量
   */
  public void setSalesTotal(final Double salesTotal) {
    this.salesTotal = salesTotal;
  }

  /**
   * 获取年份（如：2019）
   *
   * @return year - 年份（如：2019）
   */
  public String getYear() {
    return year;
  }

  /**
   * 设置年份（如：2019）
   *
   * @param year 年份（如：2019）
   */
  public void setYear(final String year) {
    this.year = year;
  }

  /**
   * 获取月份（如：02代表2月，若为全年的统计数据，月份值为13）
   *
   * @return month - 月份（如：02代表2月，若为全年的统计数据，月份值为13）
   */
  public String getMonth() {
    return month;
  }

  /**
   * 设置月份（如：02代表2月，若为全年的统计数据，月份值为13）
   *
   * @param month 月份（如：02代表2月，若为全年的统计数据，月份值为13）
   */
  public void setMonth(final String month) {
    this.month = month;
  }

  /**
   * 获取创建时间
   *
   * @return create_time - 创建时间
   */
  public Date getCreateTime() {
    return createTime;
  }

  /**
   * 设置创建时间
   *
   * @param createTime 创建时间
   */
  public void setCreateTime(final Date createTime) {
    this.createTime = createTime;
  }

  /**
   * 获取最后更新时间
   *
   * @return last_update_time - 最后更新时间
   */
  public Date getLastUpdateTime() {
    return lastUpdateTime;
  }

  /**
   * 设置最后更新时间
   *
   * @param lastUpdateTime 最后更新时间
   */
  public void setLastUpdateTime(final Date lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

  /**
   * 获取备注
   *
   * @return note - 备注
   */
  public String getNote() {
    return note;
  }

  /**
   * 设置备注
   *
   * @param note 备注
   */
  public void setNote(final String note) {
    this.note = note;
  }

  /**
   * @return the commodityCount
   */
  public Integer getCommodityCount() {
    return commodityCount;
  }

  /**
   * @param commodityCount the commodityCount to set
   */
  public void setCommodityCount(final Integer commodityCount) {
    this.commodityCount = commodityCount;
  }


}
