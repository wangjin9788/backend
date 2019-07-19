package com.plastech.crm.model.parameter;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年1月22日 上午9:53:22
 *
 */
public class AddLoyaltyParameters implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer maxFrequency;

  private Integer minFrequency;

  private Integer duration;

  private String name;

  /**
   * @return the maxFrequency
   */
  public Integer getMaxFrequency() {
    return maxFrequency;
  }

  /**
   * @param maxFrequency the maxFrequency to set
   */
  public void setMaxFrequency(final Integer maxFrequency) {
    this.maxFrequency = maxFrequency;
  }

  /**
   * @return the minFrequency
   */
  public Integer getMinFrequency() {
    return minFrequency;
  }

  /**
   * @param minFrequency the minFrequency to set
   */
  public void setMinFrequency(final Integer minFrequency) {
    this.minFrequency = minFrequency;
  }

  /**
   * @return the duration
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * @param duration the duration to set
   */
  public void setDuration(final Integer duration) {
    this.duration = duration;
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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((duration == null) ? 0 : duration.hashCode());
    result =
        prime * result + ((maxFrequency == null) ? 0 : maxFrequency.hashCode());
    result =
        prime * result + ((minFrequency == null) ? 0 : minFrequency.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    final AddLoyaltyParameters other = (AddLoyaltyParameters) obj;
    if (duration == null) {
      if (other.duration != null)
        return false;
    } else if (!duration.equals(other.duration))
      return false;
    if (maxFrequency == null) {
      if (other.maxFrequency != null)
        return false;
    } else if (!maxFrequency.equals(other.maxFrequency))
      return false;
    if (minFrequency == null) {
      if (other.minFrequency != null)
        return false;
    } else if (!minFrequency.equals(other.minFrequency))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
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
    return "AddLoyaltyParameters [maxFrequency=" + maxFrequency
        + ", minFrequency=" + minFrequency + ", duration=" + duration
        + ", name=" + name + "]";
  }



}
