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
import com.plastech.crm.model.parameter.AddOrUpdateGroupsParameters;
import com.plastech.crm.model.vo.GroupsView;
import com.plastech.crm.resultcode.ResultCodeGroups;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月15日 上午9:16:20
 *
 */
@RestController
@RequestMapping("/groups-management")
public class GroupsController extends BaseController {

 private final Logger log = LoggerFactory.getLogger(GroupsController.class);

  /**
   * get groups selection for supplier
   *
   * @return
   */
  @GetMapping("/groups/selection")
  public ResultJson<List<GroupsView>> getGroupsSelectionForSupplier() {
    final List<GroupsView> groupsList =
        gradeService.getGroupsSelectionForSupplier();
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, groupsList,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * add groups
   *
   * @param param
   * @return
   */
  @PostMapping("/groups")
  public ResultJson<Boolean> addGroups(
      @RequestBody final AddOrUpdateGroupsParameters param,
      final HttpServletRequest request) {
    final String name = param.getName();
    final Integer type = param.getType();
    final Integer code = param.getCode();
    if (Strings.isNullOrEmpty(name)) {
      return ResultUtil.getResult(ResultCodeGroups.RESULT_CODE_11001100);
    }
    if (type == null || type < 0 || type > 1) {
      return ResultUtil.getResult(ResultCodeGroups.RESULT_CODE_11001200);
    }
    if (code == null || code < 0) {
      param.setCode(0);
    }

    final Long currentUid = getCurrentUid(request);
    final int addRes = groupsService.addOrUpdateGroups(param, currentUid);
    if (addRes == 1) {
      return ResultUtil.getResult(ResultCodeGroups.RESULT_CODE_11001300);
    }
    final User user = getCurrentUser(request);
    log.info("操作模块：{}，操作人：{}  ,操作内容：{},  客户新数据：{} ===============。", "客户模块",
        user.getUid() + "---------" + user.getUname(), "Add(新增)", param);
    return ResultUtil.getResult(
        addRes >= 0 ? ResultCodeSystem.RESULT_CODE_0
            : ResultCodeSystem.RESULT_CODE_50,
        addRes >= 0 ? true : false,
        addRes >= 0 ? ResultCodeSystem.ADD_SUCCESS : ResultCodeSystem.ADD_FAIL);
  }

  @GetMapping("/groups/search")
  public ResultJson<List<GroupsView>> searchGroupsList(@RequestParam(
      required = false, value = "searchkey") final String searchkey) {
    final List<GroupsView> groupsList =
        groupsService.searchGroupsList(searchkey);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, groupsList,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @PutMapping("/groups/{gid}")
  public ResultJson<Boolean> updateGroupsName(
      @PathVariable(value = "gid") final Long gid,
      @RequestBody final AddOrUpdateGroupsParameters param,
      final HttpServletRequest request) {
    if (gid == null || gid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeGroups.RESULT_CODE_11002200);
    }
    if (Strings.isNullOrEmpty(param.getName())) {
      return ResultUtil.getResult(ResultCodeGroups.RESULT_CODE_11002201);
    }
    final Long uid = getCurrentUid(request);
    final ResultJson<Boolean> updateGroups =
        groupsService.updateGroupsName(gid, param, uid);
    if (updateGroups.getResultCode() != null
        && updateGroups.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{}, 操作数据：{} ===============。", "客户模块",
          user.getUid() + "---------" + user.getUname(), "Update(编辑)", param);
    }
    return updateGroups;
  }

  @DeleteMapping("/groups/{gid}")
  public ResultJson<Boolean> deleteGroups(
      @PathVariable(value = "gid") final Long gid, final HttpServletRequest request) {
    if (gid == null || gid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeGroups.RESULT_CODE_11003200);
    }
    final ResultJson<Boolean> deleteGroups = groupsService.deleteGroups(gid);
    if (deleteGroups.getResultCode() != null
        && deleteGroups.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{}, 操作数据：{} ===============。", "客户模块",
          user.getUid() + "---------" + user.getUname(), "Delete(编辑)", gid);
    }
    return deleteGroups;
  }

  @GetMapping("/groups/choose/list")
  public ResultJson<List<GroupsView>>getGroupsChooseList(@RequestParam(
      required = false, value = "searchkey") final String searchkey) {
    final List<GroupsView> groupsList =
        groupsService.getGroupsChooseList();
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, groupsList,
        ResultCodeSystem.SELECT_SUCCESS);
  }

}
