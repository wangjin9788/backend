package com.plastech.crmcommon.dto;

import java.io.Serializable;

/**
 * response of remote procedure call
 *
 * @author : yemin
 *
 */
public class RpcResponse<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  private boolean success; // 表示调用是否成功
                           // ,如果为true,则可以调用getResult,如果为false,则调用errorCode来获取出错信息
  private T resultData; // 结果集
  private Integer resultCode;
  private String message; // 信息

  public RpcResponse() {
    super();
  }

  public RpcResponse(final boolean success, final T resultData,
      final Integer resultCode, final String message) {
    super();
    this.success = success;
    this.resultData = resultData;
    this.resultCode = resultCode;
    this.message = message;
  }

  public RpcResponse(final boolean success, final T resultData) {
    super();
    this.success = success;
    this.resultData = resultData;
    if (success) {
      this.resultCode = 0;
      this.message = "success";
    } else {
      this.resultCode = 50;
      this.message = "failure";
    }
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(final boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  public T getResultData() {
    return resultData;
  }

  public void setResultData(final T resultData) {
    this.resultData = resultData;
  }

  public final Integer getResultCode() {
    return resultCode;
  }

  public final void setResultCode(final Integer resultCode) {
    this.resultCode = resultCode;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((message == null) ? 0 : message.hashCode());
    result =
        prime * result + ((resultCode == null) ? 0 : resultCode.hashCode());
    result =
        prime * result + ((resultData == null) ? 0 : resultData.hashCode());
    result = prime * result + (success ? 1231 : 1237);
    return result;
  }

  @SuppressWarnings("rawtypes")
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
    final RpcResponse other = (RpcResponse) obj;
    if (message == null) {
      if (other.message != null) {
        return false;
      }
    } else if (!message.equals(other.message)) {
      return false;
    }
    if (resultCode == null) {
      if (other.resultCode != null) {
        return false;
      }
    } else if (!resultCode.equals(other.resultCode)) {
      return false;
    }
    if (resultData == null) {
      if (other.resultData != null) {
        return false;
      }
    } else if (!resultData.equals(other.resultData)) {
      return false;
    }
    if (success != other.success) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "RpcResponse [success=" + success + ", resultData=" + resultData
        + ", resultCode=" + resultCode + ", message=" + message + "]";
  }

}
