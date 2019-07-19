package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年3月26日 下午4:14:28
 *
 */
public class SaGroupsCommodityPercentageView implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long ctid;
  private String name;
  private Double purchaseVolume;

  /**
   * @return the ctid
   */
  public Long getCtid() {
    return ctid;
  }

  /**
   * @param ctid the ctid to set
   */
  public void setCtid(final Long ctid) {
    this.ctid = ctid;
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
   * @return the purchaseVolume
   */
  public Double getPurchaseVolume() {
    return purchaseVolume;
  }

  /**
   * @param purchaseVolume the purchaseVolume to set
   */
  public void setPurchaseVolume(final Double purchaseVolume) {
    this.purchaseVolume = purchaseVolume;
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
    result = prime * result + ((ctid == null) ? 0 : ctid.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result
        + ((purchaseVolume == null) ? 0 : purchaseVolume.hashCode());
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
    final SaGroupsCommodityPercentageView other =
        (SaGroupsCommodityPercentageView) obj;
    if (ctid == null) {
      if (other.ctid != null)
        return false;
    } else if (!ctid.equals(other.ctid))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (purchaseVolume == null) {
      if (other.purchaseVolume != null)
        return false;
    } else if (!purchaseVolume.equals(other.purchaseVolume))
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
    return "SaGroupsCommodityPercentageView [ctid=" + ctid + ", name=" + name
        + ", purchaseVolume=" + purchaseVolume + "]";
  }


}
