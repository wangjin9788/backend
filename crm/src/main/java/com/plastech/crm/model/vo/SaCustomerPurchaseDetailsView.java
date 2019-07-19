package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年3月1日 上午10:33:02
 *
 */
public class SaCustomerPurchaseDetailsView implements Serializable {

  private static final long serialVersionUID = 1L;
  // 客户id
  private Long gid;
  // 生产商id
  private Long mfid;
  // 忠诚度id
  private Long lid;
  // 客户名称
  private String gName;
  // 忠诚度名称
  private String lName;
  // 购买量
  private String quantity;

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
   * @return the lid
   */
  public Long getLid() {
    return lid;
  }

  /**
   * @param lid the lid to set
   */
  public void setLid(final Long lid) {
    this.lid = lid;
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
   * @return the lName
   */
  public String getlName() {
    return lName;
  }

  /**
   * @param lName the lName to set
   */
  public void setlName(final String lName) {
    this.lName = lName;
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


  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((gName == null) ? 0 : gName.hashCode());
    result = prime * result + ((gid == null) ? 0 : gid.hashCode());
    result = prime * result + ((lName == null) ? 0 : lName.hashCode());
    result = prime * result + ((lid == null) ? 0 : lid.hashCode());
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
    final SaCustomerPurchaseDetailsView other = (SaCustomerPurchaseDetailsView) obj;
    if (gName == null) {
      if (other.gName != null)
        return false;
    } else if (!gName.equals(other.gName))
      return false;
    if (gid == null) {
      if (other.gid != null)
        return false;
    } else if (!gid.equals(other.gid))
      return false;
    if (lName == null) {
      if (other.lName != null)
        return false;
    } else if (!lName.equals(other.lName))
      return false;
    if (lid == null) {
      if (other.lid != null)
        return false;
    } else if (!lid.equals(other.lid))
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
    return "SaCustomerPurchaseDetailsView [gid=" + gid + ", mfid=" + mfid
        + ", lid=" + lid + ", gName=" + gName + ", lName=" + lName
        + ", quantity=" + quantity + "]";
  }

}
