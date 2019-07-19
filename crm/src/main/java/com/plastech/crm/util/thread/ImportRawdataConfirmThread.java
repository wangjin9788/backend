package com.plastech.crm.util.thread;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Strings;
import com.plastech.crm.mapper.CommodityMapper;
import com.plastech.crm.mapper.ContractGradeMapper;
import com.plastech.crm.mapper.ContractMapper;
import com.plastech.crm.mapper.ContractPurchaseMapper;
import com.plastech.crm.mapper.CustomerMapper;
import com.plastech.crm.mapper.GradeMapper;
import com.plastech.crm.mapper.GroupsMapper;
import com.plastech.crm.mapper.ImportRawdataDetailMapper;
import com.plastech.crm.mapper.ImportRawdataMapper;
import com.plastech.crm.mapper.ManufacturerMapper;
import com.plastech.crm.mapper.SupplierMapper;
import com.plastech.crm.mapper.UserMapper;
import com.plastech.crm.model.Commodity;
import com.plastech.crm.model.Contract;
import com.plastech.crm.model.ContractGrade;
import com.plastech.crm.model.ContractPurchase;
import com.plastech.crm.model.Customer;
import com.plastech.crm.model.Grade;
import com.plastech.crm.model.Groups;
import com.plastech.crm.model.ImportRawdata;
import com.plastech.crm.model.Manufacturer;
import com.plastech.crm.model.Supplier;
import com.plastech.crm.model.User;
import com.plastech.crm.model.vo.ContractGrossSalesView;
import com.plastech.crm.model.vo.ImportRawdataExplainResultData;
import com.plastech.crm.service.ImportService;
import com.plastech.crm.service.LoyaltyService;
import com.plastech.crm.service.SaCommodityAnalysisServer;
import com.plastech.crm.service.SaCommodityPurchaseService;
import com.plastech.crm.service.SaCustomerDetailAnalysisService;
import com.plastech.crm.service.SaGroupsAnalysisService;
import com.plastech.crm.service.SaManagerAnalysisService;
import com.plastech.crm.service.SaManufacturerAnalysisService;
import com.plastech.crm.service.SaSalesAnalysisService;
import com.plastech.crm.util.PasswordStorage;
import com.plastech.crm.util.PasswordStorage.CannotPerformOperationException;
import com.plastech.crm.util.UniqueStringGenerator;

/**
 *
 *
 * @author : yemin
 * @date : 2019年2月13日 下午1:46:39
 *
 */
public class ImportRawdataConfirmThread implements Runnable {

  private static Logger logger =
      LoggerFactory.getLogger(ImportRawdataConfirmThread.class);

  private final ImportRawdata rawdata;
  private final int operateType;
  private final ImportRawdataMapper importRawdataMapper;
  private final ImportRawdataDetailMapper importRawdataDetailMapper;
  private final ContractMapper contractMapper;
  private final CustomerMapper customerMapper;
  private final SupplierMapper supplierMapper;
  private final CommodityMapper commodityMapper;
  private final ManufacturerMapper manufacturerMapper;
  private final GradeMapper gradeMapper;
  private final ContractGradeMapper contractGradeMapper;
  private final ContractPurchaseMapper contractPurchaseMapper;
  private final ImportService importService;
  private final GroupsMapper groupsMapper;
  private final UserMapper userMapper;
  private final Long uid;

  // initSa
  private final SaSalesAnalysisService saSalesAnalysisService;
  private final SaManagerAnalysisService saManagerAnalysisService;
  private final SaCommodityAnalysisServer saCommodityAnalysisServer;
  private final SaManufacturerAnalysisService saManufacturerAnalysisService;
  private final SaGroupsAnalysisService saGroupsAnalysisService;
  private final SaCommodityPurchaseService saCommodityPurchaseService;
  private final SaCustomerDetailAnalysisService saCustomerDetailAnalysisService;
  private final LoyaltyService loyaltyService;


