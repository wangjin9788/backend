package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Menu implements Serializable {
    @Id
    private Long mid;

    /**
     * 类型（0：一级菜单，1：二级菜单，2：三级菜单，-1：隐藏菜单）
     */
    private Integer type;

    /**
     * 上级菜单编号
     */
    @Column(name = "parent_code")
    private String parentCode;

    /**
     * 菜单编号
     */
    private String code;

    /**
     * 菜单标题
     */
    private String title;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单链接
     */
    private String url;

    /**
     * 排序（值越小越靠前）
     */
    private Long sort;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    private String note;

    private static final long serialVersionUID = 1L;

    /**
     * @return mid
     */
    public Long getMid() {
        return mid;
    }

    /**
     * @param mid
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * 获取类型（0：一级菜单，1：二级菜单，2：三级菜单，-1：隐藏菜单）
     *
     * @return type - 类型（0：一级菜单，1：二级菜单，2：三级菜单，-1：隐藏菜单）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型（0：一级菜单，1：二级菜单，2：三级菜单，-1：隐藏菜单）
     *
     * @param type 类型（0：一级菜单，1：二级菜单，2：三级菜单，-1：隐藏菜单）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取上级菜单编号
     *
     * @return parent_code - 上级菜单编号
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 设置上级菜单编号
     *
     * @param parentCode 上级菜单编号
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * 获取菜单编号
     *
     * @return code - 菜单编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置菜单编号
     *
     * @param code 菜单编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取菜单标题
     *
     * @return title - 菜单标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置菜单标题
     *
     * @param title 菜单标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取菜单图标
     *
     * @return icon - 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置菜单图标
     *
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取菜单链接
     *
     * @return url - 菜单链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单链接
     *
     * @param url 菜单链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取排序（值越小越靠前）
     *
     * @return sort - 排序（值越小越靠前）
     */
    public Long getSort() {
        return sort;
    }

    /**
     * 设置排序（值越小越靠前）
     *
     * @param sort 排序（值越小越靠前）
     */
    public void setSort(Long sort) {
        this.sort = sort;
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
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
    public void setNote(String note) {
        this.note = note;
    }
}