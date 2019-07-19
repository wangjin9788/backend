package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年5月7日 下午4:21:10
 *
 */
public class LoyaltyDurationView implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer maxDuration;
  private Integer minDuration;

  /**
   * @return the maxDuration
   */
  public Integer getMaxDuration() {
    return maxDuration;
  }

  /**
   * @param maxDuration the maxDuration to set
   */
  public void setMaxDuration(final Integer maxDuration) {
    this.maxDuration = maxDuration;
  }

  /**
   * @return the minDuration
   */
  public Integer getMinDuration() {
    return minDuration;
  }

  /**
   * @param minDuration the minDuration to set
   */
  public void setMinDuration(final Integer minDuration) {
    this.minDuration = minDuration;
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
        prime * result + ((maxDuration == null) ? 0 : maxDuration.hashCode());
    result =
        prime * result + ((minDuration == null) ? 0 : minDuration.hashCode());
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
    final LoyaltyDurationView other = (LoyaltyDurationView) obj;
    if (maxDuration == null) {
      if (other.maxDuration != null)
        return false;
    } else if (!maxDuration.equals(other.maxDuration))
      return false;
    if (minDuration == null) {
      if (other.minDuration != null)
        return false;
    } else if (!minDuration.equals(other.minDuration))
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
    return "LoyaltyDurationView [maxDuration=" + maxDuration + ", minDuration="
        + minDuration + "]";
  }



}
