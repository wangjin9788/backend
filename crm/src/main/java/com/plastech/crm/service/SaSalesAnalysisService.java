package com.plastech.crm.service;

import com.plastech.crm.model.vo.SalesAnalysisView;

/**
 *
 *
 * @author : yemin
 * @date : 2019年2月19日 下午3:09:37
 *
 */
public interface SaSalesAnalysisService {

  /**
   * 生成某个月的销售统计数据
   *
   * @param year
   * @param month
   * @return
   */
  boolean generateSalesAnalysisForMonth(int year, int month);

  /**
   * 异步初始化销售统计数据
   *
   * @return
   */
  boolean initSalesAnalysisAsync();

  /**
   * 同步初始化销售统计数据
   *
   * @return
   */
  boolean initSalesAnalysis();

  /**
   * 查询某一年和上一年的销售统计同比信息
   *
   * @param year
   * @return
   */
  SalesAnalysisView selectSalesAnalysisByYear(int year);

  /**
   * 生成某年的销售统计数据（不含单月）
   *
   * @param string
   * @return
   */
  boolean generateSalesAnalysisForYear(int year);

}
