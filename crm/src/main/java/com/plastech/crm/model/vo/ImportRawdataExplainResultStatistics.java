package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 *
 *
 * @author : yemin
 * @date : 2019年2月13日 上午10:03:11
 *
 */
public class ImportRawdataExplainResultStatistics implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long irid;

  private Long insertCount;
  private Long updateCount;
  private Long abnormalCount;

  private Integer status;
  private String failureCause;

  public ImportRawdataExplainResultStatistics() {
    super();
  }

  public ImportRawdataExplainResultStatistics(final Long irid) {
    this.irid = irid;
    this.insertCount = 0L;
    this.updateCount = 0L;
    this.abnormalCount = 0L;
    this.status = 0;
    this.failureCause = "";
  }

  public final Long getIrid() {
    return irid;
  }

  public final void setIrid(final Long irid) {
    this.irid = irid;
  }

  public final Long getInsertCount() {
    return insertCount;
  }

  public final void setInsertCount(final Long insertCount) {
    this.insertCount = insertCount;
  }

  public final Long getUpdateCount() {
    return updateCount;
  }

  public final void setUpdateCount(final Long updateCount) {
    this.updateCount = updateCount;
  }

  public final Long getAbnormalCount() {
    return abnormalCount;
  }

  public final void setAbnormalCount(final Long abnormalCount) {
    this.abnormalCount = abnormalCount;
  }

  public final Integer getStatus() {
    return status;
  }

  public final void setStatus(final Integer status) {
    this.status = status;
  }

  public final String getFailureCause() {
    return failureCause;
  }

  public final void setFailureCause(final String failureCause) {
    this.failureCause = failureCause;
  }

}
