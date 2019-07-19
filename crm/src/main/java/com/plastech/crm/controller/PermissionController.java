package com.plastech.crm.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.plastech.crm.model.User;
import com.plastech.crm.model.parameter.UpdatePermissionOfRoleParameters;
import com.plastech.crm.model.vo.RolePermissionView;
import com.plastech.crm.model.vo.RoleView;
import com.plastech.crm.resultcode.ResultCodePermission;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月23日 下午4:27:19
 *
 */
@RestController
@RequestMapping("/permission-management")
public class PermissionController extends BaseController {
  private final Logger log =
      LoggerFactory.getLogger(PermissionController.class);

  /**
   * get permissionList by roleid
   *
   * @param roleid
   * @return
   */
  @GetMapping("/permissions")
  public ResultJson<RolePermissionView> getPermissionListByRole(
      @RequestParam("roleid") final Long roleid) {
    if (roleid.longValue() < 0) {
      return ResultUtil.getResult(ResultCodePermission.RESULT_CODE_24001200);
    }

    final RolePermissionView mvList =
        permissionService.getModulePermissionViewByRoleid(roleid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, mvList,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * update permission of role
   *
   * @param permissionList
   * @return
   */
  @PutMapping("/permissions/{roleid}")
  public ResultJson<Boolean> updatePermissionOfRole(
      @PathVariable("roleid") final Long roleid,
      @RequestBody final UpdatePermissionOfRoleParameters parameter,
      final HttpServletRequest request) {
    final List<Long> pmidList = parameter.getRoleCheckedList();
    if (roleid.longValue() < 0) {
      return ResultUtil.getResult(ResultCodePermission.RESULT_CODE_24002200);
    }
    final boolean updateRes =
        permissionService.updatePermissionOfRole(roleid, pmidList);
    if (updateRes) {
      final User user = getCurrentUser(request);
      log.info("操作模块：{}，操作人：{}  ,操作内容：{},  更改权限数据：{} ===============。", "权限模块",
          user.getUid() + "---------" + user.getUname(), "update(编辑权限)", roleid);
    }
    return ResultUtil.getSaveResult(updateRes);
  }

  /**
   * get all roles
   *
   * @return
   */
  @GetMapping("/roles")
  public ResultJson<List<RoleView>> getAllRoles() {
    final List<RoleView> roleViewList = permissionService.getAllRoles();
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, roleViewList,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * reload filter chain
   *
   * @return
   */
  @PutMapping("/filter-chains/reload")
  public ResultJson<Boolean> reloaddFilterChain() {
    final boolean reloadRes = permissionService.reloadFilterChain();
    return ResultUtil.getOperateResult(reloadRes);
  }
}
