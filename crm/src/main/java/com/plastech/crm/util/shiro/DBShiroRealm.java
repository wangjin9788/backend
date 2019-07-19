package com.plastech.crm.util.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.plastech.crm.model.User;
import com.plastech.crm.service.UserService;

/**
 * 与DB有关的数据和权限的校验
 *
 * @author : yemin
 * @date : 2018年12月19日 下午3:18:40
 *
 */
public class DBShiroRealm extends AuthorizingRealm {

  private static final Logger logger =
      LoggerFactory.getLogger(DBShiroRealm.class);

  protected UserService userService;

  public DBShiroRealm(final UserService userService) {
    super();
    this.userService = userService;
    this.setCredentialsMatcher(new LoginCredentialsMatcher());
  }

  @Override
  public boolean supports(final AuthenticationToken token) {
    return token instanceof UsernamePasswordToken;
  }

  /**
   * 帐号密码认证
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(
      final AuthenticationToken token) throws AuthenticationException {
    final UsernamePasswordToken userpasswordToken =
        (UsernamePasswordToken) token;
    final String ucode = userpasswordToken.getUsername();

    final User user = userService.selectByUcodeOrUphoneOrUmail(ucode);

    if (user != null) {
      // 三个参数依次是：Object principal, Object credentials, String realmName
      final AuthenticationInfo authcInfo =
          new SimpleAuthenticationInfo(user, user.getPwd(), "dbRealm");
      return authcInfo;
    } else {
      return null;
    }
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(
      final PrincipalCollection principalCollection) {
    // 添加角色和权限
    final SimpleAuthorizationInfo simpleAuthorizationInfo =
        new SimpleAuthorizationInfo();
//    final String uid = (String) principalCollection.getPrimaryPrincipal();
    final Long uid = (Long) principalCollection.getPrimaryPrincipal();
    final String role = userService.getUserRoleCodeByUid(uid);
    logger.info("User Role : " + role);
    simpleAuthorizationInfo.addRole(role);
    // simpleAuthorizationInfo.addStringPermission("select");
    return simpleAuthorizationInfo;
  }
}
