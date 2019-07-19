package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 王进
 *
 */

public class CommodityView implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long ctId;
  private String name;
  private String creatorTime;
  private String creatorNmae;

  /**
   * @return the ctid
   */
  public Long getCtId() {
    return ctId;
  }

  /**
   * @param ctid the ctid to set
   */
  public void setCtid(final Long ctId) {
    this.ctId = ctId;
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
   * @return the creatorTime
   */
  public String getCreatorTime() {
    return creatorTime;
  }

  /**
   * @param creatorTime the creatorTime to set
   */
  public void setCreatorTime(final Date creatorTime) {
    this.creatorTime = creatorTime != null ? creatorTime.getTime() + "" : null;
  }

  /**
   * @return the creatorNmae
   */
  public String getCreatorNmae() {
    return creatorNmae;
  }

  /**
   * @param creatorNmae the creatorNmae to set
   */
  public void setCreatorNmae(final String creatorNmae) {
    this.creatorNmae = creatorNmae;
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
        prime * result + ((creatorNmae == null) ? 0 : creatorNmae.hashCode());
    result =
        prime * result + ((creatorTime == null) ? 0 : creatorTime.hashCode());
    result = prime * result + ((ctId == null) ? 0 : ctId.hashCode());
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
    final CommodityView other = (CommodityView) obj;
    if (creatorNmae == null) {
      if (other.creatorNmae != null)
        return false;
    } else if (!creatorNmae.equals(other.creatorNmae))
      return false;
    if (creatorTime == null) {
      if (other.creatorTime != null)
        return false;
    } else if (!creatorTime.equals(other.creatorTime))
      return false;
    if (ctId == null) {
      if (other.ctId != null)
        return false;
    } else if (!ctId.equals(other.ctId))
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
    return "CommodityView [ctid=" + ctId + ", name=" + name + ", creatorTime="
        + creatorTime + ", creatorNmae=" + creatorNmae + "]";
  }


}
