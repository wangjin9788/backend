package com.plastech.crm.model.parameter;

/**
 * @author wangJin
 *
 * @date 2019年1月22日 下午1:29:00
 *
 */
public class ExchangeDataOrderParameters {

  private Long orderIdA;
  private Long orderIdB;

  /**
   * @return the orderIdA
   */
  public Long getOrderIdA() {
    return orderIdA;
  }

  /**
   * @param orderIdA the orderIdA to set
   */
  public void setOrderIdA(final Long orderIdA) {
    this.orderIdA = orderIdA;
  }

  /**
   * @return the orderIdB
   */
  public Long getOrderIdB() {
    return orderIdB;
  }

  /**
   * @param orderIdB the orderIdB to set
   */
  public void setOrderIdB(final Long orderIdB) {
    this.orderIdB = orderIdB;
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
    result = prime * result + ((orderIdA == null) ? 0 : orderIdA.hashCode());
    result = prime * result + ((orderIdB == null) ? 0 : orderIdB.hashCode());
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
    final ExchangeDataOrderParameters other = (ExchangeDataOrderParameters) obj;
    if (orderIdA == null) {
      if (other.orderIdA != null)
        return false;
    } else if (!orderIdA.equals(other.orderIdA))
      return false;
    if (orderIdB == null) {
      if (other.orderIdB != null)
        return false;
    } else if (!orderIdB.equals(other.orderIdB))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "ExchangeDataOrderParameters [orderIdA=" + orderIdA + ", orderIdB="
        + orderIdB + "]";
  }



}
