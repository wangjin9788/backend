package com.plastech.crm.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.plastech.crm.mapper.LinkmanMapper;
import com.plastech.crm.mapper.MiddleCustomerLinkmanMapper;
import com.plastech.crm.model.Customer;
import com.plastech.crm.model.parameter.AddOrUpdateCustomerParameters;
import com.plastech.crm.model.parameter.AddOrUpdateLinkmanParameter;
import com.plastech.crm.resultcode.ResultCodeCustomer;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.service.impl.CustomerServiceImpl;

/**
 * @author wangJin
 *
 * @date 2019年2月11日 下午2:24:33
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrmApplication.class)
@WebAppConfiguration
public class CustomerControllerTest extends BaseTest {

  @Mock
  private CustomerMapper customerMapper;

  @Mock
  private LinkmanMapper linkmanMapper;

  @Mock
  private MiddleCustomerLinkmanMapper middleCustomerLinkmanMapper;

  @InjectMocks
  private CustomerServiceImpl customerService;

  @InjectMocks
  private CustomerController customerController;

  @Override
  @Before()
  public void setUp() {
    super.setUp();
    ReflectionTestUtils.setField(customerController, "customerService",
        customerService);
  }

  /**
   * test add customer : success
   */
  @Test
  public void testAddCustomer_Success() {
    final AddOrUpdateCustomerParameters param = getCustomerParameters();
    Mockito.when(customerMapper.checkBranchDoesItExist(Mockito.anyString(),
        Mockito.any())).thenReturn(false);
    Mockito.when(customerMapper.insertSelective(Mockito.any())).thenReturn(1);
    final ResultJson<Boolean> addCustomer =
        customerController.addCustomer(param, null);
    assertEquals("resultcode shall be the same as expected : 0 ",
        addCustomer.getResultCode().intValue(), ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test add customer fail customer branch exists
   */
  @Test
  public void testAddCustomer_Fail_CustomerBranchExists() {
    final AddOrUpdateCustomerParameters param = getCustomerParameters();
    Mockito.when(customerMapper.checkBranchDoesItExist(Mockito.anyString(),
        Mockito.any())).thenReturn(true);
    final ResultJson<Boolean> addCustomer =
        customerController.addCustomer(param, null);
    assertEquals("resultcode shall be the same as expected : 7001302",
        addCustomer.getResultCode().intValue(),
        ResultCodeCustomer.RESULT_CODE_7001302);
  }

  /**
   * test add customer fail ：invalid cuName
   */
  @Test
  public void testAddCustomer_Fail_InvalidCuName() {
    final AddOrUpdateCustomerParameters param = getCustomerParameters();
    param.setCuName(null);
    final ResultJson<Boolean> addCustomer =
        customerController.addCustomer(param, null);
    assertEquals("resultcode shall be the same as expected : 7001200",
        addCustomer.getResultCode().intValue(),
        ResultCodeCustomer.RESULT_CODE_7001200);
  }

  /**
   * test add customer fail invalid gId
   */
  @Test
  public void testAddCustomer_Fail_InvalidGid() {
    final AddOrUpdateCustomerParameters param = getCustomerParameters();
    param.setGid(-1L);
    final ResultJson<Boolean> addCustomer =
        customerController.addCustomer(param, null);
    assertEquals("resultcode shall be the same as expected : 7001201",
        addCustomer.getResultCode().intValue(),
        ResultCodeCustomer.RESULT_CODE_7001201);
  }

  /**
   * test add customer fail Invalid linkmanName
   */
  @Test
  public void testAddCustomer_Fail_InvalidLinkmanName() {
    final AddOrUpdateCustomerParameters param = getCustomerParameters();
    final AddOrUpdateLinkmanParameter linkParam =
        new AddOrUpdateLinkmanParameter();
    final List<AddOrUpdateLinkmanParameter> list =
        new ArrayList<AddOrUpdateLinkmanParameter>();
    linkParam.setName(null);
    linkParam.setLkArea("+86");
    list.add(linkParam);
    param.setLinkmanList(list);
    final ResultJson<Boolean> addCustomer =
        customerController.addCustomer(param, null);
    assertEquals("resultcode shall be the same as expected : 7001202",
        addCustomer.getResultCode().intValue(),
        ResultCodeCustomer.RESULT_CODE_7001202);
  }


  private AddOrUpdateCustomerParameters getCustomerParameters() {
    final AddOrUpdateCustomerParameters param =
        new AddOrUpdateCustomerParameters();
    param.setGid(1L);
    param.setCuName("123");
    param.setCuAddress("广东省深圳市");
    return param;
  }

  /**
   * test delete customer ：Success
   */
  @Test
  public void testDeleteCustomer_Success() {
    final Customer customer = new Customer();
    customer.setCuid(1L);
    customer.setStatus(0);
    Mockito.when(customerMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(customer);
    Mockito.when(customerMapper.updateByPrimaryKey(Mockito.any()))
        .thenReturn(1);
    Mockito.when(middleCustomerLinkmanMapper
        .deleteCustomerLinkmanInfoByCuid(Mockito.anyLong())).thenReturn(1);
    final ResultJson<Boolean> deleteCustomer =
        customerController.deleteCustomer(1L);
    assertEquals("resultcode shall be the same as expected : 0",
        deleteCustomer.getResultCode().intValue(),
        ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test delete customer fail：Customer Branch Exists
   */
  @Test
  public void testDeleteCustomer_Fail_CustomerBranchExists() {
    Mockito.when(customerMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(null);
    final ResultJson<Boolean> deleteCustomer =
        customerController.deleteCustomer(1L);
    assertEquals("resultcode shall be the same as expected : 7003300",
        deleteCustomer.getResultCode().intValue(),
        ResultCodeCustomer.RESULT_CODE_7003300);
  }

  /**
   * test delete customer fail ：Invalid CuId
   */
  @Test
  public void testDeleteCustomer_Fail_InvalidCuid() {
    final ResultJson<Boolean> deleteCustomer =
        customerController.deleteCustomer(-1L);
    assertEquals("resultcode shall be the same as expected : 7003200",
        deleteCustomer.getResultCode().intValue(),
        ResultCodeCustomer.RESULT_CODE_7003200);
  }
}
