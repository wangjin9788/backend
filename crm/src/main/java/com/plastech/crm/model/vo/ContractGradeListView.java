package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年1月28日 下午4:29:11
 *
 */
public class ContractGradeListView implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long geid;
  private String concatName;

  /**
   * @return the geid
   */
  public Long getGeid() {
    return geid;
  }

  /**
   * @param geid the geid to set
   */
  public void setGeid(final Long geid) {
    this.geid = geid;
  }

  /**
   * @return the concatName
   */
  public String getConcatName() {
    return concatName;
  }

  /**
   * @param concatName the concatName to set
   */
  public void setConcatName(final String concatName) {
    this.concatName = concatName;
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
        prime * result + ((concatName == null) ? 0 : concatName.hashCode());
    result = prime * result + ((geid == null) ? 0 : geid.hashCode());
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
    final ContractGradeListView other = (ContractGradeListView) obj;
    if (concatName == null) {
      if (other.concatName != null)
        return false;
    } else if (!concatName.equals(other.concatName))
      return false;
    if (geid == null) {
      if (other.geid != null)
        return false;
    } else if (!geid.equals(other.geid))
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
    return "ContractGradeListView [geid=" + geid + ", concatName=" + concatName
        + "]";
  }


}
