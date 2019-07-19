package com.plastech.crm.model.parameter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author wangJin
 *
 * @date 2019年3月7日 下午5:01:37
 *
 */
public class ExportParameters implements Serializable {

  private static final long serialVersionUID = 1L;
  private List<Long> list;
  private List<Map<String, Object>> userList;
  private String year;
  private Long id;
  private String name;

  /**
   * @return the list
   */
  public List<Long> getList() {
    return list;
  }

  /**
   * @param list the list to set
   */
  public void setList(final List<Long> list) {
    this.list = list;
  }

  /**
   * @return the year
   */
  public String getYear() {
    return year;
  }

  /**
   * @param year the year to set
   */
  public void setYear(final String year) {
    this.year = year;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * @return the userList
   */
  public List<Map<String, Object>> getUserList() {
    return userList;
  }

  /**
   * @param userList the userList to set
   */
  public void setUserList(final List<Map<String, Object>> userList) {
    this.userList = userList;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((list == null) ? 0 : list.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((userList == null) ? 0 : userList.hashCode());
    result = prime * result + ((year == null) ? 0 : year.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final ExportParameters other = (ExportParameters) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (list == null) {
      if (other.list != null)
        return false;
    } else if (!list.equals(other.list))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (userList == null) {
      if (other.userList != null)
        return false;
    } else if (!userList.equals(other.userList))
      return false;
    if (year == null) {
      if (other.year != null)
        return false;
    } else if (!year.equals(other.year))
      return false;
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "ExportParameters [list=" + list + ", userList=" + userList
        + ", year=" + year + ", id=" + id + ", name=" + name + "]";
  }



}
