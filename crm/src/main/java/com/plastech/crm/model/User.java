package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.plastech.crm.model.vo.UserView;

@Table(name = "user")
public class User implements Serializable {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long uid;

  /**
   * 管理员帐号的用户名
   */
  private String ucode;

  private String unumber;

  /**
   * 登陆密码
   */
  private String pwd;

  /**
   * 用户昵称
   */
  private String uname;

  /**
   * 手机号码地区
   */
  private String area;

  /**
   * 手机号码
   */
  private String uphone;

  /**
   * 用户邮箱
   */
  private String umail;

  /**
   * 职位
   */
  private String position;

  /**
   * 角色id(0：admin 1：sales 2：operator)
   */
  private Long roleid;

  /**
   * 角色名称
   */
  private String rolename;

  /**
   * 状态（0：激活 1：冻结）
   */
  private Integer ustatus;

  /**
   * 创建时间
   */
  @Column(name = "create_time")
  private Date createTime;

  /**
   * 创建人名称
   */
  @Column(name = "create_id")
  private Long createId;

  /**
   * 备注
   */
  private String note;

  private static final long serialVersionUID = 1L;

  public final String getUnumber() {
    return unumber;
  }

  public final void setUnumber(final String unumber) {
    this.unumber = unumber;
  }

  /**
   * @return uid
   */
  public Long getUid() {
    return uid;
  }

  /**
   * @param uid
   */
  public void setUid(final Long uid) {
    this.uid = uid;
  }

  /**
   * 获取管理员帐号的用户名
   *
   * @return ucode - 管理员帐号的用户名
   */
  public String getUcode() {
    return ucode;
  }

  /**
   * 设置管理员帐号的用户名
   *
   * @param ucode 管理员帐号的用户名
   */
  public void setUcode(final String ucode) {
    this.ucode = ucode;
  }

  /**
   * 获取登陆密码
   *
   * @return pwd - 登陆密码
   */
  public String getPwd() {
    return pwd;
  }

  /**
   * 设置登陆密码
   *
   * @param pwd 登陆密码
   */
  public void setPwd(final String pwd) {
    this.pwd = pwd;
  }

  /**
   * 获取用户昵称
   *
   * @return uname - 用户昵称
   */
  public String getUname() {
    return uname;
  }

  /**
   * 设置用户昵称
   *
   * @param uname 用户昵称
   */
  public void setUname(final String uname) {
    this.uname = uname;
  }

  /**
   * 获取手机号码地区
   *
   * @return area - 手机号码地区
   */
  public String getArea() {
    return area;
  }

  /**
   * 设置手机号码地区
   *
   * @param area 手机号码地区
   */
  public void setArea(final String area) {
    this.area = area;
  }

  /**
   * 获取手机号码
   *
   * @return uphone - 手机号码
   */
  public String getUphone() {
    return uphone;
  }

  /**
   * 设置手机号码
   *
   * @param uphone 手机号码
   */
  public void setUphone(final String uphone) {
    this.uphone = uphone;
  }

  /**
   * 获取用户邮箱
   *
   * @return umail - 用户邮箱
   */
  public String getUmail() {
    return umail;
  }

  /**
   * 设置用户邮箱
   *
   * @param umail 用户邮箱
   */
  public void setUmail(final String umail) {
    this.umail = umail;
  }

  /**
   * 设置职位
   *
   * @param position 职位
   */
  public void setPosition(final String position) {
    this.position = position;
  }

  /**
   * 获取角色id(0：admin 1：sales 2：operator)
   *
   * @return roleid - 角色id(0：admin 1：sales 2：operator)
   */
  public Long getRoleid() {
    return roleid;
  }

  /**
   * 获取职位
   *
   * @return position - 职位
   */
  public String getPosition() {
    return position;
  }

  /**
   * 设置角色id(0：admin 1：sales 2：operator)
   *
   * @param roleid 角色id(0：admin 1：sales 2：operator)
   */
  public void setRoleid(final Long roleid) {
    this.roleid = roleid;
  }

  /**
   * 获取角色名称
   *
   * @return rolename - 角色名称
   */
  public String getRolename() {
    return rolename;
  }

  /**
   * 设置创建时间
   *
   * @param createTime 创建时间
   */
  public void setCreateTime(final Date createTime) {
    this.createTime = createTime;
  }

  /**
   * 获取状态（0：激活 1：冻结）
   *
   * @return ustatus - 状态（0：激活 1：冻结）
   */
  public Integer getUstatus() {
    return ustatus;
  }

  /**
   * 设置角色名称
   *
   * @param rolename 角色名称
   */
  public void setRolename(final String rolename) {
    this.rolename = rolename;
  }

  /**
   * 设置状态（0：激活 1：冻结）
   *
   * @param ustatus 状态（0：激活 1：冻结）
   */
  public void setUstatus(final Integer ustatus) {
    this.ustatus = ustatus;
  }

  /**
   * 获取创建时间
   *
   * @return create_time - 创建时间
   */
  public Date getCreateTime() {
    return createTime;
  }

  /**
   * 获取创建人名称
   *
   * @return create_id - 创建人名称
   */
  public Long getCreateId() {
    return createId;
  }

  /**
   * 设置创建人名称
   *
   * @param createId 创建人名称
   */
  public void setCreateId(final Long createId) {
    this.createId = createId;
  }

  /**
   * 获取备注
   *
   * @return note - 备注
   */
  public String getNote() {
    return note;
  }

  /**
   * 设置备注
   *
   * @param note 备注
   */
  public void setNote(final String note) {
    this.note = note;
  }

  public UserView convertToUserView(final String token) {
    final UserView userView = new UserView();
    userView.setToken(token);
    userView.setUid(this.uid);
    userView.setUname(this.uname);
    userView.setUnumber(this.unumber);
    userView.setRolename(this.rolename);
    userView.setPosition(this.position);
    userView.setUcode(this.ucode);
    userView.setUmail(this.umail);
    userView.setUstatus(this.ustatus + "");
    userView.setPwd("");
    userView.setRoleid(this.roleid);
    return userView;
  }
}
