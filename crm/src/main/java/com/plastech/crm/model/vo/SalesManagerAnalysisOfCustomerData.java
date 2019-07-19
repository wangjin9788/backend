package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 *
 *
 * @author : yemin
 * @date : 2019年2月25日 上午10:40:24
 *
 */
public class SalesManagerAnalysisOfCustomerData implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String year;// 年份
  private Long salesmanUid;// 销售经理id

  private Long gid;// 客户（集团）id
  private String groupsName;// 客户（集团）名称
  private Double totalQty;// 购买量

  private Long ctid;//品类id
  private Long mfid;//生产商id
  private String ctName;
  private String mfName;

  public final String getYear() {
    return year;
  }

  public final void setYear(final String year) {
    this.year = year;
  }

  public final Long getSalesmanUid() {
    return salesmanUid;
  }

  public final void setSalesmanUid(final Long salesmanUid) {
    this.salesmanUid = salesmanUid;
  }

  public final Long getGid() {
    return gid;
  }

  public final void setGid(final Long gid) {
    this.gid = gid;
  }

  public final String getGroupsName() {
    return groupsName;
  }

  public final void setGroupsName(final String groupsName) {
    this.groupsName = groupsName;
  }

  public final Double getTotalQty() {
    return totalQty;
  }

  public final void setTotalQty(final Double totalQty) {
    this.totalQty = totalQty;
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



}
