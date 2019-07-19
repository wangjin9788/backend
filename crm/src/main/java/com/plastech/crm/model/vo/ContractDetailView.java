package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年1月28日 上午10:42:26
 *
 */
public class ContractDetailView implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long cgid;
  // 客户po
  private String cgCustomerPo;
  // 销售单价
  private Double cgSalesUnitPrice;
  // 销售量
  private Double cgSalesVolume;
  // 销售金额(总价)
  private Double cgSalesTotal;
  // 开船时间（出货日期）
  private String cgShipmtDate;
  // 付款条款
  private String cgPaymentTerms;
  // 销售毛利润
  private Double cgGrossProfit;
  // 销售净利润
  private Double cgNetProfit;
  // 供应商po
  private String cpSupplierPo;
  // 供应商
  private String suName;
  // 采购单价
  private Double cpPurchasePrices;
  // 总采购量
  private Double cpPurchaseQuantity;
  // 采购成本
  private Double cpPurchaseCost;
  // 付款条款
  private String cpPaymentTerms;
  // 运输成本
  private Double cpLogisticsFee;
  // 其他成本
  private Double cpOtherCosts;

  /**
   * @return the cgid
   */
  public Long getCgid() {
    return cgid;
  }

  /**
   * @param cgid the cgid to set
   */
  public void setCgid(final Long cgid) {
    this.cgid = cgid;
  }

  /**
   * @return the cgCustomerPo
   */
  public String getCgCustomerPo() {
    return cgCustomerPo;
  }

  /**
   * @param cgCustomerPo the cgCustomerPo to set
   */
  public void setCgCustomerPo(final String cgCustomerPo) {
    this.cgCustomerPo = cgCustomerPo;
  }

  /**
   * @return the cgSalesUnitPrice
   */
  public Double getCgSalesUnitPrice() {
    return cgSalesUnitPrice;
  }

  /**
   * @param cgSalesUnitPrice the cgSalesUnitPrice to set
   */
  public void setCgSalesUnitPrice(final Double cgSalesUnitPrice) {
    this.cgSalesUnitPrice = cgSalesUnitPrice;
  }

  /**
   * @return the cgSalesVolume
   */
  public Double getCgSalesVolume() {
    return cgSalesVolume;
  }

  /**
   * @param cgSalesVolume the cgSalesVolume to set
   */
  public void setCgSalesVolume(final Double cgSalesVolume) {
    this.cgSalesVolume = cgSalesVolume;
  }

  /**
   * @return the cgSalesTotal
   */
  public Double getCgSalesTotal() {
    return cgSalesTotal;
  }

  /**
   * @param cgSalesTotal the cgSalesTotal to set
   */
  public void setCgSalesTotal(final Double cgSalesTotal) {
    this.cgSalesTotal = cgSalesTotal;
  }

  /**
   * @return the cgShipmtDate
   */
  public String getCgShipmtDate() {
    return cgShipmtDate;
  }

  /**
   * @param cgShipmtDate the cgShipmtDate to set
   */
  public void setCgShipmtDate(final String cgShipmtDate) {
    this.cgShipmtDate = cgShipmtDate;
  }

  /**
   * @return the cgPaymentTerms
   */
  public String getCgPaymentTerms() {
    return cgPaymentTerms;
  }

  /**
   * @param cgPaymentTerms the cgPaymentTerms to set
   */
  public void setCgPaymentTerms(final String cgPaymentTerms) {
    this.cgPaymentTerms = cgPaymentTerms;
  }

  /**
   * @return the cgGrossProfit
   */
  public Double getCgGrossProfit() {
    return cgGrossProfit;
  }

  /**
   * @param cgGrossProfit the cgGrossProfit to set
   */
  public void setCgGrossProfit(final Double cgGrossProfit) {
    this.cgGrossProfit = cgGrossProfit;
  }

  /**
   * @return the cgNetProfit
   */
  public Double getCgNetProfit() {
    return cgNetProfit;
  }

  /**
   * @param cgNetProfit the cgNetProfit to set
   */
  public void setCgNetProfit(final Double cgNetProfit) {
    this.cgNetProfit = cgNetProfit;
  }

  /**
   * @return the cpSupplierPo
   */
  public String getCpSupplierPo() {
    return cpSupplierPo;
  }

  /**
   * @param cpSupplierPo the cpSupplierPo to set
   */
  public void setCpSupplierPo(final String cpSupplierPo) {
    this.cpSupplierPo = cpSupplierPo;
  }

  /**
   * @return the suName
   */
  public String getSuName() {
    return suName;
  }

  /**
   * @param suName the suName to set
   */
  public void setSuName(final String suName) {
    this.suName = suName;
  }

  /**
   * @return the cpPurchasePrices
   */
  public Double getCpPurchasePrices() {
    return cpPurchasePrices;
  }

  /**
   * @param cpPurchasePrices the cpPurchasePrices to set
   */
  public void setCpPurchasePrices(final Double cpPurchasePrices) {
    this.cpPurchasePrices = cpPurchasePrices;
  }

  /**
   * @return the cpPurchaseQuantity
   */
  public Double getCpPurchaseQuantity() {
    return cpPurchaseQuantity;
  }

  /**
   * @param cpPurchaseQuantity the cpPurchaseQuantity to set
   */
  public void setCpPurchaseQuantity(final Double cpPurchaseQuantity) {
    this.cpPurchaseQuantity = cpPurchaseQuantity;
  }

  /**
   * @return the cpPurchaseCost
   */
  public Double getCpPurchaseCost() {
    return cpPurchaseCost;
  }

  /**
   * @param cpPurchaseCost the cpPurchaseCost to set
   */
  public void setCpPurchaseCost(final Double cpPurchaseCost) {
    this.cpPurchaseCost = cpPurchaseCost;
  }

  /**
   * @return the cpPaymentTerms
   */
  public String getCpPaymentTerms() {
    return cpPaymentTerms;
  }

  /**
   * @param cpPaymentTerms the cpPaymentTerms to set
   */
  public void setCpPaymentTerms(final String cpPaymentTerms) {
    this.cpPaymentTerms = cpPaymentTerms;
  }

  /**
   * @return the cpLogisticsFee
   */
  public Double getCpLogisticsFee() {
    return cpLogisticsFee;
  }

  /**
   * @param cpLogisticsFee the cpLogisticsFee to set
   */
  public void setCpLogisticsFee(final Double cpLogisticsFee) {
    this.cpLogisticsFee = cpLogisticsFee;
  }

  /**
   * @return the cpOtherCosts
   */
  public Double getCpOtherCosts() {
    return cpOtherCosts;
  }

  /**
   * @param cpOtherCosts the cpOtherCosts to set
   */
  public void setCpOtherCosts(final Double cpOtherCosts) {
    this.cpOtherCosts = cpOtherCosts;
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
    result =
        prime * result + ((cgCustomerPo == null) ? 0 : cgCustomerPo.hashCode());
    result = prime * result
        + ((cgGrossProfit == null) ? 0 : cgGrossProfit.hashCode());
    result =
        prime * result + ((cgNetProfit == null) ? 0 : cgNetProfit.hashCode());
    result = prime * result
        + ((cgPaymentTerms == null) ? 0 : cgPaymentTerms.hashCode());
    result =
        prime * result + ((cgSalesTotal == null) ? 0 : cgSalesTotal.hashCode());
    result = prime * result
        + ((cgSalesUnitPrice == null) ? 0 : cgSalesUnitPrice.hashCode());
    result = prime * result
        + ((cgSalesVolume == null) ? 0 : cgSalesVolume.hashCode());
    result =
        prime * result + ((cgShipmtDate == null) ? 0 : cgShipmtDate.hashCode());
    result = prime * result + ((cgid == null) ? 0 : cgid.hashCode());
    result = prime * result
        + ((cpLogisticsFee == null) ? 0 : cpLogisticsFee.hashCode());
    result =
        prime * result + ((cpOtherCosts == null) ? 0 : cpOtherCosts.hashCode());
    result = prime * result
        + ((cpPaymentTerms == null) ? 0 : cpPaymentTerms.hashCode());
    result = prime * result
        + ((cpPurchaseCost == null) ? 0 : cpPurchaseCost.hashCode());
    result = prime * result
        + ((cpPurchasePrices == null) ? 0 : cpPurchasePrices.hashCode());
    result = prime * result
        + ((cpPurchaseQuantity == null) ? 0 : cpPurchaseQuantity.hashCode());
    result =
        prime * result + ((cpSupplierPo == null) ? 0 : cpSupplierPo.hashCode());
    result = prime * result + ((suName == null) ? 0 : suName.hashCode());
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
    final ContractDetailView other = (ContractDetailView) obj;
    if (cgCustomerPo == null) {
      if (other.cgCustomerPo != null)
        return false;
    } else if (!cgCustomerPo.equals(other.cgCustomerPo))
      return false;
    if (cgGrossProfit == null) {
      if (other.cgGrossProfit != null)
        return false;
    } else if (!cgGrossProfit.equals(other.cgGrossProfit))
      return false;
    if (cgNetProfit == null) {
      if (other.cgNetProfit != null)
        return false;
    } else if (!cgNetProfit.equals(other.cgNetProfit))
      return false;
    if (cgPaymentTerms == null) {
      if (other.cgPaymentTerms != null)
        return false;
    } else if (!cgPaymentTerms.equals(other.cgPaymentTerms))
      return false;
    if (cgSalesTotal == null) {
      if (other.cgSalesTotal != null)
        return false;
    } else if (!cgSalesTotal.equals(other.cgSalesTotal))
      return false;
    if (cgSalesUnitPrice == null) {
      if (other.cgSalesUnitPrice != null)
        return false;
    } else if (!cgSalesUnitPrice.equals(other.cgSalesUnitPrice))
      return false;
    if (cgSalesVolume == null) {
      if (other.cgSalesVolume != null)
        return false;
    } else if (!cgSalesVolume.equals(other.cgSalesVolume))
      return false;
    if (cgShipmtDate == null) {
      if (other.cgShipmtDate != null)
        return false;
    } else if (!cgShipmtDate.equals(other.cgShipmtDate))
      return false;
    if (cgid == null) {
      if (other.cgid != null)
        return false;
    } else if (!cgid.equals(other.cgid))
      return false;
    if (cpLogisticsFee == null) {
      if (other.cpLogisticsFee != null)
        return false;
    } else if (!cpLogisticsFee.equals(other.cpLogisticsFee))
      return false;
    if (cpOtherCosts == null) {
      if (other.cpOtherCosts != null)
        return false;
    } else if (!cpOtherCosts.equals(other.cpOtherCosts))
      return false;
    if (cpPaymentTerms == null) {
      if (other.cpPaymentTerms != null)
        return false;
    } else if (!cpPaymentTerms.equals(other.cpPaymentTerms))
      return false;
    if (cpPurchaseCost == null) {
      if (other.cpPurchaseCost != null)
        return false;
    } else if (!cpPurchaseCost.equals(other.cpPurchaseCost))
      return false;
    if (cpPurchasePrices == null) {
      if (other.cpPurchasePrices != null)
        return false;
    } else if (!cpPurchasePrices.equals(other.cpPurchasePrices))
      return false;
    if (cpPurchaseQuantity == null) {
      if (other.cpPurchaseQuantity != null)
        return false;
    } else if (!cpPurchaseQuantity.equals(other.cpPurchaseQuantity))
      return false;
    if (cpSupplierPo == null) {
      if (other.cpSupplierPo != null)
        return false;
    } else if (!cpSupplierPo.equals(other.cpSupplierPo))
      return false;
    if (suName == null) {
      if (other.suName != null)
        return false;
    } else if (!suName.equals(other.suName))
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
    return "ContractDetailView [cgid=" + cgid + ", cgCustomerPo=" + cgCustomerPo
        + ", cgSalesUnitPrice=" + cgSalesUnitPrice + ", cgSalesVolume="
        + cgSalesVolume + ", cgSalesTotal=" + cgSalesTotal + ", cgShipmtDate="
        + cgShipmtDate + ", cgPaymentTerms=" + cgPaymentTerms
        + ", cgGrossProfit=" + cgGrossProfit + ", cgNetProfit=" + cgNetProfit
        + ", cpSupplierPo=" + cpSupplierPo + ", suName=" + suName
        + ", cpPurchasePrices=" + cpPurchasePrices + ", cpPurchaseQuantity="
        + cpPurchaseQuantity + ", cpPurchaseCost=" + cpPurchaseCost
        + ", cpPaymentTerms=" + cpPaymentTerms + ", cpLogisticsFee="
        + cpLogisticsFee + ", cpOtherCosts=" + cpOtherCosts + "]";
  }



}
