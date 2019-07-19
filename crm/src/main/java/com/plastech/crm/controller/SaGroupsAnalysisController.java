package com.plastech.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Strings;
import com.plastech.crm.model.vo.SaCommodityPurchaseDetail;
import com.plastech.crm.model.vo.SaGroupsCommodityOrManufacturerView;
import com.plastech.crm.model.vo.SaGroupsCommodityPercentageView;
import com.plastech.crm.model.vo.SaManufacturerTotalDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;
import com.plastech.crm.resultcode.ResultCodeSaGroups25;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;

/**
 * @author wangJin
 *
 * @date 2019年3月26日 下午2:11:24
 *
 */
@RestController
@RequestMapping("/sa-groups-management")
public class SaGroupsAnalysisController extends BaseController {

  @GetMapping("/sa-groups/statistics")
  public ResultJson<SalesAnalysisView> getSaGroupsStatisticsInfo(
      @RequestParam(required = true, value = "year") final Integer year,
      @RequestParam(required = true, value = "gid") final Long gid) {
    if (year == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25001200);
    }
    if (gid == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25001201);
    }
    return saGroupsAnalysisService.getSaGroupsStatisticsInfo(year, gid);
  }

  @GetMapping("/sa-groups/percentage")
  public ResultJson<List<SaGroupsCommodityPercentageView>> getCommodityPercentage(
      @RequestParam(required = false, value = "year") final Integer year,
      @RequestParam(required = false, value = "gid") final Long gid) {
    if (year == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25002200);
    }
    if (gid == null || gid.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25002201);
    }
    final List<SaGroupsCommodityPercentageView> list =
        saGroupsAnalysisService.getCommodityPercentage(year, gid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/sa-groups/commodity/purchase")
  public ResultJson<SalesAnalysisView> getCommodityPurchase(
      @RequestParam(required = false, value = "year") final Integer year,
      @RequestParam(required = false, value = "gid") final Long gid,
      @RequestParam(required = false, value = "ctid") final Long ctid,
      @RequestParam(required = false, value = "mfid") final Long mfid) {
    final Map<String, Object> map = new HashMap<>();
    if (year == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25003200);
    }
    if (gid == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25003201);
    }
    if (ctid == null || ctid.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25003202);
    }
    if (mfid != null && mfid.longValue() >= 1) {
      map.put("mfid", mfid);
    }
    map.put("year", year);
    map.put("ctid", ctid);
    map.put("gid", gid);

    final SalesAnalysisView view =
        saCommodityPurchaseService.getSaCommodityPurchaseStatistics(map, year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, view,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * 详情页面总参数
   *
   * @param year
   * @param gid
   * @param ctid
   * @param mfid
   * @return
   */
  @GetMapping("/sa-groups/commodity/detail")
  public ResultJson<SaManufacturerTotalDataView> getSaCommodityPurchaseDetailTotal(
      @RequestParam(required = true, value = "year") final Integer year,
      @RequestParam(required = true, value = "gid") final Long gid,
      @RequestParam(required = true, value = "ctid") final Long ctid,
      @RequestParam(required = false, value = "mfid") final Long mfid) {
    final Map<String, Object> map = new HashMap<>();
    if (year == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25004200);
    }
    if (gid == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25004201);
    }
    if (ctid == null || ctid.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25004202);
    }
    if (mfid != null && mfid.longValue() > 0) {
      map.put("mfid", mfid);
    }
    map.put("year", year);
    map.put("ctid", ctid);
    map.put("gid", gid);
    final SaManufacturerTotalDataView total =
        saCommodityPurchaseService.getSaCommodityPurchaseDetailTotal(map);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, total,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * 详情页面搜索接口
   *
   * @param year
   * @param gid
   * @param ctid
   * @param mfid
   * @return
   */
  @GetMapping("/sa-groups/customer/search")
  public ResultJson<List<SaCommodityPurchaseDetail>> searchCommodityPurchaseDetailCustomer(
      @RequestParam(required = true, value = "year") final Integer year,
      @RequestParam(required = true, value = "gid") final Long gid,
      @RequestParam(required = true, value = "ctid") final Long ctid,
      @RequestParam(required = false, value = "mfid") final Long mfid,
      @RequestParam(required = false, value = "name") final String name) {
    final Map<String, Object> map = new HashMap<>();
    if (year == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25005200);
    }
    if (gid == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25005201);
    }
    if (ctid == null || ctid.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25005202);
    }
    if (mfid != null && mfid.longValue() > 0) {
      map.put("mfid", mfid);
    }
    if (!Strings.isNullOrEmpty(name)) {
      map.put("name", name);
    }
    map.put("year", year);
    map.put("ctid", ctid);
    map.put("gid", gid);
    final List<SaCommodityPurchaseDetail> list =
        saCommodityPurchaseService.searchCommodityPurchaseDetailCustomer(map);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * 拉取统计列表
   *
   * @param year
   * @param gid
   * @param ctid
   * @param mfid
   * @param cuid
   * @return
   */
  @GetMapping("/sa-groups/customer/statistics")
  public ResultJson<SalesAnalysisView> getCustomerStatistics(
      @RequestParam(required = true, value = "year") final Integer year,
      @RequestParam(required = true, value = "gid") final Long gid,
      @RequestParam(required = true, value = "ctid") final Long ctid,
      @RequestParam(required = false, value = "mfid") final Long mfid,
      @RequestParam(required = true, value = "cuid") final Long cuid) {
    final Map<String, Object> map = new HashMap<>();
    if (year == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25006200);
    }
    if (gid == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_26006201);
    }
    if (ctid == null || ctid.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_26006202);
    }
    if (cuid == null || cuid.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_26006203);
    }
    if (mfid != null && mfid.longValue() > 0) {
      map.put("mfid", mfid);
    }
    map.put("year", year);
    map.put("ctid", ctid);
    map.put("gid", gid);
    map.put("cuid", cuid);
    final SalesAnalysisView view =
        saCustomerDetailAnalysisService.getCustomerStatistics(map, year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, view,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/sa-groups/commodity")
  public ResultJson<List<SaGroupsCommodityOrManufacturerView>> getCommodity(
      @RequestParam(required = true, value = "year") final Integer year,
      @RequestParam(required = true, value = "gid") final Long gid) {
    if (year == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25007200);
    }
    if (gid == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_26007201);
    }
    final List<SaGroupsCommodityOrManufacturerView> commodity =
        saGroupsAnalysisService.getCommodity(year, gid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, commodity,
        ResultCodeSystem.SAVE_SUCCESS);
  }

  @GetMapping("/sa-groups/manufacturer")
  public ResultJson<List<SaGroupsCommodityOrManufacturerView>> getManufacturer(
      @RequestParam(required = true, value = "year") final Integer year,
      @RequestParam(required = true, value = "gid") final Long gid) {
    if (year == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_25008200);
    }
    if (gid == null || year.intValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSaGroups25.RESULT_CODE_26008201);
    }
    final List<SaGroupsCommodityOrManufacturerView> commodity =
        saGroupsAnalysisService.getManufacturer(year, gid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, commodity,
        ResultCodeSystem.SAVE_SUCCESS);
  }

}
