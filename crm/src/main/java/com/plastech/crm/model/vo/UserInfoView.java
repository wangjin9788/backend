package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 王进
 *
 */
public class UserInfoView extends UserView implements Serializable {

  private static final long serialVersionUID = 1L;
  private String area;

  private Date createTime;
  private Long createId;
  private String note;


  /**
   * @return the area
   */
  public String getArea() {
    return area;
  }

  /**
   * @param area the area to set
   */
  public void setArea(final String area) {
    this.area = area;
  }


  /**
   * @return the createTime
   */
  public Date getCreateTime() {
    return createTime;
  }

  /**
   * @param createTime the createTime to set
   */
  public void setCreateTime(final Date createTime) {
    this.createTime = createTime;
  }

  /**
   * @return the createId
   */
  public Long getCreateId() {
    return createId;
  }

  /**
   * @param createId the createId to set
   */
  public void setCreateId(final Long createId) {
    this.createId = createId;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((area == null) ? 0 : area.hashCode());
    result = prime * result + ((createId == null) ? 0 : createId.hashCode());
    result =
        prime * result + ((createTime == null) ? 0 : createTime.hashCode());
    result = prime * result + ((note == null) ? 0 : note.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final UserInfoView other = (UserInfoView) obj;
    if (area == null) {
      if (other.area != null) {
        return false;
      }
    } else if (!area.equals(other.area)) {
      return false;
    }
    if (createId == null) {
      if (other.createId != null) {
        return false;
      }
    } else if (!createId.equals(other.createId)) {
      return false;
    }
    if (createTime == null) {
      if (other.createTime != null) {
        return false;
      }
    } else if (!createTime.equals(other.createTime)) {
      return false;
    }
    if (note == null) {
      if (other.note != null) {
        return false;
      }
    } else if (!note.equals(other.note)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "UserInfoView [area=" + area + ", createTime=" + createTime
        + ", createId=" + createId + ", note=" + note + "]";
  }

}
