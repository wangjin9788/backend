package com.plastech.crm.exception;

/**
 *
 * Base Exception.
 *
 * @author yemin:
 * @date 2018年5月18日 下午6:22:53
 *
 */
public class BaseException extends Exception {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public BaseException() {
    super();
  }

  public BaseException(final String errorMsg) {
    super(errorMsg);
  }
}
