package com.plastech.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import com.plastech.crm.model.Role;
import com.plastech.crm.model.User;
import com.plastech.crm.model.parameter.AddOrUpdateUserParameters;
import com.plastech.crm.model.parameter.ChangePasswordParameters;
import com.plastech.crm.model.vo.MenuInfo;
import com.plastech.crm.model.vo.UserView;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultcode.ResultCodeUser;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.rpcservice.RpcOauthService;
import com.plastech.crm.service.UserService;
import com.plastech.crm.util.AppPage;
import com.plastech.crm.util.CommonTools;
import com.plastech.crm.util.PasswordStorage;
import com.plastech.crm.util.UniqueStringGenerator;
import com.plastech.crmcommon.dto.RpcResponse;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author wangJin
 *
 * @date : 2019年1月10日 上午10:21:30
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

  @Autowired
  private RpcOauthService oauthClient;

  @Override
  public AppPageModel<List<UserView>> searchUserList(
      final Map<String, Object> map, final Integer currentpage,
      final Integer perpage) {
    final AppPage<List<UserView>> page = new AppPage<>(perpage, currentpage);
    page.start();
    // status 100 查询全部
    final List<UserView> searchUserList = userMapper.searchUserList(map);
    page.setResult(searchUserList);
    return page.convertToAppPageModel();
  }

  @Override
  public ResultJson<Integer> createUser(final Long uid,
      final AddOrUpdateUserParameters param) {
    try {
      final String mail = userMapper.selectMail(param.getMail());
      if (!Strings.isNullOrEmpty(mail)) {
        return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2001300);
      }
      final User user = new User();
      // 初始化密码
      final String pwdMd5 =
          PasswordStorage.createHash("67b2cea5146593bd19364b439de60a34");// #1234567

      user.setPwd(pwdMd5);
      final Long roleId = param.getRoleId();
      user.setUname(param.getName());
      user.setArea("+852");
      user.setUphone(param.getPhone());
      user.setUmail(param.getMail());
      user.setPosition("");
      user.setRoleid(roleId);
      user.setRolename(param.getRoleName());
      user.setCreateId(uid);
      user.setCreateTime(new Date());
      user.setUstatus(0);
      user.setUcode(param.getName());
      userMapper.insertSelective(user);

      final String uname = UniqueStringGenerator.getUniqueUid(user.getUid());
      user.setUnumber("ID" + uname);
      if (param.getName() != null) {
        user.setUname(param.getName());
      } else {
        user.setUname(uname);
      }
      userMapper.updateByPrimaryKey(user);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, 0,
          ResultCodeSystem.ADD_SUCCESS);
    } catch (final Exception e) {
      logger.info("add user{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, -1,
        ResultCodeSystem.ADD_FAIL);
  }

  @Override
  public ResultJson<Integer> updateUser(final Long uid,
      final AddOrUpdateUserParameters param) {
    try {
      final User user = userMapper.selectUserInfoByUid(uid);
      if (user == null) {
        return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2002300);
      }
      // 校验手机号和邮箱是否存在
      final String mail = userMapper.selectMail(param.getMail());
      if (!Strings.isNullOrEmpty(mail)) {
        if (!mail.equals(user.getUmail())) {
          return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2002301);
        }
      }
      user.setUname(param.getName());
      user.setRoleid(param.getRoleId());
      user.setUmail(param.getMail());
      user.setUphone(param.getPhone());
      user.setRolename(param.getRoleName());
      user.setUcode(param.getName());
      userMapper.updateByPrimaryKey(user);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, 0,
          ResultCodeSystem.SAVE_SUCCESS);
    } catch (final Exception e) {
      logger.info("add user{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, -1,
        ResultCodeSystem.SAVE_FAIL);
  }

  @Override
  public User getUserByUid(final Long uid) {
    return userMapper.selectByPrimaryKey(uid);
  }

  @Override
  public ResultJson<Integer> updateUserStatusByUid(final Long uid,
      final Integer status) {
    try {
      final User user = userMapper.selectUserInfoByUid(uid);
      if (user == null) {
        return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2003300);
      }
      user.setUstatus(status);
      userMapper.updateByPrimaryKeySelective(user);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, 0,
          ResultCodeSystem.SAVE_SUCCESS);
    } catch (final Exception e) {
      logger.info("update status error{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, -1,
        ResultCodeSystem.SAVE_FAIL);
  }

  @Override
  public String getUserRoleCodeByUid(final Long uid) {
    final Role role = roleMapper.selectRoleByUid(uid);
    return role != null ? role.getCode() : null;
  }

  @Override
  public Long checkToken(final String token) {
    try {
      if (!Strings.isNullOrEmpty(token)) {
        final RpcResponse<Long> checkRes = oauthClient.checkToken(token);
        if (checkRes.isSuccess()) {
          final Long uid = checkRes.getResultData();
          return uid;
        }
      }
    } catch (final Exception e) {
      logger.error("Check token failure , {}", e);
    }
    return 0L;
  }

  @Override
  public User selectByUcodeOrUphoneOrUmail(final String ucode) {
    return userMapper.selectByUcodeOrUphoneOrUmail(ucode);
  }

  @Override
  public List<MenuInfo> getUserMenu(final Long currentUid) {
    final User user = userMapper.selectByPrimaryKey(currentUid);
    if (user == null || user.getRoleid() == null) {
      return null;
    }

    // 查出有权限的第三级菜单，以及所有第一和第二级菜单
    final List<MenuInfo> thirdMenuDataList =
        menuMapper.getUserThirdLevelMenusByRoleidForShiro(user.getRoleid());

    // 查出所有的第一和第二级菜单
    final List<MenuInfo> fsMenuDataList =
        menuMapper.getAllFirstAndSecondLevelMenusForShiro();

    final List<MenuInfo> resMenuList = new ArrayList<>();// 返回的数据
    if (!CommonTools.isListNullOrEmpty(fsMenuDataList)) {
      for (final MenuInfo firstMenu : fsMenuDataList) {
        final Integer firstType = firstMenu.getType();
        if (firstType == 0) {// 是一级菜单
          final String firstCode = firstMenu.getCode();
          final List<MenuInfo> subMenuForFirst = getSecondMenusByFirstCode(
              firstCode, fsMenuDataList, thirdMenuDataList);
          if (subMenuForFirst.size() > 0) {// 一级菜单下有二级菜单
            firstMenu.setSub(subMenuForFirst);
            resMenuList.add(firstMenu);
          }
        }
      }
    }

    return resMenuList;
  }

  // 得到一级菜单下的二级菜单，以及二级菜单下的三级菜单
  private List<MenuInfo> getSecondMenusByFirstCode(final String firstCode,
      final List<MenuInfo> fsMenuDataList,
      final List<MenuInfo> thirdMenuDataList) {
    final List<MenuInfo> subMenuForFirst = new ArrayList<>();// 存放一级菜单下的二级菜单
    for (final MenuInfo secondMenu : fsMenuDataList) {
      final Integer secType = secondMenu.getType();
      final String parentCode = secondMenu.getParentCode();
      if (secType == 1 && firstCode.equals(parentCode)) {// 是一级菜单下的二级菜单
        final String secCode = secondMenu.getCode();
        final List<MenuInfo> subMenuForSec =
            getThirdMenusBySecondCode(secCode, thirdMenuDataList);// 查询二级菜单下的所有三级菜单
        if (subMenuForSec.size() > 0) {// 该二级菜单下有三级菜单
          secondMenu.setSub(subMenuForSec);// 为二级菜单设置三级菜单
          subMenuForFirst.add(secondMenu);// 为一级菜单设置二级菜单
        }
      }
    }
    return subMenuForFirst;
  }

  // 得到二级菜单下的三级菜单
  private List<MenuInfo> getThirdMenusBySecondCode(final String secCode,
      final List<MenuInfo> thirdMenuDataList) {
    final List<MenuInfo> subMenuForSec = new ArrayList<>();// 存放二级菜单下的三级菜单
    for (final MenuInfo thirdMenu : thirdMenuDataList) {
      final String parentCode2 = thirdMenu.getParentCode();
      if (secCode.equals(parentCode2)) {// 是二级菜单下的三级菜单
        subMenuForSec.add(thirdMenu);
      }
    }
    return subMenuForSec;
  }

  @Override
  public ResultJson<Object> changePassword(final ChangePasswordParameters param,
      final Long uid) {
    try {
      final User user = userMapper.selectByPrimaryKey(uid);
      if (user == null) {
        return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_9);
      }
      final boolean verifyPassword =
          PasswordStorage.verifyPassword(param.getOldPassword(), user.getPwd());
      if (!verifyPassword) {
        return ResultUtil.getResult(ResultCodeUser.RESULT_CODE_2004300);
      }
      final String pwdHash = PasswordStorage.createHash(param.getNewPassword());
      if (logger.isDebugEnabled()) {
        logger.debug("oldPwd: {}", param.getOldPassword());
        logger.debug("newPwd: {}", param.getNewPassword());
        logger.debug("newPwd_db: {}", pwdHash);
      }
      user.setPwd(pwdHash);
      userMapper.updateByPrimaryKey(user);
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, null,
          ResultCodeSystem.OPERATE_SUCCESS);
    } catch (final Exception e) {
      logger.info("exception{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, null,
        ResultCodeSystem.OPERATE_FAIL);
  }
}