  /**
   * @param rawdata
   * @param operateType
   * @param importRawdataMapper
   * @param importRawdataDetailMapper
   * @param contractMapper
   * @param customerMapper
   * @param supplierMapper
   * @param commodityMapper
   * @param manufacturerMapper
   * @param gradeMapper
   * @param contractGradeMapper
   * @param contractPurchaseMapper
   * @param importService
   * @param groupsMapper
   * @param userMapper
   * @param uid
   * @param saSalesAnalysisService
   * @param saManagerAnalysisService
   * @param saCommodityAnalysisServer
   * @param saManufacturerAnalysisService
   * @param saGroupsAnalysisService
   * @param saCommodityPurchaseService
   * @param saCustomerDetailAnalysisService
   * @param loyaltyService
   */
  public ImportRawdataConfirmThread(final ImportRawdata rawdata,
      final int operateType, final ImportRawdataMapper importRawdataMapper,
      final ImportRawdataDetailMapper importRawdataDetailMapper,
      final ContractMapper contractMapper, final CustomerMapper customerMapper,
      final SupplierMapper supplierMapper,
      final CommodityMapper commodityMapper,
      final ManufacturerMapper manufacturerMapper,
      final GradeMapper gradeMapper,
      final ContractGradeMapper contractGradeMapper,
      final ContractPurchaseMapper contractPurchaseMapper,
      final ImportService importService, final GroupsMapper groupsMapper,
      final UserMapper userMapper, final Long uid,
      final SaSalesAnalysisService saSalesAnalysisService,
      final SaManagerAnalysisService saManagerAnalysisService,
      final SaCommodityAnalysisServer saCommodityAnalysisServer,
      final SaManufacturerAnalysisService saManufacturerAnalysisService,
      final SaGroupsAnalysisService saGroupsAnalysisService,
      final SaCommodityPurchaseService saCommodityPurchaseService,
      final SaCustomerDetailAnalysisService saCustomerDetailAnalysisService,
      final LoyaltyService loyaltyService) {
    super();
    this.rawdata = rawdata;
    this.operateType = operateType;
    this.importRawdataMapper = importRawdataMapper;
    this.importRawdataDetailMapper = importRawdataDetailMapper;
    this.contractMapper = contractMapper;
    this.customerMapper = customerMapper;
    this.supplierMapper = supplierMapper;
    this.commodityMapper = commodityMapper;
    this.manufacturerMapper = manufacturerMapper;
    this.gradeMapper = gradeMapper;
    this.contractGradeMapper = contractGradeMapper;
    this.contractPurchaseMapper = contractPurchaseMapper;
    this.importService = importService;
    this.groupsMapper = groupsMapper;
    this.userMapper = userMapper;
    this.uid = uid;
    this.saSalesAnalysisService = saSalesAnalysisService;
    this.saManagerAnalysisService = saManagerAnalysisService;
    this.saCommodityAnalysisServer = saCommodityAnalysisServer;
    this.saManufacturerAnalysisService = saManufacturerAnalysisService;
    this.saGroupsAnalysisService = saGroupsAnalysisService;
    this.saCommodityPurchaseService = saCommodityPurchaseService;
    this.saCustomerDetailAnalysisService = saCustomerDetailAnalysisService;
    this.loyaltyService = loyaltyService;
  }

