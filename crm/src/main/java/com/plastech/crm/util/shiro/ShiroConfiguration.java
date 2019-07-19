package com.plastech.crm.util.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSessionStorageEvaluator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.plastech.crm.service.PermissionService;
import com.plastech.crm.service.UserService;

/**
 *
 *
 * @author : yemin
 * @date : 2018年12月19日 下午3:16:43
 *
 */
@Configuration
public class ShiroConfiguration {

  /**
   * 注册shiro的Filter，拦截请求
   */
  @Bean
  public FilterRegistrationBean filterRegistrationBean(
      final PermissionService permissionService, final UserService userService)
      throws Exception {
    final FilterRegistrationBean filterRegistration =
        new FilterRegistrationBean();
    filterRegistration.setFilter(
        (Filter) shiroFilter(userService, permissionService).getObject());
    filterRegistration.addInitParameter("targetFilterLifecycle", "true");
    filterRegistration.setAsyncSupported(true);
    filterRegistration.setEnabled(true);
    filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);

    return filterRegistration;
  }

  /**
   * 初始化Authenticator
   */
  @Bean("authenticator")
  public Authenticator authenticator(final UserService userService) {
    final ModularRealmAuthenticator authenticator =
        new ModularRealmAuthenticator();
    authenticator.setAuthenticationStrategy(new FirstSuccessfulStrategy());
    return authenticator;
  }

  /**
   * 禁用session
   *
   * @return
   */
  @Bean
  protected SessionStorageEvaluator sessionStorageEvaluator() {
    final DefaultWebSessionStorageEvaluator sessionStorageEvaluator =
        new DefaultWebSessionStorageEvaluator();
    sessionStorageEvaluator.setSessionStorageEnabled(false);
    return sessionStorageEvaluator;
  }

  /**
   * 登录认证、权限认证的realm
   */
  @Bean("dbRealm")
  public Realm dbShiroRealm(final UserService userService) {
    return new DBShiroRealm(userService);
  }

  /**
   * token校验的realm
   */
  @Bean("jwtRealm")
  public Realm jwtShiroRealm(final UserService userService) {
    return new JWTShiroRealm(userService);
  }

  /**
   * 设置过滤器，将自定义的Filter加入
   */
  @Bean("shiroFilter")
  public ShiroFilterFactoryBean shiroFilter(final UserService userService,
      final PermissionService permissionService) {
    final RestShiroFilterFactoryBean factoryBean =
        new RestShiroFilterFactoryBean();// 使用自定义的filter，以支持rest风格的api
    factoryBean.setSecurityManager(getSecurityManager(userService));
    final Map<String, Filter> filterMap = factoryBean.getFilters();
    // 设置两个filter，一个用于token校验，一个用于权限控制
    filterMap.put(JWTAuthFilter.AUTHC_TOKEN, new JWTAuthFilter());

    filterMap.put(AnyRolesAuthFilter.ANY_ROLE, new AnyRolesAuthFilter());

    factoryBean.setFilters(filterMap);
    factoryBean.setFilterChainDefinitionMap(
        shiroFilterChainDefinition(permissionService).getFilterChainMap());
    return factoryBean;
  }

  @Bean
  protected ShiroFilterChainDefinition shiroFilterChainDefinition(
      final PermissionService permissionService) {
    final DefaultShiroFilterChainDefinition chainDefinition =
        new DefaultShiroFilterChainDefinition();
    chainDefinition
        .addPathDefinitions(permissionService.loadFilterChainDefinitions());
    return chainDefinition;
  }

  // 权限管理，配置主要是Realm的管理认证
  @Bean(name = "securityManager")
  public DefaultWebSecurityManager getSecurityManager(
      final UserService userService) {
    final DefaultWebSecurityManager securityManager =
        new DefaultWebSecurityManager();//自定义Realm
    securityManager.setAuthenticator(authenticator(userService));//设置Realm验证器
    final Collection<Realm> realms = new ArrayList<>();
    // 设置两个Realm，一个用于用户登录验证和访问权限获取；一个用于jwt token的认证
    realms.add(dbShiroRealm(userService));
    realms.add(jwtShiroRealm(userService));
    securityManager.setRealms(realms);
    return securityManager;
  }

  // 允许使用shiro的注解，不加入这个注解会导致rest-api路径失效出现404
  @Bean
  public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
    final DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator =
        new DefaultAdvisorAutoProxyCreator();
    defaultAdvisorAutoProxyCreator.setUsePrefix(true);
    return defaultAdvisorAutoProxyCreator;
  }

}
