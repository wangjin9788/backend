package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.SaSalesManager;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesManagerAnalysisOfCustomerData;
import com.plastech.crm.model.vo.SalesManagerAnalysisYearStData;

public interface SaSalesManagerMapper extends BaseTkMapper<SaSalesManager> {

  /**
   * 查询一整年的销售经理销售统计数据，以及与上一年的环比信息
   *
   * @param year
   * @param month
   * @return
   */
  List<SalesManagerAnalysisYearStData> selectSalesManagerAnalysisDataByYearAndMonthWithPreviousData(
      @Param("year") String year, @Param("month") String month,
      @Param("pre_year") String previousYear);

  /**
   * 根据合同信息，得到销售经理的某个月的销售业绩统计
   *
   * @param year
   * @param monthStr
   * @param month
   * @return
   */
  List<SaSalesManager> getManagerSalesAnalysisFromContractData(
      @Param("year_month") String yearMonth, @Param("year") String year,
      @Param("month") String monthStr,@Param("uid")Long uid);

  /**
   * 根据合同信息，得到销售经理的一整年的销售业绩统计
   *
   * @param year
   * @param monthStr
   * @param month
   * @return
   */
  List<SaSalesManager> getManagerSalesAnalysisFromContractDataForYear(
      @Param("year") String year,@Param("uid") Long uid);

  SaSalesManager selectByUidAndYearAndMonth(@Param("uid") Long uid,
      @Param("year") String year, @Param("month") String month);

  SaSalesManager selectAnyOne();

  /**
   * 某个销售经理，一整年的销售业绩统计，以及与上一年的同比信息
   *
   * @param uid
   * @param year
   * @return
   */
  List<SalesAnalysisDataView> selectSingleSalesManagerAnalySisDetailOfSaleTotal(
      @Param("uid") Long uid, @Param("year") String year);

  /**
   * 查询单个销售经理某一年下有业务关联的客户信息及客户购买情况
   *
   * @param uid
   * @param year
   * @return
   */
  List<SalesManagerAnalysisOfCustomerData> selectSingleSalesManagerAnalysisOfCustomerData(
      @Param("uid") Long uid, @Param("year") String year,
      @Param("searchKey") String searchKey);

  /**
   * 购买客户数12个月数据
   *
   * @param gid
   * @param uid
   * @param year
   * @return
   */
  List<SalesAnalysisDataView> selectSalseCustomerPurchases(
      @Param("gid") Long gid, @Param("uid") Long uid,
      @Param("year") String year);

  /**
   * 销售经理销售品类搜索列表
   *
   * @param map
   * @return
   */
  List<SalesManagerAnalysisOfCustomerData> searchSalseCommodityName(
      Map<String, Object> map);

  /**
   * 查询销售经理中品类或生产商查询十二个月数据
   *
   * @return
   */
  List<SalesAnalysisDataView> completeCommodityDetailedMonthlyData(
      @Param("uid") Long uid, @Param("ctid") Long ctid,
      @Param("mfid") Long mfid, @Param("year") String year);

  void deleteSaSalesManagerByYearAndMonth(@Param("month") String month,
      @Param("year") String year,@Param("uid") Long uid);

  void deleteSaSalesManagerInexistenceData(@Param("month") String month,
      @Param("year") String year, @Param("list") List<Long> list);

}
