package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年1月14日 上午10:25:23
 *
 */
public class GradeView implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long geId;
  private String gradeNumber;
  private Long ctId;
  private String ctName;
  private Long mfId;
  private String mfName;
  private Integer canDel;

  /**
   * @return the geId
   */
  public Long getGeId() {
    return geId;
  }

  /**
   * @param geId the geId to set
   */
  public void setGeId(final Long geId) {
    this.geId = geId;
  }

  /**
   * @return the gradeNumber
   */
  public String getGradeNumber() {
    return gradeNumber;
  }

  /**
   * @param gradeNumber the gradeNumber to set
   */
  public void setGradeNumber(final String gradeNumber) {
    this.gradeNumber = gradeNumber;
  }

  /**
   * @return the ctId
   */
  public Long getCtId() {
    return ctId;
  }

  /**
   * @param ctId the ctId to set
   */
  public void setCtId(final Long ctId) {
    this.ctId = ctId;
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
   * @return the mfId
   */
  public Long getMfId() {
    return mfId;
  }

  /**
   * @param mfId the mfId to set
   */
  public void setMfId(final Long mfId) {
    this.mfId = mfId;
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
   * @return the canDel
   */
  public Integer getCanDel() {
    return canDel;
  }

  /**
   * @param canDel the canDel to set
   */
  public void setCanDel(final Integer canDel) {
    this.canDel = canDel;
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
    result = prime * result + ((canDel == null) ? 0 : canDel.hashCode());
    result = prime * result + ((ctId == null) ? 0 : ctId.hashCode());
    result = prime * result + ((ctName == null) ? 0 : ctName.hashCode());
    result = prime * result + ((geId == null) ? 0 : geId.hashCode());
    result =
        prime * result + ((gradeNumber == null) ? 0 : gradeNumber.hashCode());
    result = prime * result + ((mfId == null) ? 0 : mfId.hashCode());
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
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final GradeView other = (GradeView) obj;
    if (canDel == null) {
      if (other.canDel != null)
        return false;
    } else if (!canDel.equals(other.canDel))
      return false;
    if (ctId == null) {
      if (other.ctId != null)
        return false;
    } else if (!ctId.equals(other.ctId))
      return false;
    if (ctName == null) {
      if (other.ctName != null)
        return false;
    } else if (!ctName.equals(other.ctName))
      return false;
    if (geId == null) {
      if (other.geId != null)
        return false;
    } else if (!geId.equals(other.geId))
      return false;
    if (gradeNumber == null) {
      if (other.gradeNumber != null)
        return false;
    } else if (!gradeNumber.equals(other.gradeNumber))
      return false;
    if (mfId == null) {
      if (other.mfId != null)
        return false;
    } else if (!mfId.equals(other.mfId))
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
    return "GradeView [geId=" + geId + ", gradeNumber=" + gradeNumber
        + ", ctId=" + ctId + ", ctName=" + ctName + ", mfId=" + mfId
        + ", mfName=" + mfName + ", canDel=" + canDel + "]";
  }



}
