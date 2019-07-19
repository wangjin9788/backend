package com.plastech.crm.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import com.plastech.crm.CrmApplication;
import com.plastech.crm.mapper.UserMapper;
import com.plastech.crm.model.User;
import com.plastech.crm.model.parameter.AddOrUpdateUserParameters;
import com.plastech.crm.model.parameter.UpdateUserStatusParameters;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultcode.ResultCodeUser;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.service.impl.UserServiceImpl;

/**
 * @author wangJin
 *
 * @date 2019年1月15日 上午9:41:29
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrmApplication.class)
@WebAppConfiguration
public class UserControllerTest extends BaseTest {

  @Mock
  private UserMapper userMapper;

  @InjectMocks
  private UserServiceImpl userService;

  @InjectMocks
  private UserController userController;

  @Override
  @Before()
  public void setUp() {
    super.setUp();
    ReflectionTestUtils.setField(userController, "userService", userService);
  }

  /**
   * test add user: success
   */
  @Test
  public void testAddUser_Success() {
    final AddOrUpdateUserParameters param = getUserParameters();
    Mockito.when(userMapper.insertSelective(Mockito.any())).thenReturn(1);
    final ResultJson<Integer> createUser =
        userController.createUser(null, param);
    assertEquals("resultcode shall be the same as expected : 0 ",
        createUser.getResultCode().intValue(), ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test add user fail：Invalid name
   */
  @Test
  public void testAddUser_Fail_InvalidName() {
    final AddOrUpdateUserParameters param = getUserParameters();
    param.setName(null);
    final ResultJson<Integer> createUser =
        userController.createUser(null, param);
    assertEquals("resultcode shall be the same as expected : 2001200 ",
        createUser.getResultCode().intValue(),
        ResultCodeUser.RESULT_CODE_2001200);
  }

  /**
   * test add user fail：Invalid mail
   */
  @Test
  public void testAddUser_Fail_InvalidMail() {
    final AddOrUpdateUserParameters param = getUserParameters();
    param.setMail(null);
    final ResultJson<Integer> createUser =
        userController.createUser(null, param);
    assertEquals("resultcode shall be the same as expected : 2001201 ",
        createUser.getResultCode().intValue(),
        ResultCodeUser.RESULT_CODE_2001201);
  }

  /**
   * test add user fail：Invalid roleId
   */
  @Test
  public void testAddUser_Fail_InvalidRoleId() {
    final AddOrUpdateUserParameters param = getUserParameters();
    param.setRoleId(null);
    final ResultJson<Integer> createUser =
        userController.createUser(null, param);
    assertEquals("resultcode shall be the same as expected :2001202 ",
        createUser.getResultCode().intValue(),
        ResultCodeUser.RESULT_CODE_2001202);
  }

  /**
   * test add user fail：Invalid RoleName
   */
  @Test
  public void testAddUser_Fail_InvalidRoleName() {
    final AddOrUpdateUserParameters param = getUserParameters();
    param.setRoleName(null);
    final ResultJson<Integer> createUser =
        userController.createUser(null, param);
    assertEquals("resultcode shall be the same as expected : 2001203 ",
        createUser.getResultCode().intValue(),
        ResultCodeUser.RESULT_CODE_2001203);
  }

  /**
   * test add user fail：Invalid phone
   */
  @Test
  public void testAddUser_Fail_InvalidPhone() {
    final AddOrUpdateUserParameters param = getUserParameters();
    param.setPhone("123");
    final ResultJson<Integer> createUser =
        userController.createUser(null, param);
    assertEquals("resultcode shall be the same as expected : 2001204 ",
        createUser.getResultCode().intValue(),
        ResultCodeUser.RESULT_CODE_2001204);
  }

  /**
   * test add user fail：mail format is not correct
   */
  @Test
  public void testAddUser_MailFormatIsNotCorrect() {
    final AddOrUpdateUserParameters param = getUserParameters();
    param.setMail("123");
    final ResultJson<Integer> createUser =
        userController.createUser(null, param);
    assertEquals("resultcode shall be the same as expected : 2001301 ",
        createUser.getResultCode().intValue(),
        ResultCodeUser.RESULT_CODE_2001301);
  }

  /**
   * test add user fail：mailbox exists
   */
  @Test
  public void testAddUser_Fail_MailboxExists() {
    final AddOrUpdateUserParameters param = getUserParameters();
    Mockito.when(userMapper.selectMail(Mockito.anyString()))
        .thenReturn("123@qq.com");
    final ResultJson<Integer> createUser =
        userController.createUser(null, param);
    assertEquals("resultcode shall be the same as expected : 2001300 ",
        createUser.getResultCode().intValue(),
        ResultCodeUser.RESULT_CODE_2001300);
  }


  private AddOrUpdateUserParameters getUserParameters() {
    final AddOrUpdateUserParameters param = new AddOrUpdateUserParameters();
    param.setMail("123@qq.com");
    param.setName("abc");
    param.setPhone("17688555588");
    param.setRoleId(0L);
    param.setRoleName("admin");
    return param;
  }

  /**
   * test delete user success
   */
  @Test
  public void testDeleteUser_Success() {
    final UpdateUserStatusParameters param = new UpdateUserStatusParameters();
    param.setStatus(-1);
    final User u = new User();
    u.setUid(2L);
    Mockito.when(userMapper.updateByPrimaryKeySelective(Mockito.any()))
        .thenReturn(1);
    Mockito.when(userMapper.selectUserInfoByUid(Mockito.any())).thenReturn(u);
    final ResultJson<Integer> delete =
        userController.updateUserStatusByUid(2L, param, null);
    assertEquals("resultcode shall be the same as expected : 0 ",
        delete.getResultCode().intValue(), ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test delete user Fail：Invalid uId
   */
  @Test
  public void testDeleteUser_Fail_InvalidUid() {
    final UpdateUserStatusParameters param = new UpdateUserStatusParameters();
    final ResultJson<Integer> delete =
        userController.updateUserStatusByUid(null, param, null);
    assertEquals("resultcode shall be the same as expected : 2003200 ",
        delete.getResultCode().intValue(), ResultCodeUser.RESULT_CODE_2003200);
  }

  /**
   * test delete user Fail：Invalid status
   */
  @Test
  public void testDeleteUser_Fail_InvalidStatus() {
    final UpdateUserStatusParameters param = new UpdateUserStatusParameters();
    param.setStatus(500);
    final ResultJson<Integer> delete =
        userController.updateUserStatusByUid(2L, param, null);
    assertEquals("resultcode shall be the same as expected : 2003100 ",
        delete.getResultCode().intValue(), ResultCodeUser.RESULT_CODE_2003100);
  }

  /**
   * test delete user success
   */
  @Test
  public void testDeleteUser_UserNotExist() {
    final UpdateUserStatusParameters param = new UpdateUserStatusParameters();
    param.setStatus(-1);
    Mockito.when(userMapper.selectUserInfoByUid(Mockito.any()))
        .thenReturn(null);
    final ResultJson<Integer> delete =
        userController.updateUserStatusByUid(2L, param, null);
    assertEquals("resultcode shall be the same as expected : 2003300 ",
        delete.getResultCode().intValue(), ResultCodeUser.RESULT_CODE_2003300);
  }

}
