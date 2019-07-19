package com.plastech.crm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.plastech.crm.model.vo.UserView;
import com.plastech.crm.resultdata.ResultJson;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月9日 下午5:45:54
 *
 */
public interface LoginService {

  ResultJson<UserView> webLogin(HttpServletResponse response, String ucode,
      String password, String language);

  Long checkToken(HttpServletRequest request, HttpServletResponse response);

  ResultJson<Object> logout(String token);

}
