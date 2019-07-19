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
import com.plastech.crm.mapper.CustomerMapper;
import com.plastech.crm.mapper.GroupsMapper;
import com.plastech.crm.model.Groups;
import com.plastech.crm.model.parameter.AddOrUpdateGroupsParameters;
import com.plastech.crm.resultcode.ResultCodeGroups;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.service.impl.GroupsServiceImpl;

/**
 * @author wangJin
 *
 * @date 2019年1月16日 下午1:21:33
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrmApplication.class)
@WebAppConfiguration
public class GroupsControllerTest extends BaseTest {

  @Mock
  private CustomerMapper customerMapper;

  @Mock
  private GroupsMapper groupsMapper;

  @InjectMocks
  private GroupsServiceImpl groupsService;

  @InjectMocks
  private GroupsController groupsController;

  @Override
  @Before
  public void setUp() {
    super.setUp();
    ReflectionTestUtils.setField(groupsController, "groupsService",
        groupsService);
  }

  /**
   * test Groups: Success
   */
  @Test
  public void testAddGroups_Success() {
    final AddOrUpdateGroupsParameters param = getParam();
    param.setCode(500);
    Mockito.when(groupsMapper.insertSelective(Mockito.any())).thenReturn(1);
    final ResultJson<Boolean> addGroups =
        groupsController.addGroups(param, null);
    assertEquals("resultcode shall be the same as expected : 0 ",
        addGroups.getResultCode().intValue(), ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test add groups fail：missing name
   */
  @Test
  public void testAddGroups_Fail_MissingName() {
    final AddOrUpdateGroupsParameters param = getParam();
    param.setName(null);
    final ResultJson<Boolean> addGroups =
        groupsController.addGroups(param, null);
    assertEquals("resultcode shall be the same as expected : 11001100 ",
        addGroups.getResultCode().intValue(),
        ResultCodeGroups.RESULT_CODE_11001100);
  }

  /**
   * test Add Groups Fail：Missing Type
   */
  @Test
  public void testAddGroups_Fail_MissingType() {
    final AddOrUpdateGroupsParameters param = getParam();
    param.setType(100);
    final ResultJson<Boolean> addGroups =
        groupsController.addGroups(param, null);
    assertEquals("resultcode shall be the same as expected : 11001200 ",
        addGroups.getResultCode().intValue(),
        ResultCodeGroups.RESULT_CODE_11001200);
  }

  /**
   * test Add groups fail groups name is already exists
   */
  @Test
  public void testAddGroups_Fail_GroupsNameIsAlreadyExists() {
    final AddOrUpdateGroupsParameters param = getParam();
    param.setGid(12L);
    final Groups grop = new Groups();
    grop.setName("group");
    Mockito.when(groupsMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(grop);
    Mockito.when(
        groupsMapper.selectByNameAndType(Mockito.anyString(), Mockito.anyInt()))
        .thenReturn(grop);
    final ResultJson<Boolean> addGroups =
        groupsController.addGroups(param, null);
    assertEquals("resultcode shall be the same as expected : 11001300 ",
        addGroups.getResultCode().intValue(),
        ResultCodeGroups.RESULT_CODE_11001300);
  }

  private AddOrUpdateGroupsParameters getParam() {
    final AddOrUpdateGroupsParameters param = new AddOrUpdateGroupsParameters();
    param.setCode(0);
    param.setName("groups");
    param.setType(0);
    return param;
  }

  @Test
  public void testDeleteGroups_Success() {
    final Groups groups = new Groups();
    groups.setCode(1);
    Mockito.when(groupsMapper.selectByPrimaryKey(1L)).thenReturn(groups);
    Mockito
        .when(
            customerMapper.checkBranchDoesItExist(Mockito.any(), Mockito.any()))
        .thenReturn(false);
    Mockito.when(groupsMapper.updateByPrimaryKeySelective(groups))
        .thenReturn(1);
    final ResultJson<Boolean> deleteGroups = groupsController.deleteGroups(1L,null);
    assertEquals("resultcode shall be the same as expected : 0 ",
        deleteGroups.getResultCode().intValue(),
        ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test delete groups Fail_MissingGid
   */
  @Test
  public void testDeleteGroups_Fail_MissingGid() {
    final ResultJson<Boolean> deleteGroups = groupsController.deleteGroups(-1L,null);
    assertEquals("resultcode shall be the same as expected : 11003200",
        deleteGroups.getResultCode().intValue(),
        ResultCodeGroups.RESULT_CODE_11003200);
  }
/**
 * test delete groups Fail doesNotExist
 */
  @Test
  public void testDeleteGroups_Fail_doesNotExist() {
    Mockito.when(groupsMapper.selectByPrimaryKey(1L)).thenReturn(null);
    final ResultJson<Boolean> deleteGroups = groupsController.deleteGroups(1L,null);
    assertEquals("resultcode shall be the same as expected : 11003300 ",
        deleteGroups.getResultCode().intValue(),
        ResultCodeGroups.RESULT_CODE_11003300);
  }

  /**
   * test delete groups Fail Existence Of Correlation
   */
  @Test
  public void testDeleteGroups_Fail_ExistenceOfCorrelation() {
    final Groups groups = new Groups();
    groups.setCode(1);
    Mockito.when(groupsMapper.selectByPrimaryKey(1L)).thenReturn(groups);
    Mockito
        .when(
            customerMapper.checkBranchDoesItExist(Mockito.any(), Mockito.any()))
        .thenReturn(true);
    final ResultJson<Boolean> deleteGroups = groupsController.deleteGroups(1L,null);
    assertEquals("resultcode shall be the same as expected : 11003301 ",
        deleteGroups.getResultCode().intValue(),
        ResultCodeGroups.RESULT_CODE_11003301);
  }

}
