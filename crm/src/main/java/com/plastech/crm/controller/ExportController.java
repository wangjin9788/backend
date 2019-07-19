package com.plastech.crm.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Strings;
import com.plastech.crm.config.ConfigUtil;
import com.plastech.crm.model.parameter.ExportParameters;
import com.plastech.crm.resultcode.ResultCodeExport26;
import com.plastech.crm.resultcode.ResultCodeSystem;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crm.resultdata.ResultUtil;

/**
 * @author wangJin
 *
 * @date 2019年3月7日 下午1:53:42
 *
 */
@RestController
@RequestMapping("/export-management")
public class ExportController extends BaseController {

  @GetMapping("/download")
  public void downloadExcel(
      @RequestParam(required = true, value = "uuid") final String uuid,
      @RequestParam(required = false, value = "fileName") final String fileName,
      final HttpServletResponse response) {
    try {
      // 获取文件的路径
      final String xlsx = uuid + ".xlsx";
      final String excelPath =
          ConfigUtil.getDownloadTempFolderPath() + "/" + xlsx;
      // 文件的默认保存名
      // 读到流中
      final InputStream inStream = new FileInputStream(excelPath);// 文件的存放路径
      // 设置输出的格式
      response.reset();
      response.setContentType("bin");
      // 下载后的名字
      response.addHeader("Content-Disposition",
          "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "UTF-8"));
      // 循环取出流中的数据
      final byte[] b = new byte[200];
      int len;

      while ((len = inStream.read(b)) > 0) {
        response.getOutputStream().write(b, 0, len);
      }
      inStream.close();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 品类销售导出
   *
   * @param param
   * @param fileName
   * @param response
   * @return
   */
  @PostMapping("/export/commodity")
  public ResultJson<String> exportCommoditySalesAnalysis(
      @RequestBody final ExportParameters param) {
    if (param.getList() == null || param.getList().isEmpty()) {
      return ResultUtil.getResult(ResultCodeExport26.RESULT_CODE_26002200);
    }
    if (param.getYear() == null) {
      return ResultUtil.getResult(ResultCodeExport26.RESULT_CODE_26002201);
    }
    final String url = exportService
        .exportCommoditySalesAnalysis(param.getList(), param.getYear());
    if (url == null) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_27001200);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, url,
        ResultCodeSystem.ADD_SUCCESS);
  }

  /**
   * 导出销售经理信息
   *
   * @param param
   * @param fileName
   * @param response
   * @return
   */

  @PostMapping("/export/sales/manager")
  public ResultJson<String> exportSalesManagerInfoList(
      @RequestBody final ExportParameters param) {
    if (param.getUserList() == null || param.getUserList().isEmpty()) {
      return ResultUtil.getResult(ResultCodeExport26.RESULT_CODE_26003200);
    }
    if (param.getYear() == null) {
      return ResultUtil.getResult(ResultCodeExport26.RESULT_CODE_26003201);
    }
    final String url = exportService
        .exportSalesManagerInfoList(param.getUserList(), param.getYear());
    if (Strings.isNullOrEmpty(url)) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_27001200);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, url,
        ResultCodeSystem.ADD_SUCCESS);
  }

  /**
   * 导出生产商信息
   *
   * @param param
   * @param fileName
   * @param response
   * @return
   */
  @PostMapping("/export/manufacturer")
  public ResultJson<String> exportManufacturerInfo(
      @RequestBody final ExportParameters param) {
    if (param.getList() == null || param.getList().isEmpty()) {
      return ResultUtil.getResult(ResultCodeExport26.RESULT_CODE_26004200);
    }
    if (param.getYear() == null) {
      return ResultUtil.getResult(ResultCodeExport26.RESULT_CODE_26004201);
    }
    final String url =
        exportService.exportManufacturerInfo(param.getList(), param.getYear());
    if (url == null) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_27001200);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, url,
        ResultCodeSystem.ADD_SUCCESS);
  }

  /**
   * 导出生产商客户信息
   *
   * @param param
   * @param fileName
   * @param response
   * @return
   */
  @PostMapping("/export/manufacturer/groups")
  public ResultJson<String> exportManufacturerGroupsInfo(
      @RequestBody final ExportParameters param) {
    if (param.getList() == null || param.getList().isEmpty()) {
      return ResultUtil.getResult(ResultCodeExport26.RESULT_CODE_26005200);
    }
    if (param.getYear() == null) {
      return ResultUtil.getResult(ResultCodeExport26.RESULT_CODE_26005201);
    }
    final String url = exportService.exportManufacturerGroupsInfo(
        param.getList(), param.getYear(), param.getId(), param.getName());
    if (url == null) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_27001200);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, url,
        ResultCodeSystem.ADD_SUCCESS);
  }

  /**
   * 导出客户分析信息
   *
   * @param param
   * @param fileName
   * @param response
   * @return
   */
  @PostMapping("/export/groups")
  public ResultJson<String> exportGroupsInfo(
      @RequestBody final ExportParameters param) {
    if (param.getList() == null || param.getList().isEmpty()) {
      return ResultUtil.getResult(ResultCodeExport26.RESULT_CODE_26006200);
    }
    if (param.getYear() == null) {
      return ResultUtil.getResult(ResultCodeExport26.RESULT_CODE_26006201);
    }
    final String url =
        exportService.exportGroupsInfo(param.getList(), param.getYear());
    if (url == null) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_27001200);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, url,
        ResultCodeSystem.ADD_SUCCESS);
  }

  /**
   * 导出合同
   *
   * @return
   */

  @GetMapping("/export/contract")
  public ResultJson<String> exportContract() {
    final String url = exportService.exportContract();
    if (url == null) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_27001200);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, url,
        ResultCodeSystem.ADD_SUCCESS);
  }

  /**
   * 导出供应商
   *
   * @return
   */

  @GetMapping("/export/supplier")
  public ResultJson<String> exportSupplier() {
    final String url = exportService.exportSupplier();
    if (url == null) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_27001200);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, url,
        ResultCodeSystem.ADD_SUCCESS);
  }

  /**
   * 导出客户
   *
   * @return
   */
  @GetMapping("/export/customer")
  public ResultJson<String> exportCustomer() {
    final String url = exportService.exportCustomer();
    if (url == null) {
      return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_27001200);
    }
    return ResultUtil.getResult(ResultCodeSystem.RESULT_CODE_0, url,
        ResultCodeSystem.ADD_SUCCESS);
  }
}
