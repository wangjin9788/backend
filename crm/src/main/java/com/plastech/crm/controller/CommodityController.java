package com.plastech.crm.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Strings;
import com.plastech.crm.model.User;
import com.plastech.crm.model.parameter.AddOrUpdateCommodityParameters;
import com.plastech.crm.model.vo.CommodityView;
import com.plastech.crm.resultcode.ResultCodeCommodity;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.util.RequestParseUtil;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author wangJin
 * @Date 2019年1月10日 上午9:58:50
 */
@RestController
@RequestMapping("/commodity-management")
public class CommodityController extends BaseController {
  private final Logger log = LoggerFactory.getLogger(CommodityController.class);

  @GetMapping("/commodity/search")
  public ResultJson<AppPageModel<List<CommodityView>>> searchCommodity(
      @RequestParam(required = false,
          value = "currentpage") final Integer currentpage,
      @RequestParam(required = false, value = "perpage") final Integer perpage,
      @RequestParam(required = false,
          value = "searchKey") final String searchKey) {

    final AppPageModel<List<CommodityView>> commodityInfo =
        commodityService.searchCommodity(currentpage, perpage, searchKey);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, commodityInfo,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @PostMapping("/commodity")
  public ResultJson<Integer> createCommodity(
      @RequestBody final AddOrUpdateCommodityParameters param,
      final HttpServletRequest request) {
    // 校验token是否为空
    final String token = RequestParseUtil.getToken(request);
    if (Strings.isNullOrEmpty(token)) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_9, null,
          "未攜帶token，操作無效");
    }
    if (Strings.isNullOrEmpty(param.getName())) {
      return ResultUtil.getResult(ResultCodeCommodity.RESULT_CODE_3001200);
    }
    final Long uid = getCurrentUid(request);
    final ResultJson<Integer> createCommodity =
        commodityService.createCommodity(uid, param.getName());
    if (createCommodity.getResultCode() != null
        && createCommodity.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  操作品类数据：{} ===============。", "品类模块",
          user.getUid() + "---------" + user.getUname(), "Add(新增)", param);
    }
    return createCommodity;
  }

  @DeleteMapping("/commodity/{ctId}")
  public ResultJson<Integer> deleteCommodity(
      @PathVariable(required = false, value = "ctId") final Long ctId,
      final HttpServletRequest request) {
    if (ctId == null || ctId.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeCommodity.RESULT_CODE_3002200);
    }
    final ResultJson<Integer> deleteCommodity =
        commodityService.deleteCommodity(ctId);
    if (deleteCommodity.getResultCode() != null
        && deleteCommodity.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  操作品类数据：{} ===============。", "品类模块",
          user.getUid() + "---------" + user.getUname(), "Delete(删除)", ctId);
    }
    return deleteCommodity;
  }

  @GetMapping("/commodity/choose/list")
  public ResultJson<List<CommodityView>> getCommodityChooseList() {
    final List<CommodityView> list = commodityService.getCommodityChooseList();
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }
}
