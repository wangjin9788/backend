package com.plastech.crm.util.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.util.RequestParseUtil;

/**
 *
 *
 * @author : yemin
 * @date : 2018年12月20日 下午4:25:28
 *
 */
public class JWTAuthFilter extends AuthenticatingFilter {

  public static final String AUTHC_TOKEN = "authcToken";
  private final Logger logger = LoggerFactory.getLogger(JWTAuthFilter.class);

  /**
   * 自定义路径匹配规则，以适应rest风格的API
   */
  @Override
  protected boolean pathsMatch(final String path,
      final ServletRequest request) {
    final String requestURI = this.getPathWithinApplication(request);
    // path: url==method eg: http://api/menu==GET 需要解析出path中的url和httpMethod
    final String[] strings = path.split("==");
    if (strings.length <= 1) {
      // 分割出来只有URL
      return regPathMatch(strings[0], requestURI);
      // return super.pathsMatch(strings[0], requestURI);
    } else {
      // 分割出url+httpMethod,判断httpMethod和request请求的method是否一致,有一个不一致就是false
      final String httpMethod =
          WebUtils.toHttp(request).getMethod().toUpperCase();
      if (!httpMethod.equals(strings[1].toUpperCase())) {
        return false;
      } else {
        return regPathMatch(strings[0], requestURI);
      }
    }
    // return super.pathsMatch(path, request);
  }

  // 路径正则匹配
  public boolean regPathMatch(final String urlKey, final String requestURI) {
    if (urlKey.startsWith("^")) {// 正则表达式
      final boolean matchRes = requestURI.matches(urlKey);
      if (matchRes) {
        logger.info("URL正则匹配 ::: > " + urlKey + " ==> " + requestURI);
        return true;
      } else {
        return false;
      }
    } else {
      return super.pathsMatch(urlKey, requestURI);
    }
  }

  /**
   * 父类会在请求进入拦截器后调用该方法，返回true则继续，返回false则会调用onAccessDenied()。这里在不通过时，
   * 还调用了isPermissive()方法，我们后面解释。
   */
  @Override
  protected boolean isAccessAllowed(final ServletRequest servletRequest,
      final ServletResponse servletResponse, final Object mappedValue) {
    if (servletRequest instanceof HttpServletRequest) {
      final HttpServletRequest request = (HttpServletRequest) servletRequest;
      final HttpServletResponse response =
          (HttpServletResponse) servletResponse;
      RequestParseUtil.setOrigin(request, response);// 处理跨域问题
      if ("OPTIONS".equals(request.getMethod().toUpperCase())) {
        return true;
      }
      final String privUrl =
          request.getRequestURI().replace(request.getContextPath(), "");
      final String requestMethod = request.getMethod();
      logger.info("JWTAuth-url : {} , method : {}", privUrl, requestMethod);

    }

    boolean allowed = false;
    try {
      allowed = executeLogin(servletRequest, servletResponse);
    } catch (final IllegalStateException e) { // not found any token
      logger.error("Not found any token");
    } catch (final Exception e) {
      logger.error("Error occurs when login", e);
    }
    return allowed || super.isPermissive(mappedValue);
  }

  // 这里只校验token是否存在，不存在则返回resultcode=9
  // 至于token的合法性校验，返回JWTToken对象确保交给jwtShiroRealm去执行
  // 这个方法返回null的话会直接抛出异常，进入isAccessAllowed（）的异常处理逻辑。
  @Override
  protected AuthenticationToken createToken(final ServletRequest servletRequest,
      final ServletResponse servletResponse) throws Exception {
    final HttpServletRequest request = (HttpServletRequest) servletRequest;
    final String jwtToken = RequestParseUtil.getToken(request);
    if (!Strings.isNullOrEmpty(jwtToken)) {
      return new JWTToken(jwtToken);
    }

    return null;
  }

  /**
   * 如果这个Filter在之前isAccessAllowed（）方法中返回false,则会进入这个方法。我们这里直接返回错误的response
   */
  @Override
  protected boolean onAccessDenied(final ServletRequest request,
      final ServletResponse response) throws Exception {
    final HttpServletRequest httpRequest = (HttpServletRequest) request;
    final HttpServletResponse httpResponse = (HttpServletResponse) response;
    logger.error("Validate token fail");
    final String res =
        JSON.toJSONString(ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_9,
            null, ResultCodeSystem.INVALID_TOKEN));
    httpResponse.setStatus(400);
    httpResponse.setContentType("application/json;charset=UTF-8");
    httpResponse.getWriter().write(res);

    final String isAjaxRequest = httpRequest.getHeader("x-requested-with"); // 是否是ajax请求
    if (isAjaxRequest != null) { // 对于异步请求，服务器中无法直接控制浏览器页面跳转，只能返回特殊状态码，在浏览器中控制
      httpResponse.setStatus(400);
    }
    return false;
  }

  /**
   * 如果调用shiro的login认证失败，会回调这个方法，这里我们什么都不做，因为逻辑放到了onAccessDenied（）中。
   */
  @Override
  protected boolean onLoginFailure(final AuthenticationToken token,
      final AuthenticationException e, final ServletRequest request,
      final ServletResponse response) {
    logger.error("Validate token fail, token:{}, error:{}", token.toString(),
        e.getMessage());
    return false;
  }
}
