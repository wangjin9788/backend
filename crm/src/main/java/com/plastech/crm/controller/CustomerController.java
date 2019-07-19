package com.plastech.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
import com.plastech.crm.model.parameter.AddOrUpdateCustomerParameters;
import com.plastech.crm.model.parameter.AddOrUpdateLinkmanParameter;
import com.plastech.crm.model.vo.ContractCustomerView;
import com.plastech.crm.model.vo.CustomerBaseDetailView;
import com.plastech.crm.model.vo.CustomerView;
import com.plastech.crm.resultcode.ResultCodeCustomer;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.util.AppPage;
import com.plastech.crm.util.CommonTools;

/**
 * @author wangJin
 *
 * @date 2019年1月23日 下午3:29:48
 *
 */
@RestController
@RequestMapping("/customer-management")
public class CustomerController extends BaseController {

  @GetMapping("/customer/search")
  public ResultJson<AppPage<List<CustomerView>>> searchCustomerList(
      @RequestParam(required = false,
          value = "searchkey") final String searchkey,
      @RequestParam(required = false,
          value = "currentpage") final Integer currentpage,
      @RequestParam(required = false,
          value = "perpage") final Integer perpage) {
    final Map<String, String> param = new HashMap<>();
    if (!Strings.isNullOrEmpty(searchkey)) {
      param.put("searchkey", "%" + searchkey + "%");
    }

    final AppPage<List<CustomerView>> page =
        customerService.searchCustomerList(param, currentpage, perpage);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, page,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @PostMapping("/customer")
  public ResultJson<Boolean> addCustomer(
      @RequestBody final AddOrUpdateCustomerParameters param,
      final HttpServletRequest request) {

    if (Strings.isNullOrEmpty(param.getCuName())) {
      return ResultUtil.getResult(ResultCodeCustomer.RESULT_CODE_7001200);
    }
    if (param.getGid() == null || param.getGid().longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeCustomer.RESULT_CODE_7001201);
    }
    if (param.getLinkmanList() != null && !param.getLinkmanList().isEmpty()) {
      final Integer isPresence = checkAddLinkmanList(param.getLinkmanList());
      if (isPresence > 0) {
        return ResultUtil.getResult(isPresence);
      }
    }
    final Long uid = getCurrentUid(request);
    return customerService.addCustomer(param, uid);
  }

  @PutMapping("/customer/{cuid}")
  public ResultJson<Boolean> updateCustomer(
      @PathVariable(value = "cuid") final Long cuid,
      @RequestBody final AddOrUpdateCustomerParameters param,
      final HttpServletRequest request) {

    if (cuid == null || cuid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeCustomer.RESULT_CODE_7002202);
    }
    if (Strings.isNullOrEmpty(param.getCuName())) {
      return ResultUtil.getResult(ResultCodeCustomer.RESULT_CODE_7002200);
    }
    if (param.getGid() == null || param.getGid().longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeCustomer.RESULT_CODE_7002201);
    }
    if (param.getLinkmanList() != null && !param.getLinkmanList().isEmpty()) {
      final Integer isPresence = checkUpdateLinkmanList(param.getLinkmanList());
      if (isPresence > 0) {
        return ResultUtil.getResult(ResultCodeCustomer.RESULT_CODE_7002203);
      }
    }
    final Long uid = getCurrentUid(request);
    final Map<String, String> updateCustomer =
        customerService.updateCustomer(cuid, param, uid);
    if (updateCustomer != null && !updateCustomer.isEmpty()) {
      if (!Strings.isNullOrEmpty(updateCustomer.get("code"))) {
        return ResultUtil.getResult(ResultCodeCustomer.RESULT_CODE_7002302);
      }
//      if (!Strings.isNullOrEmpty(updateCustomer.get("shipmt_e"))
//          && !Strings.isNullOrEmpty(updateCustomer.get("shipmt_l"))) {
//        //防止多次初始化
//        final OperatingMethod methodStatus =
//            operatingMethodService.getSaMethodStatus("update_Customer");
//        if
//        CommonThreadPool.addTaskToSingleQueue(
//            new StatisticalCustomerDataAnalysis(updateCustomer.get("shipmt_e"),
//                updateCustomer.get("shipmt_l"), saCommodityAnalysisServer,
//                saManufacturerAnalysisService, saGroupsAnalysisService,
//                saCommodityPurchaseService));
//      }
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, true,
          ResultCodeSystem.SAVE_SUCCESS);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, false,
        ResultCodeSystem.SAVE_FAIL);
  }

  @DeleteMapping("/customer/{cuid}")
  public ResultJson<Boolean> deleteCustomer(
      @PathVariable(value = "cuid") final Long cuid) {
    if (cuid == null || cuid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeCustomer.RESULT_CODE_7003200);
    }
    return customerService.deleteCustomer(cuid);
  }

  // 获取合同所需的客户分公司
  @GetMapping("/customer/list")
  public ResultJson<List<ContractCustomerView>> getContractCustomerList() {
    final List<ContractCustomerView> customerList =
        customerService.getContractCustomerList();
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, customerList,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/customer/basedetail/{cuid}")
  public ResultJson<CustomerBaseDetailView> getCustomerBaseDetail(
      @PathVariable(required = false, value = "cuid") final Long cuid) {
    if (cuid == null || cuid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeCustomer.RESULT_CODE_7004200);
    }
    final CustomerBaseDetailView baseDetail =
        customerService.getCustomerBaseDetail(cuid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, baseDetail,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  private Integer checkAddLinkmanList(
      final List<AddOrUpdateLinkmanParameter> linkmanList) {
    for (final AddOrUpdateLinkmanParameter linkmanInfo : linkmanList) {
      if (Strings.isNullOrEmpty(linkmanInfo.getName())) {
        return ResultCodeCustomer.RESULT_CODE_7001202;
      }
      if (!Strings.isNullOrEmpty(linkmanInfo.getLkPhone())
          && !CommonTools.isRegPhoneNumber(linkmanInfo.getLkPhone())) {
        return ResultCodeCustomer.RESULT_CODE_7001303;
      }
      if (!Strings.isNullOrEmpty(linkmanInfo.getLkMail())
          && !CommonTools.isRegEmail(linkmanInfo.getLkMail())) {
        return ResultCodeCustomer.RESULT_CODE_7001304;
      }
    }
    return 0;
  }

  private Integer checkUpdateLinkmanList(
      final List<AddOrUpdateLinkmanParameter> linkmanList) {
    for (final AddOrUpdateLinkmanParameter linkmanInfo : linkmanList) {
      if (Strings.isNullOrEmpty(linkmanInfo.getName())) {
        return ResultCodeCustomer.RESULT_CODE_7002203;
      }
      if (!Strings.isNullOrEmpty(linkmanInfo.getLkPhone())
          && !CommonTools.isRegPhoneNumber(linkmanInfo.getLkPhone())) {
        return ResultCodeCustomer.RESULT_CODE_7002303;
      }
      if (!Strings.isNullOrEmpty(linkmanInfo.getLkMail())
          && !CommonTools.isRegEmail(linkmanInfo.getLkMail())) {
        return ResultCodeCustomer.RESULT_CODE_7002304;
      }
    }
    return 0;
  }

  @GetMapping("/customer/contract/number")
  public ResultJson<List<Map<String, Object>>> getGroupsContractRelationNumberByGid(
      @RequestParam(required = true, value = "cuid") final Long cuid) {
    if (cuid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeCustomer.RESULT_CODE_7005200);
    }
    final List<Map<String, Object>> list =
        customerService.getGroupsContractRelationNumberByGid(cuid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }
}
