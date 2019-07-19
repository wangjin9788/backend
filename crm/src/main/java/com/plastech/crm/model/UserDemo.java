package com.plastech.crm.model;

import java.io.Serializable;

/**
 *
 *
 * @author : yemin
 * @date : 2019年1月7日 下午1:22:13
 *
 */
public class UserDemo implements Serializable {

  public UserDemo() {
    super();
  }

  public UserDemo(final String name, final Integer age, final String introduction) {
    super();
    this.name = name;
    this.age = age;
    this.introduction = introduction;
  }


  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String name;
  private Integer age;
  private String introduction;

  public final String getName() {
    return name;
  }

  public final void setName(final String name) {
    this.name = name;
  }

  public final Integer getAge() {
    return age;
  }

  public final void setAge(final Integer age) {
    this.age = age;
  }

  public final String getIntroduction() {
    return introduction;
  }

  public final void setIntroduction(final String introduction) {
    this.introduction = introduction;
  }

}
