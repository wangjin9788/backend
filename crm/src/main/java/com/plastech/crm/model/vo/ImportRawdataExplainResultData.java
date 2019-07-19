package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.Date;

public class ImportRawdataExplainResultData implements Serializable {
  private Long irdid;
  /**
   * 导入记录id
   */
  private Long irid;

  /**
   * 数据分类（0：新增，1：更新，2：异常）
   */
  private Integer type;

  /**
   * 最终客户
   */
  private String groups;

  /**
   * 客户
   */
  private String customer;

  /**
   * 合同编号
   */
  private String contNo;

  /**
   * 牌号
   */
  private String grade;

  /**
   * 生产商
   */
  private String manufacturer;

  /**
   * 品类
   */
  private String commodity;

  /**
   * 销售量
   */
  private String qtyMt;

  /**
   * 开船时间
   */
  private String shipmt;

  /**
   * 销售价格
   */
  private String priceMt;

  /**
   * 销售金额
   */
  private String total;

  /**
   * 销售付款条款
   */
  private String term;

  /**
   * 采购价格
   */
  private String priceMt2;

  /**
   * 採購金額
   */
  private String total2;

  /**
   * 採購付款條件
   */
  private String term2;

  /**
   * 运输条款
   */
  private String term3;
  /**
   * 运输条款
   */
  private String term4;

  /**
   * 供应商
   */
  private String supplier;

  /**
   * 利润
   */
  private String profit;

  private String logisticsFee;

  private String logisticsFee2;

  /**
   * 净利润
   */
  private String netProfit;

  /**
   * 销售经理
   */
  private String salseManager;

  private String signingTime;

  private Date createTime;

  private String note;

  private static final long serialVersionUID = 1L;

  /**
   * @return irdid
   */
  public Long getIrdid() {
    return irdid;
  }

  /**
   * @param irdid
   */
  public void setIrdid(final Long irdid) {
    this.irdid = irdid;
  }

  /**
   * 获取导入记录id
   *
   * @return irid - 导入记录id
   */
  public Long getIrid() {
    return irid;
  }

  /**
   * 设置导入记录id
   *
   * @param irid 导入记录id
   */
  public void setIrid(final Long irid) {
    this.irid = irid;
  }

  /**
   * 获取数据分类（0：新增，1：更新，2：异常）
   *
   * @return type - 数据分类（0：新增，1：更新，2：异常）
   */
  public Integer getType() {
    return type;
  }

  /**
   * 设置数据分类（0：新增，1：更新，2：异常）
   *
   * @param type 数据分类（0：新增，1：更新，2：异常）
   */
  public void setType(final Integer type) {
    this.type = type;
  }

  /**
   * 获取最终客户
   *
   * @return groups - 最终客户
   */
  public String getGroups() {
    return groups;
  }

  /**
   * 设置最终客户
   *
   * @param groups 最终客户
   */
  public void setGroups(final String groups) {
    this.groups = groups;
  }

  /**
   * 获取客户
   *
   * @return customer - 客户
   */
  public String getCustomer() {
    return customer;
  }

  /**
   * 设置客户
   *
   * @param customer 客户
   */
  public void setCustomer(final String customer) {
    this.customer = customer;
  }

  /**
   * 获取合同编号
   *
   * @return cont_no - 合同编号
   */
  public String getContNo() {
    return contNo;
  }

  /**
   * 设置合同编号
   *
   * @param contNo 合同编号
   */
  public void setContNo(final String contNo) {
    this.contNo = contNo;
  }

  /**
   * 获取牌号
   *
   * @return grade - 牌号
   */
  public String getGrade() {
    return grade;
  }

  /**
   * 设置牌号
   *
   * @param grade 牌号
   */
  public void setGrade(final String grade) {
    this.grade = grade;
  }

