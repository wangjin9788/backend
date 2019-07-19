package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年3月5日 下午1:46:54
 *
 */
public class SaManufacturerCommodityView implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long gid;
  private Long mfid;
  private String quantity;
  private String ctName;
  private Long ctid;



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
   * @return the mfid
   */
  public Long getMfid() {
    return mfid;
  }

  /**
   * @param mfid the mfid to set
   */
  public void setMfid(final Long mfid) {
    this.mfid = mfid;
  }

  /**
   * @return the quantity
   */
  public String getQuantity() {
    return quantity;
  }

  /**
   * @param quantity the quantity to set
   */
  public void setQuantity(final String quantity) {
    this.quantity = quantity;
  }

  /**
   * @return the ctName
   */
  public String getCtName() {
    return ctName;
  }

  /**
   * @param ctName the ctName to set
   */
  public void setCtName(final String ctName) {
    this.ctName = ctName;
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
    result = prime * result + ((ctName == null) ? 0 : ctName.hashCode());
    result = prime * result + ((ctid == null) ? 0 : ctid.hashCode());
    result = prime * result + ((gid == null) ? 0 : gid.hashCode());
    result = prime * result + ((mfid == null) ? 0 : mfid.hashCode());
    result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
    final SaManufacturerCommodityView other = (SaManufacturerCommodityView) obj;
    if (ctName == null) {
      if (other.ctName != null)
        return false;
    } else if (!ctName.equals(other.ctName))
      return false;
    if (ctid == null) {
      if (other.ctid != null)
        return false;
    } else if (!ctid.equals(other.ctid))
      return false;
    if (gid == null) {
      if (other.gid != null)
        return false;
    } else if (!gid.equals(other.gid))
      return false;
    if (mfid == null) {
      if (other.mfid != null)
        return false;
    } else if (!mfid.equals(other.mfid))
      return false;
    if (quantity == null) {
      if (other.quantity != null)
        return false;
    } else if (!quantity.equals(other.quantity))
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
    return "SaManufacturerCommodityView [gid=" + gid + ", mfid=" + mfid
        + ", quantity=" + quantity + ", ctName=" + ctName + ", ctid=" + ctid
        + "]";
  }



}
