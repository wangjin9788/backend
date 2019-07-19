package com.plastech.crm.model.parameter;

import java.io.Serializable;

/**
 *
 *
 * @author : yemin
 *
 */
public class ImportConfirmParameter implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long irid;
  private Integer operateType;

  public final Long getIrid() {
    return irid;
  }

  public final void setIrid(final Long irid) {
    this.irid = irid;
  }

  public final Integer getOperateType() {
    return operateType;
  }

  public final void setOperateType(final Integer operateType) {
    this.operateType = operateType;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result =
        prime * result + ((operateType == null) ? 0 : operateType.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final ImportConfirmParameter other = (ImportConfirmParameter) obj;
    if (operateType == null) {
      if (other.operateType != null) {
        return false;
      }
    } else if (!operateType.equals(other.operateType)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ImportConfirmParameter [operateType=" + operateType + "]";
  }

}