  /**
   * 获取生产商
   *
   * @return manufacturer - 生产商
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * 设置生产商
   *
   * @param manufacturer 生产商
   */
  public void setManufacturer(final String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * 获取品类
   *
   * @return commodity - 品类
   */
  public String getCommodity() {
    return commodity;
  }

  /**
   * 设置品类
   *
   * @param commodity 品类
   */
  public void setCommodity(final String commodity) {
    this.commodity = commodity;
  }

  /**
   * 获取销售量
   *
   * @return qty_mt - 销售量
   */
  public String getQtyMt() {
    return qtyMt;
  }

  /**
   * 设置销售量
   *
   * @param qtyMt 销售量
   */
  public void setQtyMt(final String qtyMt) {
    this.qtyMt = qtyMt;
  }

  /**
   * 获取开船时间
   *
   * @return shipmt - 开船时间
   */
  public String getShipmt() {
    return shipmt;
  }

  /**
   * 设置开船时间
   *
   * @param shipmt 开船时间
   */
  public void setShipmt(final String shipmt) {
    this.shipmt = shipmt;
  }

  /**
   * 获取销售价格
   *
   * @return price_mt - 销售价格
   */
  public String getPriceMt() {
    return priceMt;
  }

  /**
   * 设置销售价格
   *
   * @param priceMt 销售价格
   */
  public void setPriceMt(final String priceMt) {
    this.priceMt = priceMt;
  }

  /**
   * 获取销售金额
   *
   * @return total - 销售金额
   */
  public String getTotal() {
    return total;
  }

  /**
   * 设置销售金额
   *
   * @param total 销售金额
   */
  public void setTotal(final String total) {
    this.total = total;
  }

  /**
   * 获取销售付款条款
   *
   * @return term - 销售付款条款
   */
  public String getTerm() {
    return term;
  }

  /**
   * 设置销售付款条款
   *
   * @param term 销售付款条款
   */
  public void setTerm(final String term) {
    this.term = term;
  }

  /**
   * 获取采购价格
   *
   * @return price_mt2 - 采购价格
   */
  public String getPriceMt2() {
    return priceMt2;
  }

  /**
   * 设置采购价格
   *
   * @param priceMt2 采购价格
   */
  public void setPriceMt2(final String priceMt2) {
    this.priceMt2 = priceMt2;
  }

  /**
   * 获取採購金額
   *
   * @return total2 - 採購金額
   */
  public String getTotal2() {
    return total2;
  }

  /**
   * 设置採購金額
   *
   * @param total2 採購金額
   */
  public void setTotal2(final String total2) {
    this.total2 = total2;
  }

  /**
   * 获取採購付款條件
   *
   * @return term2 - 採購付款條件
   */
  public String getTerm2() {
    return term2;
  }

  /**
   * 设置採購付款條件
   *
   * @param term2 採購付款條件
   */
  public void setTerm2(final String term2) {
    this.term2 = term2;
  }

  /**
   * 获取运输条款
   *
   * @return term3 - 运输条款
   */
  public String getTerm3() {
    return term3;
  }

  /**
   * 设置运输条款
   *
   * @param term3 运输条款
   */
  public void setTerm3(final String term3) {
    this.term3 = term3;
  }

  /**
   * 获取供应商
   *
   * @return supplier - 供应商
   */
  public String getSupplier() {
    return supplier;
  }

  /**
   * 设置供应商
   *
   * @param supplier 供应商
   */
  public void setSupplier(final String supplier) {
    this.supplier = supplier;
  }

  /**
   * 获取利润
   *
   * @return profit - 利润
   */
  public String getProfit() {
    return profit;
  }

  /**
   * 设置利润
   *
   * @param profit 利润
   */
  public void setProfit(final String profit) {
    this.profit = profit;
  }

  /**
   * @return logistics_fee
   */
  public String getLogisticsFee() {
    return logisticsFee;
  }

  /**
   * @param logisticsFee
   */
  public void setLogisticsFee(final String logisticsFee) {
    this.logisticsFee = logisticsFee;
  }

  /**
   * @return logistics_fee2
   */
  public String getLogisticsFee2() {
    return logisticsFee2;
  }

  /**
   * @param logisticsFee2
   */
  public void setLogisticsFee2(final String logisticsFee2) {
    this.logisticsFee2 = logisticsFee2;
  }

  /**
   * 获取净利润
   *
   * @return net_profit - 净利润
   */
  public String getNetProfit() {
    return netProfit;
  }

  /**
   * 设置净利润
   *
   * @param netProfit 净利润
   */
  public void setNetProfit(final String netProfit) {
    this.netProfit = netProfit;
  }

  /**
   * 获取销售经理
   *
   * @return salse_manager - 销售经理
   */
  public String getSalseManager() {
    return salseManager;
  }

  /**
   * 设置销售经理
   *
   * @param salseManager 销售经理
   */
  public void setSalseManager(final String salseManager) {
    this.salseManager = salseManager;
  }

  /**
   * @return create_time
   */
  public Date getCreateTime() {
    return createTime;
  }

  /**
   * @param createTime
   */
  public void setCreateTime(final Date createTime) {
    this.createTime = createTime;
  }

  /**
   * @return note
   */
  public String getNote() {
    return note;
  }

  /**
   * @param note
   */
  public void setNote(final String note) {
    this.note = note;
  }

  /**
   * @return the term4
   */
  public String getTerm4() {
    return term4;
  }

  /**
   * @param term4 the term4 to set
   */
  public void setTerm4(final String term4) {
    this.term4 = term4;
  }

  /**
   * @return the signingTime
   */
  public String getSigningTime() {
    return signingTime;
  }

  /**
   * @param signingTime the signingTime to set
   */
  public void setSigningTime(final String signingTime) {
    this.signingTime = signingTime;
  }


}
