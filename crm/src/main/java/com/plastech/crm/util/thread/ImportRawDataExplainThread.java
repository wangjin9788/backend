package com.plastech.crm.util.thread;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Strings;
import com.plastech.crm.model.Grade;
import com.plastech.crm.model.ImportRawdataDetail;
import com.plastech.crm.model.vo.ImportContractView;
import com.plastech.crm.service.ContractService;
import com.plastech.crm.service.ImportService;
import com.plastech.crm.util.ExcelTools;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月25日 下午1:51:26
 *
 */
public class ImportRawDataExplainThread implements Runnable {

  private static Logger logger =
      LoggerFactory.getLogger(ImportRawDataExplainThread.class);

  private final ImportService importService;
  private final ContractService contractService;
  private final String filePath;
  private final Long irid;

  public ImportRawDataExplainThread(final String filePath, final Long irid,
      final ImportService importService,
      final ContractService contractService) {
    this.filePath = filePath;
    this.irid = irid;
    this.importService = importService;
    this.contractService = contractService;
  }

  @Override
  public void run() {
    // 1.读取excel
    List<String[]> readRes = null;
    try {
      readRes = ExcelTools.readExcelByPoi(filePath, 0, 23);
      if (readRes == null || readRes.size() == 0) {
        importService.updateStatus(irid, 5);
        return;
      }
    } catch (final Exception e) {
      logger.error("excel解析出现错误，{}", e);
      importService.updateStatus(irid, 5);
      return;
    }

    // 2.数据分析
    int countFlag = 0;// 计数
    for (final String[] strArr : readRes) {
      final ImportRawdataDetail ird = setData(strArr);
      importService.insertImportRawdataDetail(ird);
      countFlag++;

      // 每10条记录更新一次进度，数据读完的时候更新一次进度
      if (countFlag > 0
          && (countFlag % 10 == 0 || countFlag == readRes.size())) {
        double progress = (double) countFlag / readRes.size() * 100.0;
        progress = BigDecimal.valueOf(progress)
            .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        importService.updateProgress(irid, progress);
      }
    }

    importService.updateStatus(irid, 1);// 更新导入记录状态
  }

  private ImportRawdataDetail setData(final String[] strArr) {
    final ImportRawdataDetail ird = new ImportRawdataDetail();

    ird.setIrid(irid);
    ird.setType(getDataType(strArr));
    ird.setCustomer(trim(strArr[0]));
    ird.setGroups(trim(strArr[1]));
    ird.setContNo(trim(strArr[2]));
    ird.setGrade(trim(strArr[3]));
    ird.setCommodity(trim(strArr[4]));
    ird.setManufacturer(trim(strArr[5]));
    ird.setQtyMt(trim(strArr[6]));
    ird.setShipmt(trim(strArr[7]));
    ird.setPriceMt(trim(strArr[8]));
    ird.setTotal(trim(strArr[9]));
    ird.setTerm(trim(strArr[10]));
    ird.setTerm3(trim(strArr[11]));
    ird.setPriceMt2(trim(strArr[12]));
    ird.setTotal2(trim(strArr[13]));
    ird.setTerm2(trim(strArr[14]));
    ird.setTerm4(trim(strArr[15]));
    ird.setSupplier(trim(strArr[16]));
    ird.setProfit(trim(strArr[17]));
    ird.setLogisticsFee(trim(strArr[18]));
    ird.setLogisticsFee2(trim(strArr[19]));
    ird.setNetProfit(trim(strArr[20]));
    ird.setSalseManager(trim(strArr[21]));
    ird.setSigningTime(trim(strArr[22]));
    ird.setCreateTime(new Date());
    ird.setNote("");
    return ird;
  }

  // 分析数据类型
  private int getDataType(final String[] strArr) {
    int type = 0;// 0：新增，1：更新，2：异常
    if (Strings.isNullOrEmpty(strArr[0]) || Strings.isNullOrEmpty(strArr[1])
        || Strings.isNullOrEmpty(strArr[2]) || Strings.isNullOrEmpty(strArr[3])

        || Strings.isNullOrEmpty(trim(strArr[21]))) {
      type = 2;
    } else {
      final String contNo = trim(strArr[2]);// 合同编号
      final ImportContractView isNotExist =
          contractService.isImportContractNumberNotExist(contNo);
      if (isNotExist == null) {
        type = 0;
      } else if (isNotExist.getNumber().equals(contNo)
          && isNotExist.getCuName().equalsIgnoreCase(trim(strArr[0]))
          && isNotExist.getuName().equals(trim(strArr[21]))) {
        for (final Grade grade : isNotExist.getGradeList()) {
          if (grade.getGradeNumber().equals(trim(strArr[3]))) {// 都相等牌号也相等是编辑，否则就是新增
            type = 1;
            break;
          }
        }
      } else if (isNotExist.getNumber().equals(contNo)
          && !isNotExist.getCuName().equalsIgnoreCase(trim(strArr[0]))) {
        type = 2;
      } else if (isNotExist.getNumber().equals(contNo)
          && isNotExist.getCuName().equalsIgnoreCase(trim(strArr[0]))
          && !isNotExist.getuName().equals(trim(strArr[21]))) {// 合同标号和客户名称存在但经理不相同就视为异常数据
        type = 2;
      }
    }
    return type;
  }

  private static String trim(final String str) {
    return str != null ? str.trim() : str;
  }

}
