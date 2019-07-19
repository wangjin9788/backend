package com.plastech.crm.model.vo;

import java.io.Serializable;
import com.plastech.crm.model.parameter.AddOrUpdateContractParameters;

/**
 * @author wangJin
 *
 * @date 2019年1月28日 下午1:29:44
 *
 */
public class ContractBaseDetailView extends AddOrUpdateContractParameters
    implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long coid;

  private String cuName;

  private String gName;

  private String managerName;

  // 总毛利
  private String grossProfit;

  // 总净利
  private String netProfit;

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
   * @return the gName
   */
  public String getgName() {
    return gName;
  }

  /**
   * @param gName the gName to set
   */
  public void setgName(final String gName) {
    this.gName = gName;
  }

  /**
   * @return the managerName
   */
  public String getManagerName() {
    return managerName;
  }

  /**
   * @param managerName the managerName to set
   */
  public void setManagerName(final String managerName) {
    this.managerName = managerName;
  }

  /**
   * @return the grossProfit
   */
  public String getGrossProfit() {
    return grossProfit;
  }

  /**
   * @param grossProfit the grossProfit to set
   */
  public void setGrossProfit(final String grossProfit) {
    this.grossProfit = grossProfit;
  }

  /**
   * @return the netProfit
   */
  public String getNetProfit() {
    return netProfit;
  }

  /**
   * @param netProfit the netProfit to set
   */
  public void setNetProfit(final String netProfit) {
    this.netProfit = netProfit;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((coid == null) ? 0 : coid.hashCode());
    result = prime * result + ((cuName == null) ? 0 : cuName.hashCode());
    result = prime * result + ((gName == null) ? 0 : gName.hashCode());
    result =
        prime * result + ((grossProfit == null) ? 0 : grossProfit.hashCode());
    result =
        prime * result + ((managerName == null) ? 0 : managerName.hashCode());
    result = prime * result + ((netProfit == null) ? 0 : netProfit.hashCode());
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
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    final ContractBaseDetailView other = (ContractBaseDetailView) obj;
    if (coid == null) {
      if (other.coid != null)
        return false;
    } else if (!coid.equals(other.coid))
      return false;
    if (cuName == null) {
      if (other.cuName != null)
        return false;
    } else if (!cuName.equals(other.cuName))
      return false;
    if (gName == null) {
      if (other.gName != null)
        return false;
    } else if (!gName.equals(other.gName))
      return false;
    if (grossProfit == null) {
      if (other.grossProfit != null)
        return false;
    } else if (!grossProfit.equals(other.grossProfit))
      return false;
    if (managerName == null) {
      if (other.managerName != null)
        return false;
    } else if (!managerName.equals(other.managerName))
      return false;
    if (netProfit == null) {
      if (other.netProfit != null)
        return false;
    } else if (!netProfit.equals(other.netProfit))
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
    return "ContractBaseDetailView [coid=" + coid + ", cuName=" + cuName
        + ", gName=" + gName + ", managerName=" + managerName + ", grossProfit="
        + grossProfit + ", netProfit=" + netProfit + "]";
  }


}
