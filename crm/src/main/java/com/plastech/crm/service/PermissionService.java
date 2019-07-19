package com.plastech.crm.service;

import java.util.List;
import java.util.Map;
import com.plastech.crm.model.vo.RolePermissionView;
import com.plastech.crm.model.vo.RoleView;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月21日 下午3:35:07
 *
 */
public interface PermissionService {

  Map<String, String> loadFilterChainDefinitions();

  boolean reloadFilterChain();

  boolean updatePermissionOfRole(Long roleid, List<Long> pmidList);

  List<RoleView> getAllRoles();

  RolePermissionView getModulePermissionViewByRoleid(Long roleid);

}
