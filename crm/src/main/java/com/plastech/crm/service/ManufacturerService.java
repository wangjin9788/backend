package com.plastech.crm.service;

import java.util.List;
import com.plastech.crm.model.vo.ManufacturerView;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author 王进
 *
 */
public interface ManufacturerService {

  AppPageModel<List<ManufacturerView>> searchManufacturer(Integer currentpage,
      Integer perpage, String searchKey);

  ResultJson<Integer> createManufacturer(Long uId, String name);

  ResultJson<Integer> updateManufacturer(Long mfId, Long uId, String name);

  ResultJson<Integer> deleteManufacturer(Long mfId);

  List<ManufacturerView> getManufacturerChooseList();
}
