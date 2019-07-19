package com.plastech.crmoauthclient.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import com.plastech.crmcommon.dto.OauthUserInfo;
import com.plastech.crmcommon.dto.RpcResponse;
import com.plastech.crmoauthclient.jwt.JWTUtil;
import com.plastech.crmoauthclient.service.OauthService;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月9日 下午1:31:06
 *
 */
@Service
public class OauthServiceImpl implements OauthService {

  protected static Logger logger =
      LoggerFactory.getLogger(OauthServiceImpl.class);

  @Override
  public RpcResponse<Long> checkToken(final String token) {
    try {
      final Long start = System.currentTimeMillis();
      logger.info("开始校验身份-->toen=" + token);
      final Long uid = JWTUtil.checkUserToken(token);
      final Long end = System.currentTimeMillis();
      logger.info("本次身份校验耗时-->" + (end - start) + ",uid:" + uid);
      return new RpcResponse<Long>(true, uid);
    } catch (final Exception e) {
      logger.info("rpc error", e);
    }

    return new RpcResponse<Long>(false, null);
  }

  @Override
  public RpcResponse<String> createToken(final OauthUserInfo ut) {
    try {
      final String token = JWTUtil.produceToken(ut);//制作令牌
      if (!Strings.isNullOrEmpty(token)) {
        return new RpcResponse<String>(true, token);
      }
    } catch (final Exception e) {
      logger.info("rpc error", e);
    }
    return new RpcResponse<String>(false, null);
  }

  @Override
  public RpcResponse<Boolean> consumeToken(final String token) {
    try {
      return new RpcResponse<Boolean>(true, JWTUtil.consumeToken(token));
    } catch (final Exception e) {
      logger.info("rpc error", e);
    }
    return new RpcResponse<Boolean>(false, null);
  }

}
