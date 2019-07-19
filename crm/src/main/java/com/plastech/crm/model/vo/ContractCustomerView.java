package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangJin
 *
 * @date 2019年1月25日 下午2:42:51
 *
 */
public class ContractCustomerView implements Serializable{

  private static final long serialVersionUID = 1L;

  private Long cuid;
  private String cuName;
  private List<GroupsView> groupsList;
  /**
   * @return the cuid
   */
  public Long getCuid() {
    return cuid;
  }
  /**
   * @param cuid the cuid to set
   */
  public void setCuid(final Long cuid) {
    this.cuid = cuid;
  }
  /**
   * @return the cuName
   */
  public String getCuName() {
    return cuName;
  }
  /**
   * @param cuName the cuName to set
   */
  public void setCuName(final String cuName) {
    this.cuName = cuName;
  }
  /**
   * @return the groupsList
   */
  public List<GroupsView> getGroupsList() {
    return groupsList;
  }
  /**
   * @param groupsList the groupsList to set
   */
  public void setGroupsList(final List<GroupsView> groupsList) {
    this.groupsList = groupsList;
  }
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cuName == null) ? 0 : cuName.hashCode());
    result = prime * result + ((cuid == null) ? 0 : cuid.hashCode());
    result =
        prime * result + ((groupsList == null) ? 0 : groupsList.hashCode());
    return result;
  }
  /* (non-Javadoc)
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
    final ContractCustomerView other = (ContractCustomerView) obj;
    if (cuName == null) {
      if (other.cuName != null)
        return false;
    } else if (!cuName.equals(other.cuName))
      return false;
    if (cuid == null) {
      if (other.cuid != null)
        return false;
    } else if (!cuid.equals(other.cuid))
      return false;
    if (groupsList == null) {
      if (other.groupsList != null)
        return false;
    } else if (!groupsList.equals(other.groupsList))
      return false;
    return true;
  }
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "ContractCustomerView [cuid=" + cuid + ", cuName=" + cuName
        + ", groupsList=" + groupsList + "]";
  }

}
