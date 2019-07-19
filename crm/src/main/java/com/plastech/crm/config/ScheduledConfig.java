package com.plastech.crm.config;

import java.time.Duration;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.ScheduledLockConfiguration;
import net.javacrumbs.shedlock.spring.ScheduledLockConfigurationBuilder;


/**
 * @author 王进
 *
 */
@Component
@Configurable
@EnableScheduling
public class ScheduledConfig {

  @Bean
  public LockProvider lockProvider(final DataSource dataSource) {
    return new JdbcTemplateLockProvider(dataSource);
  }

  @Bean
  public ScheduledLockConfiguration scheduledLockConfiguration(
      final LockProvider lockProvider) {
    return ScheduledLockConfigurationBuilder.withLockProvider(lockProvider)
        .withPoolSize(10).withDefaultLockAtMostFor(Duration.ofMinutes(10))
        .build();
  }

}

