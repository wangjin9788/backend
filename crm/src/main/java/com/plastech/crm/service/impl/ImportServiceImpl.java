package com.plastech.crm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.plastech.crm.model.ImportRawdata;
import com.plastech.crm.model.ImportRawdataDetail;
import com.plastech.crm.model.User;
import com.plastech.crm.model.parameter.ImportConfirmParameter;
import com.plastech.crm.model.vo.ImportRawdataExplainResultData;
import com.plastech.crm.model.vo.ImportRawdataExplainResultStatistics;
import com.plastech.crm.model.vo.ImportRawdataInfo;
import com.plastech.crm.service.ImportService;
import com.plastech.crm.service.LoyaltyService;
import com.plastech.crm.service.SaCommodityAnalysisServer;
import com.plastech.crm.service.SaCommodityPurchaseService;
import com.plastech.crm.service.SaCustomerDetailAnalysisService;
import com.plastech.crm.service.SaGroupsAnalysisService;
import com.plastech.crm.service.SaManagerAnalysisService;
import com.plastech.crm.service.SaManufacturerAnalysisService;
import com.plastech.crm.service.SaSalesAnalysisService;
import com.plastech.crm.util.AppPage;
import com.plastech.crm.util.CommonThreadPool;
import com.plastech.crm.util.UniqueStringGenerator;
import com.plastech.crm.util.thread.ImportRawdataConfirmThread;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月25日 上午10:31:38
 *
 */
@Service
public class ImportServiceImpl extends BaseService implements ImportService {

  @Override
  public boolean isNotExistUnfinishedImportRecords() {
    final ImportRawdata data =
        importRawdataMapper.selectUnFinishedImportRecord();
    if (data != null) {
      return false;
    }
    return true;
  }

  @Override
  public Long addImportRawdataRecord(final Integer type,
      final String sourceName, final User currentUser) {
    final ImportRawdata ir = new ImportRawdata();
    ir.setCreateTime(new Date());
    ir.setFailureCause("");
    ir.setFilename(sourceName);
    ir.setLastUpdateTime(new Date());
    ir.setNote("");
    ir.setOperatorId(currentUser != null ? currentUser.getUid() : 0L);
    ir.setOperatorName(currentUser != null ? currentUser.getUname() : "");
    ir.setProgress(0d);
    ir.setStatus(0);
    ir.setType(type);

    importRawdataMapper.insertSelective(ir);
    if (ir != null && ir.getIrid() != null && ir.getIrid() > 0) {
      ir.setNumber(UniqueStringGenerator.fillSymbolToNumber(ir.getIrid(), 8));
      importRawdataMapper.updateByPrimaryKey(ir);
      return ir.getIrid();
    }

    return 0L;
  }

  @Override
  public int insertImportRawdataDetail(final ImportRawdataDetail ird) {
    return importRawdataDetailMapper.insertSelective(ird);
  }

  @Override
  public int updateProgress(final Long irid, final double progress) {
    final ImportRawdata ir = importRawdataMapper.selectByPrimaryKey(irid);
    if (ir != null) {
      ir.setProgress(progress);
      return importRawdataMapper.updateByPrimaryKey(ir);

    }
    return 0;
  }

  @Override
  public int updateStatus(final Long irid, final int status) {
    final ImportRawdata ir = importRawdataMapper.selectByPrimaryKey(irid);
    if (ir != null) {
      ir.setStatus(status);
      return importRawdataMapper.updateByPrimaryKey(ir);
    }
    return 0;
  }

  @Override
  public AppPage<List<ImportRawdataInfo>> getImportRawdataRecord(
      final Map<String, String> parameter, final Integer currentpage,
      final Integer perpage) {
    final AppPage<List<ImportRawdataInfo>> page =
        new AppPage<>(perpage, currentpage);
    page.start();
    final List<ImportRawdataInfo> list =
        importRawdataMapper.searchImportRawdataList(parameter);
    page.setResult(list);
    return page;
  }

  @Override
  public ImportRawdataExplainResultStatistics getExplainResultStatistics(
      final Long irid) {
    final ImportRawdataExplainResultStatistics irResult =
        new ImportRawdataExplainResultStatistics(irid);
    final ImportRawdata ir = importRawdataMapper.selectByPrimaryKey(irid);
    if (ir == null) {
      logger.info("Import rawdta record is not exist,irid : {}", irid);
      return irResult;
    }

    irResult.setStatus(ir.getStatus());
    irResult.setFailureCause(ir.getFailureCause());
    final Long abnormalCount =
        importRawdataDetailMapper.selectCountByIridAndType(irid, 2);
    final Long insertCount =
        importRawdataDetailMapper.selectCountByIridAndType(irid, 0);
    final Long updateCount =
        importRawdataDetailMapper.selectCountByIridAndType(irid, 1);
    irResult.setAbnormalCount(abnormalCount);
    irResult.setInsertCount(insertCount);
    irResult.setUpdateCount(updateCount);

    return irResult;
  }

  @Override
  public AppPage<List<ImportRawdataExplainResultData>> getExplainResultDetail(
      final Long irid, final Integer searchtype, final Integer currentpage,
      final Integer perpage) {
    final AppPage<List<ImportRawdataExplainResultData>> page =
        new AppPage<>(perpage, currentpage);
    page.start();
    final List<ImportRawdataExplainResultData> list =
        importRawdataDetailMapper.getExplainResultDataList(irid, searchtype);
    page.setResult(list);
    return page;
  }

  @Override
  public boolean confirm(final ImportConfirmParameter param, final Long uid,
      final SaSalesAnalysisService saSalesAnalysisService,
      final SaManagerAnalysisService saManagerAnalysisService,
      final SaCommodityAnalysisServer saCommodityAnalysisServer,
      final SaManufacturerAnalysisService saManufacturerAnalysisService,
      final SaGroupsAnalysisService saGroupsAnalysisService,
      final SaCommodityPurchaseService saCommodityPurchaseService,
      final SaCustomerDetailAnalysisService saCustomerDetailAnalysisService,
      final LoyaltyService loyaltyService) {
    final ImportRawdata ir =
        importRawdataMapper.selectByPrimaryKey(param.getIrid());
    if (ir == null) {
      logger.info("Import rawdta record is not exist,irid : {}",
          param.getIrid());
      return false;
    }
    ir.setStatus(2);
    importRawdataMapper.updateByPrimaryKey(ir);
    final boolean addRes =
        CommonThreadPool.addTaskToSingleQueue(new ImportRawdataConfirmThread(ir,
            param.getOperateType(), importRawdataMapper,
            importRawdataDetailMapper, contractMapper, customerMapper,
            supplierMapper, commodityMapper, manufacturerMapper, gradeMapper,
            contractGradeMapper, contractPurchaseMapper, this, groupsMapper,
            userMapper, uid, saSalesAnalysisService, saManagerAnalysisService,
            saCommodityAnalysisServer, saManufacturerAnalysisService,
            saGroupsAnalysisService, saCommodityPurchaseService,
            saCustomerDetailAnalysisService, loyaltyService));
    return addRes;
  }

  @Override
  public boolean updateImportDetailStatus(final Long irdid,final Integer type) {
    try {
      importRawdataDetailMapper.updateImportDetailStatus(irdid,type);
      return true;
    } catch (final Exception e) {
     logger.info("update Import Detail status",e);
    }
    return false;
  }

}