  @Override
  public void run() {
    try {
      if (operateType == 1) {// 确认
        // 1.处理正常的合同数据（此时不能按之前的分析结果区分新增和更新，需要重新分析一次，因为DB中的原有数据可能发生变化了）
        // 查询数据
        final List<ImportRawdataExplainResultData> resultDataList =
            importRawdataDetailMapper
                .getExplainResultDataListOfAddOrUpdate(rawdata.getIrid());
        // 根据合同编号，合并数据
        final Map<String, List<ImportRawdataExplainResultData>> contractData =
            mergeContractData(resultDataList);
        // 处理数据
        for (final Map.Entry<String, List<ImportRawdataExplainResultData>> entry : contractData
            .entrySet()) {
          final String contractNumber = entry.getKey();
          final List<ImportRawdataExplainResultData> dataList =
              entry.getValue();

          // 根据第一条数据，新增合同
          final ImportRawdataExplainResultData dataFirst = dataList.get(0);
          final Groups groups = getOrCreateGroupsByName(dataFirst.getGroups());// 最终客户

          final User user = getOrCreateUserName(dataFirst.getSalseManager());// 销售经理

          final Customer customer = getOrCreateCustomerByName(
              dataFirst.getCustomer(), groups.getGid());// 客户

          Contract contract =
              contractMapper.selectByContractNumber(contractNumber);

          contract = insertNewContract(contractNumber, customer, dataFirst,
              user, dataFirst.getType(), contract);

          // 根据所有数据，写入合同牌号信息
          for (final ImportRawdataExplainResultData data : dataList) {

            final Grade grade = getOrCreateGradeByName(data.getGrade(),
                data.getCommodity(), data.getManufacturer());// 牌号

            final ContractGrade cg =
                insertNewContractGrade(contract, grade, data, data.getType());
            if (cg != null) {
              final Supplier supplier =
                  getOrCreateSupplierByName(data.getSupplier());// 供应商

              insertNewContractPurchase(contract, cg, supplier, data,
                  data.getType());

              final ContractGrossSalesView sales = contractGradeMapper
                  .getContractGrossSalesByCoid(contract.getCoid());
              if (sales != null) {
                // 编辑合同表的总金额
                contractMapper.updateContractGossSalesAndNetProfitByCoid(
                    contract.getCoid(), sales.getSalesTotal(),
                    sales.getNetProfit(), sales.getGrossProfit());
              }
            }
          }
        }

        // 2.更新导入记录的note
        importRawdataDetailMapper.updateNoteByIrid(rawdata.getIrid(),
            "import confirm");
        // 初始化忠诚度
        loyaltyService.loyaltyTakesEffect(0L);
        // 初始化统计数据
        initAnalysisOfStatisticalData();
        // 3.更新导入记录状态
        rawdata.setStatus(3);
        importRawdataMapper.updateByPrimaryKey(rawdata);
      } else {// 取消
        importRawdataDetailMapper.updateNoteByIrid(rawdata.getIrid(),
            "import cancel");
        rawdata.setStatus(4);
        importRawdataMapper.updateByPrimaryKey(rawdata);
      }
    } catch (final Exception e) {
      logger.error("导入失败,{}", e);
      importService.updateStatus(rawdata.getIrid(), 5);
    }
  }

  private void insertNewContractPurchase(final Contract contract,
      final ContractGrade cg, final Supplier supplier,
      final ImportRawdataExplainResultData data, final Integer type) {
    ContractPurchase cp = null;
    if (type == 0) {
      cp = new ContractPurchase();
      if (data != null) {
        cp.setCgid(cg.getCgid());
        cp.setSuid(supplier.getSuid());
        cp.setCpPriceCurrency("USD");
        cp.setCpPurchasePrices(
            Double.valueOf(!Strings.isNullOrEmpty(data.getPriceMt2())
                ? data.getPriceMt2() : "0"));
        cp.setCpPurchaseQuantity(Double.valueOf(data.getQtyMt()));
        cp.setCpPurchaseCost(getBigDecimal(data.getTotal2()));
        cp.setCpPaymentTerms(data.getTerm2());
        cp.setCpTransportationTerms(data.getTerm4());
        cp.setCpLogisticsCurrency("USD");
        cp.setCpLogisticsFee(getBigDecimal(data.getLogisticsFee2()));
        cp.setCpOthersCurrency("USD");
        cp.setCpOtherCosts( getBigDecimal(data.getLogisticsFee()));
        cp.setCpCreatorId(uid);
        cp.setCpCreatorTime(new Date());
        cp.setCpStatus(0);
        contractPurchaseMapper.insert(cp);
      }
    } else {
      cp = contractPurchaseMapper.getImportContractPurchaseByGeid(cg.getCgid());
      if (cp != null && data != null) {
        cp.setSuid(supplier.getSuid());
        cp.setCpPurchasePrices(
            Double.valueOf(!Strings.isNullOrEmpty(data.getPriceMt2())
                ? data.getPriceMt2() : "0"));
        cp.setCpPurchaseQuantity(Double.valueOf(data.getQtyMt()));
        cp.setCpPurchaseCost(getBigDecimal(data.getTotal2()));
        cp.setCpPaymentTerms(data.getTerm2());
        cp.setCpTransportationTerms(data.getTerm4());
        cp.setCpLogisticsFee(getBigDecimal(data.getLogisticsFee2()));
        cp.setCpOtherCosts(getBigDecimal(data.getLogisticsFee()));
        contractPurchaseMapper.updateByPrimaryKeySelective(cp);
      }
    }
  }

