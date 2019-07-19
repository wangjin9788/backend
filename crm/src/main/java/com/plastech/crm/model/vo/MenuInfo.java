package com.plastech.crm.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author : yemin
 * @date : 2018年9月12日 下午2:37:01
 *
 */
public class MenuInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  private String parentCode;
  private String code;
  private Integer type;
  private String key;
  private String title;
  private String icon;
  private Integer manager;// 1:有管理权限，0：无管理权限
  private Integer export;// 1:有导出权限，0：没有导出权限
  private List<MenuInfo> sub;

  // 查询字段不能为key，所以用ikey
  public final void setIkey(final String ikey) {
    this.key = ikey;
  }

  public final Integer getExport() {
    return export;
  }

  public final void setExport(final Integer export) {
    this.export = export;
  }

  public final String getCode() {
    return code;
  }

  public final void setCode(final String code) {
    this.code = code;
  }

  public final String getParentCode() {
    return parentCode;
  }

  public final void setParentCode(final String parentCode) {
    this.parentCode = parentCode;
  }

  public final Integer getType() {
    return type;
  }

  public final void setType(final Integer type) {
    this.type = type;
  }

  public final Integer getManager() {
    return manager;
  }

  public final void setManager(final Integer manager) {
    this.manager = manager;
  }

  public final String getKey() {
    return key;
  }

  public final void setKey(final String key) {
    this.key = key;
  }

  public final String getTitle() {
    return title;
  }

  public final void setTitle(final String title) {
    this.title = title;
  }

  public final String getIcon() {
    return icon;
  }

  public final void setIcon(final String icon) {
    this.icon = icon;
  }

  public final List<MenuInfo> getSub() {
    return sub;
  }

  public final void setSub(final List<MenuInfo> sub) {
    this.sub = sub;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((icon == null) ? 0 : icon.hashCode());
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    result = prime * result + ((sub == null) ? 0 : sub.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
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
    final MenuInfo other = (MenuInfo) obj;
    if (icon == null) {
      if (other.icon != null) {
        return false;
      }
    } else if (!icon.equals(other.icon)) {
      return false;
    }
    if (key == null) {
      if (other.key != null) {
        return false;
      }
    } else if (!key.equals(other.key)) {
      return false;
    }
    if (sub == null) {
      if (other.sub != null) {
        return false;
      }
    } else if (!sub.equals(other.sub)) {
      return false;
    }
    if (title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (!title.equals(other.title)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "MenuInfo [key=" + key + ", title=" + title + ", icon=" + icon
        + ", sub=" + sub + "]";
  }

  public void addSubMenu(final MenuInfo currentSubMenu) {
    if (this.sub == null) {
      this.sub = new ArrayList<>();
    }
    if (currentSubMenu != null) {
      this.sub.add(currentSubMenu);
    }
  }

}
