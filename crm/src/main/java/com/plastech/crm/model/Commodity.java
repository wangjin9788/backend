package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Commodity implements Serializable {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long ctid;

  /**
   * 品类名称
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
   * 备注
   */
  private String note;

  private static final long serialVersionUID = 1L;

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
   * 获取品类名称
   *
   * @return name - 品类名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置品类名称
   *
   * @param name 品类名称
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
