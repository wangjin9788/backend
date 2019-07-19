package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author : yemin
 * @date : 2018年12月25日 上午10:56:56
 *
 */
public class ModuleMenuView implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String menuName;

  private List<ModuleMenuPermissionView> permissionList = new ArrayList<>();

  public final String getMenuName() {
    return menuName;
  }

  public final void setMenuName(final String menuName) {
    this.menuName = menuName;
  }

  public final List<ModuleMenuPermissionView> getPermissionList() {
    return permissionList;
  }

  public final void setPermissionList(
      final List<ModuleMenuPermissionView> permissionList) {
    this.permissionList = permissionList;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
    result = prime * result
        + ((permissionList == null) ? 0 : permissionList.hashCode());
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
    final ModuleMenuView other = (ModuleMenuView) obj;
    if (menuName == null) {
      if (other.menuName != null) {
        return false;
      }
    } else if (!menuName.equals(other.menuName)) {
      return false;
    }
    if (permissionList == null) {
      if (other.permissionList != null) {
        return false;
      }
    } else if (!permissionList.equals(other.permissionList)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ModuleMenuView [menuName=" + menuName + ", permissionList="
        + permissionList + "]";
  }

  public void addPerssion(final ModuleMenuPermissionView permission) {
    if (this.permissionList == null) {
      this.permissionList = new ArrayList<>();
    }
    this.permissionList.add(permission);
  }

}
