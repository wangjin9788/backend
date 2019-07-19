package com.plastech.crm.exception;

/**
 *
 *
 * @author : yemin
 * @date : 2019年3月6日 下午3:20:33
 *
 */
public class AnalysisDataNotBeenInitializedException extends BaseException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public AnalysisDataNotBeenInitializedException() {
    super("正在初始化统计数据，请稍后重试");
  }

  public AnalysisDataNotBeenInitializedException(final String errorMsg) {
    super(errorMsg);
  }
}
