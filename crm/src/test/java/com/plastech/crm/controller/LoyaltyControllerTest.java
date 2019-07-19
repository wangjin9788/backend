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
import com.plastech.crm.mapper.LoyaltyMapper;
import com.plastech.crm.model.Loyalty;
import com.plastech.crm.model.parameter.AddLoyaltyParameters;
import com.plastech.crm.resultcode.ResultCodeLoyalty;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.service.impl.LoyaltyServiceImpl;

/**
 * @author wangJin
 *
 * @date 2019年2月14日 上午9:34:25
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrmApplication.class)
@WebAppConfiguration
public class LoyaltyControllerTest extends BaseTest {

  @Mock
  private LoyaltyMapper loyaltyMapper;

  @InjectMocks
  private LoyaltyServiceImpl loyaltyService;

  @InjectMocks
  private LoyaltyController loyaltyController;

  @Override
  @Before
  public void setUp() {
    super.setUp();
    ReflectionTestUtils.setField(loyaltyController, "loyaltyService",
        loyaltyService);
  }

  @Test
  public void testAddLoyalty_Success() {
    final AddLoyaltyParameters param = loyaltyParameters();
    Mockito.when(loyaltyMapper.checkLoyaltyName(Mockito.anyString()))
        .thenReturn(false);
    Mockito.when(loyaltyMapper.insertSelective(Mockito.any())).thenReturn(1);
    Mockito.when(loyaltyMapper.updateLoyaltyBylId(Mockito.anyLong()))
        .thenReturn(1);
    final ResultJson<Integer> addLoyalty =
        loyaltyController.addLoyalty(param, null);
    assertEquals("resultcode shall be the same as expected : 0 ",
        addLoyalty.getResultCode().intValue(), ResultCodeSystem.RESULT_CODE_0);
  }

  @Test
  public void testAddLoyalty_Fain_InvalidName() {
    final AddLoyaltyParameters param = loyaltyParameters();
    param.setName(null);
    final ResultJson<Integer> addLoyalty =
        loyaltyController.addLoyalty(param, null);
    assertEquals("resultcode shall be the same as expected : 6001200 ",
        addLoyalty.getResultCode().intValue(),
        ResultCodeLoyalty.RESULT_CODE_6001200);
  }

  @Test
  public void testAddLoyalty_Fain_MissingMinFrequency() {
    final AddLoyaltyParameters param = loyaltyParameters();
    param.setMinFrequency(null);
    final ResultJson<Integer> addLoyalty =
        loyaltyController.addLoyalty(param, null);
    assertEquals("resultcode shall be the same as expected : 6001100 ",
        addLoyalty.getResultCode().intValue(),
        ResultCodeLoyalty.RESULT_CODE_6001100);
  }

  @Test
  public void testAddLoyalty_Fain_MissingMaxFrequency() {
    final AddLoyaltyParameters param = loyaltyParameters();
    param.setMaxFrequency(null);
    final ResultJson<Integer> addLoyalty =
        loyaltyController.addLoyalty(param, null);
    assertEquals("resultcode shall be the same as expected : 6001101 ",
        addLoyalty.getResultCode().intValue(),
        ResultCodeLoyalty.RESULT_CODE_6001101);
  }

  @Test
  public void testAddLoyalty_Fain_MissingDuration() {
    final AddLoyaltyParameters param = loyaltyParameters();
    param.setDuration(null);
    final ResultJson<Integer> addLoyalty =
        loyaltyController.addLoyalty(param, null);
    assertEquals("resultcode shall be the same as expected : 6001102 ",
        addLoyalty.getResultCode().intValue(),
        ResultCodeLoyalty.RESULT_CODE_6001102);
  }

  @Test
  public void testAddLoyalty_Fain_LoyaltyNameRepetition() {
    final AddLoyaltyParameters param = loyaltyParameters();
    Mockito.when(loyaltyMapper.checkLoyaltyName(Mockito.anyString()))
        .thenReturn(true);
    final ResultJson<Integer> addLoyalty =
        loyaltyController.addLoyalty(param, null);
    assertEquals("resultcode shall be the same as expected : 6001300 ",
        addLoyalty.getResultCode().intValue(),
        ResultCodeLoyalty.RESULT_CODE_6001300);
  }

  private AddLoyaltyParameters loyaltyParameters() {
    final AddLoyaltyParameters param = new AddLoyaltyParameters();
    param.setDuration(1);
    param.setMaxFrequency(1);
    param.setMinFrequency(1);
    param.setName("1");
    return param;
  }

  @Test
  public void testDeleteLoyalty_Success() {
    Mockito.when(loyaltyMapper.selectByPrimaryKey(Mockito.anyString()))
        .thenReturn(new Loyalty());
    Mockito.when(loyaltyMapper.updateByPrimaryKey(Mockito.any())).thenReturn(1);
    final ResultJson<Integer> addLoyalty = loyaltyController.deleteLoyalty(1L);
    assertEquals("resultcode shall be the same as expected : 0 ",
        addLoyalty.getResultCode().intValue(), ResultCodeSystem.RESULT_CODE_0);
  }

  @Test
  public void testDeleteLoyalty_Fail_Invalidlid() {
    final ResultJson<Integer> addLoyalty =
        loyaltyController.deleteLoyalty(null);
    assertEquals("resultcode shall be the same as expected : 6002200 ",
        addLoyalty.getResultCode().intValue(),
        ResultCodeLoyalty.RESULT_CODE_6002200);
  }

  @Test
  public void testDeleteLoyalty_Fail_LoyaltyInformationDoesNotExist() {
    Mockito.when(loyaltyMapper.selectByPrimaryKey(Mockito.anyString()))
        .thenReturn(null);
    final ResultJson<Integer> addLoyalty = loyaltyController.deleteLoyalty(1L);
    assertEquals("resultcode shall be the same as expected : 0 ",
        addLoyalty.getResultCode().intValue(),
        ResultCodeLoyalty.RESULT_CODE_6002300);
  }


}
