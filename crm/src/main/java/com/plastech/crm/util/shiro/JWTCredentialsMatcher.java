package com.plastech.crm.util.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 自定义token校验规则
 *
 * @author : yemin
 * @date : 2018年12月21日 下午2:28:30
 *
 */
public class JWTCredentialsMatcher extends SimpleCredentialsMatcher {

  @Override
  public boolean doCredentialsMatch(final AuthenticationToken token,
      final AuthenticationInfo info) {
    return true;
  }


}
