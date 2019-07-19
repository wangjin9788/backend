package com.plastech.crm.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import com.plastech.crm.model.User;
import com.plastech.crm.model.vo.UserView;
import com.plastech.crm.resultcode.ResultCodeLogin;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.rpcservice.RpcOauthService;
import com.plastech.crm.service.LoginService;
import com.plastech.crm.util.PasswordStorage;
import com.plastech.crm.util.PasswordStorage.CannotPerformOperationException;
import com.plastech.crm.util.PasswordStorage.InvalidHashException;
import com.plastech.crm.util.RequestParseUtil;
import com.plastech.crm.util.constant.Constant;
import com.plastech.crmcommon.dto.OauthUserInfo;
import com.plastech.crmcommon.dto.RpcResponse;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月9日 下午5:46:23
 *
 */
@Service
public class LoginServiceImpl extends BaseService implements LoginService {

  @Autowired
  private RpcOauthService oauthClient;

  @Override
  public ResultJson<UserView> webLogin(final HttpServletResponse response,
      final String ucode, final String password, final String language) {
    try {
      // 1.find user
      final User user = userMapper.selectByUcodeOrUphoneOrUmail(ucode);
      if (user == null) {
        return ResultUtil.getResult(ResultCodeLogin.RESULT_CODE_1001300);
      }
      if (user.getUstatus() == 1) {
        return ResultUtil.getResult(ResultCodeLogin.RESULT_CODE_1001303);
      }

      // 2.verify password
      try {
        final boolean verifyPassword =
            PasswordStorage.verifyPassword(password, user.getPwd());
        if (!verifyPassword) {
          return ResultUtil.getResult(ResultCodeLogin.RESULT_CODE_1001301);
        }
      } catch (CannotPerformOperationException | InvalidHashException e) {
        logger.error("Verify password error , {}", e);
        return ResultUtil.getResult(ResultCodeLogin.RESULT_CODE_1001302);
      }
      // 3.create token
      final RpcResponse<String> createRes = oauthClient.createToken(
          new OauthUserInfo(user.getUid(), user.getUname(), user.getUnumber()));
      final String token = createRes.getResultData();
      if (!createRes.isSuccess() || Strings.isNullOrEmpty(token)) {
        logger.error("Create token failure");
        return ResultUtil.getResult(ResultCodeLogin.RESULT_CODE_1001302);
      }
      // 4.回写cookie
      reWriteCookie(token, response);

      // 5.set result
      return new ResultJson<UserView>(ResultCodeSystem.RESULT_CODE_0,
          user.convertToUserView(token), ResultCodeSystem.LOGIN_SUCCESS);
    } catch (final Exception e) {
      logger.error("WebLogin error : {}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, null,
        ResultCodeSystem.LOGIN_FAIL);
  }

  /**
   * 回写携带token的cookie
   *
   * @param jwt
   * @author: ym
   * @param response
   * @date: 2015年12月4日 下午7:14:58
   */
  private static void reWriteCookie(final String jwt,
      final HttpServletResponse response) {
    final Cookie tokenCookie = new Cookie(Constant.TOKEN_NAME, jwt);
    tokenCookie.setSecure(false);// 是否只能用于安全的https协议中
    tokenCookie.setHttpOnly(true);// 防止token被js盗取（XSS漏洞）
    tokenCookie.setMaxAge(Constant.VALID_TIME);
    tokenCookie.setPath("/");
    response.addCookie(tokenCookie);
  }

  @Override
  public Long checkToken(final HttpServletRequest request,
      final HttpServletResponse response) {
    try {
      final String token = RequestParseUtil.getToken(request);
      if (!Strings.isNullOrEmpty(token)) {
        final RpcResponse<Long> checkRes = oauthClient.checkToken(token);
        if (checkRes.isSuccess()) {
          final Long uid = checkRes.getResultData();
          return uid;
        }
      }
    } catch (final Exception e) {
      logger.error("Check token failure , {}", e);
    }
    return 0L;
  }

  @Override
  public ResultJson<Object> logout(final String token) {
    try {
      final RpcResponse<Boolean> rr = oauthClient.consumeToken(token);
      if (rr.isSuccess()) {
        final boolean isLogOutSuccess = rr.getResultData();
        if (isLogOutSuccess) {
          return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, null,
              "logout success");
        }
      }
    } catch (final Exception e) {
      logger.error("Logout failure , {}", e);
    }

    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, null,
        "logout failure");
  }

}
