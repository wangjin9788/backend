package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * permission view
 *
 * @author : yemin
 * @date : 2018年12月25日 上午10:48:25
 *
 */
public class ModuleView implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String moduleName;

  private List<ModuleMenuView> menuList = new ArrayList<>();

  public final String getModuleName() {
    return moduleName;
  }

  public final void setModuleName(final String moduleName) {
    this.moduleName = moduleName;
  }

  public final List<ModuleMenuView> getMenuList() {
    return menuList;
  }

  public final void setMenuList(final List<ModuleMenuView> menuList) {
    this.menuList = menuList;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((menuList == null) ? 0 : menuList.hashCode());
    result =
        prime * result + ((moduleName == null) ? 0 : moduleName.hashCode());
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
    final ModuleView other = (ModuleView) obj;
    if (menuList == null) {
      if (other.menuList != null) {
        return false;
      }
    } else if (!menuList.equals(other.menuList)) {
      return false;
    }
    if (moduleName == null) {
      if (other.moduleName != null) {
        return false;
      }
    } else if (!moduleName.equals(other.moduleName)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ModuleView [moduleName=" + moduleName + ", menuList=" + menuList
        + "]";
  }

  public void addMenuList(final ModuleMenuView menu) {
    if (this.menuList == null) {
      this.menuList = new ArrayList<>();
    }
    this.menuList.add(menu);
  }

}
