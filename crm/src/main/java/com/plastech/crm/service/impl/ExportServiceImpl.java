package com.plastech.crm.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.plastech.crm.config.ConfigUtil;
import com.plastech.crm.model.parameter.ExportDataInfoView;
import com.plastech.crm.model.vo.ContractExportView;
import com.plastech.crm.model.vo.ExportPropertyfeeInfoView;
import com.plastech.crm.model.vo.ExportSupplierAndGroupsView;
import com.plastech.crm.service.ExportService;
import com.plastech.crm.util.excel.ExcelDataUtil;
import com.plastech.crm.util.excel.ExportContractExcelTools;
import com.plastech.crm.util.excel.ExportExcelTools;
import com.plastech.crm.util.excel.ExportGroupsExcelTools;
import com.plastech.crm.util.excel.ExportGroupsManufactureExcelTools;
import com.plastech.crm.util.excel.ExportManufactureExcelTools;
import com.plastech.crm.util.excel.ExportSalesManagerExcelTools;
import com.plastech.crm.util.excel.ExportSupplierAndCustomerExcelTools;

/**
 * @author wangJin
 *
 * @date 2019年3月7日 下午2:02:09
 *
 */
@Service
public class ExportServiceImpl extends BaseService implements ExportService {

  @Override
  public String exportCommoditySalesAnalysis(final List<Long> ctidList,
      final String year) {
    try {
      final List<ExportDataInfoView> exportInfoList =
          commodityMapper.getExportCommodityInfoList(ctidList, year);
      if (exportInfoList != null && !exportInfoList.isEmpty()) {
        // 获取数据
        final Integer maxMonth = ExcelDataUtil.getMaxMonth(exportInfoList);
        final List<ExportPropertyfeeInfoView> completeExportedData =
            ExcelDataUtil.completeExportedData(exportInfoList, 1, maxMonth);
        // 获取总计
        final ExportPropertyfeeInfoView totalQuantity =
            ExcelDataUtil.totalQuantity(completeExportedData,1);
        completeExportedData.add(totalQuantity);
        // 4.保存待导入的文件
        filePath();
        final String exportXml = ExportExcelTools.exportXml(
            ConfigUtil.getExportTempFolderPath() + "/2.xlsx",
            completeExportedData, maxMonth + 4, year, "品类销售分析", "品类销售分析");
        return exportXml;
      }
    } catch (final Exception e) {
      logger.info("export commodity sales analysis", e);
    }
    return null;
  }

  @Override
  public String exportSalesManagerInfoList(
      final List<Map<String, Object>> userList, final String year) {
    try {

      // 4.保存待导入的文件
      filePath();
      // 获取数据
      final String exportXml = ExportSalesManagerExcelTools.exportXml(
          ConfigUtil.getExportTempFolderPath() + "/2.xlsx", year,
          commodityMapper, userList,"销售经理分析");
      return exportXml;
    } catch (final Exception e) {
      logger.info("export commodity sales analysis", e);
    }
    return null;
  }


  @Override
  public String exportManufacturerInfo(final List<Long> ctidList,
      final String year) {
    try {
      final List<ExportDataInfoView> exportInfoList =
          commodityMapper.getExportManufacturerInfoList(ctidList, year);
      if (exportInfoList != null && !exportInfoList.isEmpty()) {
        // 获取最大月份
        final Integer maxMonth = ExcelDataUtil.getMaxMonth(exportInfoList);
        final List<ExportPropertyfeeInfoView> completeExportedData =
            ExcelDataUtil.completeExportedData(exportInfoList, 3, maxMonth);
        // 获取总计
        final ExportPropertyfeeInfoView totalQuantity =
            ExcelDataUtil.totalQuantity(completeExportedData,3);

        completeExportedData.add(totalQuantity);
        // 4.保存待导入的文件
        filePath();
        // 把导出数据保留在本地
        final String exportXml = ExportManufactureExcelTools.exportXml(
            ConfigUtil.getExportTempFolderPath() + "/2.xlsx",
            completeExportedData, maxMonth + 4, year, "生产商分析表","生产商分析");
        return exportXml;
      }
    } catch (final Exception e) {
      logger.info("export commodity sales analysis", e);
    }
    return null;
  }

