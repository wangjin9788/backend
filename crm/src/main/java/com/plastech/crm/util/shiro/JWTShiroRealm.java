package com.plastech.crm.util.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import com.plastech.crm.service.UserService;

/**
 * JWT校验
 *
 * @author : yemin
 * @date : 2018年12月19日 下午3:18:40
 *
 */
public class JWTShiroRealm extends AuthorizingRealm {

  protected UserService userService;

  public JWTShiroRealm(final UserService userService) {
    super();
    this.userService = userService;
    this.setCredentialsMatcher(new JWTCredentialsMatcher());
  }

  /**
   * 限定这个Realm只支持我们自定义的JWTToken
   */
  @Override
  public boolean supports(final AuthenticationToken token) {
    return token instanceof JWTToken;
  }

  /**
   * token认证，认证逻辑由matcher执行
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(
      final AuthenticationToken authcToken) throws AuthenticationException {
    final JWTToken jwtToken = (JWTToken) authcToken;
    final String token = jwtToken.getToken();

    // 直接在这里验证token，matcher中没有rpc，无法检测token
    final Long uid = userService.checkToken(token);
    // final AdminToken adminToken = userService.getAdminTokenByToken(token);
    if (uid == null) {
      throw new AuthenticationException("token无效，请重新登录");
    }
    final AuthenticationInfo authenticationInfo =
        new SimpleAuthenticationInfo(uid,// uid在dbRealm的doGetAuthorizationInfo中会用于查询角色
            new JWTToken(token, jwtToken.getHost(), uid), "uid");

    return authenticationInfo;
  }

  /**
   * 授权
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(
      final PrincipalCollection principals) {
    return new SimpleAuthorizationInfo();
  }
}
