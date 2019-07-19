package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年3月5日 下午1:52:21
 *
 */
public class SaManufacturerLoyaltyView implements Serializable {

  private static final long serialVersionUID = 1L;
  private Integer monthCount;
  private String year;
  private String name;
  private Long gid;

  /**
   * @return the monthCount
   */
  public Integer getMonthCount() {
    return monthCount;
  }

  /**
   * @param monthCount the monthCount to set
   */
  public void setMonthCount(final Integer monthCount) {
    this.monthCount = monthCount;
  }

  /**
   * @return the year
   */
  public String getYear() {
    return year;
  }

  /**
   * @param year the year to set
   */
  public void setYear(final String year) {
    this.year = year;
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
        prime * result + ((monthCount == null) ? 0 : monthCount.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((year == null) ? 0 : year.hashCode());
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
    final SaManufacturerLoyaltyView other = (SaManufacturerLoyaltyView) obj;
    if (gid == null) {
      if (other.gid != null)
        return false;
    } else if (!gid.equals(other.gid))
      return false;
    if (monthCount == null) {
      if (other.monthCount != null)
        return false;
    } else if (!monthCount.equals(other.monthCount))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (year == null) {
      if (other.year != null)
        return false;
    } else if (!year.equals(other.year))
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
    return "SaManufacturerLoyaltyView [monthCount=" + monthCount + ", year="
        + year + ", name=" + name + ", gid=" + gid + "]";
  }


}
