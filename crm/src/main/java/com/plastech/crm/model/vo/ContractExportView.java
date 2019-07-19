package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年4月9日 下午2:58:18
 *
 */
public class ContractExportView implements Serializable {

  private static final long serialVersionUID = 1L;


  private String cuName;// 用户名称
  private String gName;// 最终客户
  private String coNumber;// 合同编号
  private String geNumber;// 牌号
  private String ctName;// 品类
  private String mfName;// 生产商
  private Double salesVolume;// 数量
  private String shipmtDate;// 时间
  private Double salesUnitPrice;// 销售价格
  private Double salesTotal;// 销售金额
  private String cgPaymentTerms;// 销售条款
  private String transportationTerms;// 销售运输条款
  private Double purchasePrices;// 采购价格
  private Double purchaseCost;// 采购金额
  private String cpPaymentTerms;// 付款条款
  private String cpTransportationTerms;// 采购运输条款
  private String suName;// 供应商名称
  private Double grossProfit;// 利润
  private Double netProfit; // 净利润
  private Double logistics;// 物流费用1
  private Double cpOtherCosts;
  private String uname;
  private String currencyType;// 货币种类

  /**
   * @return the cuName
   */
  public String getCuName() {
    return cuName;
  }

  /**
   * @param cuName the cuName to set
   */
  public void setCuName(final String cuName) {
    this.cuName = cuName;
  }

  /**
   * @return the gName
   */
  public String getgName() {
    return gName;
  }

  /**
   * @param gName the gName to set
   */
  public void setgName(final String gName) {
    this.gName = gName;
  }

  /**
   * @return the coNumber
   */
  public String getCoNumber() {
    return coNumber;
  }

  /**
   * @param coNumber the coNumber to set
   */
  public void setCoNumber(final String coNumber) {
    this.coNumber = coNumber;
  }

  /**
   * @return the geNumber
   */
  public String getGeNumber() {
    return geNumber;
  }

