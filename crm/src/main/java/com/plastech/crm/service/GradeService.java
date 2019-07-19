package com.plastech.crm.service;

import java.util.List;
import java.util.Map;
import com.plastech.crm.model.Grade;
import com.plastech.crm.model.parameter.AddOrUpdateGradeParameters;
import com.plastech.crm.model.vo.ContractGradeListView;
import com.plastech.crm.model.vo.GradeView;
import com.plastech.crm.model.vo.GroupsView;
import com.plastech.crm.resultdata.ResultJson;
import com.plastech.crmcommon.page.AppPageModel;

/**
 * @author wangJin
 *
 * @date 2019年1月14日 上午10:17:31
 *
 */
public interface GradeService {
  AppPageModel<List<GradeView>> searchGradeList(Integer currentpage,
      Integer perpage, Map<String, Object> map);

  ResultJson<Integer> createGrade(Long uId, AddOrUpdateGradeParameters param);

  ResultJson<Integer> updateGrade(Long geId, Long uId,
      AddOrUpdateGradeParameters param);

  ResultJson<Boolean> deleteGrade(Long geId);

  List<GroupsView> getGroupsSelectionForSupplier();

  List<ContractGradeListView> getContractGradeList();

  List<Map<String, Object>> getContractRelationNumberByGeid(final Long geid);

  Grade getCtidAndMfidByGeid(Long geid);
}
