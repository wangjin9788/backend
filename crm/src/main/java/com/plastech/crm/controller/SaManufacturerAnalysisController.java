package com.plastech.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Strings;
import com.plastech.crm.model.vo.SaCustomerPurchaseDetailsView;
import com.plastech.crm.model.vo.SaManufacturerCommodityView;
import com.plastech.crm.model.vo.SaManufacturerLoyaltyView;
import com.plastech.crm.model.vo.SaManufacturerTotalDataView;
import com.plastech.crm.model.vo.SalesAnalysisDataView;
import com.plastech.crm.model.vo.SalesAnalysisView;
import com.plastech.crm.resultcode.ResultCodeSaManufacturer12;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;

/**
 * @author wangJin
 *
 * @date 2019年2月28日 下午1:18:04
 *
 */
@RestController
@RequestMapping("/sa-manufacturer-management")
public class SaManufacturerAnalysisController extends BaseController {

  /**
   * 生产商年销售统计
   *
   * @param mfid
   * @param year
   * @return
   */

  @GetMapping("/sa-manufacturer/list")
  public ResultJson<SalesAnalysisView> getSaManufacturerList(
      @RequestParam(required = true, value = "mfid") final Long mfid,
      @RequestParam(required = false, value = "year") final Integer year) {
    final Map<String, Object> map = new HashMap<String, Object>();
    if (mfid != null) {
      map.put("mfid", mfid);
    }
    if (year == null || year.intValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12001200);
    }
    map.put("year", year);

    final SalesAnalysisView list =
        saManufacturerAnalysisService.getSaManufacturerList(map, year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * 客户购买情况
   *
   * @param lid
   * @param gid
   * @param mfid
   * @param year
   * @return
   */

  @GetMapping("/sa-manufacturer/purchase")
  public ResultJson<List<SaCustomerPurchaseDetailsView>> getCustomerPurchaseInformation(
      @RequestParam(required = false, value = "lid") final Long lid,
      @RequestParam(required = false, value = "gid") final Long gid,
      @RequestParam(required = false, value = "mfid") final Long mfid,
      @RequestParam(required = false, value = "year") final Integer year) {
    final Map<String, Object> map = new HashMap<String, Object>();
    if (lid != null && lid>0) {
      map.put("lid", lid);
    }
    if (gid != null && gid.longValue() > 0) {
      map.put("gid", gid);
    }
    if (mfid == null || mfid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12002200);
    }
    if (year == null || year.intValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12002201);
    }
    map.put("mfid", mfid);
    map.put("year", year);
    final List<SaCustomerPurchaseDetailsView> list =
        saManufacturerAnalysisService.getCustomerPurchaseInformation(map, year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * 查询生产商detail没有就insert
   *
   * @param gid
   * @param mfid
   * @param year
   * @param ctid
   * @return
   */
  @GetMapping("/sa-manufacturer/commodity/list")
  public ResultJson<List<SaManufacturerCommodityView>> getManufacturerCommodityList(
      @RequestParam(required = false, value = "gid") final Long gid,
      @RequestParam(required = false, value = "mfid") final Long mfid,
      @RequestParam(required = false, value = "year") final Integer year,
      @RequestParam(required = false, value = "name") final String name) {
    if (gid == null || gid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12003202);
    }
    if (mfid == null || mfid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12003200);
    }
    if (year == null || year.intValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12003201);
    }
    final List<SaManufacturerCommodityView> list = saManufacturerAnalysisService
        .getManufacturerCommodityList(gid, mfid, year, name);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/sa-manufacturer/acquire/loyalty")
  public ResultJson<List<SaManufacturerLoyaltyView>> getAcquireLoyaltyList(
      @RequestParam(required = false, value = "year") final String year,
      @RequestParam(required = false, value = "gid") final Long gid,
      @RequestParam(required = false, value = "mfid") final Long mfid) {
    if (gid == null || gid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12004201);
    }
    if (Strings.isNullOrEmpty(year)) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12004200);
    }
    if(mfid==null || mfid.longValue()<=0){
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12004204);
    }
    final List<SaManufacturerLoyaltyView> list =
        saManufacturerAnalysisService.getAcquireLoyaltyList(year, gid,mfid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }
/**
 * 获取详情页面参数
 * @param gid
 * @param mfid
 * @param year
 * @param lid
 * @return
 */
  @GetMapping("/sa-manufacturer/salse/info")
  public ResultJson<SaManufacturerTotalDataView> obtainManufacturerRelatedParameters(
      @RequestParam(required = false, value = "gid") final Long gid,
      @RequestParam(required = false, value = "mfid") final Long mfid,
      @RequestParam(required = false, value = "year") final String year,
      @RequestParam(required = false, value = "lid") final Long lid) {
    if (gid == null || gid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12007201);
    }
    if (mfid == null || mfid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12007201);
    }
    if (lid == null || lid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12007202);
    }
    if (Strings.isNullOrEmpty(year)) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12007200);
    }
    final SaManufacturerTotalDataView view = saManufacturerAnalysisService
        .obtainManufacturerRelatedParameters(gid, mfid, year, lid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, view,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/sa-manufacturer/statistics/list")
  public ResultJson<List<SalesAnalysisDataView>> getCommodityAnalysisStatisticsList(
      @RequestParam(required = false, value = "gid") final Long gid,
      @RequestParam(required = false, value = "mfid") final Long mfid,
      @RequestParam(required = true, value = "year") final Integer year,
      @RequestParam(required = false, value = "ctid") final Long ctid) {
    if (gid == null || gid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12005201);
    }
    if (mfid == null || mfid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12005200);
    }
    if (year == null || year <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12005202);
    }
    final List<SalesAnalysisDataView> list = saManufacturerAnalysisService
        .getCommodityAnalysisStatisticsList(gid, mfid, year, ctid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/sa-manufacturer/groups/list")
  public ResultJson<List<SaManufacturerLoyaltyView>> getManufacturersRelatedGroups(
      @RequestParam(required = false, value = "mfid") final Long mfid,
      @RequestParam(required = false, value = "year") final String year) {
    if (mfid == null || mfid.longValue() <= 0) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12006200);
    }
    if (Strings.isNullOrEmpty(year)) {
      return ResultUtil
          .getResult(ResultCodeSaManufacturer12.RESULT_CODE_12006202);
    }
    final List<SaManufacturerLoyaltyView> list =
        saManufacturerAnalysisService.getManufacturersRelatedGroups(mfid, year);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }

}
