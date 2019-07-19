package com.plastech.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Strings;
import com.plastech.crm.model.vo.SaCommodityCustomerView;
import com.plastech.crm.model.vo.SaCommodityDetailView;
import com.plastech.crm.model.vo.SaGroupsCommodityOrManufacturerView;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;
import com.plastech.crm.resultcode.ResultCodeSaCommodityAnalysis;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;

/**
 * @author wangJin
 *
 * @date 2019年2月22日 上午10:14:23
 *
 */
@RestController
@RequestMapping("/sa-commodit-management")
public class SaCommodityAnalysisController extends BaseController {

  /**
   * 品类销售列表
   *
   * @param ctid
   * @param mfid
   * @param year
   * @return
   */
  @GetMapping("/commodity/analysis")
  public ResultJson<SalesAnalysisView> commoditysalesList(
      @RequestParam(required = false, value = "ctid") final Long ctid,
      @RequestParam(required = false, value = "mfid") final Long mfid,
      @RequestParam(required = false, value = "year") final Integer year) {
    final Map<String, Object> map = new HashMap<String, Object>();
    if (ctid != null && ctid.longValue() > 0) {
      map.put("ctid", ctid);
    }
    if (mfid != null && mfid.longValue() > 0) {
      map.put("mfid", mfid);
    }
    if (year == null || year.intValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaCommodityAnalysis.RESULT_CODE_9001200);
    }
    map.put("year", year);
    final SalesAnalysisView searchCommodityAnalysis =
        saCommodityAnalysisServer.commoditySalesList(map, year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0,
        searchCommodityAnalysis, ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/commodity/analysis/detail")
  public ResultJson<SaCommodityDetailView> commodityAnalysisDetail(
      @RequestParam(required = false, value = "ctid") final Long ctid,
      @RequestParam(required = false, value = "mfid") final Long mfid,
      @RequestParam(required = true, value = "year") final Integer year) {
    final Map<String, Object> map = new HashMap<String, Object>();
    if (ctid != null && ctid.longValue() > 0) {
      map.put("ctid", ctid);
    }
    if (mfid != null && mfid.longValue() > 0) {
      map.put("mfid", mfid);
    }
    if (year == null || year.intValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaCommodityAnalysis.RESULT_CODE_9002200);
    }
    map.put("year", year);
    final SaCommodityDetailView detail =
        saCommodityAnalysisServer.commodityAnalysisDetail(map, year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, detail,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/commodity/analysis/customer")
  public ResultJson<List<SaCommodityCustomerView>> getCommodityAnalysisCustomer(
      @RequestParam(required = false, value = "ctid") final Long ctid,
      @RequestParam(required = false, value = "mfid") final Long mfid,
      @RequestParam(required = false, value = "year") final Integer year,
      @RequestParam(required = false,
          value = "searchkey") final String searchkey) {
    final Map<String, Object> map = new HashMap<String, Object>();
    if (ctid != null && ctid.longValue() > 0) {
      map.put("ctid", ctid);
    }
    if (mfid != null && mfid.longValue() > 0) {
      map.put("mfid", mfid);
    }
    if (year == null || year.intValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaCommodityAnalysis.RESULT_CODE_9003200);
    }
    if (!Strings.isNullOrEmpty(searchkey)) {
      map.put("searchkey", "%" + searchkey + "%");
    }
    map.put("year", year);
    final List<SaCommodityCustomerView> list =
        saCommodityAnalysisServer.getCommodityAnalysisCustomer(map, year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/commodity/customer/statistics")
  public ResultJson<List<SalesAnalysisDataView>> getCommodityCustomerStatistics(
      @RequestParam(required = false, value = "ctid") final Long ctid,
      @RequestParam(required = false, value = "mfid") final Long mfid,
      @RequestParam(required = false, value = "year") final Integer year,
      @RequestParam(required = false, value = "cuName") final String cuName) {
    final Map<String, Object> map = new HashMap<String, Object>();
    if (ctid != null && ctid.longValue() > 0) {
      map.put("ctid", ctid);
    }
    if (mfid != null && mfid.longValue() > 0) {
      map.put("mfid", mfid);
    }
    if (year == null || year < 0) {
      return ResultUtil
          .getResult(ResultCodeSaCommodityAnalysis.RESULT_CODE_9004200);
    }
    if (Strings.isNullOrEmpty(cuName)) {
      return ResultUtil
          .getResult(ResultCodeSaCommodityAnalysis.RESULT_CODE_9004201);
    }
    map.put("year", year);
    map.put("cuName", cuName);
    final List<SalesAnalysisDataView> list =
        saCommodityAnalysisServer.getCommodityCustomerStatistics(map, year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/commodity")
  public ResultJson<List<SaGroupsCommodityOrManufacturerView>> getCommodity(
      @RequestParam(required = true, value = "year") final Integer year) {
    if (year == null || year.intValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaCommodityAnalysis.RESULT_CODE_9005200);
    }
    final List<SaGroupsCommodityOrManufacturerView> commodity =
        saCommodityAnalysisServer.getCommodity(year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, commodity,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/manufacturer")
  public ResultJson<List<SaGroupsCommodityOrManufacturerView>> getManufacturer(
      @RequestParam(required = true, value = "year") final Integer year) {

    if (year == null || year.intValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaCommodityAnalysis.RESULT_CODE_9006200);
    }
    final List<SaGroupsCommodityOrManufacturerView> commodity =
        saCommodityAnalysisServer.getManufacturer(year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, commodity,
        ResultCodeSystem.SELECT_SUCCESS);
  }
}
