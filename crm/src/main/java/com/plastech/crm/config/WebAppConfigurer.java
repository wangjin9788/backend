package com.plastech.crm.config;

import javax.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.plastech.crm.interceptor.TokenVerifyInterceptor;

/**
 *
 * Interceptor Configurer
 *
 * @author yemin:
 * @date 2018年5月11日 下午2:05:22
 *
 */

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

  @Bean
  public TokenVerifyInterceptor createTokenVerifyInterceptor() {
    return new TokenVerifyInterceptor();
  }

  @Override
  public final void addInterceptors(final InterceptorRegistry registry) {
    // 多个拦截器组成一个拦截器链
    // addPathPatterns 用于添加拦截规则
    // excludePathPatterns 用户排除拦截
    registry.addInterceptor(createTokenVerifyInterceptor())
        .addPathPatterns("/**-management/**");
  }

  @Bean
  MultipartConfigElement multipartConfigElement() {
    final MultipartConfigFactory factory = new MultipartConfigFactory();
    factory.setFileSizeThreshold("1KB");
    factory.setMaxFileSize("20480KB");
    factory.setMaxRequestSize("20480KB");
    return factory.createMultipartConfig();
  }

}
