package com.plastech.crm.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.plastech.crm.exception.ContractException;
import com.plastech.crm.model.Contract;
import com.plastech.crm.model.ContractGrade;
import com.plastech.crm.model.ContractPurchase;
import com.plastech.crm.model.parameter.AddOrUpdateContractGradeParameters;
import com.plastech.crm.model.parameter.AddOrUpdateContractParameters;
import com.plastech.crm.model.vo.ContractBaseDetailView;
import com.plastech.crm.model.vo.ContractDetailView;
import com.plastech.crm.model.vo.ContractGrossSalesView;
import com.plastech.crm.model.vo.ContractListView;
import com.plastech.crm.model.vo.ImportContractView;
import com.plastech.crm.model.vo.SalesManagerView;
import com.plastech.crm.resultcode.ResultCodeContract;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.service.ContractService;
import com.plastech.crm.util.AppPage;
import com.plastech.crm.util.CommonTools;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author wangJin
 *
 * @date 2019年1月24日 上午10:44:15
 *
 */
@Service
public class ContractServiceImpl extends BaseService
    implements ContractService {
  @Override
  public AppPageModel<List<ContractListView>> searchContractList(
      final Map<String, Object> map, final Integer currentpage,
      final Integer perpage) {
    try {
      final AppPage<List<ContractListView>> page =
          new AppPage<>(perpage, currentpage);
      page.start();
      final List<ContractListView> searchContractList =
          contractMapper.searchContractList(map);
      page.setResult(searchContractList);
      return page.convertToAppPageModel();
    } catch (final Exception e) {
      logger.info("contract Exception:{}", e);
    }
    return null;
  }

  @Override
  public ResultJson<Long> addContract(final AddOrUpdateContractParameters param,
      final Long uid) {
    try {
      // 检查合同编号是否重复
      final Long coid = contractMapper.checkContractNumber(param.getNumber());
      if (coid != null) {
        return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8001300);
      }
      // 合同添加
      final Contract contrac = new Contract();
      addOrUpdateContract(param, uid, null, contrac);
      if (contrac.getCoid() == null) {
        return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50);
      }

      // 合同清单添加
      final Integer checkAdd = addOrUpdateContractList(contrac.getCoid(),
          param.getContractList(), uid);
      if (checkAdd > 0) {
        return ResultUtil.getResult(checkAdd);

      }
      // 获取（总金额、总利润）
      final ContractGrossSalesView sales =
          contractGradeMapper.getContractGrossSalesByCoid(contrac.getCoid());
      if (sales != null) {
        // 编辑合同表的总金额
        contractMapper.updateContractGossSalesAndNetProfitByCoid(
            contrac.getCoid(), sales.getSalesTotal(), sales.getNetProfit(),
            sales.getGrossProfit());
      }
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0,
          contrac.getCoid(), ResultCodeSystem.ADD_SUCCESS);
    } catch (final Exception e) {
      logger.info("add Contract Exception:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, 0L,
        ResultCodeSystem.ADD_FAIL);
  }

  @Override
  public ResultJson<Boolean> updateContract(final Long coid,
      final AddOrUpdateContractParameters param, final Long uid)
      throws ContractException {
    // 校验合同编号
    final Long checkCoid =
        contractMapper.checkContractNumber(param.getNumber());
    if (checkCoid != null && checkCoid.longValue() != coid) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8002300);
    }
    final Contract contractInfo = contractMapper.selectByPrimaryKey(coid);
    if (contractInfo == null || contractInfo.getStatus() == -1) {
      return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8002301);
    }
    final Contract contract = CommonTools.deepCloneObject(contractInfo);
    addOrUpdateContract(param, uid, coid, contract);
    // 删除清单
    contractMapper.deleteGradeByCoid(coid);
    contractMapper.deletePurchaseByCoid(coid);
    // 编辑合同清单
    final Integer checkAdd =
        addOrUpdateContractList(coid, param.getContractList(), uid);
    if (checkAdd > 0) {
      return ResultUtil.getResult(checkAdd);
    }
    // 获取（总金额、总毛利润）
    final ContractGrossSalesView sales =
        contractGradeMapper.getContractGrossSalesByCoid(coid);
    if (sales != null) {
      // 编辑合同表的总金额
      contractMapper.updateContractGossSalesAndNetProfitByCoid(coid,
          sales.getSalesTotal(), sales.getNetProfit(), sales.getGrossProfit());
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, true,
        ResultCodeSystem.SAVE_SUCCESS);

  }

  // 合同添加或编辑
  private void addOrUpdateContract(final AddOrUpdateContractParameters param,
      final Long uid, final Long coid, final Contract contract) {
    if (coid == null) {
      contract.setCreatorId(uid);
      contract.setCreatorTime(new Date());
    }
    contract.setNumber(param.getNumber());
    contract.setCuid(param.getCuid());
    contract.setGid(param.getGid());
    contract.setUid(param.getUid());
    contract.setSigningTime(param.getSigningTime());
    contract.setUpdateId(uid);
    contract.setUpdateTime(new Date());
    contract.setStatus(0);
    if (coid == null) {
      contractMapper.insertSelective(contract);
    } else {
      contractMapper.updateByPrimaryKeySelective(contract);
    }
  }

  // 添加或编辑合同清单
  private Integer addOrUpdateContractList(final Long coid,
      final List<AddOrUpdateContractGradeParameters> gradetList, final Long uid)
      throws ContractException {
    for (final AddOrUpdateContractGradeParameters salesInfo : gradetList) {
      final ContractGrade grade = new ContractGrade();
      final ContractPurchase purch = new ContractPurchase();
      grade.setCoid(coid);
      grade.setGeid(salesInfo.getGeid());
      grade.setCgSalesVolume(salesInfo.getCgSalesVolume());
      grade.setCgCurrencyType(salesInfo.getCgCurrencyType());
      grade.setCgSalesUnitPrice(salesInfo.getCgSalesUnitPrice());
      grade.setCgSalesTotal(salesInfo.getCgSalesTotal());
      grade.setCgShipmtDate(salesInfo.getCgShipmtDate());
      grade.setCgCustomerPo(salesInfo.getCgCustomerPo());
      grade.setCgPaymentTerms(salesInfo.getCgPaymentTerms());
      grade.setCgTransportationTerms(salesInfo.getCgTransportationTerms());
      // 获取毛利润和净利润
      final Map<String, BigDecimal> calculatedProfit = calculatedProfit(
          salesInfo.getCgSalesTotal(), salesInfo.getCpPurchaseCost(),
          salesInfo.getCpLogisticsFee(), salesInfo.getCpOtherCosts());
      grade.setCgGrossProfit(calculatedProfit.get("grossProfit"));
      grade.setCgNetProfit(calculatedProfit.get("netProfit"));
      grade.setCgStatus(0);
      grade.setCgCreatorId(uid);
      grade.setCgCreatorTime(new Date());
      // 添加contractGrade
      contractGradeMapper.insertSelective(grade);
      if (grade.getCgid() == null || grade.getCgid().longValue() <= 0) {
        throw new ContractException("Failure of new contract");
      }

      purch.setCgid(grade.getCgid());
      purch.setSuid(salesInfo.getSuid());
      purch.setCpPriceCurrency(salesInfo.getCpPriceCurrency());
      purch.setCpPurchasePrices(salesInfo.getCpPurchasePrices());
      purch.setCpPurchaseQuantity(salesInfo.getCpPurchaseQuantity());
      purch.setCpPurchaseCost(salesInfo.getCpPurchaseCost());
      purch.setCpSupplierPo(salesInfo.getCpSupplierPo());
      purch.setCpPaymentTerms(salesInfo.getCpPaymentTerms());
      purch.setCpTransportationTerms(salesInfo.getCpTransportationTerms());
      purch.setCpLogisticsCurrency(salesInfo.getCpLogisticsCurrency());
      purch.setCpLogisticsFee(salesInfo.getCpLogisticsFee());
      purch.setCpOthersCurrency(salesInfo.getCpOthersCurrency());
      purch.setCpOtherCosts(salesInfo.getCpOtherCosts());
      purch.setCpRoute(salesInfo.getCpRoute());
      purch.setCpToolNumber(salesInfo.getCpToolNumber());
      purch.setCpStatus(0);

      purch.setCpCreatorId(uid);
      purch.setCpCreatorTime(new Date());
      contractPurchaseMapper.insertSelective(purch);

    }
    return 0;
  }

  @Override
  public boolean isContractNumberNotExist(final String contNo) {
    final Contract contract = contractMapper.selectByContractNumber(contNo);
    return contract == null ? true : false;
  }

  @Override
  public List<SalesManagerView> getSalseManagersList() {
    try {
      return userMapper.getSalseManagersList();
    } catch (final Exception e) {
      logger.info("salse Exception:{}", e);
    }
    return null;
  }

  @Override
  public ContractDetailView expandingContractListByCgId(final Long cgid) {
    try {
      return contractMapper.expandingContractListByCgId(cgid);
    } catch (final Exception e) {
      logger.info("expanding Exception:{}", e);
    }
    return null;
  }

  @Override
  public ContractBaseDetailView getContractBaseDetail(final Long coid) {
    try {
      return contractMapper.getContractBaseDetail(coid);
    } catch (final Exception e) {
      logger.info("Base Detail Exception:{}", e);
    }
    return null;
  }

  @Override
  public ResultJson<Boolean> deleteContract(final Long coid) {
    try {
      final Contract contract = contractMapper.selectByPrimaryKey(coid);
      if (contract == null) {
        return ResultUtil.getResult(ResultCodeContract.RESULT_CODE_8006300);
      }
      contract.setStatus(-1);
      contractMapper.updateByPrimaryKeySelective(contract);
      // 修改清单及采购信息的状态
      contractMapper.updateContractGradeAndPurchaseByCoid(coid);
      // 清理缓存
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, true,
          ResultCodeSystem.DELETE_SUCCESS);
    } catch (final Exception e) {
      logger.info(" Delete Exception:{}", e);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, false,
        ResultCodeSystem.DELETE_FAIL);
  }

  private Map<String, BigDecimal> calculatedProfit(
      final BigDecimal cgSalesTotal, final BigDecimal cpPurchaseCost,
      final BigDecimal cpLogisticsFee, final BigDecimal cpOtherCosts) {
    final Map<String, BigDecimal> map = new HashMap<>();
    // 毛利润=总销售额-采购总金额
    final BigDecimal decGrossProfit = cgSalesTotal.subtract(cpPurchaseCost);
    // 净利润=总销售额-采购总金额-运输金额-其他金额
    final BigDecimal decNetProfit = cgSalesTotal.subtract(cpPurchaseCost)
        .subtract(cpLogisticsFee).subtract(cpOtherCosts);
    map.put("grossProfit", decGrossProfit);
    map.put("netProfit", decNetProfit);
    return map;
  }

  @Override
  public AddOrUpdateContractParameters getContractInfoByCoid(final Long coid) {
    return contractMapper.getContractInfoByCoid(coid);
  }

  @Override
  public ImportContractView isImportContractNumberNotExist(
      final String contNo) {
    return contractMapper.isImportContractNumberNotExist(contNo);
  }

  @Override
  public Boolean getImportDetailStatus() {
    return importRawdataDetailMapper.getImportDetailStatus();
  }
}

