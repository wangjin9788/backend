package com.plastech.crm.util.shiro;

import java.util.Iterator;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 * @author : yemin
 * @date : 2018年12月28日 下午3:34:15
 *
 */
public class RestPathMatchingFilterChainResolver
    extends PathMatchingFilterChainResolver {

  protected static final Logger logger =
      LoggerFactory.getLogger(RestShiroFilterFactoryBean.class);

  public RestPathMatchingFilterChainResolver() {
    super();
  }

  public RestPathMatchingFilterChainResolver(final FilterConfig filterConfig) {
    super(filterConfig);
  }

  @Override
  public FilterChain getChain(final ServletRequest request,
      final ServletResponse response, final FilterChain originalChain) {
    final FilterChainManager filterChainManager = getFilterChainManager();
    if (!filterChainManager.hasChains()) {
      return null;
    }

    final String requestURI = this.getPathWithinApplication(request);
    final Iterator<String> var6 = filterChainManager.getChainNames().iterator();

    String pathPattern;
    boolean flag = true;
    String[] strings = null;
    do {
      if (!var6.hasNext()) {
        return null;
      }

      pathPattern = var6.next();

      strings = pathPattern.split("==");
      if (strings.length == 2) {
        // 分割出url+httpMethod,判断httpMethod和request请求的method是否一致,不一致直接false
        if (WebUtils.toHttp(request).getMethod().toUpperCase()
            .equals(strings[1].toUpperCase())) {
          flag = false;
        } else {
          flag = true;
        }
      } else {
        flag = false;
      }
      pathPattern = strings[0];
    } while (!pathMatches(pathPattern, requestURI) || flag);

    // if (LOGGER.isTraceEnabled()) {
    // LOGGER.trace("Matched path pattern [" + pathPattern + "] for requestURI
    // ["
    // + requestURI + "]. Utilizing corresponding filter chain...");
    // }
    if (strings.length == 2) {
      pathPattern = pathPattern.concat("==")
          .concat(WebUtils.toHttp(request).getMethod().toUpperCase());
    }

    return filterChainManager.proxy(originalChain, pathPattern);
  }

  /**
   * 自定义路径匹配规则，以适应rest风格的API
   * 注意：我们将用带有^$的正则，来替代之前的*
   */
  @Override
  public boolean pathMatches(final String pathPattern,
      final String requestURI) {
    if (pathPattern.startsWith("^")) {// 正则表达式
      return requestURI.matches(pathPattern);
    } else {
      return super.pathMatches(pathPattern, requestURI);
    }
  }
}
