package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "customer")
public class Customer implements Serializable {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long cuid;

  /**
   * 集团、分公司、部门id
   */
  private Long gid;

  /**
   * 状态（-1：删除，0：正常）
   */
  private Integer status;

  /**
   * 客户名称
   */
  @Column(name = "cu_name")
  private String cuName;

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

  @Column(name = "cu_address")
  private String cuAddress;

  private static final long serialVersionUID = 1L;

  /**
   * @return the cuid
   */
  public Long getCuid() {
    return cuid;
  }

  /**
   * @param cuid the cuid to set
   */
  public void setCuid(final Long cuid) {
    this.cuid = cuid;
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
   * @return the cuAddress
   */
  public String getCuAddress() {
    return cuAddress;
  }

  /**
   * @param cuAddress the cuAddress to set
   */
  public void setCuAddress(final String cuAddress) {
    this.cuAddress = cuAddress;
  }


}
