package com.plastech.crmoauthclient.service;

import com.plastech.crmcommon.dto.OauthUserInfo;
import com.plastech.crmcommon.dto.RpcResponse;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月9日 下午1:30:33
 *
 */
public interface OauthService {

  RpcResponse<Long> checkToken(String token);

  RpcResponse<String> createToken(OauthUserInfo user);

  RpcResponse<Boolean> consumeToken(String token);

}
