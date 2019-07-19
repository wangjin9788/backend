package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangJin
 *
 * @date 2019年2月19日 上午9:19:06
 *
 */
public class SupplierBaseDetailView implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long suid;
  private String suName;
  private String suAddress;
  private String fullName;
  private List<LinkmanView> linkmanList;

  /**
   * @return the suid
   */
  public Long getSuid() {
    return suid;
  }

  /**
   * @param suid the suid to set
   */
  public void setSuid(final Long suid) {
    this.suid = suid;
  }

  /**
   * @return the suName
   */
  public String getSuName() {
    return suName;
  }

  /**
   * @param suName the suName to set
   */
  public void setSuName(final String suName) {
    this.suName = suName;
  }

  /**
   * @return the suAddress
   */
  public String getSuAddress() {
    return suAddress;
  }

  /**
   * @param suAddress the suAddress to set
   */
  public void setSuAddress(final String suAddress) {
    this.suAddress = suAddress;
  }

  /**
   * @return the linkmanList
   */
  public List<LinkmanView> getLinkmanList() {
    return linkmanList;
  }

  /**
   * @param linkmanList the linkmanList to set
   */
  public void setLinkmanList(final List<LinkmanView> linkmanList) {
    this.linkmanList = linkmanList;
  }

  /**
   * @return the fullName
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * @param fullName the fullName to set
   */
  public void setFullName(final String fullName) {
    this.fullName = fullName;
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
    result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
    result =
        prime * result + ((linkmanList == null) ? 0 : linkmanList.hashCode());
    result = prime * result + ((suAddress == null) ? 0 : suAddress.hashCode());
    result = prime * result + ((suName == null) ? 0 : suName.hashCode());
    result = prime * result + ((suid == null) ? 0 : suid.hashCode());
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
    final SupplierBaseDetailView other = (SupplierBaseDetailView) obj;
    if (fullName == null) {
      if (other.fullName != null)
        return false;
    } else if (!fullName.equals(other.fullName))
      return false;
    if (linkmanList == null) {
      if (other.linkmanList != null)
        return false;
    } else if (!linkmanList.equals(other.linkmanList))
      return false;
    if (suAddress == null) {
      if (other.suAddress != null)
        return false;
    } else if (!suAddress.equals(other.suAddress))
      return false;
    if (suName == null) {
      if (other.suName != null)
        return false;
    } else if (!suName.equals(other.suName))
      return false;
    if (suid == null) {
      if (other.suid != null)
        return false;
    } else if (!suid.equals(other.suid))
      return false;
    return true;
  }


}
