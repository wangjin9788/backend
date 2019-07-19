package com.plastech.crmoauthclient.util;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author : yemin
 * @date : 2018年7月10日 下午2:12:17
 *
 */
@Component
public class RedisUtil {

  private RedisUtil() {}

  private static RedisUtil redisUtil;

  @Resource
  private RedisTemplate<Object, Object> redisTemplate;

  @PostConstruct
  public void init() {
    redisUtil = this;
    redisUtil.redisTemplate = this.redisTemplate;
  }

  public static RedisTemplate<Object, Object> getRedisTemplate() {
    return redisUtil.redisTemplate;
  }

}
