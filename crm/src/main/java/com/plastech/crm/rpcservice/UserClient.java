package com.plastech.crm.rpcservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.plastech.crm.model.UserDemo;
import com.plastech.crm.rpcservice.hystrix.UserClientHystrix;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月7日 下午2:40:18
 *
 */
@FeignClient(value = "spring-cloud-producer",
    fallback = UserClientHystrix.class)
public interface UserClient {

  @RequestMapping(value = "/user-management/userinfo",
      method = RequestMethod.GET)
  public UserDemo getuserinfo(@RequestParam("name") String name);

  @RequestMapping(method = RequestMethod.GET, value = "/getuser")
  public String getuserinfostr();

  @RequestMapping(method = RequestMethod.GET, value = "/info")
  public String info();

}