  private BigDecimal getBigDecimal(final String data) {
    try {
      return new BigDecimal(Strings.isNullOrEmpty(data) ? "0" : data);
    } catch (final Exception e) {
      logger.info("Parse bigDecimal error");
    }
    return new BigDecimal(0);
  }

  private ContractGrade insertNewContractGrade(final Contract contract,
      final Grade grade, final ImportRawdataExplainResultData data,
      final Integer type) {
    ContractGrade cg = null;
    if (type == 0) {
      cg = new ContractGrade();
      cg.setCoid(contract.getCoid());
      cg.setGeid(grade.getGeid());
      cg.setCgSalesVolume(Strings.isNullOrEmpty(data.getQtyMt())?0:Double.valueOf(data.getQtyMt()));
      cg.setCgCurrencyType("USD");
      cg.setCgSalesUnitPrice(data.getPriceMt());
      cg.setCgSalesTotal(getBigDecimal(data.getTotal()));
      cg.setCgShipmtDate(data.getShipmt());
      cg.setCgPaymentTerms(data.getTerm());
      cg.setCgGrossProfit(getBigDecimal(data.getProfit()));
      cg.setCgNetProfit(getBigDecimal(data.getNetProfit()));
      cg.setCgTransportationTerms(data.getTerm3());
      cg.setCgCreatorId(uid);
      cg.setCgCreatorTime(new Date());
      cg.setCgStatus(0);
      cg.setCgNote("");
      contractGradeMapper.insert(cg);
    } else {
     final Double mt=Strings.isNullOrEmpty(data.getQtyMt())?0:Double.valueOf(data.getQtyMt());
      cg = acquireTheSameContractAsImport(contract.getCoid(), grade.getGradeNumber(),
          mt, data.getShipmt());
      if (cg != null) {
        cg.setGeid(grade.getGeid());
        cg.setCgSalesVolume(mt);
        cg.setCgSalesUnitPrice(data.getPriceMt());
        cg.setCgSalesTotal(getBigDecimal(data.getTotal()));
        cg.setCgShipmtDate(data.getShipmt());
        cg.setCgPaymentTerms(data.getTerm());
        cg.setCgGrossProfit(getBigDecimal(data.getProfit()));
        cg.setCgNetProfit(getBigDecimal(data.getNetProfit()));
        cg.setCgTransportationTerms(data.getTerm3());
        contractGradeMapper.updateByPrimaryKeySelective(cg);
      }
    }
    return cg;
  }

