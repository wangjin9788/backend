package com.plastech.crm.service;

import java.util.List;
import com.plastech.crm.model.parameter.AddOrUpdateGroupsParameters;
import com.plastech.crm.model.vo.GroupsView;
import com.plastech.crm.resultdata.ResultJson;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月15日 上午10:01:04
 *
 */
public interface GroupsService {

  int addOrUpdateGroups(AddOrUpdateGroupsParameters param, Long currentUid);

  List<GroupsView> searchGroupsList(String searchkey);

  List<GroupsView> getGroupsChooseList();

  ResultJson<Boolean> updateGroupsName(Long gid,
      AddOrUpdateGroupsParameters param, Long uid);

  ResultJson<Boolean> deleteGroups(Long gid);


}
