package com.plastech.crm.mapper;

import java.util.List;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.Role;
import com.plastech.crm.model.vo.RoleView;

public interface RoleMapper extends BaseTkMapper<Role> {

  Role selectRoleByUid(Long uid);

  List<RoleView> getAllRoles();
}
