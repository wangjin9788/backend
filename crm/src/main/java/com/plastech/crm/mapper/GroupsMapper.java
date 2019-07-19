package com.plastech.crm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.Groups;
import com.plastech.crm.model.vo.GroupsView;

public interface GroupsMapper extends BaseTkMapper<Groups> {

  List<GroupsView> getGroupsSelectionForSupplier();

  Groups selectByNameAndType(@Param("name") String name,
      @Param("type") Integer type);

  List<GroupsView> searchGroupsList(
      @Param(value = "searchKey") String searchKey);

  List<GroupsView> getGroupsChooseList();

  List<GroupsView> getContractGroupsByGid(@Param(value = "gid") Long gid);

}
