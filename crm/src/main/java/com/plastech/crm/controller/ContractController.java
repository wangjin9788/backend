package com.plastech.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Strings;
import com.plastech.crm.exception.ContractException;
import com.plastech.crm.model.Grade;
import com.plastech.crm.model.User;
import com.plastech.crm.model.parameter.AddOrUpdateContractGradeParameters;
import com.plastech.crm.model.parameter.AddOrUpdateContractParameters;
import com.plastech.crm.model.vo.ContractBaseDetailView;
import com.plastech.crm.model.vo.ContractDetailView;
import com.plastech.crm.model.vo.ContractListView;
import com.plastech.crm.model.vo.SalesManagerView;
import com.plastech.crm.resultcode.ResultCodeContract;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author wangJin
 *
 * @date 2019年1月24日 上午10:42:55
 *
 */
@RestController
@RequestMapping("/contract-management")
public class ContractController extends BaseController {

  private final Logger log = LoggerFactory.getLogger(ContractController.class);

  @GetMapping("/contract/search")
  public ResultJson<AppPageModel<List<ContractListView>>> searchContractList(
      @RequestParam(required = false,
          value = "currentpage") final Integer currentpage,
      @RequestParam(required = false, value = "perpage") final Integer perpage,
      @RequestParam(required = false, value = "suid") final Long suid,
      @RequestParam(required = false,
          value = "searchKey") final String searchKey,
      @RequestParam(required = false,
          value = "startShipmtDate") final String startShipmtDate,
      @RequestParam(required = false,
          value = "endShipmtDate") final String endShipmtDate) {
    final Map<String, Object> map = new HashMap<>();
    if (!Strings.isNullOrEmpty(searchKey)) {
      map.put("searchKey", "%" + searchKey + "%");
    }
    if (!Strings.isNullOrEmpty(startShipmtDate)) {
      map.put("startShipmtDate", startShipmtDate);
    }
    if (!Strings.isNullOrEmpty(endShipmtDate)) {
      map.put("endShipmtDate", endShipmtDate);
    }
    if (suid != null) {
      map.put("suid", suid);
    }
    final AppPageModel<List<ContractListView>> searchContractList =
        contractService.searchContractList(map, currentpage, perpage);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0,
        searchContractList, ResultCodeSystem.SELECT_SUCCESS);
  }

  @PostMapping("/contract")
  public ResultJson<Long> addContract(
      @RequestBody final AddOrUpdateContractParameters param,
      final HttpServletRequest request) throws ContractException {
    if (Strings.isNullOrEmpty(param.getNumber())) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8001200);
    }
    if (param.getCuid() == null || param.getCuid() <= 0) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8001201);
    }
    if (param.getUid() == null || param.getUid() <= 0) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8001202);
    }

    if (param.getContractList() != null || !param.getContractList().isEmpty()) {
      final Integer checkCommodity =
          checkAddCommodityList(param.getContractList());
      if (checkCommodity > 0) {
        return ResultUtil.getResult(checkCommodity);
      }
    } else {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8001207);
    }
    final Long uid = getCurrentUid(request);

    final ResultJson<Long> isCreate = contractService.addContract(param, uid);
    if (isCreate.getResultCode() == 0) {
      OperatingContractSynchronizationData(param, null);

      final User user = getCurrentUser(request);
      log.info(
          "操作模块：{}，操作人：{}  ,操作内容：{}, 合同原始数据：{}, 合同新数据：{} ,合同ID:{} ===============。",
          "合同模块", user.getUid() + "-----" + user.getUname(), "Add(新增)", "",
          param, isCreate);
    }
    return isCreate;
  }

  private Integer checkAddCommodityList(
      final List<AddOrUpdateContractGradeParameters> gradeList) {
    String currencyType = null;
    for (final AddOrUpdateContractGradeParameters contractGradeInfo : gradeList) {
      if (contractGradeInfo.getGeid() == null
          || contractGradeInfo.getGeid() <= 0) {
        return ResultCodeContract.RESULT_CODE_8001204;
      }
      if (contractGradeInfo.getCgSalesVolume() == null) {
        return ResultCodeContract.RESULT_CODE_8001205;
      }
      if (contractGradeInfo.getCgSalesUnitPrice() == null) {
        return ResultCodeContract.RESULT_CODE_8001206;
      }
      // 校验清单货币类型
      if (currencyType != null
          && !currencyType.equals(contractGradeInfo.getCgCurrencyType())) {
        return ResultCodeContract.RESULT_CODE_8002302;
      }
      currencyType = contractGradeInfo.getCgCurrencyType();
    }
    return 0;
  }

  @GetMapping("/contract/salse/managers")
  public ResultJson<List<SalesManagerView>> getSalseManagersList() {
    final List<SalesManagerView> list = contractService.getSalseManagersList();
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @PutMapping("/contract/{coid}")
  @Transactional
  public ResultJson<Boolean> updateController(
      @PathVariable(value = "coid") final Long coid,
      @RequestBody final AddOrUpdateContractParameters param,
      final HttpServletRequest request) throws ContractException {
    final Boolean isImport = contractService.getImportDetailStatus();
    if (isImport) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8007300);
    }
    if (coid == null || coid <= 0) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8002207);
    }
    if (Strings.isNullOrEmpty(param.getNumber())) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8002200);
    }
    if (param.getCuid() == null || param.getCuid() <= 0) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8002201);
    }
    if (param.getUid() == null || param.getUid() <= 0) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8002202);
    }

    if (param.getContractList() != null || !param.getContractList().isEmpty()) {
      final Integer checkCommodity =
          checkUpdateCommodityList(param.getContractList());
      if (checkCommodity > 0) {
        return ResultUtil.getResult(checkCommodity);
      }
    } else {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8002208);
    }
    // 同步数据获取旧数据
    final AddOrUpdateContractParameters usedParam =
        contractService.getContractInfoByCoid(coid);
    final Long uid = getCurrentUid(request);
    // 更新数据
    final ResultJson<Boolean> isUpdate =
        contractService.updateContract(coid, param, uid);
    if (isUpdate.getResultCode() == 0) {
      OperatingContractSynchronizationData(usedParam, param);
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{}, 合同原始数据：{}, 合同新数据：{} ===============。",
          "合同模块", user.getUid() + "---------" + user.getUname(), "Update(編輯)",
          usedParam, param);
    }
    return isUpdate;
  }

  private Integer checkUpdateCommodityList(
      final List<AddOrUpdateContractGradeParameters> gradeList) {
    String currencyType = null;
    for (final AddOrUpdateContractGradeParameters contractGradeInfo : gradeList) {
      if (contractGradeInfo.getGeid() == null
          || contractGradeInfo.getGeid() <= 0) {
        return ResultCodeContract.RESULT_CODE_8002204;
      }
      if (contractGradeInfo.getCgSalesVolume() == null) {
        return ResultCodeContract.RESULT_CODE_8002205;
      }
      if (contractGradeInfo.getCgSalesUnitPrice() == null) {
        return ResultCodeContract.RESULT_CODE_8002206;
      }
      // 校验清单货币类型
      if (currencyType != null
          && !currencyType.equals(contractGradeInfo.getCgCurrencyType())) {
        return ResultCodeContract.RESULT_CODE_8002302;
      }
      currencyType = contractGradeInfo.getCgCurrencyType();
    }
    return 0;
  }

  @GetMapping("/contract/expanding")
  public ResultJson<ContractDetailView> expandingContractList(
      @RequestParam(required = false, value = "cgid") final Long cgid) {
    if (cgid == null || cgid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8004200);
    }
    final ContractDetailView expandingInfo =
        contractService.expandingContractListByCgId(cgid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, expandingInfo,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/contract/base/detail")
  public ResultJson<ContractBaseDetailView> getContractBaseDetail(
      @RequestParam(required = false, value = "coid") final Long coid) {
    if (coid == null || coid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8005200);
    }
    final ContractBaseDetailView contractBaseDetail =
        contractService.getContractBaseDetail(coid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0,
        contractBaseDetail, ResultCodeSystem.SELECT_SUCCESS);
  }

  @DeleteMapping("/contract/{coid}")
  public ResultJson<Boolean> deleteContract(
      @PathVariable(required = false, value = "coid") final Long coid,
      final HttpServletRequest request) {
    final Boolean isImport = contractService.getImportDetailStatus();
    if (isImport) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8007300);
    }
    if (coid == null || coid <= 0) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8006200);
    }
    // 同步数据获取旧数据
    final AddOrUpdateContractParameters usedParam =
        contractService.getContractInfoByCoid(coid);
    final ResultJson<Boolean> isDelete = contractService.deleteContract(coid);
    if (isDelete.getResultCode() == 0) {
      OperatingContractSynchronizationData(usedParam, null);
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{}, 合同原始数据：{}, 合同新数据：{} ===============。",
          "合同模块", user.getUid() + "---------" + user.getUname(), "Delete(刪除)",
          usedParam, "");
    }
    return isDelete;
  }

  public void OperatingContractSynchronizationData(
      final AddOrUpdateContractParameters usedParam,
      final AddOrUpdateContractParameters newParam) {
    // 创建一个list把所有的年月记录
    for (int i = 0; i < 2; i++) {
      if (i == 0 && usedParam != null) {
        synchronousContractData(usedParam);
      } else if (i == 1 && newParam != null) {
        synchronousContractData(newParam);
      }
    }
  }

  private void synchronousContractData(
      final AddOrUpdateContractParameters usedParam) {
    for (final AddOrUpdateContractGradeParameters uParam : usedParam
        .getContractList()) {
      final Grade grade = gradeService.getCtidAndMfidByGeid(uParam.getGeid());
      final String uYearStr = uParam.getCgShipmtDate().substring(0, 4);
      final String uMonthStr = uParam.getCgShipmtDate().substring(5, 7);
      final Integer year = Integer.parseInt(uYearStr);
      final Integer month = Integer.parseInt(uMonthStr);
      // 初始化銷售分析-销售情况(月)
      saSalesAnalysisService.generateSalesAnalysisForMonth(year, month);
      // 初始化銷售分析-销售情况(年)
      saSalesAnalysisService.generateSalesAnalysisForYear(year);
      // 初始化銷售情況-销售经理(月)
      saManagerAnalysisService.generateSalesManagerAnalysisForMonth(year, month,
          usedParam.getUid());
      // 初始化銷售情況-销售经理(年)
      saManagerAnalysisService.generateSalesManagerAnalysisForMonth(year, 13,
          usedParam.getUid());
      // 初始化銷售情況-熱門品類銷售情况(月)
      saCommodityAnalysisServer.generateSalesCommodityAnalysisForMonth(year,
          month, grade.getCtid(), grade.getMfid());
      // 初始化銷售情況-熱門品類銷售情况(年)
      saCommodityAnalysisServer.generateSalesCommodityAnalysisForMonth(year, 13,
          grade.getCtid(), grade.getMfid());
      // 初始化銷售情況-熱門品類銷售情况-详情(月)
      saCommodityAnalysisServer.generateSalesCommodityDetailAnalysisForMonth(
          year, month, grade.getCtid(), grade.getMfid(), usedParam.getGid());
      // 初始化銷售情況-熱門品類銷售情况-详情(年)
      saCommodityAnalysisServer.generateSalesCommodityDetailAnalysisForMonth(
          year, 13, grade.getCtid(), grade.getMfid(), usedParam.getGid());
      // 初始化生產商分析-銷售情況(月)
      saManufacturerAnalysisService.generateSalesAnalysisForMonth(year, month,
          grade.getMfid());
      // 初始化生產商分析-銷售情況(年）
      saManufacturerAnalysisService.generateSalesAnalysisForMonth(year, 13,
          grade.getMfid());
      // 初始化生產商分析-客戶購買情況(月)
      saManufacturerAnalysisService.generateSalesManufacturerAnalysisForMonth(
          year, month, usedParam.getGid(), grade.getMfid());
      // 初始化生產商分析-客戶購買情況(年）
      saManufacturerAnalysisService.generateSalesManufacturerAnalysisForMonth(
          year, 13, usedParam.getGid(), grade.getMfid());
      // 初始化生產商分析-客戶購買情況-详情(月)
      saManufacturerAnalysisService
          .generateSalesManufacturerDetailAnalysisForMonth(year, month,
              grade.getCtid(), grade.getMfid(), usedParam.getGid());
      // 初始化生產商分析-客戶購買情況-详情(年)
      saManufacturerAnalysisService
          .generateSalesManufacturerDetailAnalysisForMonth(year, 13,
              grade.getCtid(), grade.getMfid(), usedParam.getGid());
      // 客戶分析-年度購買情況（月）
      saGroupsAnalysisService.generateSaGroupsAnalysisForMonth(year, month,
          usedParam.getGid());
      // 客户分析-年度購買情況（年）
      saGroupsAnalysisService.generateSaGroupsAnalysisForMonth(year, 13,
          usedParam.getGid());
      // 客戶分析-品類購買情況(月)
      saCommodityPurchaseService.generateSaCommodityPurchaseForMonth(year,
          month, grade.getCtid(), grade.getMfid(), usedParam.getGid());
      // 客戶分析-品類購買情況(年)
      saCommodityPurchaseService.generateSaCommodityPurchaseForMonth(year, 13,
          grade.getCtid(), grade.getMfid(), usedParam.getGid());
      // 客戶分析-品類購買情況-详情（月）
      saCustomerDetailAnalysisService.generateSaCustomerDetailForMonth(year,
          month, grade.getCtid(), grade.getMfid(), usedParam.getGid(),
          usedParam.getCuid());
      // 客戶分析-品類購買情況-详情（年）
      saCustomerDetailAnalysisService.generateSaCustomerDetailForMonth(year, 13,
          grade.getCtid(), grade.getMfid(), usedParam.getGid(),
          usedParam.getCuid());
    }
  }
}
