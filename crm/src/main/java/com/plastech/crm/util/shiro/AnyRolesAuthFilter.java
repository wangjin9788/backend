package com.plastech.crm.util.shiro;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.util.RequestParseUtil;

/**
 *
 *
 * @author : yemin
 * @date : 2018年12月20日 下午5:07:28
 *
 */
public class AnyRolesAuthFilter extends AuthorizationFilter {

  public static final String ANY_ROLE = "anyRole";
  private static final Logger logger =
      LoggerFactory.getLogger(AnyRolesAuthFilter.class);

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
      return super.pathsMatch(strings[0], requestURI);
    } else {
      // 分割出url+httpMethod,判断httpMethod和request请求的method是否一致,不一致直接false
      final String httpMethod =
          WebUtils.toHttp(request).getMethod().toUpperCase();
      return httpMethod.equals(strings[1].toUpperCase())
          && super.pathsMatch(strings[0], requestURI);
    }

    // return super.pathsMatch(path, request);
  }

  /**
   * mappedValue : filterChain中配置的value
   */
  @Override
  protected boolean isAccessAllowed(final ServletRequest servletRequest,
      final ServletResponse servletResponse, final Object mappedValue)
      throws Exception {
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

      // APP端暂时不需要做角色校验
      if (RequestParseUtil.isAppPlatform(request)) {
        logger.info("App - RoleAuth Cancel : ");
        return true;
      }
    }

    final Subject subject = getSubject(servletRequest, servletResponse);
    final String[] rolesArray = (String[]) mappedValue;
    if (rolesArray == null || rolesArray.length == 0) { // 没有角色限制，有权限访问
      return true;
    }
    if (rolesArray.length == 1 && "ALL_FORBIDDEN".equals(rolesArray[0])) {
      return false;
    }
    for (final String role : rolesArray) {
      if (subject.hasRole(role)) { // 若当前用户是rolesArray中的任何一个，则有权限访问
        logger.info("Authority pass ,role : " + role);
        return true;
      }
    }
    return false;

  }

  /**
   * 权限校验失败，错误处理
   */
  @Override
  protected boolean onAccessDenied(final ServletRequest servletRequest,
      final ServletResponse servletResponse) throws IOException {
    final HttpServletRequest request = (HttpServletRequest) servletRequest;
    final HttpServletResponse response = (HttpServletResponse) servletResponse;
    final String res =
        JSON.toJSONString(ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_401,
            null, ResultCodeSystem.NO_PERMISSION));
    response.setStatus(401);
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(res);
    final String isAjaxRequest = request.getHeader("x-requested-with"); //
    // 是否是ajax请求
    if (isAjaxRequest != null) { //
      // 对于异步请求，服务器中无法直接控制浏览器页面跳转，只能返回特殊状态码，在浏览器中控制
      response.setStatus(401);
    }
    logger.info("No permission : ");
    return false;
  }

}
