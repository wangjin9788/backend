package com.plastech.crm.model.parameter;

import java.io.Serializable;
import java.util.List;

/**
 *
 *
 * @author : yemin
 * @date : 2018年12月26日 下午5:54:17
 *
 */
public class UpdatePermissionOfRoleParameters implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private List<Long> roleCheckedList;

  public final List<Long> getRoleCheckedList() {
    return roleCheckedList;
  }

  public final void setRoleCheckedList(final List<Long> roleCheckedList) {
    this.roleCheckedList = roleCheckedList;
  }


}
