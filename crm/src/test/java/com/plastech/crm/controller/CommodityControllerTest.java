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
import com.plastech.crm.mapper.CommodityMapper;
import com.plastech.crm.mapper.GradeMapper;
import com.plastech.crm.model.Commodity;
import com.plastech.crm.model.parameter.AddOrUpdateCommodityParameters;
import com.plastech.crm.resultcode.ResultCodeCommodity;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.service.impl.CommodityServiceImpl;

/**
 * @author wangJin
 *
 * @date 2019年1月15日 上午11:14:44
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrmApplication.class)
@WebAppConfiguration
public class CommodityControllerTest extends BaseTest {

  @Mock
  private CommodityMapper commodityMapper;

  @Mock
  private GradeMapper gradeMapper;

  @InjectMocks
  private CommodityServiceImpl commodityService;

  @InjectMocks
  private CommodityController commodityController;

  @Override
  @Before()
  public void setUp() {
    super.setUp();
    ReflectionTestUtils.setField(commodityController, "commodityService",
        commodityService);
  }

  /**
   * test add commodity success
   */
  @Test
  public void testAddCommodity_Success() {
    final AddOrUpdateCommodityParameters param =
        new AddOrUpdateCommodityParameters();
    param.setName("13");
    Mockito.when(commodityMapper.insertSelective(Mockito.any())).thenReturn(1);
    final ResultJson<Integer> createCommodity =
        commodityController.createCommodity(param, null);
    assertEquals("resultcode shall be the same as expected : 0 ",
        createCommodity.getResultCode().intValue(),
        ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test add commodity success
   */
  @Test
  public void testAddCommodity_Fail_InvalidName() {
    final AddOrUpdateCommodityParameters param =
        new AddOrUpdateCommodityParameters();
    param.setName(null);
    final ResultJson<Integer> createCommodity =
        commodityController.createCommodity(param, null);
    assertEquals("resultcode shall be the same as expected :3001200 ",
        createCommodity.getResultCode().intValue(),
        ResultCodeCommodity.RESULT_CODE_3001200);
  }

  /**
   * test add commodity Fail : NameExists
   */
  @Test
  public void testAddCommodity_Fail_NameExists() {
    final AddOrUpdateCommodityParameters param =
        new AddOrUpdateCommodityParameters();
    param.setName("13");
    Mockito.when(commodityMapper.selectCommodityName(Mockito.any()))
        .thenReturn("123");
    final ResultJson<Integer> createCommodity =
        commodityController.createCommodity(param, null);
    assertEquals("resultcode shall be the same as expected : 3001300 ",
        createCommodity.getResultCode().intValue(),
        ResultCodeCommodity.RESULT_CODE_3001300);
  }

  /**
   * test delete commodity ：success
   */
  @Test
  public void testDeleteCommodity_Success() {
    Mockito.when(commodityMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(new Commodity());
    Mockito.when(gradeMapper.checkCommodityByCtId(Mockito.anyLong()))
        .thenReturn(false);
    final ResultJson<Integer> deleteCommodity =
        commodityController.deleteCommodity(1L,null);
    assertEquals("resultcode shall be the same as expected : 0 ",
        deleteCommodity.getResultCode().intValue(),
        ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test delete commodity fail：Invalid CtId
   */
  @Test
  public void testDeleteCommodity_Fail_InvalidCtId() {
    final ResultJson<Integer> deleteCommodity =
        commodityController.deleteCommodity(null,null);
    assertEquals("resultcode shall be the same as expected : 3002200 ",
        deleteCommodity.getResultCode().intValue(),
        ResultCodeCommodity.RESULT_CODE_3002200);
  }

  /**
   * test delete commodity fail：commodity not exist
   */
  @Test
  public void testDeleteCommodity_Fail_CommodityNotExist() {
    Mockito.when(commodityMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(null);
    final ResultJson<Integer> deleteCommodity =
        commodityController.deleteCommodity(1L,null);
    assertEquals("resultcode shall be the same as expected : 3002300 ",
        deleteCommodity.getResultCode().intValue(),
        ResultCodeCommodity.RESULT_CODE_3002300);
  }
  /**
   * test delete commodity fail：Commodity Relevant relationships
   */
  @Test
  public void testDeleteCommodity_Fail_CommodityRelevantRelationships() {
    Mockito.when(commodityMapper.selectByPrimaryKey(Mockito.any()))
    .thenReturn(new Commodity());
    Mockito.when(gradeMapper.checkCommodityByCtId(Mockito.anyLong()))
    .thenReturn(true);
    final ResultJson<Integer> deleteCommodity =
        commodityController.deleteCommodity(1L,null);
    assertEquals("resultcode shall be the same as expected : 3002301 ",
        deleteCommodity.getResultCode().intValue(),
        ResultCodeCommodity.RESULT_CODE_3002301);
  }
}
