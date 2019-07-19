package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sa_manufacturer_detail")
public class SaManufacturerDetail implements Serializable {
  /**
   * 分析生产商品类购买量id
   */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long smdid;

  /**
   * 最终客户id
   */
  private Long gid;

  private Long ctid;

  /**
   * 生产商id
   */
  private Long mfid;

  /**
   * 品类名称
   */
  @Column(name = "ct_name")
  private String ctName;

  /**
   * 采购量
   */
  @Column(name = "purchase_quantity")
  private Double purchaseQuantity;

  /**
   * 年份（如：2019）
   */
  @Column(name = "smd_year")
  private String smdYear;

  /**
   * 月份（如：02代表2月，若为全年的统计数据，月份值为13）
   */
  @Column(name = "smd_month")
  private Integer smdMonth;

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
   * 获取分析生产商品类购买量id
   *
   * @return smdid - 分析生产商品类购买量id
   */
  public Long getSmdid() {
    return smdid;
  }

  /**
   * 设置分析生产商品类购买量id
   *
   * @param smdid 分析生产商品类购买量id
   */
  public void setSmdid(final Long smdid) {
    this.smdid = smdid;
  }

  /**
   * 获取最终客户id
   *
   * @return gid - 最终客户id
   */
  public Long getGid() {
    return gid;
  }

  /**
   * 设置最终客户id
   *
   * @param gid 最终客户id
   */
  public void setGid(final Long gid) {
    this.gid = gid;
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
   * 获取品类名称
   *
   * @return ct_name - 品类名称
   */
  public String getCtName() {
    return ctName;
  }

  /**
   * 设置品类名称
   *
   * @param ctName 品类名称
   */
  public void setCtName(final String ctName) {
    this.ctName = ctName;
  }

  /**
   * 获取采购量
   *
   * @return purchase_quantity - 采购量
   */
  public Double getPurchaseQuantity() {
    return purchaseQuantity;
  }

  /**
   * 设置采购量
   *
   * @param purchaseQuantity 采购量
   */
  public void setPurchaseQuantity(final Double purchaseQuantity) {
    this.purchaseQuantity = purchaseQuantity;
  }

  /**
   * 获取年份（如：2019）
   *
   * @return smd_year - 年份（如：2019）
   */
  public String getSmdYear() {
    return smdYear;
  }

  /**
   * 设置年份（如：2019）
   *
   * @param smdYear 年份（如：2019）
   */
  public void setSmdYear(final String smdYear) {
    this.smdYear = smdYear;
  }

  /**
   * 获取月份（如：02代表2月，若为全年的统计数据，月份值为13）
   *
   * @return smd_month - 月份（如：02代表2月，若为全年的统计数据，月份值为13）
   */
  public Integer getSmdMonth() {
    return smdMonth;
  }

  /**
   * 设置月份（如：02代表2月，若为全年的统计数据，月份值为13）
   *
   * @param integer 月份（如：02代表2月，若为全年的统计数据，月份值为13）
   */
  public void setSmdMonth(final Integer integer) {
    this.smdMonth = integer;
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
   * @return the ctid
   */
  public Long getCtid() {
    return ctid;
  }

  /**
   * @param ctid the ctid to set
   */
  public void setCtid(final Long ctid) {
    this.ctid = ctid;
  }


}
