package com.plastech.crm.service;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesManagerAnalysisOfCustomerData;
import com.plastech.crm.model.vo.SalesManagerAnalysisYearStView;
import com.plastech.crm.model.vo.SingleSalesManagerAnalysisYearStView;

/**
 *
 *
 * @author : yemin
 * @date : 2019年2月25日 下午3:08:10
 *
 */
public interface SaManagerAnalysisService {

  /**
   * 查询某一年和上一年的销售经理销售统计同比信息（含每个销售经理的销售统计数据列表）
   *
   * @param year
   * @return
   */
  SalesManagerAnalysisYearStView selectSalesManagerAnalysisByYear(int year);

  /**
   * 生成某个月的销售经理销售统计数据
   *
   * @param year
   * @param month
   * @return
   */
  boolean generateSalesManagerAnalysisForMonth(int year, int month,Long uid);

  /**
   * 查询单个销售经理的销售统计数据（不含详情）
   *
   * @param year
   * @param uid
   * @return
   */
  SingleSalesManagerAnalysisYearStView selectSingleSalesManagerAnalySisStatistics(
      int year, Long uid);

  /**
   * 查询单个销售经理的销售统计数据详情——销售总量详情
   *
   * @param year
   * @param uid
   * @return
   */
  List<SalesAnalysisDataView> selectSingleSalesManagerAnalySisDetailOfSaleTotal(
      int year, Long uid);

  /**
   * 查询单个销售经理某一年下有业务关联的客户信息及
   *
   * @param year
   * @param uid
   * @return
   */
  List<SalesManagerAnalysisOfCustomerData> selectSalesManagerAnalysisOfCustomerData(
      int year, Long uid, String searchkey);

  /**
   * 查询单个销售经理某一年下有业务关联的客户购买情况
   *
   * @param gid
   * @param year
   * @return
   */

  List<SalesAnalysisDataView> selectSalseCustomerPurchases(
      @PathVariable(required = false, value = "gid") final Long gid,
      @PathVariable(required = false, value = "year") final Integer year,
      final Long uid);

  /**
   * 搜索销售品类
   *
   * @param map
   * @return
   */
  List<SalesManagerAnalysisOfCustomerData> searchSalseCommodity(
      Map<String, Object> map);

  /**
   * 查询销售经理中品类或生产商查询十二个月数据
   *
   * @return
   */
  List<SalesAnalysisDataView> completeCommodityDetailedMonthlyData(Long uid,
      Long ctid, Long mfid, Integer year);
  /**
   * 初始化销售经理
   * @return
   */
  boolean initAllSalesManagerAnalysisData();

}
