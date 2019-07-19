package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "customer_loyalty")
public class CustomerLoyalty implements Serializable {
  @Id
  private Long clid;

  /**
   * 客戶id
   */
  private Long gid;

  /**
   * 忠誠度
   */
  private Long lid;

  /**
   * 年份
   */
  private Integer years;

  /**
   * 创建时间
   */
  @Column(name = "creator_id")
  private Long creatorId;

  /**
   * 创建时间
   */
  @Column(name = "creator_time")
  private Date creatorTime;

  /**
   * 备注
   */
  private String note;

  /**
   * 生产商id
   */
  private Long mfid;
  private static final long serialVersionUID = 1L;

  /**
   * @return clid
   */
  public Long getClid() {
    return clid;
  }

  /**
   * @param clid
   */
  public void setClid(final Long clid) {
    this.clid = clid;
  }

  /**
   * 获取客戶id
   *
   * @return cuid - 客戶id
   */
  public Long getGid() {
    return gid;
  }

  /**
   * 设置客戶id
   *
   * @param cuid 客戶id
   */
  public void setGid(final Long gid) {
    this.gid = gid;
  }

  /**
   * 获取忠誠度
   *
   * @return lid - 忠誠度
   */
  public Long getLid() {
    return lid;
  }

  /**
   * 设置忠誠度
   *
   * @param lid 忠誠度
   */
  public void setLid(final Long lid) {
    this.lid = lid;
  }

  /**
   * 获取年份
   *
   * @return years - 年份
   */
  public Integer getYears() {
    return years;
  }

  /**
   * 设置年份
   *
   * @param integer 年份
   */
  public void setYears(final Integer integer) {
    this.years = integer;
  }

  /**
   * 获取创建时间
   *
   * @return creator_id - 创建时间
   */
  public Long getCreatorId() {
    return creatorId;
  }

  /**
   * 设置创建时间
   *
   * @param creatorId 创建时间
   */
  public void setCreatorId(final Long creatorId) {
    this.creatorId = creatorId;
  }

  /**
   * 获取创建时间
   *
   * @return creator_time - 创建时间
   */
  public Date getCreatorTime() {
    return creatorTime;
  }

  /**
   * 设置创建时间
   *
   * @param creatorTime 创建时间
   */
  public void setCreatorTime(final Date creatorTime) {
    this.creatorTime = creatorTime;
  }

  /**
   * 获取备注
   *
   * @return note - 备注
   */
  public String getNote() {
    return note;
  }

  /**
   * 设置备注
   *
   * @param note 备注
   */
  public void setNote(final String note) {
    this.note = note;
  }

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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "CustomerLoyalty [clid=" + clid + ", gid=" + gid + ", lid=" + lid
        + ", years=" + years + ", creatorId=" + creatorId + ", creatorTime="
        + creatorTime + ", note=" + note + "]";
  }


}
