package com.plastech.crm.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Strings;
import com.plastech.crm.model.parameter.WebLoginParameters;
import com.plastech.crm.model.vo.MenuInfo;
import com.plastech.crm.model.vo.UserView;
import com.plastech.crm.resultcode.ResultCodeLogin;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.util.RequestParseUtil;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月10日 上午10:45:40
 *
 */
@RestController
@RequestMapping("/login-management")
public class LoginController extends BaseController {

  /**
   * web user login
   *
   * @param info
   * @param response
   * @return
   */
  @PostMapping("/users/login/web")
  public ResultJson<UserView> webLogin(
      @RequestBody final WebLoginParameters info,
      final HttpServletResponse response) {
    if (info == null) {
      return ResultUtil.getResult(ResultCodeLogin.RESULT_CODE_1001100);
    }
    final String ucode = info.getUcode();
    final String password = info.getPassword();
    final String language = info.getLanguage();

    if (Strings.isNullOrEmpty(ucode)) {
      return ResultUtil.getResult(ResultCodeLogin.RESULT_CODE_1001101);
    }
    if (Strings.isNullOrEmpty(password)) {
      return ResultUtil.getResult(ResultCodeLogin.RESULT_CODE_1001102);
    }

    return loginService.webLogin(response, ucode, password, language);

  }


  /**
   * User log out.
   *
   * @param request Request
   * @return Object
   */
  @PostMapping("/users/logout")
  public ResultJson<Object> logout(final HttpServletRequest request) {
    final String token = RequestParseUtil.getToken(request);
    if (Strings.isNullOrEmpty(token)) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, null,
          "未攜帶token，操作無效");
    }

    // clear login token
    return loginService.logout(token);
  }

  /**
   * get user menu
   *
   * @param request
   * @return
   */
  @GetMapping("/users/menu")
  public ResultJson<List<MenuInfo>> getUserMenu(
      final HttpServletRequest request) {
    final Long currentUid = getCurrentUid(request);
    if (currentUid == null || currentUid <= 0) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_9, null,
          ResultCodeSystem.INVALID_TOKEN);
    }
    final List<MenuInfo> menuList = userService.getUserMenu(currentUid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, menuList,
        ResultCodeSystem.SELECT_SUCCESS);
  }
}
