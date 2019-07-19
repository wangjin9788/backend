package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangJin
 *
 * @date 2019年1月24日 上午10:46:39
 *
 */
public class ContractView implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * 合同id
   */
  private Long coid;
  /**
   * 集团id
   */
  private Long gid;

  /**
   * 客户id
   */
  private Long cuid;

  /**
   * 销售经理表id
   */
  private Long smid;
  /**
   * 合同编号
   */
  private String number;
  /**
   * 总毛利
   */
  private Double grossProfit;
  /**
   * 总销售额
   */
  private Double grossSales;

  /**
   * 总净利
   */
  private Double totalNetProfit;

  /**
   * 签署时间
   */
  private Date signingTime;

  /**
   * 状态（-1：删除，0：正常）
   */
  private Integer status;

  /**
   * 备注
   */
  private String note;

  /**
   * @return the coid
   */
  public Long getCoid() {
    return coid;
  }

  /**
   * @param coid the coid to set
   */
  public void setCoid(final Long coid) {
    this.coid = coid;
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
   * @return the smid
   */
  public Long getSmid() {
    return smid;
  }

  /**
   * @param smid the smid to set
   */
  public void setSmid(final Long smid) {
    this.smid = smid;
  }

  /**
   * @return the number
   */
  public String getNumber() {
    return number;
  }

  /**
   * @param number the number to set
   */
  public void setNumber(final String number) {
    this.number = number;
  }

  /**
   * @return the grossProfit
   */
  public Double getGrossProfit() {
    return grossProfit;
  }

  /**
   * @param grossProfit the grossProfit to set
   */
  public void setGrossProfit(final Double grossProfit) {
    this.grossProfit = grossProfit;
  }

  /**
   * @return the grossSales
   */
  public Double getGrossSales() {
    return grossSales;
  }

  /**
   * @param grossSales the grossSales to set
   */
  public void setGrossSales(final Double grossSales) {
    this.grossSales = grossSales;
  }

  /**
   * @return the totalNetProfit
   */
  public Double getTotalNetProfit() {
    return totalNetProfit;
  }

  /**
   * @param totalNetProfit the totalNetProfit to set
   */
  public void setTotalNetProfit(final Double totalNetProfit) {
    this.totalNetProfit = totalNetProfit;
  }

  /**
   * @return the signingTime
   */
  public Date getSigningTime() {
    return signingTime;
  }

  /**
   * @param signingTime the signingTime to set
   */
  public void setSigningTime(final Date signingTime) {
    this.signingTime = signingTime;
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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((coid == null) ? 0 : coid.hashCode());
    result = prime * result + ((cuid == null) ? 0 : cuid.hashCode());
    result = prime * result + ((gid == null) ? 0 : gid.hashCode());
    result =
        prime * result + ((grossProfit == null) ? 0 : grossProfit.hashCode());
    result =
        prime * result + ((grossSales == null) ? 0 : grossSales.hashCode());
    result = prime * result + ((note == null) ? 0 : note.hashCode());
    result = prime * result + ((number == null) ? 0 : number.hashCode());
    result =
        prime * result + ((signingTime == null) ? 0 : signingTime.hashCode());
    result = prime * result + ((smid == null) ? 0 : smid.hashCode());
    result = prime * result + ((status == null) ? 0 : status.hashCode());
    result = prime * result
        + ((totalNetProfit == null) ? 0 : totalNetProfit.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final ContractView other = (ContractView) obj;
    if (coid == null) {
      if (other.coid != null)
        return false;
    } else if (!coid.equals(other.coid))
      return false;
    if (cuid == null) {
      if (other.cuid != null)
        return false;
    } else if (!cuid.equals(other.cuid))
      return false;
    if (gid == null) {
      if (other.gid != null)
        return false;
    } else if (!gid.equals(other.gid))
      return false;
    if (grossProfit == null) {
      if (other.grossProfit != null)
        return false;
    } else if (!grossProfit.equals(other.grossProfit))
      return false;
    if (grossSales == null) {
      if (other.grossSales != null)
        return false;
    } else if (!grossSales.equals(other.grossSales))
      return false;
    if (note == null) {
      if (other.note != null)
        return false;
    } else if (!note.equals(other.note))
      return false;
    if (number == null) {
      if (other.number != null)
        return false;
    } else if (!number.equals(other.number))
      return false;
    if (signingTime == null) {
      if (other.signingTime != null)
        return false;
    } else if (!signingTime.equals(other.signingTime))
      return false;
    if (smid == null) {
      if (other.smid != null)
        return false;
    } else if (!smid.equals(other.smid))
      return false;
    if (status == null) {
      if (other.status != null)
        return false;
    } else if (!status.equals(other.status))
      return false;
    if (totalNetProfit == null) {
      if (other.totalNetProfit != null)
        return false;
    } else if (!totalNetProfit.equals(other.totalNetProfit))
      return false;
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "ContractView [coid=" + coid + ", gid=" + gid + ", cuid=" + cuid
        + ", smid=" + smid + ", number=" + number + ", grossProfit="
        + grossProfit + ", grossSales=" + grossSales + ", totalNetProfit="
        + totalNetProfit + ", signingTime=" + signingTime + ", status=" + status
        + ", note=" + note + "]";
  }


}
