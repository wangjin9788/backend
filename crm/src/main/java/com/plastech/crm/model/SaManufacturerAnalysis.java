package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sa_manufacturer")
public class SaManufacturerAnalysis implements Serializable {
  /**
   * 生产商表id
   */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long smid;

  /**
   * 生产商id
   */
  private Long mfid;
  /**
   * 最终客户id
   */
  private Long gid;

  /**
   * 忠诚度id
   */
  private Long lid;

  /**
   * 品类id
   */
  private Long ctid;

  /**
   * 最终客户名称
   */
  @Column(name = "g_name")
  private String gName;

  /**
   * 忠诚度
   */
  @Column(name = "l_name")
  private String lName;

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
   * 获取忠诚度id
   *
   * @return lid - 忠诚度id
   */
  public Long getLid() {
    return lid;
  }

  /**
   * 设置忠诚度id
   *
   * @param lid 忠诚度id
   */
  public void setLid(final Long lid) {
    this.lid = lid;
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
   * 获取最终客户名称
   *
   * @return g_name - 最终客户名称
   */
  public String getgName() {
    return gName;
  }

  /**
   * 设置最终客户名称
   *
   * @param gName 最终客户名称
   */
  public void setgName(final String gName) {
    this.gName = gName;
  }

  /**
   * 获取忠诚度
   *
   * @return l_name - 忠诚度
   */
  public String getlName() {
    return lName;
  }

  /**
   * 设置忠诚度
   *
   * @param lName 忠诚度
   */
  public void setlName(final String lName) {
    this.lName = lName;
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
   * @return the gid
   */
  public Long getGid() {
    return gid;
  }

  /**
   * @param gid the gid to set
   */
  public void setGid(final Long gid) {
    this.gid = gid;
  }

}
