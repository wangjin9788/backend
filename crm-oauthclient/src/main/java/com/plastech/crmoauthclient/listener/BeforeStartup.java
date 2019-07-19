package com.plastech.crmoauthclient.listener;



import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import com.plastech.crmoauthclient.jwt.AeskeyInitUtil;

@Configuration
public class BeforeStartup
    implements ApplicationListener<ContextRefreshedEvent> {


  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event) {
    // after spring init
    // if (event.getApplicationContext().getParent() == null) {
    AeskeyInitUtil.getInstance().initAesKey();
    // }

  }
}
