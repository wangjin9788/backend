package com.plastech.crm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.google.common.base.Strings;
import com.plastech.crm.config.ConfigUtil;
import com.plastech.crm.model.Grade;
import com.plastech.crm.model.parameter.ImportConfirmParameter;
import com.plastech.crm.model.vo.ImportContractView;
import com.plastech.crm.model.vo.ImportRawdataExplainResultData;
import com.plastech.crm.model.vo.ImportRawdataExplainResultStatistics;
import com.plastech.crm.model.vo.ImportRawdataInfo;
import com.plastech.crm.resultcode.ResultCodeImport15;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;
import com.plastech.crm.util.AppPage;
import com.plastech.crm.util.CommonThreadPool;
import com.plastech.crm.util.RequestParseUtil;
import com.plastech.crm.util.UniqueStringGenerator;
import com.plastech.crm.util.thread.ImportRawDataExplainThread;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月24日 下午4:51:58
 *
 */
@RestController
@RequestMapping("/import-management")
public class ImportController extends BaseController {

  /**
   * excel原始数据导入
   *
   * @param file
   * @param type
   * @param request
   * @return
   */
  @PostMapping("/raw-data/import")
  public ResultJson<Object> importRawData(
      @RequestParam("file") final MultipartFile file,
      final HttpServletRequest request) {
    String sourceName = "";
    try {
      // 1.获取上传的文件、读取文件名称
      if (file.isEmpty()) {
        return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15001100);
      }
      sourceName = file.getOriginalFilename(); // 原始文件名
      if (sourceName == null) {
        return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15001301);
      }

