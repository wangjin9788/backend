package com.plastech.crm.model.parameter;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年1月14日 上午10:21:01
 *
 */
public class AddOrUpdateGradeParameters implements Serializable {

  private static final long serialVersionUID = 1L;

  private String gradeNumber;
  private Long ctId;
  private Long mfId;

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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ctId == null) ? 0 : ctId.hashCode());
    result =
        prime * result + ((gradeNumber == null) ? 0 : gradeNumber.hashCode());
    result = prime * result + ((mfId == null) ? 0 : mfId.hashCode());
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
    final AddOrUpdateGradeParameters other = (AddOrUpdateGradeParameters) obj;
    if (ctId == null) {
      if (other.ctId != null)
        return false;
    } else if (!ctId.equals(other.ctId))
      return false;
    if (mfId == null) {
      if (other.mfId != null)
        return false;
    } else if (!mfId.equals(other.mfId))
      return false;
    if (gradeNumber == null) {
      if (other.gradeNumber != null)
        return false;
    } else if (!gradeNumber.equals(other.gradeNumber))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "AddOrUpdateGradeParameters [gradeNumber=" + gradeNumber + ", ctId="
        + ctId + ", mfId=" + mfId + "]";
  }

}
