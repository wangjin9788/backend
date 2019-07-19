package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "grade")
public class Grade implements Serializable {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long geid;

  /**
   * 品类id
   */
  private Long ctid;

  /**
   * 生产商id
   */
  private Long mfid;

  /**
   * 牌号
   */
  @Column(name = "grade_number")
  private String gradeNumber;

  /**
   * 状态（-1：删除，0：正常）
   */
  private Integer status;

  /**
   * 创建者id
   */
  @Column(name = "creator_id")
  private Long creatorId;

  /**
   * 创建时间
   */
  @Column(name = "creator_time")
  private Date creatorTime;

  /**
   * 修改者id
   */
  @Column(name = "last_update_id")
  private Long lastUpdateId;

  /**
   * 最后修改时间
   */
  @Column(name = "last_update_time")
  private Date lastUpdateTime;

  /**
   * 备注
   */
  private String note;

  private static final long serialVersionUID = 1L;

  /**
   * @return geid
   */
  public Long getGeid() {
    return geid;
  }

  /**
   * @param geid
   */
  public void setGeid(final Long geid) {
    this.geid = geid;
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
   * 获取牌号
   *
   * @return grade_number - 牌号
   */
  public String getGradeNumber() {
    return gradeNumber;
  }

  /**
   * 获取状态（-1：删除，0：正常）
   *
   * @return stauts - 状态（-1：删除，0：正常）
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * 设置牌号
   *
   * @param gradeNumber 牌号
   */
  public void setGradeNumber(final String gradeNumber) {
    this.gradeNumber = gradeNumber;
  }

  /**
   * 设置状态（-1：删除，0：正常）
   *
   * @param stauts 状态（-1：删除，0：正常）
   */
  public void setStatus(final Integer status) {
    this.status = status;
  }

  /**
   * 设置创建者id
   *
   * @param creatorId 创建者id
   */
  public void setCreatorId(final Long creatorId) {
    this.creatorId = creatorId;
  }

  /**
   * 获取创建者id
   *
   * @return creator_id - 创建者id
   */
  public Long getCreatorId() {
    return creatorId;
  }

  /**
   * 获取创建时间
   *
   * @return creator_time - 创建时间
   */
  public Date getCreatorTime() {
    return creatorTime;
  }


  /**
   * 获取修改者id
   *
   * @return last_update_id - 修改者id
   */
  public Long getLastUpdateId() {
    return lastUpdateId;
  }

  /**
   * 设置修改者id
   *
   * @param lastUpdateId 修改者id
   */
  public void setLastUpdateId(final Long lastUpdateId) {
    this.lastUpdateId = lastUpdateId;
  }

  /**
   * 获取最后修改时间
   *
   * @return last_update_time - 最后修改时间
   */
  public Date getLastUpdateTime() {
    return lastUpdateTime;
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
   * 设置最后修改时间
   *
   * @param lastUpdateTime 最后修改时间
   */
  public void setLastUpdateTime(final Date lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }


  /**
   * 设置创建时间
   *
   * @param creatorTime 创建时间
   */
  public void setCreatorTime(final Date creatorTime) {
    this.creatorTime = creatorTime;
  }

  /**
   * 设置备注
   *
   * @param note 备注
   */
  public void setNote(final String note) {
    this.note = note;
  }
}
