package com.plastech.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.plastech.crm.model.parameter.AddOrUpdateUserParameters;
import com.plastech.crm.model.parameter.ChangePasswordParameters;
import com.plastech.crm.model.parameter.UpdateUserStatusParameters;
import com.plastech.crm.model.vo.UserView;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultcode.ResultCodeUser;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.util.CommonTools;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author wangJin
 * @Date 2019年1月10日 上午9:58:50
 */
@RestController
@RequestMapping("/user-management")
public class UserController extends BaseController {

  private final Logger log = LoggerFactory.getLogger(UserController.class);

  @GetMapping("/user/search")
  public ResultJson<AppPageModel<List<UserView>>> searchUserList(
      @RequestParam(required = false, value = "status") final Integer status,
      @RequestParam(required = false,
          value = "currentpage") final Integer currentpage,
      @RequestParam(required = false, value = "perpage") final Integer perpage,
      @RequestParam(required = false,
          value = "searchKey") final String searchKey) {
    final Map<String, Object> map = new HashMap<>();
    if (status != null) {
      map.put("status", status);
    }
    if (!Strings.isNullOrEmpty(searchKey)) {
      map.put("searchKey", "%" + searchKey + "%");
    }

    final AppPageModel<List<UserView>> userList =
        userService.searchUserList(map, currentpage, perpage);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, userList,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  @PostMapping("/user")
  public ResultJson<Integer> createUser(final HttpServletRequest request,
      @RequestBody final AddOrUpdateUserParameters param) {
    if (Strings.isNullOrEmpty(param.getName())) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2001200);
    }
    if (Strings.isNullOrEmpty(param.getMail())) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2001201);
    }
    if (param.getRoleId() == null) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2001202);
    }
    if (Strings.isNullOrEmpty(param.getRoleName())) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2001203);
    }
    if (!Strings.isNullOrEmpty(param.getPhone())
        && !CommonTools.isRegPhoneNumber(param.getPhone())) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2001204);
    }
    if (!CommonTools.isRegEmail(param.getMail())) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2001301);
    }
    final Long uid = getCurrentUid(request);
    final ResultJson<Integer> createUser = userService.createUser(uid, param);
    if (createUser.getResultCode() != null && createUser.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  操作用户数据：{} ===============。", "用户模块",
          user.getUid() + "---------" + user.getUname(), "Add(新增)", param);
    }
    return createUser;
  }

  @PutMapping("/user/{uid}")
  public ResultJson<Integer> updateUser(
      @PathVariable(required = false, value = "uid") final Long uid,
      @RequestBody final AddOrUpdateUserParameters param,
      final HttpServletRequest request) {

    if (Strings.isNullOrEmpty(param.getName())) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2002200);
    }
    if (Strings.isNullOrEmpty(param.getMail())) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2002201);
    }
    if (param.getRoleId() == null) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2002202);
    }
    if (param.getRoleName() == null) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2002203);
    }
    if (uid == null || uid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2002204);
    }
    if (!Strings.isNullOrEmpty(param.getPhone())
        && !CommonTools.isRegPhoneNumber(param.getPhone())) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2002205);
    }
    if (!CommonTools.isRegEmail(param.getMail())) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2002302);
    }
    final ResultJson<Integer> updateUser = userService.updateUser(uid, param);
    if (updateUser.getResultCode() != null && updateUser.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  操作用户数据：{} ===========。", "用户模块",
          user.getUid() + "---------" + user.getUname(), "Update(编辑)", param);
    }
    return updateUser;
  }

  @PutMapping("/user/status/{uid}")
  public ResultJson<Integer> updateUserStatusByUid(
      @PathVariable(value = "uid") final Long uid,
      @RequestBody final UpdateUserStatusParameters param,
      final HttpServletRequest request) {
    if (uid == null || uid <= 0) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2003200);
    }
    if (param.getStatus() == null || param.getStatus().intValue() < -1
        || param.getStatus().intValue() > 1) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2003100);
    }
    final ResultJson<Integer> delete =
        userService.updateUserStatusByUid(uid, param.getStatus());
    if (delete.getResultCode() != null && delete.getResultCode() == 0) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  操作用户数据：{} ===============。", "用户模块",
          user.getUid() + "---------" + user.getUname(), "Update(编辑(删除或冻结操作))",
          param);
    }
    return delete;
  }

  @PutMapping("/user/password/change")
  public ResultJson<Object> changePassword(
      @RequestBody final ChangePasswordParameters param,
      final HttpServletRequest request) {
    if (Strings.isNullOrEmpty(param.getOldPassword())) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2004100);
    }
    if (Strings.isNullOrEmpty(param.getNewPassword())) {
      return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2004101);
    }
    final Long uid = getCurrentUid(request);
    if (uid == null || uid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_9);
    }

    return userService.changePassword(param, uid);

  }

}
