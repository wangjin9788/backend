package com.plastech.crm.rpcservice.hystrix;

import org.springframework.stereotype.Service;
import com.plastech.crm.model.UserDemo;
import com.plastech.crm.rpcservice.UserClient;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月7日 下午3:20:12
 *
 */
@Service
public class UserClientHystrix implements UserClient {

  @Override
  public UserDemo getuserinfo(final String name) {
    throw new NullPointerException(" User getuserinfo() 服务不可用。。");
  }

  @Override
  public String getuserinfostr() {
    return " UserClientHystrix getuserinfostr() is fallback 服务不可用。。";
  }

  @Override
  public String info() {
    return " UserClientHystrix info() is fallback 服务不可用。。";
  }

}
