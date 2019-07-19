package com.plastech.crm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "contract_grade")
public class ContractGrade implements Serializable {
  /**
   * 销售牌号清单
   */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long cgid;

  /**
   * 合同编号
   */
  @Id
  private Long coid;

  /**
   * 牌号id
   */
  private Long geid;

  /**
   * 销售量
   */
  @Column(name = "cg_sales_volume")
  private Double cgSalesVolume;

  /**
   * 货币种类
   */
  @Column(name = "cg_currency_type")
  private String cgCurrencyType;

  /**
   * 销售单价
   */
  @Column(name = "cg_sales_unit_price")
  private String cgSalesUnitPrice;

  /**
   * 销售金额
   */
  @Column(name = "cg_sales_total")
  private BigDecimal cgSalesTotal;

  /**
   * 开船时间
   */
  @Column(name = "cg_shipmt_date")
  private String cgShipmtDate;

  /**
   * 客户po
   */
  @Column(name = "cg_customer_po")
  private String cgCustomerPo;

  /**
   * 付款条款
   */
  @Column(name = "cg_payment_terms")
  private String cgPaymentTerms;

  /**
   * 销售毛利润
   */
  @Column(name = "cg_gross_profit")
  private BigDecimal cgGrossProfit;

  /**
   * 销售净利润
   */
  @Column(name = "cg_net_profit")
  private BigDecimal cgNetProfit;

  /**
   * 运输条款
   */
  @Column(name = "cg_transportation_terms")
  private String cgTransportationTerms;

  /**
   * 创建人id
   */
  @Column(name = "cg_creator_id")
  private Long cgCreatorId;

  /**
   * 创建时间
   */
  @Column(name = "cg_creator_time")
  private Date cgCreatorTime;

  /**
   * 备注
   */
  @Column(name = "cg_note")
  private String cgNote;

  /**
   * 状态（-1：删除 0：正常）
   */
  @Column(name = "cg_status")
  private Integer cgStatus;

  private static final long serialVersionUID = 1L;

  /**
   * 获取销售牌号清单
   *
   * @return cgid - 销售牌号清单
   */
  public Long getCgid() {
    return cgid;
  }

  /**
   * 设置销售牌号清单
   *
   * @param cgid 销售牌号清单
   */
  public void setCgid(final Long cgid) {
    this.cgid = cgid;
  }

  /**
   * 获取合同编号
   *
   * @return coid - 合同编号
   */
  public Long getCoid() {
    return coid;
  }

  /**
   * 设置合同编号
   *
   * @param coid 合同编号
   */
  public void setCoid(final Long coid) {
    this.coid = coid;
  }

  /**
   * 获取牌号id
   *
   * @return geid - 牌号id
   */
  public Long getGeid() {
    return geid;
  }

  /**
   * 设置牌号id
   *
   * @param geid 牌号id
   */
  public void setGeid(final Long geid) {
    this.geid = geid;
  }

  /**
   * 获取销售量
   *
   * @return cg_sales_volume - 销售量
   */
  public Double getCgSalesVolume() {
    return cgSalesVolume;
  }

  /**
   * 设置销售量
   *
   * @param cgSalesVolume 销售量
   */
  public void setCgSalesVolume(final Double cgSalesVolume) {
    this.cgSalesVolume = cgSalesVolume;
  }

  /**
   * 获取货币种类
   *
   * @return cg_currency_type - 货币种类
   */
  public String getCgCurrencyType() {
    return cgCurrencyType;
  }

  /**
   * 设置货币种类
   *
   * @param cgCurrencyType 货币种类
   */
  public void setCgCurrencyType(final String cgCurrencyType) {
    this.cgCurrencyType = cgCurrencyType;
  }

  /**
   * 获取销售单价
   *
   * @return cg_sales_unit_price - 销售单价
   */
  public String getCgSalesUnitPrice() {
    return cgSalesUnitPrice;
  }

  /**
   * 设置销售单价
   *
   * @param cgSalesUnitPrice 销售单价
   */
  public void setCgSalesUnitPrice(final String cgSalesUnitPrice) {
    this.cgSalesUnitPrice = cgSalesUnitPrice;
  }

