package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangJin
 *
 * @date 2019年1月22日 下午5:47:35
 *
 */
public class CustomerLoyaltyView implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long gid;
  private Long mfid;
  private List<UserPurchaseFrequencyView> loyaltyCount;

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
   * @return the loyaltyCount
   */
  public List<UserPurchaseFrequencyView> getLoyaltyCount() {
    return loyaltyCount;
  }

  /**
   * @param loyaltyCount the loyaltyCount to set
   */
  public void setLoyaltyCount(
      final List<UserPurchaseFrequencyView> loyaltyCount) {
    this.loyaltyCount = loyaltyCount;
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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((gid == null) ? 0 : gid.hashCode());
    result =
        prime * result + ((loyaltyCount == null) ? 0 : loyaltyCount.hashCode());
    result = prime * result + ((mfid == null) ? 0 : mfid.hashCode());
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
    final CustomerLoyaltyView other = (CustomerLoyaltyView) obj;
    if (gid == null) {
      if (other.gid != null)
        return false;
    } else if (!gid.equals(other.gid))
      return false;
    if (loyaltyCount == null) {
      if (other.loyaltyCount != null)
        return false;
    } else if (!loyaltyCount.equals(other.loyaltyCount))
      return false;
    if (mfid == null) {
      if (other.mfid != null)
        return false;
    } else if (!mfid.equals(other.mfid))
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
    return "CustomerLoyaltyView [gid=" + gid + ", mfid=" + mfid
        + ", loyaltyCount=" + loyaltyCount + "]";
  }

}
