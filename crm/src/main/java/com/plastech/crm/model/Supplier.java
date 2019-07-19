package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Supplier implements Serializable {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long suid;


  /**
   * 状态（-1：删除，0：正常）
   */
  private Integer status;

  /**
   * 供应商名称
   */
  @Column(name = "su_name")
  private String suName;


  /**
   * 供应商全称
   */
  @Column(name = "su_full_name")
  private String fullName;

  @Column(name = "su_address")
  private String suAddress;


  /**
   * 创建人id
   */
  @Column(name = "creator_id")
  private Long creatorId;

  /**
   * 创建时间
   */
  @Column(name = "creator_time")
  private Date creatorTime;

  /**
   * 最后修改人id
   */
  @Column(name = "last_update_id")
  private Long lastUpdateId;

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
   * @return the suid
   */
  public Long getSuid() {
    return suid;
  }

  /**
   * @param suid the suid to set
   */
  public void setSuid(final Long suid) {
    this.suid = suid;
  }

  /**
   * @return the status
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(final Integer status) {
    this.status = status;
  }

  /**
   * @return the suName
   */
  public String getSuName() {
    return suName;
  }

  /**
   * @param suName the suName to set
   */
  public void setSuName(final String suName) {
    this.suName = suName;
  }

  /**
   * @return the suAddress
   */
  public String getSuAddress() {
    return suAddress;
  }

  /**
   * @param suAddress the suAddress to set
   */
  public void setSuAddress(final String suAddress) {
    this.suAddress = suAddress;
  }

  /**
   * @return the creatorId
   */
  public Long getCreatorId() {
    return creatorId;
  }

  /**
   * @param creatorId the creatorId to set
   */
  public void setCreatorId(final Long creatorId) {
    this.creatorId = creatorId;
  }

  /**
   * @return the creatorTime
   */
  public Date getCreatorTime() {
    return creatorTime;
  }

  /**
   * @param creatorTime the creatorTime to set
   */
  public void setCreatorTime(final Date creatorTime) {
    this.creatorTime = creatorTime;
  }

  /**
   * @return the lastUpdateId
   */
  public Long getLastUpdateId() {
    return lastUpdateId;
  }

  /**
   * @param lastUpdateId the lastUpdateId to set
   */
  public void setLastUpdateId(final Long lastUpdateId) {
    this.lastUpdateId = lastUpdateId;
  }

  /**
   * @return the lastUpdateTime
   */
  public Date getLastUpdateTime() {
    return lastUpdateTime;
  }

  /**
   * @param lastUpdateTime the lastUpdateTime to set
   */
  public void setLastUpdateTime(final Date lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

  /**
   * @return the note
   */
  public String getNote() {
    return note;
  }

  /**
   * @param note the note to set
   */
  public void setNote(final String note) {
    this.note = note;
  }

  /**
   * @return the fullName
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * @param fullName the fullName to set
   */
  public void setFullName(final String fullName) {
    this.fullName = fullName;
  }



}
