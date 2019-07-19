package com.plastech.crm.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Strings;
import com.plastech.crm.model.parameter.AddLoyaltyParameters;
import com.plastech.crm.model.parameter.ExchangeDataOrderParameters;
import com.plastech.crm.model.vo.LoyaltyView;
import com.plastech.crm.resultcode.ResultCodeLoyalty;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;

/**
 * @author wangJin
 *
 * @date 2019年1月22日 上午9:27:45
 *
 */
@RestController
@RequestMapping("/loyalty-management")
public class LoyaltyController extends BaseController {

  @GetMapping("/loyalty/list")
  public ResultJson<List<LoyaltyView>> getLoyaltyList() {
    final List<LoyaltyView> loyaltyList = loyaltyService.getLoyaltyList(0);
    return ResultUtil.getResult(
        loyaltyList != null ? ResultCodeSystem.RESULT_CODE_0
            : ResultCodeSystem.RESULT_CODE_50,
        loyaltyList, loyaltyList != null ? ResultCodeSystem.SELECT_SUCCESS
            : ResultCodeSystem.SELECT_FAIL);
  }

  @PostMapping("/loyalty")
  public ResultJson<Integer> addLoyalty(
      @RequestBody final AddLoyaltyParameters param,
      final HttpServletRequest request) {
    if (Strings.isNullOrEmpty(param.getName())) {
      return ResultUtil.getResult(ResultCodeLoyalty.RESULT_CODE_6001200);
    }
    if (param.getMinFrequency() == null) {
      return ResultUtil.getResult(ResultCodeLoyalty.RESULT_CODE_6001100);
    }
    if (param.getMaxFrequency() == null) {
      return ResultUtil.getResult(ResultCodeLoyalty.RESULT_CODE_6001101);
    }
    if (param.getDuration() == null) {
      return ResultUtil.getResult(ResultCodeLoyalty.RESULT_CODE_6001102);
    }
    final Long uid = getCurrentUid(request);
    final Integer addLoyalty = loyaltyService.addLoyalty(param, uid);
    if (addLoyalty == 1) {
      return ResultUtil.getResult(ResultCodeLoyalty.RESULT_CODE_6001300);
    }
    return ResultUtil.getResult(
        addLoyalty == 0 ? ResultCodeSystem.RESULT_CODE_0
            : ResultCodeSystem.RESULT_CODE_50,
        addLoyalty, addLoyalty == 0 ? ResultCodeSystem.ADD_SUCCESS
            : ResultCodeSystem.ADD_FAIL);
  }

  @DeleteMapping("/loyalty/{lid}")
  public ResultJson<Integer> deleteLoyalty(
      @PathVariable(value = "lid") final Long lid) {
    if (lid == null || lid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeLoyalty.RESULT_CODE_6002200);
    }
    final Integer deleteLoyalty = loyaltyService.deleteLoyalty(lid);
    if (deleteLoyalty == 1) {
      return ResultUtil.getResult(ResultCodeLoyalty.RESULT_CODE_6002300);
    }
    return ResultUtil.getResult(
        deleteLoyalty == 0 ? ResultCodeSystem.RESULT_CODE_0
            : ResultCodeSystem.RESULT_CODE_50,
        deleteLoyalty, deleteLoyalty == 0 ? ResultCodeSystem.ADD_SUCCESS
            : ResultCodeSystem.ADD_FAIL);
  }

  @PatchMapping("/loyalty/order/exchange")
  public ResultJson<Boolean> exchangeLoyaltyOrder(
      @RequestBody final ExchangeDataOrderParameters parameter) {
    final Long orderIdA = parameter.getOrderIdA();
    final Long orderIdB = parameter.getOrderIdA();
    if (orderIdA == null || orderIdA.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeLoyalty.RESULT_CODE_6003200);
    }
    if (orderIdB == null || orderIdB.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeLoyalty.RESULT_CODE_6003200);
    }
    return loyaltyService.exchangeLoyaltyOrder(parameter);
  }

  @GetMapping("/loyalty/takes/effect")
  public ResultJson<Boolean> loyaltyTakesEffect(final HttpServletRequest request) {
    final Long uid = getCurrentUid(request);
    final Boolean loyaltyTakesEffect = loyaltyService.loyaltyTakesEffect(uid);
    return ResultUtil.getResult(0, loyaltyTakesEffect, "");
  }

}
