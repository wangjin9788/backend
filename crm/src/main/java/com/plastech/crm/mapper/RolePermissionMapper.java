package com.plastech.crm.mapper;

import java.util.List;
import com.plastech.crm.base.BaseTkMapper;
import com.plastech.crm.model.RolePermission;
import com.plastech.crm.model.vo.Authority;
import com.plastech.crm.model.vo.ModuleMenuPermissionView;

public interface RolePermissionMapper extends BaseTkMapper<RolePermission> {

  List<Authority> getAllAuthorities();

  List<ModuleMenuPermissionView> getPermissionViewByRoleid(Long roleid);

  int deleteByRoleid(Long roleid);
}
