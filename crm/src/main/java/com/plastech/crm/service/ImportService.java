package com.plastech.crm.service;

import java.util.List;
import java.util.Map;
import com.plastech.crm.model.ImportRawdataDetail;
import com.plastech.crm.model.User;
import com.plastech.crm.model.parameter.ImportConfirmParameter;
import com.plastech.crm.model.vo.ImportRawdataExplainResultData;
import com.plastech.crm.model.vo.ImportRawdataExplainResultStatistics;
import com.plastech.crm.model.vo.ImportRawdataInfo;
import com.plastech.crm.util.AppPage;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月25日 上午10:31:16
 *
 */
public interface ImportService {

  boolean isNotExistUnfinishedImportRecords();

  Long addImportRawdataRecord(Integer type, String sourceName,
      User currentUser);

  int insertImportRawdataDetail(ImportRawdataDetail ird);

  int updateProgress(Long irid, double progress);

  int updateStatus(Long irid, int i);

  AppPage<List<ImportRawdataInfo>> getImportRawdataRecord(
      Map<String, String> parameter, Integer currentpage, Integer perpage);

  ImportRawdataExplainResultStatistics getExplainResultStatistics(Long irid);

  AppPage<List<ImportRawdataExplainResultData>> getExplainResultDetail(
      Long irid, Integer searchtype, Integer currentpage, Integer perpage);

  boolean confirm(ImportConfirmParameter param,Long uid, SaSalesAnalysisService saSalesAnalysisService,
      SaManagerAnalysisService saManagerAnalysisService,SaCommodityAnalysisServer saCommodityAnalysisServer,
      SaManufacturerAnalysisService saManufacturerAnalysisService,SaGroupsAnalysisService
      saGroupsAnalysisService,SaCommodityPurchaseService saCommodityPurchaseService,SaCustomerDetailAnalysisService
      saCustomerDetailAnalysisService,LoyaltyService loyaltyService);

  boolean updateImportDetailStatus(Long irdid,Integer type);

}
