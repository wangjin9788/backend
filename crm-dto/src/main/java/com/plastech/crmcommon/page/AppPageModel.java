package com.plastech.crmcommon.page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 *
 * @author yemin
 *
 */
public class AppPageModel<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  private int perpage = 10;// 每页显示多少条
  private int currentpage = 1;// 当前显示第几页
  private int totalcount = 0;// 总共有多少条
  private int totalpage = 0;// 总共有多少页

  private List<T> data;// 放数据

  public AppPageModel() {
    super();
  }

  public AppPageModel(final int perpage, final int currentpage,
      final int totalcount, final int totalpage, final List<T> data) {
    super();
    this.perpage = perpage;
    this.currentpage = currentpage;
    this.totalcount = totalcount;
    this.totalpage = totalpage;
    this.data = data;
  }



  public int getPerpage() {
    return perpage;
  }

  public void setPerpage(final int perpage) {
    this.perpage = perpage;
    if (totalcount != 0)
      setTotalcount(totalcount);// 重新设置条数和页数（计算页数会用到everyPageCount）
  }

  public int getCurrentpage() {
    return currentpage;
  }

  public void setCurrentpage(final int currentpage) {
    this.currentpage = currentpage;
  }

  public int getTotalcount() {
    return totalcount;
  }

  public void setTotalcount(final int totalcount) {
    this.totalcount = totalcount;

    int pageCount = totalcount / this.perpage;// 取除的结果
    final int yu = totalcount % this.perpage;// 取余
    if (yu > 0)
      pageCount++;
    this.totalpage = pageCount;
  }

  public int getTotalpage() {
    return totalpage;
  }

  public void setTotalpage(final int totalpage) {
    this.totalpage = totalpage;
  }

  public Object getData() {
    return data;
  }

  public void setData(final List<T> data) {
    this.data = data;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + currentpage;
    result = prime * result + ((data == null) ? 0 : data.hashCode());
    result = prime * result + perpage;
    result = prime * result + totalcount;
    result = prime * result + totalpage;
    return result;
  }

  @SuppressWarnings("rawtypes")
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
    final AppPageModel other = (AppPageModel) obj;
    if (currentpage != other.currentpage) {
      return false;
    }
    if (data == null) {
      if (other.data != null) {
        return false;
      }
    } else if (!data.equals(other.data)) {
      return false;
    }
    if (perpage != other.perpage) {
      return false;
    }
    if (totalcount != other.totalcount) {
      return false;
    }
    if (totalpage != other.totalpage) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "AppPage [perpage=" + perpage + ", currentpage=" + currentpage
        + ", totalcount=" + totalcount + ", totalpage=" + totalpage + ", data="
        + data + "]";
  }
}
