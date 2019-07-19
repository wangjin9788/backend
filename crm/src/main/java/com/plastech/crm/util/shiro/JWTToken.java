package com.plastech.crm.util.shiro;

import org.apache.shiro.authc.HostAuthenticationToken;

/**
 *
 *
 * @author : yemin
 * @date : 2018年12月20日 下午4:34:29
 *
 */
public class JWTToken implements HostAuthenticationToken {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private final String token;
  private final String host;
  private final Long uid;

  public JWTToken(final String token) {
    this(token, null, null);
  }

  public JWTToken(final String token, final String host, final Long uid) {
    this.token = token;
    this.host = host;
    this.uid = uid;
  }

  public final Long getUid() {
    return uid;
  }

  public String getToken() {
    return this.token;
  }

  @Override
  public String getHost() {
    return host;
  }

  @Override
  public Object getPrincipal() {
    return token;
  }

  @Override
  public Object getCredentials() {
    return token;
  }

  @Override
  public String toString() {
    return token + ':' + host;
  }
}
