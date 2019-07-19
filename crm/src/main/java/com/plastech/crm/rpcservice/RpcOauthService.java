package com.plastech.crm.rpcservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.plastech.crm.rpcservice.hystrix.RpcOauthServiceHystrix;
import com.plastech.crmcommon.dto.OauthUserInfo;
import com.plastech.crmcommon.dto.RpcResponse;
import feign.Headers;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月9日 下午5:27:04
 *
 */
@FeignClient(value = "crmOauthClient", fallback = RpcOauthServiceHystrix.class)
public interface RpcOauthService {

  /**
   * Verify token
   *
   * @param token
   * @return
   */
  @RequestMapping(value = "/oauth-management/tokens/check",
      method = RequestMethod.POST)
  @Headers("Content-Type: application/json")
  RpcResponse<Long> checkToken(String token);

  /**
   * Create a new token
   *
   * @param user
   * @return
   */
  @RequestMapping(value = "/oauth-management/tokens/create",
      method = RequestMethod.POST)
  @Headers("Content-Type: application/json")
  RpcResponse<String> createToken(OauthUserInfo user);

  /**
   * Consume token
   *
   * @param user
   * @return
   */
  @RequestMapping(value = "/oauth-management/tokens/consume",
      method = RequestMethod.POST)
  @Headers("Content-Type: application/json")
  RpcResponse<Boolean> consumeToken(String token);

}