  private Grade getOrCreateGradeByName(final String gradeNumber,
      final String commodityName, final String manufacturerName) {
    Commodity commodity = commodityMapper.selectByCommodityName(commodityName);
    if (commodity == null) {
      commodity = new Commodity();
      commodity.setName(commodityName);
      commodity.setStatus(0);
      commodity.setCreatorId(uid);
      commodity.setCreatorTime(new Date());
      commodity.setNote("");
      commodityMapper.insert(commodity);
    }

    Manufacturer manufacturer =
        manufacturerMapper.selectByName(manufacturerName);
    if (manufacturer == null) {
      manufacturer = new Manufacturer();
      manufacturer.setName(manufacturerName);
      manufacturer.setStatus(0);
      manufacturer.setCreatorId(uid);
      manufacturer.setCreatorTime(new Date());
      manufacturer.setLastUpdateId(0L);
      manufacturer.setLastUpdateTime(new Date());
      manufacturer.setNote("");
      manufacturerMapper.insert(manufacturer);
    }

    Grade grade = gradeMapper.selectByGradenumberAndMfidAndCtid(gradeNumber,
        manufacturer.getMfid(), commodity.getCtid());
    if (grade == null) {
      grade = new Grade();
      grade.setMfid(manufacturer.getMfid());
      grade.setCtid(commodity.getCtid());
      grade.setGradeNumber(gradeNumber);
      grade.setStatus(0);
      grade.setCreatorId(uid);
      grade.setCreatorTime(new Date());
      grade.setLastUpdateId(uid);
      grade.setLastUpdateTime(new Date());
      grade.setNote("");
      gradeMapper.insert(grade);
    }

    return grade;
  }

  private Supplier getOrCreateSupplierByName(final String supplierName) {
    Supplier supplier = supplierMapper.selectSuname(supplierName);
    if (supplier == null) {
      supplier = new Supplier();
      supplier.setStatus(0);
      supplier.setSuName(supplierName);
      supplier.setCreatorId(uid);
      supplier.setCreatorTime(new Date());
      supplier.setLastUpdateId(uid);
      supplier.setLastUpdateTime(new Date());
      supplier.setNote("import");
      supplierMapper.insert(supplier);
    }
    return supplier;
  }

  private Contract insertNewContract(final String contractNumber,
      final Customer customer, final ImportRawdataExplainResultData dataFirst,
      final User user, final Integer type, Contract contract) {
    if (contract == null && type == 0) {
      contract = new Contract();
      contract.setCuid(customer.getCuid());
      contract.setGid(customer.getGid());
      contract.setUid(user.getUid());
      contract.setNumber(contractNumber);
      contract.setGrossProfit(getBigDecimal(dataFirst.getProfit()));
      contract.setGrossSales(getBigDecimal(dataFirst.getTotal()));
      contract.setTotalNetProfit(getBigDecimal(dataFirst.getNetProfit()));
      contract.setSigningTime(dataFirst.getSigningTime());
      contract.setStatus(0);
      contract.setCreatorId(uid);
      contract.setCreatorTime(new Date());
      contract.setUpdateId(uid);
      contract.setUpdateTime(new Date());
      contract.setNote("import");
      contractMapper.insert(contract);
    }
    return contract;
  }

  private Customer getOrCreateCustomerByName(final String customerName,
      final Long gid) {
    Customer customer = customerMapper.selectByName(customerName, gid);
    if (customer == null) {
      customer = new Customer();
      customer.setCuName(customerName);
      customer.setStatus(0);
      customer.setGid(gid);
      customer.setCreatorId(uid);
      customer.setCreatorTime(new Date());
      customer.setLastUpdateId(0L);
      customer.setLastUpdateTime(new Date());

      customerMapper.insertSelective(customer);
    }
    return customer;
  }

  private Groups getOrCreateGroupsByName(final String groupsName) {
    Groups groups = groupsMapper.selectByNameAndType(groupsName, 1);
    if (groups == null) {
      groups = new Groups();
      groups.setName(groupsName);
      groups.setType(1);
      groups.setStatus(0);
      groups.setCode(0);
      groups.setCreatorId(uid);
      groups.setCreatorTime(new Date());
      groups.setNote("import");

      groupsMapper.insertSelective(groups);
    }
    return groups;
  }

