package com.plastech.crm.rpcservice.hystrix;

import org.springframework.stereotype.Service;
import com.plastech.crm.rpcservice.RpcOauthService;
import com.plastech.crmcommon.dto.OauthUserInfo;
import com.plastech.crmcommon.dto.RpcResponse;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月9日 下午5:28:36
 *
 */
@Service
public class RpcOauthServiceHystrix implements RpcOauthService {

  @Override
  public RpcResponse<Long> checkToken(final String token) {
    return new RpcResponse<Long>(false, 0L);
  }

  @Override
  public RpcResponse<String> createToken(final OauthUserInfo user) {
    return new RpcResponse<String>(false, null);
  }

  @Override
  public RpcResponse<Boolean> consumeToken(final String token) {
    return new RpcResponse<Boolean>(false, null);
  }
}
