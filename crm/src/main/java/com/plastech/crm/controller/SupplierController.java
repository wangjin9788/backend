package com.plastech.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.plastech.crm.model.User;
import com.plastech.crm.model.parameter.AddOrUpdateLinkmanParameter;
import com.plastech.crm.model.parameter.AddOrUpdateSupplierParameters;
import com.plastech.crm.model.vo.SupplierBaseDetailView;
import com.plastech.crm.model.vo.SupplierView;
import com.plastech.crm.resultcode.ResultCodeSupplier;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.util.AppPage;
import com.plastech.crm.util.CommonTools;
import com.plastech.crm.util.RequestParseUtil;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月10日 下午4:48:09
 *
 */
@RestController
@RequestMapping("/supplier-management")
public class SupplierController extends BaseController {

  private final Logger log = LoggerFactory.getLogger(SupplierController.class);

  /**
   * search suppliers
   *
   * @param tags
   * @param searchkey
   * @param currentpage
   * @param perpage
   * @return
   */
  @GetMapping("/suppliers/search")
  public ResultJson<AppPage<List<SupplierView>>> searchSupplierList(
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

    final AppPage<List<SupplierView>> page =
        supplierService.searchSupplierList(param, currentpage, perpage);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, page,
        ResultCodeSystem.SELECT_SUCCESS);
  }



  /**
   * add supplier
   *
   * @param param
   * @return
   */
  @PostMapping("/suppliers")
  public ResultJson<Boolean> addSupplier(
      @RequestBody final AddOrUpdateSupplierParameters param,
      final HttpServletRequest request) {
    // 校验token是否为空
    final String token = RequestParseUtil.getToken(request);
    if (Strings.isNullOrEmpty(token)) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_9, null,
          "未攜帶token，操作無效");
    }
    if (param == null) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10001100);
    }
    final String suName = param.getSuName();
    if (Strings.isNullOrEmpty(suName)) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10001101);
    }
    if (Strings.isNullOrEmpty(param.getFullName())) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10001102);
    }
    if (param.getLinkmanList() != null && !param.getLinkmanList().isEmpty()) {
      final Integer isPresence = checkAddLinkmanList(param.getLinkmanList());
      if (isPresence > 0) {
        return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10002201);
      }
    }
    final Long uid = getCurrentUid(request);
    final int addRes = supplierService.addOrUpdateSupplier(param, uid, null);
    if (addRes == 1) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10002300);
    }
    if (addRes >= 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  供应商数据：{} ===============。", "供应商模块",
          user.getUid() + "---------" + user.getUname(), "Add(新增)", param);
    }
    return ResultUtil.getResult(
        addRes >= 0 ? ResultCodeSystem.RESULT_CODE_0
            : ResultCodeSystem.RESULT_CODE_50,
        addRes >= 0 ? true : false,
        addRes >= 0 ? ResultCodeSystem.ADD_SUCCESS : ResultCodeSystem.ADD_FAIL);
  }

  /**
   * update supplier
   *
   * @param param
   * @param request
   * @return
   */
  @PutMapping("/suppliers/{suid}")
  public ResultJson<Boolean> updateSupplier(
      @RequestBody final AddOrUpdateSupplierParameters param,
      @PathVariable("suid") final Long suid, final HttpServletRequest request) {
    if (param == null) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10002100);
    }
    final String suName = param.getSuName();
    if (suid == null || suid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10002203);
    }
    if (Strings.isNullOrEmpty(suName)) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10002101);
    }
    if (Strings.isNullOrEmpty(param.getFullName())) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10002102);
    }
    final Long uid = getCurrentUid(request);
    final int updateRes = supplierService.addOrUpdateSupplier(param, uid, suid);
    if (updateRes == 1) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10002300);
    }
    if (updateRes == 2) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10002301);
    }
    if (param.getLinkmanList() != null && !param.getLinkmanList().isEmpty()) {
      final Integer isPresence = checkUpdateLinkmanList(param.getLinkmanList());
      if (isPresence > 0) {
        return ResultUtil.getResult(isPresence);
      }
    }
    if (updateRes >= 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  供应商数据：{} ===============。", "供应商模块",
          user.getUid() + "---------" + user.getUname(), "Update(编辑)", param);
    }
    return ResultUtil.getResult(
        updateRes >= 0 ? ResultCodeSystem.RESULT_CODE_0
            : ResultCodeSystem.RESULT_CODE_50,
        updateRes >= 0 ? true : false, updateRes >= 0
            ? ResultCodeSystem.SAVE_SUCCESS : ResultCodeSystem.SAVE_FAIL);
  }

  /**
   * delete supplier
   *
   * @param suid
   * @param request
   * @return
   */
  @DeleteMapping("/suppliers/{suid}")
  public ResultJson<Boolean> deleteSupplier(
      @PathVariable("suid") final Long suid, final HttpServletRequest request) {
    if (suid == null || suid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10003200);
    }
    final int delRes = supplierService.deleteSupplier(suid);
    if (delRes == 1) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10003300);
    }
    if (delRes >= 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  供应商数据：{} ===============。", "供应商模块",
          user.getUid() + "---------" + user.getUname(), "Delete(删除)", suid);
    }
    return ResultUtil.getResult(
        delRes >= 0 ? ResultCodeSystem.RESULT_CODE_0
            : ResultCodeSystem.RESULT_CODE_50,
        delRes >= 0 ? true : false, delRes >= 0
            ? ResultCodeSystem.DELETE_SUCCESS : ResultCodeSystem.DELETE_FAIL);
  }

  @GetMapping("/suppliers/basedetail/{suid}")
  public ResultJson<SupplierBaseDetailView> getSupplierBaseDetail(
      @PathVariable(required = false, value = "suid") final Long suid) {
    if (suid == null || suid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSupplier.RESULT_CODE_10004200);
    }
    final SupplierBaseDetailView detail =
        supplierService.getSupplierBaseDetail(suid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, detail,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  private Integer checkAddLinkmanList(
      final List<AddOrUpdateLinkmanParameter> linkmanList) {
    for (final AddOrUpdateLinkmanParameter linkmanInfo : linkmanList) {
      if (Strings.isNullOrEmpty(linkmanInfo.getName())) {
        return ResultCodeSupplier.RESULT_CODE_10001201;
      }
      if (!Strings.isNullOrEmpty(linkmanInfo.getLkPhone())
          && !CommonTools.isRegPhoneNumber(linkmanInfo.getLkPhone())) {
        return ResultCodeSupplier.RESULT_CODE_10001302;
      }
      if (!Strings.isNullOrEmpty(linkmanInfo.getLkMail())
          && !CommonTools.isRegEmail(linkmanInfo.getLkMail())) {
        return ResultCodeSupplier.RESULT_CODE_10001303;
      }
    }
    return 0;
  }

  private Integer checkUpdateLinkmanList(
      final List<AddOrUpdateLinkmanParameter> linkmanList) {
    for (final AddOrUpdateLinkmanParameter linkmanInfo : linkmanList) {
      if (Strings.isNullOrEmpty(linkmanInfo.getName())) {
        return ResultCodeSupplier.RESULT_CODE_10002201;
      }
      if (!Strings.isNullOrEmpty(linkmanInfo.getLkPhone())
          && !CommonTools.isRegPhoneNumber(linkmanInfo.getLkPhone())) {
        return ResultCodeSupplier.RESULT_CODE_10002302;
      }
      if (!Strings.isNullOrEmpty(linkmanInfo.getLkMail())
          && !CommonTools.isRegEmail(linkmanInfo.getLkMail())) {
        return ResultCodeSupplier.RESULT_CODE_10002303;
      }
    }
    return 0;
  }

  @GetMapping("/suppliers/init")
  public ResultJson<Boolean> initSupplier() {
    final Boolean isSuccess = supplierService.initSupplier();
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, isSuccess,
        ResultCodeSystem.ADD_SUCCESS);
  }

  @GetMapping("/suppliers/contract/list")
  public ResultJson<List<SupplierView>> suppliersContractList() {

    final List<SupplierView> list = supplierService.suppliersContractList();
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }

}
