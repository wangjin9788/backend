package com.plastech.crm.util.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanInitializationException;

/**
 *
 *
 * @author : yemin
 * @date : 2018年12月28日 下午3:37:33
 *
 */
public class RestShiroFilterFactoryBean extends ShiroFilterFactoryBean {

  protected static final Logger logger =
      LoggerFactory.getLogger(RestShiroFilterFactoryBean.class);

  public RestShiroFilterFactoryBean() {
    super();
  }

  @Override
  protected AbstractShiroFilter createInstance() throws Exception {
    logger.debug("Creating Shiro Filter instance.");
    final SecurityManager securityManager = this.getSecurityManager();
    String msg;
    if (securityManager == null) {
      msg = "SecurityManager property must be set.";
      throw new BeanInitializationException(msg);
    } else if (!(securityManager instanceof WebSecurityManager)) {
      msg =
          "The security manager does not implement the WebSecurityManager interface.";
      throw new BeanInitializationException(msg);
    } else {
      final FilterChainManager manager = this.createFilterChainManager();
      final RestPathMatchingFilterChainResolver chainResolver =
          new RestPathMatchingFilterChainResolver();
      chainResolver.setFilterChainManager(manager);
      return new RestShiroFilterFactoryBean.SpringShiroFilter(
          (WebSecurityManager) securityManager, chainResolver);
    }
  }

  private static final class SpringShiroFilter extends AbstractShiroFilter {
    protected SpringShiroFilter(final WebSecurityManager webSecurityManager,
        final FilterChainResolver resolver) {
      if (webSecurityManager == null) {
        throw new IllegalArgumentException(
            "WebSecurityManager property cannot be null.");
      } else {
        this.setSecurityManager(webSecurityManager);
        if (resolver != null) {
          this.setFilterChainResolver(resolver);
        }

      }
    }
  }
}
