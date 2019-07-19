package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.Date;
import com.plastech.crm.util.CommonTools;

/**
 *
 *
 * @author : yemin
 * @date : 2019年2月12日 下午4:57:52
 *
 */
public class ImportRawdataInfo implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private Long irid;

  private String number;

  private String filename;

  private Integer type;

  /**
   * 状态（0：分析中，1：待确认，2：导入中，3：导入完成，4：已作废，5：导入失败）
   */
  private Integer status;

  private Double progress;

  private String failureCause;

  private String operatorName;

  private String createTimeStr;

  private String note;

  public final Long getIrid() {
    return irid;
  }

  public final void setIrid(final Long irid) {
    this.irid = irid;
  }

  public final String getNumber() {
    return number;
  }

  public final void setNumber(final String number) {
    this.number = number;
  }

  public final String getFilename() {
    return filename;
  }

  public final void setFilename(final String filename) {
    this.filename = filename;
  }

  public final Integer getType() {
    return type;
  }

  public final void setType(final Integer type) {
    this.type = type;
  }

  public final Integer getStatus() {
    return status;
  }

  public final void setStatus(final Integer status) {
    this.status = status;
  }

  public final Double getProgress() {
    return progress;
  }

  public final void setProgress(final Double progress) {
    this.progress = progress;
  }

  public final String getFailureCause() {
    return failureCause;
  }

  public final void setFailureCause(final String failureCause) {
    this.failureCause = failureCause;
  }

  public final String getOperatorName() {
    return operatorName;
  }

  public final void setOperatorName(final String operatorName) {
    this.operatorName = operatorName;
  }

  public final String getCreateTimeStr() {
    return createTimeStr;
  }

  public final void setCreateTimeStr(final Date createTime) {
    this.createTimeStr =
        createTime != null ? CommonTools.parseDateToString(createTime,
            CommonTools.DATEFORMAT_Y4_MM_DD_HMS) : "";
  }

  public final String getNote() {
    return note;
  }

  public final void setNote(final String note) {
    this.note = note;
  }

}
