package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sa_customer")
public class SaCustomerDetailAnalysis implements Serializable {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long scuid;

  /**
   * 最終客戶id
   */
  private Long gid;

  /**
   * 品类名称
   */
  private Long cuid;

  private Long ctid;

  private Long mfid;

  /**
   * 购买量
   */
  @Column(name = "cu_name")
  private String cuName;

  /**
   * 购买量
   */
  @Column(name = "purchase_total")
  private Double purchaseTotal;

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
   * 备注
   */
  private String note;

  private static final long serialVersionUID = 1L;

  /**
   * @return scuid
   */
  public Long getScuid() {
    return scuid;
  }

  /**
   * @param scuid
   */
  public void setScuid(final Long scuid) {
    this.scuid = scuid;
  }

  /**
   * 获取最終客戶id
   *
   * @return gid - 最終客戶id
   */
  public Long getGid() {
    return gid;
  }

  /**
   * 设置最終客戶id
   *
   * @param gid 最終客戶id
   */
  public void setGid(final Long gid) {
    this.gid = gid;
  }

  /**
   * 获取品类名称
   *
   * @return cuid - 品类名称
   */
  public Long getCuid() {
    return cuid;
  }

  /**
   * 设置品类名称
   *
   * @param cuid 品类名称
   */
  public void setCuid(final Long cuid) {
    this.cuid = cuid;
  }

  /**
   * @return ctid
   */
  public Long getCtid() {
    return ctid;
  }

  /**
   * @param ctid
   */
  public void setCtid(final Long ctid) {
    this.ctid = ctid;
  }

  /**
   * @return mfid
   */
  public Long getMfid() {
    return mfid;
  }

  /**
   * @param mfid
   */
  public void setMfid(final Long mfid) {
    this.mfid = mfid;
  }

  /**
   * 获取购买量
   *
   * @return purchase_total - 购买量
   */
  public Double getPurchaseTotal() {
    return purchaseTotal;
  }

  /**
   * 设置购买量
   *
   * @param purchaseTotal 购买量
   */
  public void setPurchaseTotal(final Double purchaseTotal) {
    this.purchaseTotal = purchaseTotal;
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


}
