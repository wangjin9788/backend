package com.plastech.crm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "contract_purchase")
public class ContractPurchase implements Serializable {
  /**
   * 采购清单
   */
  @Id
  private Long cpid;


  /**
   * contract_grade(销售牌号表) id
   */
  private Long cgid;

  /**
   * 供应商
   */
  private Long suid;

  /**
   * 货币种类
   */
  @Column(name = "cp_price_currency")
  private String cpPriceCurrency;

  /**
   * 采购单价
   */
  @Column(name = "cp_purchase_prices")
  private Double cpPurchasePrices;

  /**
   * 总采购量
   */
  @Column(name = "cp_purchase_quantity")
  private Double cpPurchaseQuantity;

  /**
   * 采购成本
   */
  @Column(name = "cp_purchase_cost")
  private BigDecimal cpPurchaseCost;

  /**
   * 供应商po
   */
  @Column(name = "cp_supplier_po")
  private String cpSupplierPo;

  /**
   * 付款条款
   */
  @Column(name = "cp_payment_terms")
  private String cpPaymentTerms;

  /**
   * 运输条款
   */
  @Column(name = "cp_transportation_terms")
  private String cpTransportationTerms;

  /**
   * 运输成本货币类型
   */
  @Column(name = "cp_logistics_currency")
  private String cpLogisticsCurrency;

  /**
   * 运输成本
   */
  @Column(name = "cp_logistics_fee")
  private BigDecimal cpLogisticsFee;

  /**
   * 其他成本币种类型
   */
  @Column(name = "cp_others_currency")
  private String cpOthersCurrency;

  /**
   * 其他成本
   */
  @Column(name = "cp_other_costs")
  private BigDecimal cpOtherCosts;

  /**
   * 航线
   */
  @Column(name = "cp_route")
  private String cpRoute;

  /**
   * 运输工具编号
   */
  @Column(name = "cp_tool_number")
  private String cpToolNumber;

  /**
   * 创建人id
   */
  @Column(name = "cp_creator_id")
  private Long cpCreatorId;

  /**
   * 创建时间
   */
  @Column(name = "cp_creator_time")
  private Date cpCreatorTime;

  /**
   * 状态（-1：删除,0：正常）
   */
  @Column(name = "cp_status")
  private Integer cpStatus;

  private static final long serialVersionUID = 1L;

  /**
   * 获取采购清单
   *
   * @return cpid - 采购清单
   */
  public Long getCpid() {
    return cpid;
  }

  /**
   * 设置采购清单
   *
   * @param cpid 采购清单
   */
  public void setCpid(final Long cpid) {
    this.cpid = cpid;
  }


  /**
   * 获取contract_grade(销售牌号表) id
   *
   * @return cgid - contract_grade(销售牌号表) id
   */
  public Long getCgid() {
    return cgid;
  }

  /**
   * 设置contract_grade(销售牌号表) id
   *
   * @param cgid contract_grade(销售牌号表) id
   */
  public void setCgid(final Long cgid) {
    this.cgid = cgid;
  }

  /**
   * 获取供应商
   *
   * @return suid - 供应商
   */
  public Long getSuid() {
    return suid;
  }

  /**
   * 设置供应商
   *
   * @param suid 供应商
   */
  public void setSuid(final Long suid) {
    this.suid = suid;
  }

  /**
   * 获取货币种类
   *
   * @return cp_price_currency - 货币种类
   */
  public String getCpPriceCurrency() {
    return cpPriceCurrency;
  }

  /**
   * 设置货币种类
   *
   * @param cpPriceCurrency 货币种类
   */
  public void setCpPriceCurrency(final String cpPriceCurrency) {
    this.cpPriceCurrency = cpPriceCurrency;
  }

  /**
   * 获取采购单价
   *
   * @return cp_purchase_prices - 采购单价
   */
  public Double getCpPurchasePrices() {
    return cpPurchasePrices;
  }

  /**
   * 设置采购单价
   *
   * @param cpPurchasePrices 采购单价
   */
  public void setCpPurchasePrices(final Double cpPurchasePrices) {
    this.cpPurchasePrices = cpPurchasePrices;
  }

  /**
   * 获取总采购量
   *
   * @return cp_purchase_quantity - 总采购量
   */
  public Double getCpPurchaseQuantity() {
    return cpPurchaseQuantity;
  }

  /**
   * 设置总采购量
   *
   * @param cpPurchaseQuantity 总采购量
   */
  public void setCpPurchaseQuantity(final Double cpPurchaseQuantity) {
    this.cpPurchaseQuantity = cpPurchaseQuantity;
  }


  /**
   * 获取采购成本
   *
   * @return cp_purchase_cost - 采购成本
   */
  public BigDecimal getCpPurchaseCost() {
    return cpPurchaseCost;
  }

  /**
   * 设置采购成本
   *
   * @param cpPurchaseCost 采购成本
   */
  public void setCpPurchaseCost(final BigDecimal cpPurchaseCost) {
    this.cpPurchaseCost = cpPurchaseCost;
  }

