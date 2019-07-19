package com.plastech.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Strings;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;
import com.plastech.crm.model.vo.SalesManagerAnalysisOfCustomerData;
import com.plastech.crm.model.vo.SalesManagerAnalysisYearStView;
import com.plastech.crm.model.vo.SingleSalesManagerAnalysisYearStView;
import com.plastech.crm.resultcode.ResultCodeSalesAnalysis16;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;

/**
 * BI分析-销售分析
 *
 * @author : yemin
 * @date : 2019年2月19日 下午2:24:49
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/sales-analysis-management")
public class SalesAnalysisController extends BaseController {

  /**
   * 根据年份，查询销售情况统计数据
   *
   * @param year
   * @return
   */
  @GetMapping("/sales-analysis/{year}")
  public ResultJson<SalesAnalysisView> selectSalesAnalysisData(
      @PathVariable(required = true, value = "year") final int year) {
    if (year < 1970 || year > 2100) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16001200);
    }
    final SalesAnalysisView sav =
        saSalesAnalysisService.selectSalesAnalysisByYear(year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, sav,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * 根据年份，查询销售经理的销售统计数据
   *
   * @return
   */
  @GetMapping("/salesmanager-analysis/{year}")
  public ResultJson<SalesManagerAnalysisYearStView> selectSalesManagerAnalysisByYear(
      @PathVariable(required = true, value = "year") final int year) {
    if (year < 1970 || year > 2100) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16002200);
    }
    final SalesManagerAnalysisYearStView smay =
        saManagerAnalysisService.selectSalesManagerAnalysisByYear(year);

    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, smay,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * 查询某个销售经理的销售统计数据（不含详情）
   *
   * @param year
   * @param uid
   * @return
   */
  @GetMapping("/salesmanager-analysis/{uid}/{year}")
  public ResultJson<SingleSalesManagerAnalysisYearStView> selectSingleSalesManagerAnalySisStatistics(
      @PathVariable(required = true, value = "year") final int year,
      @PathVariable(required = true, value = "uid") final Long uid) {
    final SingleSalesManagerAnalysisYearStView ssmays = saManagerAnalysisService
        .selectSingleSalesManagerAnalySisStatistics(year, uid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, ssmays,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * 查询某个销售经理某一年的销售统计数据详情
   *
   * @param year
   * @param uid
   * @return
   */
  @GetMapping("/salesmanager-analysis/{uid}/{year}/detail")
  public ResultJson<Object> selectSingleSalesManagerAnalySisDetail(
      @PathVariable(required = true, value = "year") final int year,
      @PathVariable(required = true, value = "uid") final Long uid) {
    if (year < 1970 || year > 2100) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16003200);
    }
    final List<SalesAnalysisDataView> savList = saManagerAnalysisService
        .selectSingleSalesManagerAnalySisDetailOfSaleTotal(year, uid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, savList,
        ResultCodeSystem.SELECT_SUCCESS);
  }
  /**
   * 查询某个销售经理某一年的购买客户数搜索接口
   *
   * @param year
   * @param uid
   * @return
   */
  @GetMapping("/salesmanager-analysis/customer/search")
  public ResultJson<List<SalesManagerAnalysisOfCustomerData>> searchCustomer(
      @RequestParam(required = true, value = "year") final int year,
      @RequestParam(required = true, value = "uid") final Long uid,
      @RequestParam(required = false,
          value = "searchkey") final String searchkey) {
    if (year < 1970 || year > 2100) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16007200);
    }
    // 客户搜索接口
    final List<SalesManagerAnalysisOfCustomerData> saCustomerDataList =
        saManagerAnalysisService.selectSalesManagerAnalysisOfCustomerData(year,
            uid, searchkey);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0,
        saCustomerDataList, ResultCodeSystem.SELECT_SUCCESS);
  }
  /**
   * 查询某个销售经理某一年的某个购买客户的12个月数据
   *
   * @param year
   * @param uid
   * @return
   */
  @GetMapping("/salesmanager-analysis/customer/purchases")
  public ResultJson<List<SalesAnalysisDataView>> selectSalseCustomerPurchases(
      @RequestParam(required = false, value = "gid") final Long gid,
      @RequestParam(required = false, value = "year") final Integer year,
      @RequestParam(required = false, value = "uid") final Long uid) {
    if (gid == null || gid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16004200);
    }
    if (uid == null || uid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16004201);
    }
    if (year == null || year.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16004202);
    }
    final List<SalesAnalysisDataView> list =
        saManagerAnalysisService.selectSalseCustomerPurchases(gid, year, uid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }
  /**
   * 查询某个销售经理某一年的购品类搜索接口
   *
   * @param year
   * @param uid
   * @return
   */
  @GetMapping("/salesmanager-analysis/search/commodity")
  public ResultJson<List<SalesManagerAnalysisOfCustomerData>> searchSalseCommodity(
      @RequestParam(required = true, value = "uid") final Long uid,
      @RequestParam(required = true, value = "year") final Long year,
      @RequestParam(required = false,
          value = "searchkey") final String searchkey,
      @RequestParam(required = false, value = "type") final Integer type) {
    final Map<String, Object> map = new HashMap<>();
    if (uid == null || uid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16005200);
    }
    if (year == null || year.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16005201);
    }
    if (!Strings.isNullOrEmpty(searchkey)) {
      map.put("searchkey","%"+ searchkey+"%");
    }
    if (type != null && type.intValue() > 0 && type.intValue() <= 2) {
      map.put("type", type);
    }
    map.put("uid", uid);
    map.put("year", year);
    final List<SalesManagerAnalysisOfCustomerData> list =
        saManagerAnalysisService.searchSalseCommodity(map);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }
  /**
   *  查询某个销售经理某一年的购品类或生产商12个月接口
   * @param uid
   * @param ctid
   * @param mfid
   * @param year
   * @return
   */


  @GetMapping("/salesmanager-analysis/complete/list")
  public ResultJson<List<SalesAnalysisDataView>> completeCommodityDetailedMonthlyData(
      @RequestParam(required = true, value = "uid") final Long uid,
      @RequestParam(required = true, value = "ctid") final Long ctid,
      @RequestParam(required = true, value = "mfid") final Long mfid,
      @RequestParam(required = true, value = "year") final Integer year) {
    if (uid == null || uid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16006200);
    }
    if (ctid == null || ctid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16006201);
    }
    if (mfid == null || mfid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16006202);
    }
    if (year == null || year.intValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSalesAnalysis16.RESULT_CODE_16006203);
    }
    final List<SalesAnalysisDataView> list = saManagerAnalysisService
        .completeCommodityDetailedMonthlyData(uid, ctid, mfid, year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }
}
