package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月15日 上午9:20:17
 *
 */
public class GroupsView implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private Long gid;
  private String name;
  private Integer type;
  private Long creatorId;
  private String creatorName;

  public final void setGid(final Long gid) {
    this.gid = gid;
  }

  public final Long getGid() {
    return gid;
  }

  public final String getName() {
    return name;
  }

  public final void setType(final Integer type) {
    this.type = type;
  }

  public final void setName(final String name) {
    this.name = name;
  }

  public final Integer getType() {
    return type;
  }


  public final Long getCreatorId() {
    return creatorId;
  }

  public final void setCreatorId(final Long creatorId) {
    this.creatorId = creatorId;
  }

  public final String getCreatorName() {
    return creatorName;
  }

  public final void setCreatorName(final String creatorName) {
    this.creatorName = creatorName;
  }

}
