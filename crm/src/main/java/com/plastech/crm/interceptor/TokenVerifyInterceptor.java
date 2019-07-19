package com.plastech.crm.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.plastech.crm.config.SpringContextHolder;
import com.plastech.crm.service.LoginService;
import com.plastech.crm.service.impl.LoginServiceImpl;
import com.plastech.crm.util.RequestParseUtil;

/**
 *
 * token verify interceptor.
 *
 * @author yemin
 * @date 2018年5月11日 下午2:31:53
 *
 */
public final class TokenVerifyInterceptor extends HandlerInterceptorAdapter {

  private static Logger logger =
      LoggerFactory.getLogger(TokenVerifyInterceptor.class);

  private LoginService loginService;

  /**
   * 方法执行前
   */
  @Override
  public boolean preHandle(final HttpServletRequest request,
      final HttpServletResponse response, final Object handler)
      throws Exception {
    // 处理跨域
    RequestParseUtil.setOrigin(request, response);

    final String requestMethod = request.getMethod();
    if ("OPTIONS".equals(requestMethod)) {
      return true;
    }

    // 1. get requestUrl
    final String privUrl =
        request.getRequestURI().replace(request.getContextPath(), "");
    logger.info("校验token，url：" + privUrl);

    // 2.verify token
    if (loginService == null) {
      loginService = SpringContextHolder.getBean("loginServiceImpl",
          LoginServiceImpl.class);
    }
    final Long uid = loginService.checkToken(request, response);
    if (uid != null && uid > 0) {
      logger.info("Uid=" + uid + " , (Url=" + privUrl + ")");
      RequestParseUtil.setUid(request, uid);
    }

    return true;
  }

  @Override
  public void afterCompletion(final HttpServletRequest httpServletRequest,
      final HttpServletResponse httpServletResponse, final Object object,
      final Exception exception) throws Exception {}

  /**
   * 方法执行中
   *
   * controller处理完成
   */
  @Override
  public void postHandle(final HttpServletRequest httpServletRequest,
      final HttpServletResponse httpServletResponse, final Object object,
      final ModelAndView andView) throws Exception {}

}
