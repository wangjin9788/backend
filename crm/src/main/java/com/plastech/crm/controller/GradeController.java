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
import com.plastech.crm.model.parameter.AddOrUpdateGradeParameters;
import com.plastech.crm.model.vo.ContractGradeListView;
import com.plastech.crm.model.vo.GradeView;
import com.plastech.crm.resultcode.ResultCodeGrade;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author wangJin
 *
 * @date 2019年1月14日 上午10:16:25
 *
 */
@RestController
@RequestMapping("/grade-management")
public class GradeController extends BaseController {

  private final Logger log = LoggerFactory.getLogger(GradeController.class);

  @GetMapping("/grade/search")
  public ResultJson<AppPageModel<List<GradeView>>> searchGradeList(
      @RequestParam(required = false,
          value = "currentpage") final Integer currentpage,
      @RequestParam(required = false, value = "perpage") final Integer perpage,
      @RequestParam(required = false,
          value = "searchKey") final String searchKey,
      @RequestParam(required = false, value = "ctId") final Long ctId,
      @RequestParam(required = false, value = "mfId") final Long mfId) {
    final Map<String, Object> map = new HashMap<>();
    if (!Strings.isNullOrEmpty(searchKey)) {
      map.put("searchKey", "%" + searchKey + "%");
    }
    if (ctId != null) {
      map.put("ctId", ctId);
    }
    if (mfId != null) {
      map.put("mfId", mfId);
    }
    final AppPageModel<List<GradeView>> searchGradeList =
        gradeService.searchGradeList(currentpage, perpage, map);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, searchGradeList,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @PostMapping("/grade")
  public ResultJson<Integer> createGrade(final HttpServletRequest request,
      @RequestBody final AddOrUpdateGradeParameters param) {
    if (Strings.isNullOrEmpty(param.getGradeNumber())) {
      return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5001200);
    }
    if (param.getCtId() == null || param.getCtId().longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5001201);
    }
    if (param.getMfId() == null || param.getMfId().longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5001202);
    }
    final Long uId = getCurrentUid(request);
    final ResultJson<Integer> createGrade =
        gradeService.createGrade(uId, param);
    if (createGrade.getResultCode() != null
        && createGrade.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  牌号数据：{} ===============。", "牌号模块",
          user.getUid() + "---------" + user.getUname(), "Add(新增)", param);
    }
    return createGrade;
  }

  @PutMapping("/grade/{geId}")
  public ResultJson<Integer> updateGrade(
      @PathVariable(required = false, value = "geId") final Long geId,
      final HttpServletRequest request,
      @RequestBody final AddOrUpdateGradeParameters param) {
    if (geId == null || geId.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5002200);
    }
    if (param.getMfId() == null || param.getMfId().longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5002201);
    }
    if (param.getCtId() == null || param.getCtId().longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5002202);
    }
    if (Strings.isNullOrEmpty(param.getGradeNumber())) {
      return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5002203);
    }
    final Long uId = getCurrentUid(request);
    final ResultJson<Integer> updateGrade =
        gradeService.updateGrade(geId, uId, param);
    if (updateGrade.getResultCode() != null
        && updateGrade.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  编辑牌号数据：{} ===============。", "牌号模块",
          user.getUid() + "---------" + user.getUname(), "Update(编辑)", param);
    }
    return updateGrade;
  }

  @DeleteMapping("/grade/{geId}")
  public ResultJson<Boolean> deleteGrade(
      @PathVariable(required = false, value = "geId") final Long geId,
      final HttpServletRequest request) {
    if (geId == null || geId.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5003200);
    }
    final ResultJson<Boolean> deleteGrade = gradeService.deleteGrade(geId);
    if (deleteGrade.getResultCode() != null
        && deleteGrade.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  删除牌号数据：{} ===============。", "牌号模块",
          user.getUid() + "---------" + user.getUname(), "Delete(删除)", geId);
    }
    return deleteGrade;

  }

  @GetMapping("/grade/contract/list")
  public ResultJson<List<ContractGradeListView>> getContractGradeList() {
    final List<ContractGradeListView> gradeList =
        gradeService.getContractGradeList();
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, gradeList,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @GetMapping("/grade/contract/number")
  public ResultJson<List<Map<String, Object>>> getContractRelationNumberByGeid(
      @RequestParam(required = true, value = "geid") final Long geid) {
    if (geid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeGrade.RESULT_CODE_5004200);
    }
    final List<Map<String, Object>> list =
        gradeService.getContractRelationNumberByGeid(geid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, list,
        ResultCodeSystem.SELECT_SUCCESS);
  }
}
