package com.plastech.crm.service;

import java.util.List;
import java.util.Map;

/**
 * @author wangJin
 *
 * @date 2019年3月7日 下午2:01:53
 *
 */
public interface ExportService {
  String exportCommoditySalesAnalysis(List<Long> ctidList, String year);

  String exportSalesManagerInfoList(List<Map<String, Object>> userList,
      String year);

  String exportManufacturerInfo(List<Long> list, String year);

  String exportManufacturerGroupsInfo(List<Long> ctidList, String year,
      Long mfid, String name);

  String exportGroupsInfo(List<Long> ctidList, String year);

  String exportContract();

  String exportSupplier();

  String exportCustomer();

}
