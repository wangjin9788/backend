package com.plastech.crm.model.parameter;

import java.io.Serializable;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月15日 上午9:20:17
 *
 */
public class AddOrUpdateGroupsParameters implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private Long gid;
  private String name;
  private Integer type;
  private Integer code;
  private String note;

  public final void setGid(final Long gid) {
    this.gid = gid;
  }

  public final Long getGid() {
    return gid;
  }

  public final void setName(final String name) {
    this.name = name;
  }

  public final String getName() {
    return name;
  }


  public final Integer getType() {
    return type;
  }

  public final void setType(final Integer type) {
    this.type = type;
  }

  public final Integer getCode() {
    return code;
  }

  public final void setCode(final Integer code) {
    this.code = code;
  }

  public final String getNote() {
    return note;
  }

  public final void setNote(final String note) {
    this.note = note;
  }

}
