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
import com.plastech.crm.mapper.LinkmanMapper;
import com.plastech.crm.mapper.MiddleSupplierLinkmanMapper;
import com.plastech.crm.mapper.SupplierMapper;
import com.plastech.crm.model.Supplier;
import com.plastech.crm.model.parameter.AddOrUpdateLinkmanParameter;
import com.plastech.crm.model.parameter.AddOrUpdateSupplierParameters;
import com.plastech.crm.resultcode.ResultCodeSupplier;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.service.impl.SupplierServiceImpl;

/**
 * @author wangJin
 *
 * @date 2019年1月16日 上午10:55:11
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrmApplication.class)
@WebAppConfiguration
public class SupplierControllerTest extends BaseTest {
  @Mock
  private SupplierMapper supplierMapper;

  @Mock
  private LinkmanMapper linkmanMapper;

  @Mock
  private MiddleSupplierLinkmanMapper middleSupplierLinkmanMapper;

  @InjectMocks
  private SupplierServiceImpl supplierService;

  @InjectMocks
  private SupplierController supplierController;


  @Override
  @Before
  public void setUp() {
    super.setUp();
    ReflectionTestUtils.setField(supplierController, "supplierService",
        supplierService);
  }

  /**
   * test add supplier：success
   */
  @Test
  public void testAdiandSupplier_Success() {
    final AddOrUpdateSupplierParameters param = getParamters();
    Mockito.when(supplierMapper.insert(Mockito.any())).thenReturn(1);
    Mockito.when(linkmanMapper.insertSelective(Mockito.any())).thenReturn(1);
    Mockito.when(middleSupplierLinkmanMapper.insertSelective(Mockito.any()))
        .thenReturn(1);
    final ResultJson<Boolean> addSupplier =
        supplierController.addSupplier(param, null);
    assertEquals("resultcode shall be the same as expected : 0 ",
        addSupplier.getResultCode().intValue(), ResultCodeSystem.RESULT_CODE_0);
  }


  /**
   * test add supplier fail : invalid name
   */
  @Test
  public void testAddSupplier_Fail_InvalidName() {
    final AddOrUpdateSupplierParameters param = getParamters();
    param.setSuName(null);
    final ResultJson<Boolean> addSupplier =
        supplierController.addSupplier(param, null);
    assertEquals("resultcode shall be the same as expected : 10001101 ",
        addSupplier.getResultCode().intValue(),
        ResultCodeSupplier.RESULT_CODE_10001101);
  }

  /**
   * test add supplier fail : Invalid linkman Name
   */
  @Test
  public void testAddSupplier_Fail_InvalidLinkmanName() {
    final AddOrUpdateSupplierParameters param = getParamters();
    final AddOrUpdateLinkmanParameter linkParam =
        new AddOrUpdateLinkmanParameter();
    final List<AddOrUpdateLinkmanParameter> list =
        new ArrayList<AddOrUpdateLinkmanParameter>();
    linkParam.setName(null);
    linkParam.setLkArea("+86");
    list.add(linkParam);
    param.setLinkmanList(list);
    final ResultJson<Boolean> addSupplier =
        supplierController.addSupplier(param, null);
    assertEquals("resultcode shall be the same as expected : 10002201 ",
        addSupplier.getResultCode().intValue(),
        ResultCodeSupplier.RESULT_CODE_10002201);
  }


  /**
   * test add supplier ：supplier name is already exists
   */
  @Test
  public void testAddSupplier_SupplierNameIsAlreadyExists() {
    final AddOrUpdateSupplierParameters param = getParamters();
    final Supplier su = new Supplier();
    Mockito.when(supplierMapper.selectSuname(Mockito.any())).thenReturn(su);
    final ResultJson<Boolean> addSupplier =
        supplierController.addSupplier(param, null);
    assertEquals("resultcode shall be the same as expected : 10001300 ",
        addSupplier.getResultCode().intValue(),
        ResultCodeSupplier.RESULT_CODE_10001300);
  }

  private AddOrUpdateSupplierParameters getParamters() {
    final AddOrUpdateSupplierParameters param =
        new AddOrUpdateSupplierParameters();
    param.setSuName("su");
    return param;
  }

  /**
   * test delete supplier ：success
   */
  @Test
  public void testDeleteSupplier_Success() {
    Mockito.when(supplierMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(new Supplier());
    Mockito.when(supplierMapper.updateByPrimaryKey(Mockito.any()))
        .thenReturn(5);
    final ResultJson<Boolean> deleteSupplier =
        supplierController.deleteSupplier(1L, null);
    assertEquals("resultcode shall be the same as expected : 0 ",
        deleteSupplier.getResultCode().intValue(),
        ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test delete supplier fail：invalid suid
   */
  @Test
  public void testDeleteSupplier_Fail_InvalidSuid() {
    final ResultJson<Boolean> deleteSupplier =
        supplierController.deleteSupplier(null, null);
    assertEquals("resultcode shall be the same as expected : 10003200 ",
        deleteSupplier.getResultCode().intValue(),
        ResultCodeSupplier.RESULT_CODE_10003200);
  }

  /**
   * test delete supplier fail delete does not exists
   */
  @Test
  public void testDeleteSupplier_Fail_DeleteDoesNotExists() {
    Mockito.when(supplierMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(null);
    final ResultJson<Boolean> deleteSupplier =
        supplierController.deleteSupplier(1L, null);
    assertEquals("resultcode shall be the same as expected : 10003300 ",
        deleteSupplier.getResultCode().intValue(),
        ResultCodeSupplier.RESULT_CODE_10003300);
  }
}