  /**
   * @param geNumber the geNumber to set
   */
  public void setGeNumber(final String geNumber) {
    this.geNumber = geNumber;
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

  /**
   * @return the salesVolume
   */
  public Double getSalesVolume() {
    return salesVolume;
  }

  /**
   * @param salesVolume the salesVolume to set
   */
  public void setSalesVolume(final Double salesVolume) {
    this.salesVolume = salesVolume;
  }

  /**
   * @return the shipmtDate
   */
  public String getShipmtDate() {
    return shipmtDate;
  }

  /**
   * @param shipmtDate the shipmtDate to set
   */
  public void setShipmtDate(final String shipmtDate) {
    this.shipmtDate = shipmtDate;
  }

  /**
   * @return the salesUnitPrice
   */
  public Double getSalesUnitPrice() {
    return salesUnitPrice;
  }

  /**
   * @param salesUnitPrice the salesUnitPrice to set
   */
  public void setSalesUnitPrice(final Double salesUnitPrice) {
    this.salesUnitPrice = salesUnitPrice;
  }

  /**
   * @return the salesTotal
   */
  public Double getSalesTotal() {
    return salesTotal;
  }

  /**
   * @param salesTotal the salesTotal to set
   */
  public void setSalesTotal(final Double salesTotal) {
    this.salesTotal = salesTotal;
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
   * @return the transportationTerms
   */
  public String getTransportationTerms() {
    return transportationTerms;
  }

  /**
   * @param transportationTerms the transportationTerms to set
   */
  public void setTransportationTerms(final String transportationTerms) {
    this.transportationTerms = transportationTerms;
  }

  /**
   * @return the purchasePrices
   */
  public Double getPurchasePrices() {
    return purchasePrices;
  }

  /**
   * @param purchasePrices the purchasePrices to set
   */
  public void setPurchasePrices(final Double purchasePrices) {
    this.purchasePrices = purchasePrices;
  }

  /**
   * @return the purchaseCost
   */
  public Double getPurchaseCost() {
    return purchaseCost;
  }

  /**
   * @param purchaseCost the purchaseCost to set
   */
  public void setPurchaseCost(final Double purchaseCost) {
    this.purchaseCost = purchaseCost;
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
   * @return the grossProfit
   */
  public Double getGrossProfit() {
    return grossProfit;
  }

  /**
   * @param grossProfit the grossProfit to set
   */
  public void setGrossProfit(final Double grossProfit) {
    this.grossProfit = grossProfit;
  }

  /**
   * @return the netProfit
   */
  public Double getNetProfit() {
    return netProfit;
  }

  /**
   * @param netProfit the netProfit to set
   */
  public void setNetProfit(final Double netProfit) {
    this.netProfit = netProfit;
  }

  /**
   * @return the logistics
   */
  public Double getLogistics() {
    return logistics;
  }

  /**
   * @param logistics the logistics to set
   */
  public void setLogistics(final Double logistics) {
    this.logistics = logistics;
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

  /**
   * @return the uname
   */
  public String getUname() {
    return uname;
  }

  /**
   * @param uname the uname to set
   */
  public void setUname(final String uname) {
    this.uname = uname;
  }

  /**
   * @return the currencyType
   */
  public String getCurrencyType() {
    return currencyType;
  }

  /**
   * @param currencyType the currencyType to set
   */
  public void setCurrencyType(final String currencyType) {
    this.currencyType = currencyType;
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
        + ((cgPaymentTerms == null) ? 0 : cgPaymentTerms.hashCode());
    result = prime * result + ((coNumber == null) ? 0 : coNumber.hashCode());
    result =
        prime * result + ((cpOtherCosts == null) ? 0 : cpOtherCosts.hashCode());
    result = prime * result
        + ((cpPaymentTerms == null) ? 0 : cpPaymentTerms.hashCode());
    result = prime * result + ((cpTransportationTerms == null) ? 0
        : cpTransportationTerms.hashCode());
    result = prime * result + ((ctName == null) ? 0 : ctName.hashCode());
    result = prime * result + ((cuName == null) ? 0 : cuName.hashCode());
    result =
        prime * result + ((currencyType == null) ? 0 : currencyType.hashCode());
    result = prime * result + ((gName == null) ? 0 : gName.hashCode());
    result = prime * result + ((geNumber == null) ? 0 : geNumber.hashCode());
    result =
        prime * result + ((grossProfit == null) ? 0 : grossProfit.hashCode());
    result = prime * result + ((logistics == null) ? 0 : logistics.hashCode());
    result = prime * result + ((mfName == null) ? 0 : mfName.hashCode());
    result = prime * result + ((netProfit == null) ? 0 : netProfit.hashCode());
    result =
        prime * result + ((purchaseCost == null) ? 0 : purchaseCost.hashCode());
    result = prime * result
        + ((purchasePrices == null) ? 0 : purchasePrices.hashCode());
    result =
        prime * result + ((salesTotal == null) ? 0 : salesTotal.hashCode());
    result = prime * result
        + ((salesUnitPrice == null) ? 0 : salesUnitPrice.hashCode());
    result =
        prime * result + ((salesVolume == null) ? 0 : salesVolume.hashCode());
    result =
        prime * result + ((shipmtDate == null) ? 0 : shipmtDate.hashCode());
    result = prime * result + ((suName == null) ? 0 : suName.hashCode());
    result = prime * result
        + ((transportationTerms == null) ? 0 : transportationTerms.hashCode());
    result = prime * result + ((uname == null) ? 0 : uname.hashCode());
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
    final ContractExportView other = (ContractExportView) obj;
    if (cgPaymentTerms == null) {
      if (other.cgPaymentTerms != null)
        return false;
    } else if (!cgPaymentTerms.equals(other.cgPaymentTerms))
      return false;
    if (coNumber == null) {
      if (other.coNumber != null)
        return false;
    } else if (!coNumber.equals(other.coNumber))
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
    if (cpTransportationTerms == null) {
      if (other.cpTransportationTerms != null)
        return false;
    } else if (!cpTransportationTerms.equals(other.cpTransportationTerms))
      return false;
    if (ctName == null) {
      if (other.ctName != null)
        return false;
    } else if (!ctName.equals(other.ctName))
      return false;
    if (cuName == null) {
      if (other.cuName != null)
        return false;
    } else if (!cuName.equals(other.cuName))
      return false;
    if (currencyType == null) {
      if (other.currencyType != null)
        return false;
    } else if (!currencyType.equals(other.currencyType))
      return false;
    if (gName == null) {
      if (other.gName != null)
        return false;
    } else if (!gName.equals(other.gName))
      return false;
    if (geNumber == null) {
      if (other.geNumber != null)
        return false;
    } else if (!geNumber.equals(other.geNumber))
      return false;
    if (grossProfit == null) {
      if (other.grossProfit != null)
        return false;
    } else if (!grossProfit.equals(other.grossProfit))
      return false;
    if (logistics == null) {
      if (other.logistics != null)
        return false;
    } else if (!logistics.equals(other.logistics))
      return false;
    if (mfName == null) {
      if (other.mfName != null)
        return false;
    } else if (!mfName.equals(other.mfName))
      return false;
    if (netProfit == null) {
      if (other.netProfit != null)
        return false;
    } else if (!netProfit.equals(other.netProfit))
      return false;
    if (purchaseCost == null) {
      if (other.purchaseCost != null)
        return false;
    } else if (!purchaseCost.equals(other.purchaseCost))
      return false;
    if (purchasePrices == null) {
      if (other.purchasePrices != null)
        return false;
    } else if (!purchasePrices.equals(other.purchasePrices))
      return false;
    if (salesTotal == null) {
      if (other.salesTotal != null)
        return false;
    } else if (!salesTotal.equals(other.salesTotal))
      return false;
    if (salesUnitPrice == null) {
      if (other.salesUnitPrice != null)
        return false;
    } else if (!salesUnitPrice.equals(other.salesUnitPrice))
      return false;
    if (salesVolume == null) {
      if (other.salesVolume != null)
        return false;
    } else if (!salesVolume.equals(other.salesVolume))
      return false;
    if (shipmtDate == null) {
      if (other.shipmtDate != null)
        return false;
    } else if (!shipmtDate.equals(other.shipmtDate))
      return false;
    if (suName == null) {
      if (other.suName != null)
        return false;
    } else if (!suName.equals(other.suName))
      return false;
    if (transportationTerms == null) {
      if (other.transportationTerms != null)
        return false;
    } else if (!transportationTerms.equals(other.transportationTerms))
      return false;
    if (uname == null) {
      if (other.uname != null)
        return false;
    } else if (!uname.equals(other.uname))
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
    return "ContractExportView [cuName=" + cuName + ", gName=" + gName
        + ", coNumber=" + coNumber + ", geNumber=" + geNumber + ", ctName="
        + ctName + ", mfName=" + mfName + ", salesVolume=" + salesVolume
        + ", shipmtDate=" + shipmtDate + ", salesUnitPrice=" + salesUnitPrice
        + ", salesTotal=" + salesTotal + ", cgPaymentTerms=" + cgPaymentTerms
        + ", transportationTerms=" + transportationTerms + ", purchasePrices="
        + purchasePrices + ", purchaseCost=" + purchaseCost
        + ", cpPaymentTerms=" + cpPaymentTerms + ", cpTransportationTerms="
        + cpTransportationTerms + ", suName=" + suName + ", grossProfit="
        + grossProfit + ", netProfit=" + netProfit + ", logistics=" + logistics
        + ", cpOtherCosts=" + cpOtherCosts + ", uname=" + uname
        + ", currencyType=" + currencyType + "]";
  }



}
