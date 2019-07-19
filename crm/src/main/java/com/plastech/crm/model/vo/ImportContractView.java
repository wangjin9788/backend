package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.List;
import com.plastech.crm.model.Grade;

/**
 * @author wangJin
 *
 * @date 2019年5月20日 上午10:51:04
 *
 */
public class ImportContractView implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long coid;// 合同id
  private String number;// 合同编号
  private Long cuid;// 客户id
  private String cuName;// 客户名称
  private Long uid;// 经理id
  private String uName;// 经理名称
  private List<Grade> gradeList;// 牌号

  /**
   * @return the coid
   */
  public Long getCoid() {
    return coid;
  }

  /**
   * @param coid the coid to set
   */
  public void setCoid(final Long coid) {
    this.coid = coid;
  }

  /**
   * @return the number
   */
  public String getNumber() {
    return number;
  }

  /**
   * @param number the number to set
   */
  public void setNumber(final String number) {
    this.number = number;
  }

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
   * @return the uid
   */
  public Long getUid() {
    return uid;
  }

  /**
   * @param uid the uid to set
   */
  public void setUid(final Long uid) {
    this.uid = uid;
  }

  /**
   * @return the uName
   */
  public String getuName() {
    return uName;
  }

  /**
   * @param uName the uName to set
   */
  public void setuName(final String uName) {
    this.uName = uName;
  }

  /**
   * @return the gradeList
   */
  public List<Grade> getGradeList() {
    return gradeList;
  }

  /**
   * @param gradeList the gradeList to set
   */
  public void setGradeList(final List<Grade> gradeList) {
    this.gradeList = gradeList;
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
    result = prime * result + ((coid == null) ? 0 : coid.hashCode());
    result = prime * result + ((cuName == null) ? 0 : cuName.hashCode());
    result = prime * result + ((cuid == null) ? 0 : cuid.hashCode());
    result = prime * result + ((gradeList == null) ? 0 : gradeList.hashCode());
    result = prime * result + ((number == null) ? 0 : number.hashCode());
    result = prime * result + ((uName == null) ? 0 : uName.hashCode());
    result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
    final ImportContractView other = (ImportContractView) obj;
    if (coid == null) {
      if (other.coid != null)
        return false;
    } else if (!coid.equals(other.coid))
      return false;
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
    if (gradeList == null) {
      if (other.gradeList != null)
        return false;
    } else if (!gradeList.equals(other.gradeList))
      return false;
    if (number == null) {
      if (other.number != null)
        return false;
    } else if (!number.equals(other.number))
      return false;
    if (uName == null) {
      if (other.uName != null)
        return false;
    } else if (!uName.equals(other.uName))
      return false;
    if (uid == null) {
      if (other.uid != null)
        return false;
    } else if (!uid.equals(other.uid))
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
    return "ImportContractView [coid=" + coid + ", number=" + number + ", cuid="
        + cuid + ", cuName=" + cuName + ", uid=" + uid + ", uName=" + uName
        + ", gradeList=" + gradeList + "]";
  }


}
