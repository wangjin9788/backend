package com.plastech.crm.model.parameter;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年3月7日 下午4:48:55
 *
 */
public class ExportDataInfoView implements Serializable {
  private static final long serialVersionUID = 1L;
  private Long mfid=0L;
  private Long ctid=0L;
  private Long gid=0L;
  private String ctName;
  private String mfName;
  private String gName;
  private Double volume;
  private String year;
  private Integer month;
  private Long lid=0L;
  private String lName;

  /**
   * @return the mfid
   */
  public Long getMfid() {
    return mfid;
  }

  /**
   * @param mfid the mfid to set
   */
  public void setMfid(final Long mfid) {
    this.mfid = mfid;
  }

  /**
   * @return the ctid
   */
  public Long getCtid() {
    return ctid;
  }

  /**
   * @param ctid the ctid to set
   */
  public void setCtid(final Long ctid) {
    this.ctid = ctid;
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
   * @return the gName
   */
  public String getgName() {
    return gName;
  }

  /**
   * @param gName the gName to set
   */
  public void setgName(final String gName) {
    this.gName = gName;
  }

  /**
   * @return the volume
   */
  public Double getVolume() {
    return volume;
  }

  /**
   * @param volume the volume to set
   */
  public void setVolume(final Double volume) {
    this.volume = volume;
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
   * @return the month
   */
  public Integer getMonth() {
    return month;
  }

  /**
   * @param month the month to set
   */
  public void setMonth(final Integer month) {
    this.month = month;
  }

  /**
   * @return the lid
   */
  public Long getLid() {
    return lid;
  }

  /**
   * @param lid the lid to set
   */
  public void setLid(final Long lid) {
    this.lid = lid;
  }

  /**
   * @return the lName
   */
  public String getlName() {
    return lName;
  }

  /**
   * @param lName the lName to set
   */
  public void setlName(final String lName) {
    this.lName = lName;
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
    result = prime * result + ((ctName == null) ? 0 : ctName.hashCode());
    result = prime * result + ((ctid == null) ? 0 : ctid.hashCode());
    result = prime * result + ((gName == null) ? 0 : gName.hashCode());
    result = prime * result + ((gid == null) ? 0 : gid.hashCode());
    result = prime * result + ((lName == null) ? 0 : lName.hashCode());
    result = prime * result + ((lid == null) ? 0 : lid.hashCode());
    result = prime * result + ((mfName == null) ? 0 : mfName.hashCode());
    result = prime * result + ((mfid == null) ? 0 : mfid.hashCode());
    result = prime * result + ((month == null) ? 0 : month.hashCode());
    result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
    final ExportDataInfoView other = (ExportDataInfoView) obj;
    if (ctName == null) {
      if (other.ctName != null)
        return false;
    } else if (!ctName.equals(other.ctName))
      return false;
    if (ctid == null) {
      if (other.ctid != null)
        return false;
    } else if (!ctid.equals(other.ctid))
      return false;
    if (gName == null) {
      if (other.gName != null)
        return false;
    } else if (!gName.equals(other.gName))
      return false;
    if (gid == null) {
      if (other.gid != null)
        return false;
    } else if (!gid.equals(other.gid))
      return false;
    if (lName == null) {
      if (other.lName != null)
        return false;
    } else if (!lName.equals(other.lName))
      return false;
    if (lid == null) {
      if (other.lid != null)
        return false;
    } else if (!lid.equals(other.lid))
      return false;
    if (mfName == null) {
      if (other.mfName != null)
        return false;
    } else if (!mfName.equals(other.mfName))
      return false;
    if (mfid == null) {
      if (other.mfid != null)
        return false;
    } else if (!mfid.equals(other.mfid))
      return false;
    if (month == null) {
      if (other.month != null)
        return false;
    } else if (!month.equals(other.month))
      return false;
    if (volume == null) {
      if (other.volume != null)
        return false;
    } else if (!volume.equals(other.volume))
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
    return "ExportDataInfoView [mfid=" + mfid + ", ctid=" + ctid + ", gid="
        + gid + ", ctName=" + ctName + ", mfName=" + mfName + ", gName=" + gName
        + ", volume=" + volume + ", year=" + year + ", month=" + month
        + ", lid=" + lid + ", lName=" + lName + "]";
  }


}
