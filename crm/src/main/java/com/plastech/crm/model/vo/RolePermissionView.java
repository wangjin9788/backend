package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 *
 *
 * @author : yemin
 * @date : 2018年12月25日 下午3:12:01
 *
 */
public class RolePermissionView implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private List<ModuleView> moduleViewList;

  private List<ModuleMenuPermissionView> permissionList;//冗余内容：前端赋值用

  public final List<ModuleView> getModuleViewList() {
    return moduleViewList;
  }

  public final void setModuleViewList(final List<ModuleView> moduleViewList) {
    this.moduleViewList = moduleViewList;
  }

  public final List<ModuleMenuPermissionView> getPermissionList() {
    return permissionList;
  }

  public final void setPermissionList(
      final List<ModuleMenuPermissionView> permissionList) {
    this.permissionList = permissionList;
  }

}
