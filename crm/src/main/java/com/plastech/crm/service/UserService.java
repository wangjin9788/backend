package com.plastech.crm.service;

import java.util.List;
import java.util.Map;
import com.plastech.crm.model.User;
import com.plastech.crm.model.parameter.AddOrUpdateUserParameters;
import com.plastech.crm.model.parameter.ChangePasswordParameters;
import com.plastech.crm.model.vo.MenuInfo;
import com.plastech.crm.model.vo.UserView;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author wangJin
 * @date : 2019年1月10日 上午10:16:54
 */
public interface UserService {

  AppPageModel<List<UserView>> searchUserList(Map<String, Object> map,
      Integer currentpage, Integer perpage);

  ResultJson<Integer> createUser(Long uid, AddOrUpdateUserParameters param);

  User getUserByUid(Long uid);

  ResultJson<Integer> updateUser(Long uid, AddOrUpdateUserParameters param);

  ResultJson<Integer> updateUserStatusByUid(Long uid, Integer status);

  String getUserRoleCodeByUid(Long uid);

  Long checkToken(String token);

  User selectByUcodeOrUphoneOrUmail(String ucode);

  List<MenuInfo> getUserMenu(Long currentUid);

  ResultJson<Object> changePassword(ChangePasswordParameters param, Long uid);

}