  /**
   * 获取销售金额
   *
   * @return cg_sales_total - 销售金额
   */
  public BigDecimal getCgSalesTotal() {
    return cgSalesTotal;
  }

  /**
   * 设置销售金额
   *
   * @param cgSalesTotal 销售金额
   */
  public void setCgSalesTotal(final BigDecimal cgSalesTotal) {
    this.cgSalesTotal = cgSalesTotal;
  }

  /**
   * 获取开船时间
   *
   * @return cg_shipmt_date - 开船时间
   */
  public String getCgShipmtDate() {
    return cgShipmtDate;
  }

  /**
   * 设置开船时间
   *
   * @param cgShipmtDate 开船时间
   */
  public void setCgShipmtDate(final String cgShipmtDate) {
    this.cgShipmtDate = cgShipmtDate;
  }

  /**
   * 获取客户po
   *
   * @return cg_customer_po - 客户po
   */
  public String getCgCustomerPo() {
    return cgCustomerPo;
  }

  /**
   * 设置客户po
   *
   * @param cgCustomerPo 客户po
   */
  public void setCgCustomerPo(final String cgCustomerPo) {
    this.cgCustomerPo = cgCustomerPo;
  }

  /**
   * 获取付款条款
   *
   * @return cg_payment_terms - 付款条款
   */
  public String getCgPaymentTerms() {
    return cgPaymentTerms;
  }

  /**
   * 设置付款条款
   *
   * @param cgPaymentTerms 付款条款
   */
  public void setCgPaymentTerms(final String cgPaymentTerms) {
    this.cgPaymentTerms = cgPaymentTerms;
  }

  /**
   * 获取销售毛利润
   *
   * @return cg_gross_profit - 销售毛利润
   */
  public BigDecimal getCgGrossProfit() {
    return cgGrossProfit;
  }

  /**
   * 设置销售毛利润
   *
   * @param cgGrossProfit 销售毛利润
   */
  public void setCgGrossProfit(final BigDecimal cgGrossProfit) {
    this.cgGrossProfit = cgGrossProfit;
  }

  /**
   * 获取销售净利润
   *
   * @return cg_net_profit - 销售净利润
   */
  public BigDecimal getCgNetProfit() {
    return cgNetProfit;
  }

  /**
   * 设置销售净利润
   *
   * @param cgNetProfit 销售净利润
   */
  public void setCgNetProfit(final BigDecimal cgNetProfit) {
    this.cgNetProfit = cgNetProfit;
  }

  /**
   * 获取运输条款
   *
   * @return cg_transportation_terms - 运输条款
   */
  public String getCgTransportationTerms() {
    return cgTransportationTerms;
  }

  /**
   * 设置运输条款
   *
   * @param cgTransportationTerms 运输条款
   */
  public void setCgTransportationTerms(final String cgTransportationTerms) {
    this.cgTransportationTerms = cgTransportationTerms;
  }

  /**
   * 获取创建人id
   *
   * @return cg_creator_id - 创建人id
   */
  public Long getCgCreatorId() {
    return cgCreatorId;
  }

  /**
   * 设置创建人id
   *
   * @param cgCreatorId 创建人id
   */
  public void setCgCreatorId(final Long cgCreatorId) {
    this.cgCreatorId = cgCreatorId;
  }

  /**
   * 获取创建时间
   *
   * @return cg_creator_time - 创建时间
   */
  public Date getCgCreatorTime() {
    return cgCreatorTime;
  }

  /**
   * 设置创建时间
   *
   * @param cgCreatorTime 创建时间
   */
  public void setCgCreatorTime(final Date cgCreatorTime) {
    this.cgCreatorTime = cgCreatorTime;
  }

  /**
   * 获取备注
   *
   * @return cg_note - 备注
   */
  public String getCgNote() {
    return cgNote;
  }

  /**
   * 设置备注
   *
   * @param cgNote 备注
   */
  public void setCgNote(final String cgNote) {
    this.cgNote = cgNote;
  }

  /**
   * @return the cgStatus
   */
  public Integer getCgStatus() {
    return cgStatus;
  }

  /**
   * @param cgStatus the cgStatus to set
   */
  public void setCgStatus(final Integer cgStatus) {
    this.cgStatus = cgStatus;
  }

}
