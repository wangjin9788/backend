package com.plastech.crmoauthclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plastech.crmcommon.dto.OauthUserInfo;
import com.plastech.crmcommon.dto.RpcResponse;
import com.plastech.crmoauthclient.service.OauthService;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月7日 下午1:19:10
 *
 */
@RestController
@RequestMapping("/oauth-management")
public class OauthController {

  @Autowired
  private OauthService oauthService;

  /**
   * check token
   *
   * @param token
   * @return
   */
  @PostMapping("/tokens/check")
  public RpcResponse<Long> checkToken(@RequestBody final String token) {
    return oauthService.checkToken(token);
  }

  /**
   * create token
   *
   * @param user
   * @return
   */
  @PostMapping("/tokens/create")
  public RpcResponse<String> createToken(
      @RequestBody final OauthUserInfo user) {
    return oauthService.createToken(user);
  }

  /**
   * consume token
   *
   * @param token
   * @return
   */
  @PostMapping("/tokens/consume")
  public RpcResponse<Boolean> consumeToken(@RequestBody final String token) {
    return oauthService.consumeToken(token);
  }
}
