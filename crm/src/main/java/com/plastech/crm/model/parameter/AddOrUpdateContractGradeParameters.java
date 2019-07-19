package com.plastech.crm.model.parameter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author wangJin
 *
 * @date 2019年1月24日 下午4:07:37
 *
 */
public class AddOrUpdateContractGradeParameters
    extends AddContractPurchaseParameters implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long cgid;

  private Long coid;

  // 牌号id
  private Long geid;
  // 销售量
  private Double cgSalesVolume;
  // 货币种类
  private String cgCurrencyType;
  // 销售单价
  private String cgSalesUnitPrice;
  // 销售金额
  private BigDecimal cgSalesTotal;
  // 开船时间
  private String cgShipmtDate;
  // 客户po
  private String cgCustomerPo;
  // 付款条款
  private String cgPaymentTerms;
  // 运输条款
  private String cgTransportationTerms;
  // 牌号名称
  private String concatName;
  // 毛利润
  private BigDecimal cgGrossProfit;
  //净利润
  private BigDecimal cgNetProfit;

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
   * @return the coid
   */
  public Long getCoid() {
    return coid;
  }

  /**
   * @param coid the coid to set
   */
  public void setCoid(final Long coid) {
    this.coid = coid;
  }

  /**
   * @return the geid
   */
  public Long getGeid() {
    return geid;
  }

  /**
   * @param geid the geid to set
   */
  public void setGeid(final Long geid) {
    this.geid = geid;
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
   * @return the cgCurrencyType
   */
  public String getCgCurrencyType() {
    return cgCurrencyType;
  }

  /**
   * @param cgCurrencyType the cgCurrencyType to set
   */
  public void setCgCurrencyType(final String cgCurrencyType) {
    this.cgCurrencyType = cgCurrencyType;
  }

  /**
   * @return the cgSalesUnitPrice
   */
  public String getCgSalesUnitPrice() {
    return cgSalesUnitPrice;
  }

  /**
   * @param cgSalesUnitPrice the cgSalesUnitPrice to set
   */
  public void setCgSalesUnitPrice(final String cgSalesUnitPrice) {
    this.cgSalesUnitPrice = cgSalesUnitPrice;
  }

  /**
   * @return the cgSalesTotal
   */
  public BigDecimal getCgSalesTotal() {
    return cgSalesTotal;
  }

  /**
   * @param cgSalesTotal the cgSalesTotal to set
   */
  public void setCgSalesTotal(final BigDecimal cgSalesTotal) {
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
   * @return the cgTransportationTerms
   */
  public String getCgTransportationTerms() {
    return cgTransportationTerms;
  }

  /**
   * @param cgTransportationTerms the cgTransportationTerms to set
   */
  public void setCgTransportationTerms(final String cgTransportationTerms) {
    this.cgTransportationTerms = cgTransportationTerms;
  }



  /**
   * @return the concatName
   */
  public String getConcatName() {
    return concatName;
  }

  /**
   * @param concatName the concatName to set
   */
  public void setConcatName(final String concatName) {
    this.concatName = concatName;
  }


  /**
   * @return the cgGrossProfit
   */
  public BigDecimal getCgGrossProfit() {
    return cgGrossProfit;
  }

  /**
   * @param cgGrossProfit the cgGrossProfit to set
   */
  public void setCgGrossProfit(final BigDecimal cgGrossProfit) {
    this.cgGrossProfit = cgGrossProfit;
  }

  /**
   * @return the cgNetProfit
   */
  public BigDecimal getCgNetProfit() {
    return cgNetProfit;
  }

  /**
   * @param cgNetProfit the cgNetProfit to set
   */
  public void setCgNetProfit(final BigDecimal cgNetProfit) {
    this.cgNetProfit = cgNetProfit;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result
        + ((cgCurrencyType == null) ? 0 : cgCurrencyType.hashCode());
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
    result = prime * result + ((cgTransportationTerms == null) ? 0
        : cgTransportationTerms.hashCode());
    result = prime * result + ((cgid == null) ? 0 : cgid.hashCode());
    result = prime * result + ((coid == null) ? 0 : coid.hashCode());
    result =
        prime * result + ((concatName == null) ? 0 : concatName.hashCode());
    result = prime * result + ((geid == null) ? 0 : geid.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    final AddOrUpdateContractGradeParameters other =
        (AddOrUpdateContractGradeParameters) obj;
    if (cgCurrencyType == null) {
      if (other.cgCurrencyType != null)
        return false;
    } else if (!cgCurrencyType.equals(other.cgCurrencyType))
      return false;
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
    if (cgTransportationTerms == null) {
      if (other.cgTransportationTerms != null)
        return false;
    } else if (!cgTransportationTerms.equals(other.cgTransportationTerms))
      return false;
    if (cgid == null) {
      if (other.cgid != null)
        return false;
    } else if (!cgid.equals(other.cgid))
      return false;
    if (coid == null) {
      if (other.coid != null)
        return false;
    } else if (!coid.equals(other.coid))
      return false;
    if (concatName == null) {
      if (other.concatName != null)
        return false;
    } else if (!concatName.equals(other.concatName))
      return false;
    if (geid == null) {
      if (other.geid != null)
        return false;
    } else if (!geid.equals(other.geid))
      return false;
    return true;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "AddOrUpdateContractGradeParameters [cgid=" + cgid + ", coid=" + coid
        + ", geid=" + geid + ", cgSalesVolume=" + cgSalesVolume
        + ", cgCurrencyType=" + cgCurrencyType + ", cgSalesUnitPrice="
        + cgSalesUnitPrice + ", cgSalesTotal=" + cgSalesTotal
        + ", cgShipmtDate=" + cgShipmtDate + ", cgCustomerPo=" + cgCustomerPo
        + ", cgPaymentTerms=" + cgPaymentTerms + ", cgTransportationTerms="
        + cgTransportationTerms + ", concatName=" + concatName
        + ", cgGrossProfit=" + cgGrossProfit + ", cgNetProfit=" + cgNetProfit
        + "]";
  }


}