  /**
   * 获取供应商po
   *
   * @return cp_supplier_po - 供应商po
   */
  public String getCpSupplierPo() {
    return cpSupplierPo;
  }

  /**
   * 设置供应商po
   *
   * @param cpSupplierPo 供应商po
   */
  public void setCpSupplierPo(final String cpSupplierPo) {
    this.cpSupplierPo = cpSupplierPo;
  }

  /**
   * 获取付款条款
   *
   * @return cp_payment_terms - 付款条款
   */
  public String getCpPaymentTerms() {
    return cpPaymentTerms;
  }

  /**
   * 设置付款条款
   *
   * @param cpPaymentTerms 付款条款
   */
  public void setCpPaymentTerms(final String cpPaymentTerms) {
    this.cpPaymentTerms = cpPaymentTerms;
  }

  /**
   * 获取运输条款
   *
   * @return cp_transportation_terms - 运输条款
   */
  public String getCpTransportationTerms() {
    return cpTransportationTerms;
  }

  /**
   * 设置运输条款
   *
   * @param cpTransportationTerms 运输条款
   */
  public void setCpTransportationTerms(final String cpTransportationTerms) {
    this.cpTransportationTerms = cpTransportationTerms;
  }

  /**
   * 获取运输成本货币类型
   *
   * @return cp_logistics_currency - 运输成本货币类型
   */
  public String getCpLogisticsCurrency() {
    return cpLogisticsCurrency;
  }

  /**
   * 设置运输成本货币类型
   *
   * @param cpLogisticsCurrency 运输成本货币类型
   */
  public void setCpLogisticsCurrency(final String cpLogisticsCurrency) {
    this.cpLogisticsCurrency = cpLogisticsCurrency;
  }

  /**
   * 获取运输成本
   *
   * @return cp_logistics_fee - 运输成本
   */
  public BigDecimal getCpLogisticsFee() {
    return cpLogisticsFee;
  }

  /**
   * 设置运输成本
   *
   * @param cpLogisticsFee 运输成本
   */
  public void setCpLogisticsFee(final BigDecimal cpLogisticsFee) {
    this.cpLogisticsFee = cpLogisticsFee;
  }

  /**
   * 获取其他成本币种类型
   *
   * @return cp_others_currency - 其他成本币种类型
   */
  public String getCpOthersCurrency() {
    return cpOthersCurrency;
  }

  /**
   * 设置其他成本币种类型
   *
   * @param cpOthersCurrency 其他成本币种类型
   */
  public void setCpOthersCurrency(final String cpOthersCurrency) {
    this.cpOthersCurrency = cpOthersCurrency;
  }

  /**
   * 获取其他成本
   *
   * @return cp_other_costs - 其他成本
   */
  public BigDecimal getCpOtherCosts() {
    return cpOtherCosts;
  }

  /**
   * 设置其他成本
   *
   * @param cpOtherCosts 其他成本
   */
  public void setCpOtherCosts(final BigDecimal cpOtherCosts) {
    this.cpOtherCosts = cpOtherCosts;
  }

  /**
   * 获取航线
   *
   * @return cp_route - 航线
   */
  public String getCpRoute() {
    return cpRoute;
  }

  /**
   * 设置航线
   *
   * @param cpRoute 航线
   */
  public void setCpRoute(final String cpRoute) {
    this.cpRoute = cpRoute;
  }

  /**
   * 获取运输工具编号
   *
   * @return cp_tool_number - 运输工具编号
   */
  public String getCpToolNumber() {
    return cpToolNumber;
  }

  /**
   * 设置运输工具编号
   *
   * @param cpToolNumber 运输工具编号
   */
  public void setCpToolNumber(final String cpToolNumber) {
    this.cpToolNumber = cpToolNumber;
  }

  /**
   * 获取创建人id
   *
   * @return cp_creator_id - 创建人id
   */
  public Long getCpCreatorId() {
    return cpCreatorId;
  }

  /**
   * 设置创建人id
   *
   * @param cpCreatorId 创建人id
   */
  public void setCpCreatorId(final Long cpCreatorId) {
    this.cpCreatorId = cpCreatorId;
  }

  /**
   * 获取创建时间
   *
   * @return cp_creator_time - 创建时间
   */
  public Date getCpCreatorTime() {
    return cpCreatorTime;
  }

  /**
   * 设置创建时间
   *
   * @param cpCreatorTime 创建时间
   */
  public void setCpCreatorTime(final Date cpCreatorTime) {
    this.cpCreatorTime = cpCreatorTime;
  }

  /**
   * @return the cpStatus
   */
  public Integer getCpStatus() {
    return cpStatus;
  }

  /**
   * @param cpStatus the cpStatus to set
   */
  public void setCpStatus(final Integer cpStatus) {
    this.cpStatus = cpStatus;
  }


}
