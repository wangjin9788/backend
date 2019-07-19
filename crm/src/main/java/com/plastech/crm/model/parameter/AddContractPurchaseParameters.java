package com.plastech.crm.model.parameter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author wangJin
 *
 * @date 2019年1月24日 下午4:12:15
 *
 */
public class AddContractPurchaseParameters implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long cpid;
  // 供应商
  private Long suid;
  private String suName;
  // 货币种类
  private String cpPriceCurrency;
  // 采购单价
  private Double cpPurchasePrices;
  // 总采购量
  private Double cpPurchaseQuantity;
  // 采购成本
  private BigDecimal cpPurchaseCost;
  // 供应商po
  private String cpSupplierPo;
  // 付款条款
  private String cpPaymentTerms;
  // 运输条款
  private String cpTransportationTerms;
  // 运输成本货币类型
  private String cpLogisticsCurrency;
  // 运输成本
  private BigDecimal cpLogisticsFee;
  // 其他成本币种类型
  private String cpOthersCurrency;
  // 其他成本
  private BigDecimal cpOtherCosts;
  // 航线
  private String cpRoute;
  // 运输工具编号
  private String cpToolNumber;

  /**
   * @return the cpid
   */
  public Long getCpid() {
    return cpid;
  }

  /**
   * @param cpid the cpid to set
   */
  public void setCpid(final Long cpid) {
    this.cpid = cpid;
  }

  /**
   * @return the suid
   */
  public Long getSuid() {
    return suid;
  }

  /**
   * @param suid the suid to set
   */
  public void setSuid(final Long suid) {
    this.suid = suid;
  }

  /**
   * @return the cpPriceCurrency
   */
  public String getCpPriceCurrency() {
    return cpPriceCurrency;
  }

  /**
   * @param cpPriceCurrency the cpPriceCurrency to set
   */
  public void setCpPriceCurrency(final String cpPriceCurrency) {
    this.cpPriceCurrency = cpPriceCurrency;
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
  public BigDecimal getCpPurchaseCost() {
    return cpPurchaseCost;
  }

  /**
   * @param cpPurchaseCost the cpPurchaseCost to set
   */
  public void setCpPurchaseCost(final BigDecimal cpPurchaseCost) {
    this.cpPurchaseCost = cpPurchaseCost;
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
   * @return the cpTransportationTerms
   */
  public String getCpTransportationTerms() {
    return cpTransportationTerms;
  }

  /**
   * @param cpTransportationTerms the cpTransportationTerms to set
   */
  public void setCpTransportationTerms(final String cpTransportationTerms) {
    this.cpTransportationTerms = cpTransportationTerms;
  }

  /**
   * @return the cpLogisticsCurrency
   */
  public String getCpLogisticsCurrency() {
    return cpLogisticsCurrency;
  }

  /**
   * @param cpLogisticsCurrency the cpLogisticsCurrency to set
   */
  public void setCpLogisticsCurrency(final String cpLogisticsCurrency) {
    this.cpLogisticsCurrency = cpLogisticsCurrency;
  }

  /**
   * @return the cpLogisticsFee
   */
  public BigDecimal getCpLogisticsFee() {
    return cpLogisticsFee;
  }

  /**
   * @param cpLogisticsFee the cpLogisticsFee to set
   */
  public void setCpLogisticsFee(final BigDecimal cpLogisticsFee) {
    this.cpLogisticsFee = cpLogisticsFee;
  }

  /**
   * @return the cpOthersCurrency
   */
  public String getCpOthersCurrency() {
    return cpOthersCurrency;
  }

  /**
   * @param cpOthersCurrency the cpOthersCurrency to set
   */
  public void setCpOthersCurrency(final String cpOthersCurrency) {
    this.cpOthersCurrency = cpOthersCurrency;
  }

  /**
   * @return the cpOtherCosts
   */
  public BigDecimal getCpOtherCosts() {
    return cpOtherCosts;
  }

  /**
   * @param cpOtherCosts the cpOtherCosts to set
   */
  public void setCpOtherCosts(final BigDecimal cpOtherCosts) {
    this.cpOtherCosts = cpOtherCosts;
  }

  /**
   * @return the cpRoute
   */
  public String getCpRoute() {
    return cpRoute;
  }

  /**
   * @param cpRoute the cpRoute to set
   */
  public void setCpRoute(final String cpRoute) {
    this.cpRoute = cpRoute;
  }

  /**
   * @return the cpToolNumber
   */
  public String getCpToolNumber() {
    return cpToolNumber;
  }

  /**
   * @param cpToolNumber the cpToolNumber to set
   */
  public void setCpToolNumber(final String cpToolNumber) {
    this.cpToolNumber = cpToolNumber;
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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((cpLogisticsCurrency == null) ? 0 : cpLogisticsCurrency.hashCode());
    result = prime * result
        + ((cpLogisticsFee == null) ? 0 : cpLogisticsFee.hashCode());
    result =
        prime * result + ((cpOtherCosts == null) ? 0 : cpOtherCosts.hashCode());
    result = prime * result
        + ((cpOthersCurrency == null) ? 0 : cpOthersCurrency.hashCode());
    result = prime * result
        + ((cpPaymentTerms == null) ? 0 : cpPaymentTerms.hashCode());
    result = prime * result
        + ((cpPriceCurrency == null) ? 0 : cpPriceCurrency.hashCode());
    result = prime * result
        + ((cpPurchaseCost == null) ? 0 : cpPurchaseCost.hashCode());
    result = prime * result
        + ((cpPurchasePrices == null) ? 0 : cpPurchasePrices.hashCode());
    result = prime * result
        + ((cpPurchaseQuantity == null) ? 0 : cpPurchaseQuantity.hashCode());
    result = prime * result + ((cpRoute == null) ? 0 : cpRoute.hashCode());
    result =
        prime * result + ((cpSupplierPo == null) ? 0 : cpSupplierPo.hashCode());
    result =
        prime * result + ((cpToolNumber == null) ? 0 : cpToolNumber.hashCode());
    result = prime * result + ((cpTransportationTerms == null) ? 0
        : cpTransportationTerms.hashCode());
    result = prime * result + ((cpid == null) ? 0 : cpid.hashCode());
    result = prime * result + ((suName == null) ? 0 : suName.hashCode());
    result = prime * result + ((suid == null) ? 0 : suid.hashCode());
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
    final AddContractPurchaseParameters other = (AddContractPurchaseParameters) obj;
    if (cpLogisticsCurrency == null) {
      if (other.cpLogisticsCurrency != null)
        return false;
    } else if (!cpLogisticsCurrency.equals(other.cpLogisticsCurrency))
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
    if (cpOthersCurrency == null) {
      if (other.cpOthersCurrency != null)
        return false;
    } else if (!cpOthersCurrency.equals(other.cpOthersCurrency))
      return false;
    if (cpPaymentTerms == null) {
      if (other.cpPaymentTerms != null)
        return false;
    } else if (!cpPaymentTerms.equals(other.cpPaymentTerms))
      return false;
    if (cpPriceCurrency == null) {
      if (other.cpPriceCurrency != null)
        return false;
    } else if (!cpPriceCurrency.equals(other.cpPriceCurrency))
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
    if (cpRoute == null) {
      if (other.cpRoute != null)
        return false;
    } else if (!cpRoute.equals(other.cpRoute))
      return false;
    if (cpSupplierPo == null) {
      if (other.cpSupplierPo != null)
        return false;
    } else if (!cpSupplierPo.equals(other.cpSupplierPo))
      return false;
    if (cpToolNumber == null) {
      if (other.cpToolNumber != null)
        return false;
    } else if (!cpToolNumber.equals(other.cpToolNumber))
      return false;
    if (cpTransportationTerms == null) {
      if (other.cpTransportationTerms != null)
        return false;
    } else if (!cpTransportationTerms.equals(other.cpTransportationTerms))
      return false;
    if (cpid == null) {
      if (other.cpid != null)
        return false;
    } else if (!cpid.equals(other.cpid))
      return false;
    if (suName == null) {
      if (other.suName != null)
        return false;
    } else if (!suName.equals(other.suName))
      return false;
    if (suid == null) {
      if (other.suid != null)
        return false;
    } else if (!suid.equals(other.suid))
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
    return "AddContractPurchaseParameters [cpid=" + cpid + ", suid=" + suid
        + ", suName=" + suName + ", cpPriceCurrency=" + cpPriceCurrency
        + ", cpPurchasePrices=" + cpPurchasePrices + ", cpPurchaseQuantity="
        + cpPurchaseQuantity + ", cpPurchaseCost=" + cpPurchaseCost
        + ", cpSupplierPo=" + cpSupplierPo + ", cpPaymentTerms="
        + cpPaymentTerms + ", cpTransportationTerms=" + cpTransportationTerms
        + ", cpLogisticsCurrency=" + cpLogisticsCurrency + ", cpLogisticsFee="
        + cpLogisticsFee + ", cpOthersCurrency=" + cpOthersCurrency
        + ", cpOtherCosts=" + cpOtherCosts + ", cpRoute=" + cpRoute
        + ", cpToolNumber=" + cpToolNumber + "]";
  }


}
