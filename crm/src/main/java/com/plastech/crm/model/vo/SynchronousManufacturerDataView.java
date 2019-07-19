package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年3月25日 下午5:03:00
 *
 */
public class SynchronousManufacturerDataView
    extends SynchronousCommodityDataView implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long lid;
  private Long gid;
  private String lName;

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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((gid == null) ? 0 : gid.hashCode());
    result = prime * result + ((lName == null) ? 0 : lName.hashCode());
    result = prime * result + ((lid == null) ? 0 : lid.hashCode());
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
    final SynchronousManufacturerDataView other =
        (SynchronousManufacturerDataView) obj;
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
    return true;
  }

  @Override
  public String toString() {
    return "SynchronousManufacturerDataView [lid=" + lid + ", gid=" + gid
        + ", lName=" + lName + "]";
  }

}