  private User getOrCreateUserName(final String uname) {
    User user = userMapper.getUserInfoByName(uname);
    if (user == null) {
      user = new User();
      // 初始化密码
      try {
        final String pwdMd5 =
            PasswordStorage.createHash("67b2cea5146593bd19364b439de60a34");
        user.setPwd(pwdMd5);
      } catch (final CannotPerformOperationException e) {
        e.printStackTrace();
      }
      user.setUname(uname);
      user.setUcode(uname);
      user.setPosition("");
      user.setRoleid(2L);
      user.setRolename("銷售");
      user.setCreateId(0L);
      user.setCreateTime(new Date());
      user.setUstatus(0);
      userMapper.insertSelective(user);

      final String nunber = UniqueStringGenerator.getUniqueUid(user.getUid());
      user.setUnumber("ID" + nunber);
      if (!Strings.isNullOrEmpty(uname)) {
        user.setUname(uname);
      } else {
        user.setUname(nunber);
      }
      userMapper.updateByPrimaryKey(user);
    }
    return user;
  }

  // 对数据进行处理，把同一个合同的数据放到一起
  private Map<String, List<ImportRawdataExplainResultData>> mergeContractData(
      final List<ImportRawdataExplainResultData> resultDataList) {
    final Map<String, List<ImportRawdataExplainResultData>> dataMap =
        new HashMap<>();// key为合同号，value为多条合同数据
    for (final ImportRawdataExplainResultData data : resultDataList) {
      final String contractNumber = data.getContNo();
      if (!dataMap.containsKey(contractNumber)) {
        final List<ImportRawdataExplainResultData> list = new ArrayList<>();
        list.add(data);
        dataMap.put(contractNumber, list);
      } else {
        final List<ImportRawdataExplainResultData> list =
            dataMap.get(contractNumber);
        list.add(data);
        dataMap.put(contractNumber, list);
      }
    }
    return dataMap;
  }

  private void initAnalysisOfStatisticalData() {
    // 初始化銷售分析-销售情况
    saSalesAnalysisService.initSalesAnalysis();
    // 初始化銷售情況-销售经理
    saManagerAnalysisService.initAllSalesManagerAnalysisData();
    // 初始化銷售情況-熱門品類銷售情况
    saCommodityAnalysisServer.initAllCommodityAnalysisData();
    // 初始化銷售情況-熱門品類銷售情况-详情
    saCommodityAnalysisServer.initSaConnodityDetail();
    // 初始化生產商分析-銷售情況
    saManufacturerAnalysisService.initSalesAnalysis();
    // 初始化生產商分析-客戶購買情況
    saManufacturerAnalysisService.initAllManufacturerAnalysisData();
    // 初始化生產商分析-客戶購買情況-详情
    saManufacturerAnalysisService.initManufacturerDetail();
    // 客戶分析-年度購買情況
    saGroupsAnalysisService.initSaGroupsAnalysis();
    // 客戶分析-品類購買情況
    saCommodityPurchaseService.initSaCommodityPurchaseAnalysis();
    // 客戶分析-品類購買情況-详情
    saCustomerDetailAnalysisService.initCustomerDetail();

  }

  // 获取与导入一直的合同清单
  private ContractGrade acquireTheSameContractAsImport(final Long coid,
      final String  gNumber, final Double volume, final String time) {
    ContractGrade cg = null;
    final List<ContractGrade> contractGrade =
        contractGradeMapper.getImportContractGradeByCoidAndGeid(coid, gNumber);

    for (final ContractGrade info : contractGrade) {
      if (cg == null) {
        cg = info;
      }
      if (info.getCgShipmtDate().equals(time)
          && info.getCgSalesVolume() == volume) {
        cg = info;
      }
    }
    return cg;
  }
}
