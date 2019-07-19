package com.plastech.crm.service;

import java.util.List;
import com.plastech.crm.model.vo.CommodityView;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author 王进
 *
 */
public interface CommodityService {

  AppPageModel<List<CommodityView>> searchCommodity(Integer currentpage,
      Integer perpage, String searchKey);

  ResultJson<Integer> createCommodity(Long uid, String name);

  ResultJson<Integer> deleteCommodity(Long ctId);

  List<CommodityView> getCommodityChooseList();

}
