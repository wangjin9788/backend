package com.plastech.crm.model;

import java.io.Serializable;
import javax.persistence.*;

public class Permission implements Serializable {
    @Id
    private Long pmid;

    /**
     * 所属菜单
     */
    private Long mid;

    /**
     * 菜单名称（冗余字段，不可靠，仅供查看）
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 标识
     */
    private String mark;

    private String note;

    private static final long serialVersionUID = 1L;

    /**
     * @return pmid
     */
    public Long getPmid() {
        return pmid;
    }

    /**
     * @param pmid
     */
    public void setPmid(Long pmid) {
        this.pmid = pmid;
    }

    /**
     * 获取所属菜单
     *
     * @return mid - 所属菜单
     */
    public Long getMid() {
        return mid;
    }

    /**
     * 设置所属菜单
     *
     * @param mid 所属菜单
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * 获取菜单名称（冗余字段，不可靠，仅供查看）
     *
     * @return menu_name - 菜单名称（冗余字段，不可靠，仅供查看）
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称（冗余字段，不可靠，仅供查看）
     *
     * @param menuName 菜单名称（冗余字段，不可靠，仅供查看）
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取权限名称
     *
     * @return name - 权限名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限名称
     *
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取标识
     *
     * @return mark - 标识
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置标识
     *
     * @param mark 标识
     */
    public void setMark(String mark) {
        this.mark = mark;
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }
}