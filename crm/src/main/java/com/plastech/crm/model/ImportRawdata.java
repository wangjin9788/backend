package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "import_rawdata")
public class ImportRawdata implements Serializable {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long irid;

  /**
   * 编号
   */
  private String number;

  /**
   * 导入文件名称
   */
  private String filename;

  private String savename;

  /**
   * 类型（0：）
   */
  private Integer type;

  /**
   * 状态（0：分析中，1：待确认，2：导入中，3：导入完成，4：已作废，5：导入失败）
   */
  private Integer status;

  /**
   * 进度
   */
  private Double progress;

  /**
   * 失败原因
   */
  @Column(name = "failure_cause")
  private String failureCause;

  /**
   * 操作人id
   */
  @Column(name = "operator_id")
  private Long operatorId;

  /**
   * 操作人名称
   */
  @Column(name = "operator_name")
  private String operatorName;

  /**
   * 创建时间
   */
  @Column(name = "create_time")
  private Date createTime;

  /**
   * 最后一次更新时间
   */
  @Column(name = "last_update_time")
  private Date lastUpdateTime;

  /**
   * 备注
   */
  private String note;

  private static final long serialVersionUID = 1L;

  public final String getSavename() {
    return savename;
  }

  public final void setSavename(final String savename) {
    this.savename = savename;
  }

  /**
   * @return irid
   */
  public Long getIrid() {
    return irid;
  }

  /**
   * @param irid
   */
  public void setIrid(final Long irid) {
    this.irid = irid;
  }

  /**
   * 获取编号
   *
   * @return number - 编号
   */
  public String getNumber() {
    return number;
  }

  /**
   * 设置编号
   *
   * @param number 编号
   */
  public void setNumber(final String number) {
    this.number = number;
  }

  /**
   * 获取导入文件名称
   *
   * @return filename - 导入文件名称
   */
  public String getFilename() {
    return filename;
  }

  /**
   * 设置导入文件名称
   *
   * @param filename 导入文件名称
   */
  public void setFilename(final String filename) {
    this.filename = filename;
  }

  /**
   * 获取类型（0：）
   *
   * @return type - 类型（0：）
   */
  public Integer getType() {
    return type;
  }

  /**
   * 设置类型（0：）
   *
   * @param type 类型（0：）
   */
  public void setType(final Integer type) {
    this.type = type;
  }

  /**
   * 获取状态（0：分析中，1：待确认，2：导入中，3：导入完成，4：已作废，5：导入失败）
   *
   * @return status - 状态（0：分析中，1：待确认，2：导入中，3：导入完成，4：已作废，5：导入失败）
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * 设置状态（0：分析中，1：待确认，2：导入中，3：导入完成，4：已作废，5：导入失败）
   *
   * @param status 状态（0：分析中，1：待确认，2：导入中，3：导入完成，4：已作废，5：导入失败）
   */
  public void setStatus(final Integer status) {
    this.status = status;
  }

  /**
   * 获取进度
   *
   * @return progress - 进度
   */
  public Double getProgress() {
    return progress;
  }

  /**
   * 设置进度
   *
   * @param progress 进度
   */
  public void setProgress(final Double progress) {
    this.progress = progress;
  }

  /**
   * 获取失败原因
   *
   * @return failure_cause - 失败原因
   */
  public String getFailureCause() {
    return failureCause;
  }

  /**
   * 设置失败原因
   *
   * @param failureCause 失败原因
   */
  public void setFailureCause(final String failureCause) {
    this.failureCause = failureCause;
  }

  /**
   * 获取操作人id
   *
   * @return operator_id - 操作人id
   */
  public Long getOperatorId() {
    return operatorId;
  }

  /**
   * 设置操作人id
   *
   * @param operatorId 操作人id
   */
  public void setOperatorId(final Long operatorId) {
    this.operatorId = operatorId;
  }

  /**
   * 获取操作人名称
   *
   * @return operator_name - 操作人名称
   */
  public String getOperatorName() {
    return operatorName;
  }

  /**
   * 设置操作人名称
   *
   * @param operatorName 操作人名称
   */
  public void setOperatorName(final String operatorName) {
    this.operatorName = operatorName;
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
   * 获取最后一次更新时间
   *
   * @return last_update_time - 最后一次更新时间
   */
  public Date getLastUpdateTime() {
    return lastUpdateTime;
  }

  /**
   * 设置最后一次更新时间
   *
   * @param lastUpdateTime 最后一次更新时间
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