      // 2.检查文件类型
      final String fileType =
          sourceName.substring(sourceName.lastIndexOf(".") + 1);
      if (Strings.isNullOrEmpty(fileType)
          || (!"xlsx".equals(fileType.toLowerCase())
              && !"xls".equals(fileType.toLowerCase()))) {
        return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15001300,
            null, ResultCodeImport15.RESULT_MSG_15001300 + ":"
                + (fileType != null ? fileType : ""));
      }

      // 3.检查最近是否有未完成的导入记录(true:没有，false：有)
      final boolean checkRes =
          importService.isNotExistUnfinishedImportRecords();
      if (!checkRes) {
        return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15001302);
      }

      // 4.保存待导入的文件
      final String folderPath = ConfigUtil.getUploadTempFolderPath();
      final File folder = new File(folderPath);
      if (!folder.exists()) {
        folder.mkdirs();
      }
      final String filePath = folderPath + File.separator
          + UniqueStringGenerator.get16UUID() + "." + fileType;// 保留excel的后缀
      file.transferTo(new File(filePath));
      // 校验token是否为空
      final String token = RequestParseUtil.getToken(request);
      if (Strings.isNullOrEmpty(token)) {
        return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_9, null,
            "未攜帶token，操作無效");
      }
      final Long irid = importService.addImportRawdataRecord(0, sourceName,
          getCurrentUser(request));

      // 5.异步解析文件内容
      if (irid != null && irid > 0) {
        final boolean taskRes = CommonThreadPool
            .addTaskToSingleQueue(new ImportRawDataExplainThread(filePath, irid,
                importService, contractService));
        if (taskRes) {
          return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, null,
              "Upload Success");// 成功
        }
      }
    } catch (final Exception e) {
      logger.error("CRM文件导入失败 : {} , {}", sourceName, e);
    }

    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_50, null,
        "Upload Failure.");// 失败
  }

  /**
   * 搜索导入记录
   *
   * @param status
   * @param searchkey
   * @param currentpage
   * @param perpage
   * @return
   */
  @GetMapping("/import-rawdata-records/search")
  public ResultJson<AppPage<List<ImportRawdataInfo>>> getImportRawdataRecord(
      @RequestParam(value = "status", required = false) final Integer status,
      @RequestParam(value = "searchkey",
          required = false) final String searchkey,
      @RequestParam(required = false,
          value = "currentpage") final Integer currentpage,
      @RequestParam(required = false,
          value = "perpage") final Integer perpage) {
    final Map<String, String> parameter = new HashMap<String, String>();
    if (status != null && status >= 0) {
      parameter.put("status", status + "");
    }
    if (!Strings.isNullOrEmpty(searchkey)) {
      parameter.put("searchkey", "%" + searchkey.trim() + "%");
    }

    final AppPage<List<ImportRawdataInfo>> page =
        importService.getImportRawdataRecord(parameter, currentpage, perpage);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, page,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * 查询某条导入记录的分析结果统计信息
   *
   * @param irid
   * @return
   */
  @GetMapping("/import-rawdata-records/{irid}/statistics")
  public ResultJson<ImportRawdataExplainResultStatistics> getExplainResultStatistics(
      @PathVariable("irid") final Long irid) {
    if (irid == null || irid.longValue() <= 0) {
      return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15002200);
    }

    final ImportRawdataExplainResultStatistics result =
        importService.getExplainResultStatistics(irid);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, result,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * 查询某条导入记录的分析结果详细数据信息
   *
   * @param irid
   * @return
   */
  @GetMapping("/import-rawdata-records/{irid}/data")
  public ResultJson<AppPage<List<ImportRawdataExplainResultData>>> getExplainResultData(
      @PathVariable("irid") final Long irid,
      @RequestParam(required = true,
          value = "searchtype") final Integer searchtype,
      @RequestParam(required = false,
          value = "currentpage") final Integer currentpage,
      @RequestParam(required = false,
          value = "perpage") final Integer perpage) {
    if (irid <= 0) {
      return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15003200);
    }
    if (searchtype == null || searchtype.intValue() < 0
        || searchtype.intValue() > 5) {
      return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15003201);
    }

    final AppPage<List<ImportRawdataExplainResultData>> page = importService
        .getExplainResultDetail(irid, searchtype, currentpage, perpage);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, page,
        ResultCodeSystem.SELECT_SUCCESS);
  }

  /**
   * 确认/取消 导入
   *
   * @param param
   * @return
   */
  @PostMapping("/import-rawdata-records/{irid}/confirm")
  public ResultJson<Boolean> importConfirm(
      @PathVariable("irid") final Long irid,
      @RequestBody final ImportConfirmParameter param,
      final HttpServletRequest request) {
    if (irid <= 0) {
      return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15004200);
    }
    final Integer operateType = param.getOperateType();
    if (operateType == null) {
      return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15004100);
    }
    if (operateType.intValue() != 0 && operateType.intValue() != 1) {
      return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15004201);
    }
    final Long uid = getCurrentUid(request);
    param.setIrid(irid);
    final boolean res = importService.confirm(param, uid,
        saSalesAnalysisService, saManagerAnalysisService,
        saCommodityAnalysisServer, saManufacturerAnalysisService,
        saGroupsAnalysisService, saCommodityPurchaseService,
        saCustomerDetailAnalysisService, loyaltyService);
    return ResultUtil.getResult(
        res ? ResultCodeSystem.RESULT_CODE_0 : ResultCodeSystem.RESULT_CODE_50,
        null,
        res ? ResultCodeSystem.OPERATE_SUCCESS : ResultCodeSystem.OPERATE_FAIL);
  }

  // 变更导入状态
  @GetMapping("/import-rawdata-records/{irdid}/status")
  public ResultJson<Boolean> updateImportDetailStatus(
      @PathVariable("irdid") final Long irdid,
      @RequestParam("type") final Integer type,
      final HttpServletRequest request) {
    if (irdid <= 0) {
      return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15007200);
    }
    if (type == null || type < 0) {
      return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15007200);
    }
    final boolean isSuccess =
        importService.updateImportDetailStatus(irdid, type);
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, isSuccess,
        ResultCodeSystem.OPERATE_SUCCESS);
  }

  // 分析数据类型
  @GetMapping("/import-rawdata-records/type")
  public ResultJson<Boolean> getDataType(
      @RequestParam(required = false, value = "number") final String number,
      @RequestParam(required = false, value = "cuName") final String cuName,
      @RequestParam(required = false, value = "uName") final String uName,
      @RequestParam(required = false,
          value = "gradeNumber") final String gradeNumber) {

    if (Strings.isNullOrEmpty(number)) {
      return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15008200);
    }
    if (Strings.isNullOrEmpty(cuName)) {
      return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15008201);
    }
    if (Strings.isNullOrEmpty(uName)) {
      return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15008202);
    }
    if (Strings.isNullOrEmpty(gradeNumber)) {
      return ResultUtil.getResult(ResultCodeImport15.RESULT_CODE_15008203);
    }
    Boolean status = false;
    final ImportContractView isNotExist =
        contractService.isImportContractNumberNotExist(number);
    if (isNotExist != null && isNotExist.getNumber().equals(number)
        && isNotExist.getCuName().equalsIgnoreCase(cuName)
        && isNotExist.getuName().equals(uName)) {
      for (final Grade grade : isNotExist.getGradeList()) {
        if (grade.getGradeNumber().equals(gradeNumber)) {// 都相等牌号也相等是编辑，否则就是新增
          status = true;
          break;
        }
      }
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, status,
        ResultCodeSystem.SELECT_SUCCESS);
  }

}
