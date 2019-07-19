package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "loyalty")
public class Loyalty implements Serializable {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long lid;

  /**
   * 购买频率
   */
  @Column(name = "max_frequency")
  private Integer maxFrequency;

  @Column(name = "min_frequency")
  private Integer minFrequency;

  /**
   * 时长
   */
  private Integer duration;

  /**
   * 优先级
   */
  private Integer priority;
  /**
   * 优先级
   */
  private String name;

  /**
   * 状态（-1：删除，0：正常）
   */
  private Integer status;

  /**
   * 创建时间
   */
  @Column(name = "creator_time")
  private Date creatorTime;

  /**
   * 创建人id
   */
  @Column(name = "creator_id")
  private Long creatorId;

  /**
   * 备注
   */
  private String note;

  private static final long serialVersionUID = 1L;

  /**
   * @return lid
   */
  public Long getLid() {
    return lid;
  }

  /**
   * @param lid
   */
  public void setLid(final Long lid) {
    this.lid = lid;
  }

  /**
   * 获取购买频率
   *
   * @return max_frequency - 购买频率
   */
  public Integer getMaxFrequency() {
    return maxFrequency;
  }

  /**
   * 设置购买频率
   *
   * @param maxFrequency 购买频率
   */
  public void setMaxFrequency(final Integer maxFrequency) {
    this.maxFrequency = maxFrequency;
  }

  /**
   * @return min_frequency
   */
  public Integer getMinFrequency() {
    return minFrequency;
  }

  /**
   * @param minFrequency
   */
  public void setMinFrequency(final Integer minFrequency) {
    this.minFrequency = minFrequency;
  }

  /**
   * 获取时长
   *
   * @return duration - 时长
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * 设置时长
   *
   * @param duration 时长
   */
  public void setDuration(final Integer duration) {
    this.duration = duration;
  }

  /**
   * 获取优先级
   *
   * @return priority - 优先级
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * 设置优先级
   *
   * @param priority 优先级
   */
  public void setPriority(final Integer priority) {
    this.priority = priority;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
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
   * 获取创建人id
   *
   * @return creator_id - 创建人id
   */
  public Long getCreatorId() {
    return creatorId;
  }

  /**
   * 设置创建人id
   *
   * @param creatorId 创建人id
   */
  public void setCreatorId(final Long creatorId) {
    this.creatorId = creatorId;
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
