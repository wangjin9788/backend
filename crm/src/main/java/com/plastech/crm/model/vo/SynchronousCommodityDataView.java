package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年3月25日 下午4:06:32
 *
 */
public class SynchronousCommodityDataView extends SynchronousSalseDataView
    implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long ctid;
  private String ctName;
  private String mfName;
  private String gName;

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

  /**
   * @return the mfName
   */
  public String getMfName() {
    return mfName;
  }

  /**
   * @param mfName the mfName to set
   */
  public void setMfName(final String mfName) {
    this.mfName = mfName;
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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((ctName == null) ? 0 : ctName.hashCode());
    result = prime * result + ((ctid == null) ? 0 : ctid.hashCode());
    result = prime * result + ((gName == null) ? 0 : gName.hashCode());
    result = prime * result + ((mfName == null) ? 0 : mfName.hashCode());
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
    final SynchronousCommodityDataView other = (SynchronousCommodityDataView) obj;
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
    if (gName == null) {
      if (other.gName != null)
        return false;
    } else if (!gName.equals(other.gName))
      return false;
    if (mfName == null) {
      if (other.mfName != null)
        return false;
    } else if (!mfName.equals(other.mfName))
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
    return "SynchronousCommodityDataView [ctid=" + ctid + ", ctName=" + ctName
        + ", mfName=" + mfName + ", gName=" + gName + "]";
  }


}
