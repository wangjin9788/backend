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
import com.plastech.crm.model.Grade;
import com.plastech.crm.model.parameter.AddOrUpdateGradeParameters;
import com.plastech.crm.resultcode.ResultCodeGrade;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.service.impl.GradeServiceImpl;

/**
 * @author wangJin
 *
 * @date 2019年1月15日 上午11:15:12
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrmApplication.class)
@WebAppConfiguration
public class GradeControllerTest extends BaseTest {

  @Mock
  private GradeMapper gradeMapper;

  @InjectMocks
  private GradeServiceImpl gradeService;

  @InjectMocks
  private GradeController gradeController;

  @Override
  @Before()
  public void setUp() {
    super.setUp();
    ReflectionTestUtils.setField(gradeController, "gradeService", gradeService);
  }

  /**
   * test add grade : success
   */
  @Test
  public void testAddGrade_Success() {
    final AddOrUpdateGradeParameters parameters = getParameters();
    Mockito.when(gradeMapper.checkGradePresence(Mockito.anyLong(),
        Mockito.anyLong(), Mockito.anyString())).thenReturn(null);
    Mockito.when(gradeMapper.insertSelective(Mockito.any())).thenReturn(1);
    final ResultJson<Integer> createGrade =
        gradeController.createGrade(null, parameters);
    assertEquals("resultcode shall be the same as expected : 0 ",
        createGrade.getResultCode().intValue(), ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test add grade fail：invalid ctId
   */
  @Test
  public void testAddGrade_Fail_InvalidCtId() {
    final AddOrUpdateGradeParameters parameters = getParameters();
    parameters.setCtId(null);
    final ResultJson<Integer> createGrade =
        gradeController.createGrade(null, parameters);
    assertEquals("resultcode shall be the same as expected : 5001201 ",
        createGrade.getResultCode().intValue(),
        ResultCodeGrade.RESULT_CODE_5001201);
  }

  /**
   * test add grade fail：invalid grade number
   */
  @Test
  public void testAddGrade_Fail_InvalidMfid() {
    final AddOrUpdateGradeParameters parameters = getParameters();
    parameters.setMfId(null);
    final ResultJson<Integer> createGrade =
        gradeController.createGrade(null, parameters);
    assertEquals("resultcode shall be the same as expected : 5001202 ",
        createGrade.getResultCode().intValue(),
        ResultCodeGrade.RESULT_CODE_5001202);
  }

  /**
   * test add grade fail：invalid grade number
   */
  @Test
  public void testAddGrade_Fail_InvalidGradeNumber() {
    final AddOrUpdateGradeParameters parameters = getParameters();
    parameters.setGradeNumber(null);
    final ResultJson<Integer> createGrade =
        gradeController.createGrade(null, parameters);
    assertEquals("resultcode shall be the same as expected : 5001200 ",
        createGrade.getResultCode().intValue(),
        ResultCodeGrade.RESULT_CODE_5001200);
  }

  /**
   * test add grade fail ：grade information exists
   */
  @Test
  public void testAddGrade_Fail_GradeInformationExists() {
    final AddOrUpdateGradeParameters parameters = getParameters();
    Mockito.when(gradeMapper.checkGradePresence(Mockito.anyLong(),
        Mockito.anyLong(), Mockito.anyString())).thenReturn(1L);
    final ResultJson<Integer> createGrade =
        gradeController.createGrade(null, parameters);
    assertEquals("resultcode shall be the same as expected : 5001300 ",
        createGrade.getResultCode().intValue(),
        ResultCodeGrade.RESULT_CODE_5001300);
  }

  private AddOrUpdateGradeParameters getParameters() {
    final AddOrUpdateGradeParameters param = new AddOrUpdateGradeParameters();
    param.setCtId(1L);
    param.setMfId(1L);
    param.setGradeNumber("123");
    return param;
  }

  /**
   * test delete grade：success
   */
  public void testDeleteGrade_Success() {
    Mockito.when(gradeMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(new Grade());
    Mockito.when(gradeMapper.updateByPrimaryKey(Mockito.any())).thenReturn(1);
    final ResultJson<Boolean> deleteGrade = gradeController.deleteGrade(1L,null);
    assertEquals("resultcode shall be the same as expected : 5001300 ",
        deleteGrade.getResultCode().intValue(), ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test delete grade fain：invalid geId
   */
  public void testDeleteGrade_Fain_InvalidGeId() {
    final ResultJson<Boolean> deleteGrade = gradeController.deleteGrade(null,null);
    assertEquals("resultcode shall be the same as expected : 5001300 ",
        deleteGrade.getResultCode().intValue(),
        ResultCodeGrade.RESULT_CODE_5003200);
  }

  /**
   * test delete grade fain： grade does not exist
   */
  public void testDeleteGrade_Fain_GradeDoesNotExist() {
    Mockito.when(gradeMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(null);
    final ResultJson<Boolean> deleteGrade = gradeController.deleteGrade(1L,null);
    assertEquals("resultcode shall be the same as expected : 5001300 ",
        deleteGrade.getResultCode().intValue(),
        ResultCodeGrade.RESULT_CODE_5003300);
  }
}
