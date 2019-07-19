package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年2月27日 下午2:00:28
 *
 */
public class SaCommodityCustomerView implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long ctid;
  private Long mfid;
  private String customerName;
  private String purchaseQuantity;

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
   * @return the customerName
   */
  public String getCustomerName() {
    return customerName;
  }

  /**
   * @param customerName the customerName to set
   */
  public void setCustomerName(final String customerName) {
    this.customerName = customerName;
  }

  /**
   * @return the purchasequantity
   */
  public String getPurchaseQuantity() {
    return purchaseQuantity;
  }

  /**
   * @param purchasequantity the purchasequantity to set
   */
  public void setPurchaseQuantity(final String purchaseQuantity) {
    this.purchaseQuantity = purchaseQuantity;
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
    result =
        prime * result + ((customerName == null) ? 0 : customerName.hashCode());
    result = prime * result + ((mfid == null) ? 0 : mfid.hashCode());
    result = prime * result
        + ((purchaseQuantity == null) ? 0 : purchaseQuantity.hashCode());
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
    final SaCommodityCustomerView other = (SaCommodityCustomerView) obj;
    if (ctid == null) {
      if (other.ctid != null)
        return false;
    } else if (!ctid.equals(other.ctid))
      return false;
    if (customerName == null) {
      if (other.customerName != null)
        return false;
    } else if (!customerName.equals(other.customerName))
      return false;
    if (mfid == null) {
      if (other.mfid != null)
        return false;
    } else if (!mfid.equals(other.mfid))
      return false;
    if (purchaseQuantity == null) {
      if (other.purchaseQuantity != null)
        return false;
    } else if (!purchaseQuantity.equals(other.purchaseQuantity))
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
    return "SaCommodityCustomerView [ctid=" + ctid + ", mfid=" + mfid
        + ", customerName=" + customerName + ", purchaseQuantity="
        + purchaseQuantity + "]";
  }

}
