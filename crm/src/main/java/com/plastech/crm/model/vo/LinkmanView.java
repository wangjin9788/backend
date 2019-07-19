package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年2月19日 上午9:26:12
 *
 */
public class LinkmanView implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long lkid;
  private String name;
  private String lkPosition;
  private String lkArea;
  private String lkPhone;
  private String lkMail;
  private String lkTags;
  private String note;

  /**
   * @return the lkid
   */
  public Long getLkid() {
    return lkid;
  }

  /**
   * @param lkid the lkid to set
   */
  public void setLkid(final Long lkid) {
    this.lkid = lkid;
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
   * @return the lkPosition
   */
  public String getLkPosition() {
    return lkPosition;
  }

  /**
   * @param lkPosition the lkPosition to set
   */
  public void setLkPosition(final String lkPosition) {
    this.lkPosition = lkPosition;
  }

  /**
   * @return the lkArea
   */
  public String getLkArea() {
    return lkArea;
  }

  /**
   * @param lkArea the lkArea to set
   */
  public void setLkArea(final String lkArea) {
    this.lkArea = lkArea;
  }

  /**
   * @return the lkPhone
   */
  public String getLkPhone() {
    return lkPhone;
  }

  /**
   * @param lkPhone the lkPhone to set
   */
  public void setLkPhone(final String lkPhone) {
    this.lkPhone = lkPhone;
  }

  /**
   * @return the lkMail
   */
  public String getLkMail() {
    return lkMail;
  }

  /**
   * @param lkMail the lkMail to set
   */
  public void setLkMail(final String lkMail) {
    this.lkMail = lkMail;
  }

  /**
   * @return the lkTags
   */
  public String getLkTags() {
    return lkTags;
  }

  /**
   * @param lkTags the lkTags to set
   */
  public void setLkTags(final String lkTags) {
    this.lkTags = lkTags;
  }

  /**
   * @return the note
   */
  public String getNote() {
    return note;
  }

  /**
   * @param note the note to set
   */
  public void setNote(final String note) {
    this.note = note;
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
    result = prime * result + ((lkArea == null) ? 0 : lkArea.hashCode());
    result = prime * result + ((lkMail == null) ? 0 : lkMail.hashCode());
    result = prime * result + ((lkPhone == null) ? 0 : lkPhone.hashCode());
    result =
        prime * result + ((lkPosition == null) ? 0 : lkPosition.hashCode());
    result = prime * result + ((lkTags == null) ? 0 : lkTags.hashCode());
    result = prime * result + ((lkid == null) ? 0 : lkid.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((note == null) ? 0 : note.hashCode());
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
    final LinkmanView other = (LinkmanView) obj;
    if (lkArea == null) {
      if (other.lkArea != null)
        return false;
    } else if (!lkArea.equals(other.lkArea))
      return false;
    if (lkMail == null) {
      if (other.lkMail != null)
        return false;
    } else if (!lkMail.equals(other.lkMail))
      return false;
    if (lkPhone == null) {
      if (other.lkPhone != null)
        return false;
    } else if (!lkPhone.equals(other.lkPhone))
      return false;
    if (lkPosition == null) {
      if (other.lkPosition != null)
        return false;
    } else if (!lkPosition.equals(other.lkPosition))
      return false;
    if (lkTags == null) {
      if (other.lkTags != null)
        return false;
    } else if (!lkTags.equals(other.lkTags))
      return false;
    if (lkid == null) {
      if (other.lkid != null)
        return false;
    } else if (!lkid.equals(other.lkid))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (note == null) {
      if (other.note != null)
        return false;
    } else if (!note.equals(other.note))
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
    return "LinkmanView [lkid=" + lkid + ", name=" + name + ", lkPosition="
        + lkPosition + ", lkArea=" + lkArea + ", lkPhone=" + lkPhone
        + ", lkMail=" + lkMail + ", lkTags=" + lkTags + ", note=" + note + "]";
  }

}
