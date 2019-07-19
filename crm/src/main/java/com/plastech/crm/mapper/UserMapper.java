package com.plastech.crm.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.User;
import com.plastech.crm.model.vo.SalesManagerView;
import com.plastech.crm.model.vo.UserView;

public interface UserMapper extends BaseTkMapper<User> {

  User selectByUcode(String ucode);

  User selectByUcodeOrUphoneOrUmail(String ucode);

  List<UserView> searchUserList(Map<String, Object> map);

  Integer checkPhoneOrMail(@Param(value = "phone") String phone,
      @Param(value = "mail") String mail);

  User selectUserInfoByUid(@Param(value = "uid") Long uid);

  String selectUserNameByUid(@Param(value = "uid") Long uid);

  String selectMail(@Param(value = "mail") String mail);

  List<SalesManagerView> getSalseManagersList();

  User getUserInfoByName(@Param(value = "name") String name);
}
