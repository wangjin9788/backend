package com.plastech.crm.model.parameter;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangJin
 *
 * @date 2019年1月24日 下午4:01:26
 *
 */
public class AddOrUpdateContractParameters implements Serializable {

  private static final long serialVersionUID = 1L;
  // 集团id
  private Long gid;
  // 客户id
  private Long cuid;
  // 销售经理表id
  private Long uid;
  // 合同编号
  private String number;
  // 总销售额
  private Double grossSales;
  // 签署时间
  private String signingTime;

  private List<AddOrUpdateContractGradeParameters> contractList;


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
  public Long getUid() {
    return uid;
  }

  /**
   * @param smid the smid to set
   */
  public void setUid(final Long uid) {
    this.uid = uid;
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
   * @return the signingTime
   */
  public String getSigningTime() {
    return signingTime;
  }

  /**
   * @param signingTime the signingTime to set
   */
  public void setSigningTime(final String signingTime) {
    this.signingTime = signingTime;
  }

  /**
   * @return the contractList
   */
  public List<AddOrUpdateContractGradeParameters> getContractList() {
    return contractList;
  }

  /**
   * @param contractList the contractList to set
   */
  public void setContractList(
      final List<AddOrUpdateContractGradeParameters> contractList) {
    this.contractList = contractList;
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
    result =
        prime * result + ((contractList == null) ? 0 : contractList.hashCode());
    result = prime * result + ((cuid == null) ? 0 : cuid.hashCode());
    result = prime * result + ((gid == null) ? 0 : gid.hashCode());
    result =
        prime * result + ((grossSales == null) ? 0 : grossSales.hashCode());
    result = prime * result + ((number == null) ? 0 : number.hashCode());
    result =
        prime * result + ((signingTime == null) ? 0 : signingTime.hashCode());
    result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
    final AddOrUpdateContractParameters other =
        (AddOrUpdateContractParameters) obj;
    if (contractList == null) {
      if (other.contractList != null)
        return false;
    } else if (!contractList.equals(other.contractList))
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
    if (grossSales == null) {
      if (other.grossSales != null)
        return false;
    } else if (!grossSales.equals(other.grossSales))
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
    if (uid == null) {
      if (other.uid != null)
        return false;
    } else if (!uid.equals(other.uid))
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
    return "AddOrUpdateContractParameters [ gid=" + gid + ", cuid=" + cuid
        + ", uid=" + uid + ", number=" + number + ", grossSales=" + grossSales
        + ", signingTime=" + signingTime + ", contractList=" + contractList
        + "]";
  }

}
