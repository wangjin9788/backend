package com.plastech.crm.util.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.plastech.crm.util.PasswordStorage;
import com.plastech.crm.util.PasswordStorage.CannotPerformOperationException;
import com.plastech.crm.util.PasswordStorage.InvalidHashException;

/**
 *
 * 自定义密码校验规则
 *
 * @author : yemin
 * @date : 2018年12月20日 下午2:50:28
 *
 */
public class LoginCredentialsMatcher extends SimpleCredentialsMatcher {

  protected static final Logger logger =
      LoggerFactory.getLogger(LoginCredentialsMatcher.class);

  @Override
  public boolean doCredentialsMatch(final AuthenticationToken authcToken,
      final AuthenticationInfo info) {
    final UsernamePasswordToken token =
        (UsernamePasswordToken) authcToken;
    // 用户端传过来的密码
    final char[] inputCredentials = token.getPassword();
    // DB中存储的密码
    final String accountCredentials = String.valueOf(getCredentials(info));

    boolean verifyPassword = false;
    try {
      verifyPassword =
          PasswordStorage.verifyPassword(inputCredentials, accountCredentials);
    } catch (CannotPerformOperationException | InvalidHashException e) {
      logger.error("LoginCredentialsMatcher, Password Verify Error : {}", e);
    }
    return verifyPassword;
  }

}
