package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Groups implements Serializable {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long gid;

  /**
   * 集团名称
   */
  private String name;

  /**
   * 类型（0：客户 1：供应商）
   */
  private Integer type;

  /**
   * 分级（0：总公司，1：分公司，2：部门）
   */
  private Integer code;

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

  /**
   * 状态（-1：删除，0：正常）
   */
  private Integer status;

  private static final long serialVersionUID = 1L;

  /**
   * @return gid
   */
  public Long getGid() {
    return gid;
  }

  /**
   * @param gid
   */
  public void setGid(final Long gid) {
    this.gid = gid;
  }

  /**
   * 获取集团名称
   *
   * @return name - 集团名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置集团名称
   *
   * @param name 集团名称
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * 获取类型（0：客户 1：供应商）
   *
   * @return type - 类型（0：客户 1：供应商）
   */
  public Integer getType() {
    return type;
  }

  /**
   * 设置类型（0：客户 1：供应商）
   *
   * @param type 类型（0：客户 1：供应商）
   */
  public void setType(final Integer type) {
    this.type = type;
  }

  /**
   * 获取分级（0：总公司，1：分公司，2：部门）
   *
   * @return code - 分级（0：总公司，1：分公司，2：部门）
   */
  public Integer getCode() {
    return code;
  }

  /**
   * 设置分级（0：总公司，1：分公司，2：部门）
   *
   * @param code 分级（0：总公司，1：分公司，2：部门）
   */
  public void setCode(final Integer code) {
    this.code = code;
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
   * @return creattor_time - 创建时间
   */
  public Date getCreatorTime() {
    return creatorTime;
  }

  /**
   * 设置创建时间
   *
   * @param creattorTime 创建时间
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
}
