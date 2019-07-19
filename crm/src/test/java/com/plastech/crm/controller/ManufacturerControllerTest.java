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
import com.plastech.crm.mapper.GradeMapper;
import com.plastech.crm.mapper.ManufacturerMapper;
import com.plastech.crm.model.Manufacturer;
import com.plastech.crm.model.parameter.ManufacturerParameters;
import com.plastech.crm.resultcode.ResultCodeManufacturer;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.service.impl.ManufacturerServiceImpl;

/**
 * @author wangJin
 *
 * @date 2019年1月15日 上午11:15:31
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrmApplication.class)
@WebAppConfiguration
public class ManufacturerControllerTest extends BaseTest {

  @Mock
  private ManufacturerMapper manufacturerMapper;

  @Mock
  private GradeMapper gradeMapper;

  @InjectMocks
  private ManufacturerServiceImpl manufacturerService;

  @InjectMocks
  private ManufacturerController manufacturerController;

  @Override
  @Before()
  public void setUp() {
    super.setUp();
    ReflectionTestUtils.setField(manufacturerController, "manufacturerService",
        manufacturerService);
  }

  /**
   * test add manufacturer：success
   */
  @Test
  public void testAddManufacturer_Success() {
    final ManufacturerParameters param = new ManufacturerParameters();
    param.setName("123");
    Mockito.when(manufacturerMapper.selectManufacturerName(Mockito.anyString()))
        .thenReturn(null);
    Mockito.when(manufacturerMapper.insertSelective(Mockito.any()))
        .thenReturn(1);
    final ResultJson<Integer> createManufacturer =
        manufacturerController.createManufacturer(param, null);
    assertEquals("resultcode shall be the same as expected : 0 ",
        createManufacturer.getResultCode().intValue(),
        ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test add manufacturer fail： invalid name
   */
  @Test
  public void testAddManufacturer_Fail_InvalidName() {
    final ManufacturerParameters param = new ManufacturerParameters();
    param.setName("");
    final ResultJson<Integer> createManufacturer =
        manufacturerController.createManufacturer(param, null);
    assertEquals("resultcode shall be the same as expected : 4001200 ",
        createManufacturer.getResultCode().intValue(),
        ResultCodeManufacturer.RESULT_CODE_4001200);
  }

  /**
   * test add manufacturer fail ：producer name exists
   */
  @Test
  public void testAddManufacturer_Fail_ProducerNameExists() {
    final ManufacturerParameters param = new ManufacturerParameters();
    param.setName("123");
    Mockito.when(manufacturerMapper.selectManufacturerName(Mockito.anyString()))
        .thenReturn("123");
    final ResultJson<Integer> createManufacturer =
        manufacturerController.createManufacturer(param, null);
    assertEquals("resultcode shall be the same as expected : 4001300 ",
        createManufacturer.getResultCode().intValue(),
        ResultCodeManufacturer.RESULT_CODE_4001300);
  }

  /**
   * test delete manufacturer :success
   */
  @Test
  public void testDeleteManufacturer_Success() {
    Mockito.when(manufacturerMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(new Manufacturer());
    Mockito.when(gradeMapper.checkManufacturerByMfId(Mockito.anyLong()))
        .thenReturn(false);
    Mockito.when(manufacturerMapper.updateByPrimaryKey(Mockito.any()))
        .thenReturn(1);
    final ResultJson<Integer> manufacturer =
        manufacturerController.deleteManufacturer(1L,null);
    assertEquals("resultcode shall be the same as expected : 0 ",
        manufacturer.getResultCode().intValue(),
        ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test delete manufacturer fail invalid mfId
   */
  @Test
  public void testDeleteManufacturer_Fail_InvalidMfId() {
    final ResultJson<Integer> manufacturer =
        manufacturerController.deleteManufacturer(null,null);
    assertEquals("resultcode shall be the same as expected : 4003200 ",
        manufacturer.getResultCode().intValue(),
        ResultCodeManufacturer.RESULT_CODE_4003200);
  }

  /**
   * test delete manufacturer fail ：manufacturer does not exist
   */
  @Test
  public void testDeleteManufacturer_Fail_ManufacturerDoesNotExist() {
    Mockito.when(manufacturerMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(null);
    final ResultJson<Integer> manufacturer =
        manufacturerController.deleteManufacturer(1L,null);
    assertEquals("resultcode shall be the same as expected : 4003300 ",
        manufacturer.getResultCode().intValue(),
        ResultCodeManufacturer.RESULT_CODE_4003300);
  }

  /**
   * test delete manufacturer fail ：manufacturer Relevant relationships
   */
  @Test
  public void testDeleteManufacturer_Fail_ManufacturerRelevantRelationships() {
    Mockito.when(manufacturerMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(new Manufacturer());
    Mockito.when(gradeMapper.checkManufacturerByMfId(Mockito.anyLong()))
        .thenReturn(true);
    final ResultJson<Integer> manufacturer =
        manufacturerController.deleteManufacturer(1L,null);
    assertEquals("resultcode shall be the same as expected : 4003301 ",
        manufacturer.getResultCode().intValue(),
        ResultCodeManufacturer.RESULT_CODE_4003301);
  }
}
