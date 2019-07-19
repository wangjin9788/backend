package com.plastech.crmoauthclient.util;

import java.util.Arrays;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 *
 * @author : yemin
 * @date : 2018年7月10日 上午11:35:08
 *
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

  // 缓存管理器
  @SuppressWarnings("rawtypes")
  @Bean
  public CacheManager cacheManager(final RedisTemplate redisTemplate) {
    final RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
    // 多个缓存的名称,目前只定义了一个
    rcm.setCacheNames(Arrays.asList("thisredis"));
    // 设置缓存过期时间(秒)
    rcm.setDefaultExpiration(600);
    return rcm;
  }

  @SuppressWarnings("rawtypes")
  @Bean
  public RedisTemplate redisTemplate(final RedisConnectionFactory factory) {
    final StringRedisTemplate template = new StringRedisTemplate(factory);
    final Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer =
        new Jackson2JsonRedisSerializer<Object>(Object.class);
    final ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    jackson2JsonRedisSerializer.setObjectMapper(om);
    template.setValueSerializer(jackson2JsonRedisSerializer);
    template.afterPropertiesSet();
    return template;
  }

  // // 缓存管理器
  // @Bean
  // public CacheManager cacheManager(
  // final RedisConnectionFactory connectionFactory) {
  // // user信息缓存配置
  // final RedisCacheConfiguration userCacheConfiguration =
  // RedisCacheConfiguration.defaultCacheConfig()
  // .entryTtl(Duration.ofSeconds(10)).disableCachingNullValues()
  // .prefixKeysWith("user");
  // final Map<String, RedisCacheConfiguration> redisCacheConfigurationMap =
  // new HashMap<>();
  // redisCacheConfigurationMap.put("user", userCacheConfiguration);
  // // 初始化一个RedisCacheWriter
  // final RedisCacheWriter redisCacheWriter =
  // RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
  //
  //
  // //
  // 设置CacheManager的值序列化方式为JdkSerializationRedisSerializer,但其实RedisCacheConfiguration默认就是使用StringRedisSerializer序列化key，JdkSerializationRedisSerializer序列化value,所以以下注释代码为默认实现
  // // ClassLoader loader = this.getClass().getClassLoader();
  // // JdkSerializationRedisSerializer jdkSerializer = new
  // // JdkSerializationRedisSerializer(loader);
  // // RedisSerializationContext.SerializationPair<Object> pair =
  // //
  // RedisSerializationContext.SerializationPair.fromSerializer(jdkSerializer);
  // // RedisCacheConfiguration defaultCacheConfig =
  // // RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
  //
  // final RedisCacheConfiguration defaultCacheConfig =
  // RedisCacheConfiguration.defaultCacheConfig();
  //
  // // 设置默认超过期时间是30秒
  // defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
  // // 初始化RedisCacheManager
  // final RedisCacheManager cacheManager = new RedisCacheManager(
  // redisCacheWriter, defaultCacheConfig, redisCacheConfigurationMap);
  // return cacheManager;
  // }

}
