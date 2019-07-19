package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "manufacturer")
public class Manufacturer implements Serializable {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long mfid;

  /**
   * 生产商名称
   */
  private String name;

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
   * 最后修改者id
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
   * 获取生产商名称
   *
   * @return name - 生产商名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置生产商名称
   *
   * @param name 生产商名称
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * 获取状态（-1：删除，0：正常）
   *
   * @return status - 状态（-1：删除，0：正常）
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * 设置状态（-1：删除，0：正常）
   *
   * @param status 状态（-1：删除，0：正常）
   */
  public void setStatus(final Integer status) {
    this.status = status;
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
   * 设置创建者id
   *
   * @param creatorId 创建者id
   */
  public void setCreatorId(final Long creatorId) {
    this.creatorId = creatorId;
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
   * 设置创建时间
   *
   * @param creatorTime 创建时间
   */
  public void setCreatorTime(final Date creatorTime) {
    this.creatorTime = creatorTime;
  }

  /**
   * 获取最后修改者id
   *
   * @return last_update_id - 最后修改者id
   */
  public Long getLastUpdateId() {
    return lastUpdateId;
  }

  /**
   * 设置最后修改者id
   *
   * @param lastUpdateId 最后修改者id
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
   * 设置最后修改时间
   *
   * @param lastUpdateTime 最后修改时间
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
}