  @Override
  public String exportManufacturerGroupsInfo(final List<Long> ctidList,
      final String year, final Long mfid, final String name) {
    try {
      // 獲取数据
      final List<ExportDataInfoView> infoList = saManufacturerMapper
          .getExportManufacturerGroupsInfoList(ctidList, mfid, year);
      if (infoList != null && !infoList.isEmpty()) {
        // 获取最大月份
        final Integer maxMonth = ExcelDataUtil.getMaxMonth(infoList);
        final List<ExportPropertyfeeInfoView> completeExportedData =
            ExcelDataUtil.completeExportedData(infoList, 5, maxMonth);

        final ExportPropertyfeeInfoView totalQuantity =
            ExcelDataUtil.totalQuantity(completeExportedData,5);
        completeExportedData.add(totalQuantity);
        // 4.保存待导入的文件
        filePath();
        final String exportXml = ExportGroupsManufactureExcelTools.exportXml(
            ConfigUtil.getExportTempFolderPath() + "/2.xlsx",
            completeExportedData, maxMonth + 3, year, "客户分析", name,"客户分析按生产商");
        return exportXml;
      }
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public String exportGroupsInfo(final List<Long> gidList, final String year) {
    try {
      final List<ExportDataInfoView> infoList =
          saGroupsAnalysisMapper.getExportGroupsInfoList(year, gidList);
      if (infoList != null && !infoList.isEmpty()) {
        // 获取最大月份
        final Integer maxMonth = ExcelDataUtil.getMaxMonth(infoList);
        final List<ExportPropertyfeeInfoView> completeExportedData =
            ExcelDataUtil.completeExportedData(infoList, 4, maxMonth);
        // 获取总计
        final ExportPropertyfeeInfoView totalQuantity =
            ExcelDataUtil.totalQuantity(completeExportedData,4);

        completeExportedData.add(totalQuantity);
        // 4.保存待导入的文件
        filePath();
        final String exportXml = ExportGroupsExcelTools.exportXml(
            ConfigUtil.getExportTempFolderPath() + "/2.xlsx",
            completeExportedData, maxMonth + 2, year, "客户分析");
        return exportXml;
      }
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private void filePath() {
    final String folderPath = ConfigUtil.getExportTempFolderPath();
    final File folder = new File(folderPath);
    if (!folder.exists()) {
      folder.mkdirs();
    }
    final String downloadPath = ConfigUtil.getDownloadTempFolderPath();
    final File downloadFolder = new File(downloadPath);
    if (!downloadFolder.exists()) {
      downloadFolder.mkdirs();
    }
  }

  @Override
  public String exportContract() {
    try {
      final List<ContractExportView> list = contractMapper.exportContract();
      if (list != null && !list.isEmpty()) {
        // 4.保存待导入的文件
        filePath();
        final String url = ExportContractExcelTools.exportXml(
            ConfigUtil.getExportTempFolderPath() + "/contract.xlsx", list,"合同");
        return url;
      }
    } catch (final Exception e) {
      logger.info("export contract Exception:{}", e);
    }
    return null;
  }

  @Override
  public String exportSupplier() {
    try {
      final List<ExportSupplierAndGroupsView> list =
          supplierMapper.getExportSupplierInfoList();
      if (list != null && !list.isEmpty()) {
        filePath();
        final String url = ExportSupplierAndCustomerExcelTools.exportXml(
            ConfigUtil.getExportTempFolderPath() + "/export_supplier.xlsx",
            list,"供应商");
        return url;
      }
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public String exportCustomer() {
    try {
      final List<ExportSupplierAndGroupsView> list =
          customerMapper.getExportCustomerInfoList();
      if (list != null && !list.isEmpty()) {
        filePath();
        final String url = ExportSupplierAndCustomerExcelTools.exportXml(
            ConfigUtil.getExportTempFolderPath() + "/export_customer.xlsx",
            list,"客户");
        return url;
      }
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}
