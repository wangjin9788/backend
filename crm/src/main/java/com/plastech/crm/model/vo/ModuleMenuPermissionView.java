package com.plastech.crm.model.vo;

import java.io.Serializable;

/**
 *
 *
 * @author : yemin
 * @date : 2018年12月25日 上午10:57:37
 *
 */
public class ModuleMenuPermissionView implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private Long pmid;// id

  private String permissionName;// 访问、管理

  private String selected;// 是否选中。1：已选中，0：未选中

  private String menuName;// 菜单名称

  private String menuCode;//菜单编码

  private String moduleName;// 模块名称

  private String moduleCode;// 模块编码

  public final String getMenuCode() {
    return menuCode;
  }

  public final void setMenuCode(final String menuCode) {
    this.menuCode = menuCode;
  }

  public final String getModuleCode() {
    return moduleCode;
  }

  public final void setModuleCode(final String moduleCode) {
    this.moduleCode = moduleCode;
  }

  public final String getModuleName() {
    return moduleName;
  }

  public final void setModuleName(final String moduleName) {
    this.moduleName = moduleName;
  }

  public final String getMenuName() {
    return menuName;
  }

  public final void setMenuName(final String menuName) {
    this.menuName = menuName;
  }

  public final Long getPmid() {
    return pmid;
  }

  public final void setPmid(final Long pmid) {
    this.pmid = pmid;
  }

  public final String getPermissionName() {
    return permissionName;
  }

  public final void setPermissionName(final String permissionName) {
    this.permissionName = permissionName;
  }

  public final String getSelected() {
    return selected;
  }

  public final void setSelected(final String selected) {
    this.selected = selected;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((permissionName == null) ? 0 : permissionName.hashCode());
    result = prime * result + ((pmid == null) ? 0 : pmid.hashCode());
    result = prime * result + ((selected == null) ? 0 : selected.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final ModuleMenuPermissionView other = (ModuleMenuPermissionView) obj;
    if (permissionName == null) {
      if (other.permissionName != null) {
        return false;
      }
    } else if (!permissionName.equals(other.permissionName)) {
      return false;
    }
    if (pmid == null) {
      if (other.pmid != null) {
        return false;
      }
    } else if (!pmid.equals(other.pmid)) {
      return false;
    }
    if (selected == null) {
      if (other.selected != null) {
        return false;
      }
    } else if (!selected.equals(other.selected)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ModuleMenuPermissionView [pmid=" + pmid + ", permissionName="
        + permissionName + ", selected=" + selected + "]";
  }

}
