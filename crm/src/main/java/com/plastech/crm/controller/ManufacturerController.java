package com.plastech.crm.controller;

import java.util.List;
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
import com.plastech.crm.model.parameter.ManufacturerParameters;
import com.plastech.crm.model.vo.ManufacturerView;
import com.plastech.crm.resultcode.ResultCodeManufacturer;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author 王进
 *
 */
@RestController
@RequestMapping("/manufacturer-management")
public class ManufacturerController extends BaseController {
  private final Logger log =
      LoggerFactory.getLogger(ManufacturerController.class);

  @GetMapping("/manufacturer/search")
  public ResultJson<AppPageModel<List<ManufacturerView>>> searchManufacturer(
      @RequestParam(required = false,
          value = "currentpage") final Integer currentpage,
      @RequestParam(required = false, value = "perpage") final Integer perpage,
      @RequestParam(required = false,
          value = "searchKey") final String searchKey) {

    final AppPageModel<List<ManufacturerView>> manufacturerInfo =
        manufacturerService.searchManufacturer(currentpage, perpage, searchKey);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0,
        manufacturerInfo, ResultCodeSystem.SELECT_SUCCESS);
  }

  @PostMapping("/manufacturer")
  public ResultJson<Integer> createManufacturer(
      @RequestBody final ManufacturerParameters param,
      final HttpServletRequest request) {
    if (Strings.isNullOrEmpty(param.getName())) {
      return ResultUtil.getResult(ResultCodeManufacturer.RESULT_CODE_4001200);
    }
    final Long uid = getCurrentUid(request);
    final ResultJson<Integer> createManufacturer =
        manufacturerService.createManufacturer(uid, param.getName());
    if (createManufacturer.getResultCode() != null
        && createManufacturer.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  生产商数据：{} ===============。", "生产商模块",
          user.getUid() + "---------" + user.getUname(), "Add(新增)", param);
    }
    return createManufacturer;
  }

  @PutMapping("/manufacturer/{mfId}")
  public ResultJson<Integer> updateManufacturer(
      @PathVariable(required = false, value = "mfId") final Long mfId,
      @RequestBody final ManufacturerParameters param,
      final HttpServletRequest request) {
    if (mfId == null || mfId.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeManufacturer.RESULT_CODE_4002201);
    }
    if (Strings.isNullOrEmpty(param.getName())) {
      return ResultUtil.getResult(ResultCodeManufacturer.RESULT_CODE_4002200);
    }
    final Long uId = getCurrentUid(request);
    final ResultJson<Integer> updateManufacturer =
        manufacturerService.updateManufacturer(mfId, uId, param.getName());
    if (updateManufacturer.getResultCode() != null
        && updateManufacturer.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  生产商数据：{} ===============。", "生产商模块",
          user.getUid() + "---------" + user.getUname(), "Update(编辑)", param);
    }
    return updateManufacturer;
  }

  @DeleteMapping("/manufacturer/{mfId}")
  public ResultJson<Integer> deleteManufacturer(
      @PathVariable(required = false, value = "mfId") final Long mfId,
      final HttpServletRequest request) {
    if (mfId == null || mfId.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeManufacturer.RESULT_CODE_4003200);
    }
    final ResultJson<Integer> deleteManufacturer =
        manufacturerService.deleteManufacturer(mfId);
    if (deleteManufacturer.getResultCode() != null
        && deleteManufacturer.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  操作生产商数据：{} ===============。", "生产商模块",
          user.getUid() + "---------" + user.getUname(), "Delete(删除)", mfId);
    }
    return deleteManufacturer;
  }

  @GetMapping("/manufacturer/choose/list")
  public ResultJson<List<ManufacturerView>> getManufacturerChooseList(){
   final List<ManufacturerView> manufacturerInfo =
       manufacturerService.getManufacturerChooseList();
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0,
        manufacturerInfo, ResultCodeSystem.SELECT_SUCCESS);
  }
}
