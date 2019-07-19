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
import com.plastech.crm.exception.ContractException;
import com.plastech.crm.mapper.ContractGradeMapper;
import com.plastech.crm.mapper.ContractMapper;
import com.plastech.crm.mapper.ContractPurchaseMapper;
import com.plastech.crm.model.Contract;
import com.plastech.crm.model.parameter.AddOrUpdateContractParameters;
import com.plastech.crm.resultcode.ResultCodeContract;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.service.impl.ContractServiceImpl;

/**
 * @author wangJin
 *
 * @date 2019年2月12日 下午1:31:18
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrmApplication.class)
@WebAppConfiguration
public class ContractControllerTest extends BaseTest {

  @Mock
  private ContractMapper contractMapper;

  @Mock
  private ContractGradeMapper contractGradeMapper;

  @Mock
  private ContractPurchaseMapper contractPurchaseMapper;

  @InjectMocks
  private ContractServiceImpl contractService;

  @InjectMocks
  private ContractController contractController;

  @Override
  @Before()
  public void setUp() {
    super.setUp();
    ReflectionTestUtils.setField(contractController, "contractService",
        contractService);
  }

  // @Test
  // public void testAddContract_Success() throws ContractException {
  // final AddOrUpdateContractParameters param = getContractParameters();
  // final Contract contrac = new Contract();
  // contrac.setCoid(1L);
  // Mockito.when(contractMapper.checkContractNumber(Mockito.anyString()))
  // .thenReturn(null);
  // Mockito.when(contractMapper.insertSelective(Mockito.any())).thenReturn(1);
  // Mockito
  // .when(
  // contractGradeMapper.getContractGrossSalesByCoid(Mockito.anyLong()))
  // .thenReturn(null);
  // Mockito.when(contractGradeMapper.insertSelective(Mockito.any()))
  // .thenReturn(1);
  // Mockito.when(contractPurchaseMapper.insertSelective(Mockito.any()))
  // .thenReturn(1);
  // final List<AddOrUpdateContractGradeParameters> list = new ArrayList<>();
  // param.setContractList(list);
  // final ResultJson<Boolean> addContract =
  // contractController.addContract(param, null);
  // assertEquals("resultcode shall be the same as expected : 0 ",
  // addContract.getResultCode().intValue(), ResultCodeSystem.RESULT_CODE_0);
  // }

  /**
   * test add contract fail invalid number
   *
   * @throws ContractException
   */
  @Test
  public void testAddContract_Fail_InvalidNumber() throws ContractException {
    final AddOrUpdateContractParameters param = getContractParameters();
    param.setNumber(null);
    final ResultJson<Long> addContract =
        contractController.addContract(param, null);
    assertEquals("resultcode shall be the same as expected : 8001200 ",
        addContract.getResultCode().intValue(),
        ResultCodeContract.RESULT_CODE_8001200);
  }

  /**
   * test add contract fail invalid smid
   *
   * @throws ContractException
   */
  @Test
  public void testAddContract_Fail_InvalidSmid() throws ContractException {
    final AddOrUpdateContractParameters param = getContractParameters();
    param.setUid(null);
    final ResultJson<Long> addContract =
        contractController.addContract(param, null);
    assertEquals("resultcode shall be the same as expected : 8001202 ",
        addContract.getResultCode().intValue(),
        ResultCodeContract.RESULT_CODE_8001202);
  }


  private AddOrUpdateContractParameters getContractParameters() {
    final AddOrUpdateContractParameters param =
        new AddOrUpdateContractParameters();
    param.setGid(1L);
    param.setCuid(1L);
    param.setUid(1L);
    param.setNumber("a");
    param.setGrossSales(1D);
    param.setSigningTime("123");
    return param;
  }

  /**
   * test delete contract success
   */
  @Test
  public void testDeleteContract_Success() {
    final Contract contract = new Contract();
    contract.setCoid(0L);
    Mockito.when(contractMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(contract);
    Mockito.when(contractMapper.updateByPrimaryKeySelective(Mockito.any()))
        .thenReturn(1);
    Mockito
        .when(contractMapper
            .updateContractGradeAndPurchaseByCoid(Mockito.anyLong()))
        .thenReturn(1);
    final ResultJson<Boolean> deleteContract =
        contractController.deleteContract(1L, null);
    assertEquals("resultcode shall be the same as expected : 0 ",
        deleteContract.getResultCode().intValue(),
        ResultCodeSystem.RESULT_CODE_0);
  }

  /**
   * test delete contract fail invalidcoid
   */
  @Test
  public void testDeleteContract_Fail_InvalidCoid() {
    final ResultJson<Boolean> deleteContract =
        contractController.deleteContract(-1L, null);
    assertEquals("resultcode shall be the same as expected : 8006200 ",
        deleteContract.getResultCode().intValue(),
        ResultCodeContract.RESULT_CODE_8006200);
  }

  /**
   * test delete contract fail contracts does not exist
   */
  @Test
  public void testDeleteContract_Fail_ContractsDoesNotExist() {
    final Contract contract = new Contract();
    contract.setCoid(0L);
    Mockito.when(contractMapper.selectByPrimaryKey(Mockito.any()))
        .thenReturn(null);
    final ResultJson<Boolean> deleteContract =
        contractController.deleteContract(1L, null);
    assertEquals("resultcode shall be the same as expected : 8006300 ",
        deleteContract.getResultCode().intValue(),
        ResultCodeContract.RESULT_CODE_8006300);
  }
}
