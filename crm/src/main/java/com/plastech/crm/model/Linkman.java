package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="linkman")
public class Linkman implements Serializable {
    /**
     * 联系人id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long lkid;

    /**
     * 联系人名称
     */
    private String name;

    /**
     * 状态（-1：删除，0：正常）
     */
    private Integer status;

    /**
     * 职位
     */
    @Column(name = "lk_position")
    private String lkPosition;

    /**
     * 电话区号
     */
    @Column(name = "lk_area")
    private String lkArea;

    /**
     * 电话号码
     */
    @Column(name = "lk_phone")
    private String lkPhone;

    /**
     * 邮箱
     */
    @Column(name = "lk_mail")
    private String lkMail;

    /**
     * 节日标志（例如：中秋 、圣诞）
     */
    @Column(name = "lk_tags")
    private String lkTags;

    /**
     * 备注
     */
    private String note;

    /**
     * 创建人id
     */
    @Column(name = "creator_id")
    private Long creatorId;

    /**
     * 创建时间
     */
    @Column(name = "creator_time")
    private Date creatorTime;

    /**
     * 最后修改人id
     */
    @Column(name = "last_update_id")
    private Long lastUpdateId;

    /**
     * 最后更新时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取联系人id
     *
     * @return lkid - 联系人id
     */
    public Long getLkid() {
        return lkid;
    }

    /**
     * 设置联系人id
     *
     * @param lkid 联系人id
     */
    public void setLkid(final Long lkid) {
        this.lkid = lkid;
    }

    /**
     * 获取联系人名称
     *
     * @return name - 联系人名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置联系人名称
     *
     * @param name 联系人名称
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * 获取状态（-1：删除，0：正常）
     *
     * @return status - 状态（-1：删除，0：正常）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态（-1：删除，0：正常）
     *
     * @param status 状态（-1：删除，0：正常）
     */
    public void setStatus(final Integer status) {
        this.status = status;
    }

    /**
     * 获取职位
     *
     * @return lk_position - 职位
     */
    public String getLkPosition() {
        return lkPosition;
    }

    /**
     * 设置职位
     *
     * @param lkPosition 职位
     */
    public void setLkPosition(final String lkPosition) {
        this.lkPosition = lkPosition;
    }

    /**
     * 获取电话区号
     *
     * @return lk_area - 电话区号
     */
    public String getLkArea() {
        return lkArea;
    }

    /**
     * 设置电话区号
     *
     * @param lkArea 电话区号
     */
    public void setLkArea(final String lkArea) {
        this.lkArea = lkArea;
    }

    /**
     * 获取电话号码
     *
     * @return lk_phone - 电话号码
     */
    public String getLkPhone() {
        return lkPhone;
    }

    /**
     * 设置电话号码
     *
     * @param lkPhone 电话号码
     */
    public void setLkPhone(final String lkPhone) {
        this.lkPhone = lkPhone;
    }

    /**
     * 获取邮箱
     *
     * @return lk_mail - 邮箱
     */
    public String getLkMail() {
        return lkMail;
    }

    /**
     * 设置邮箱
     *
     * @param lkMail 邮箱
     */
    public void setLkMail(final String lkMail) {
        this.lkMail = lkMail;
    }

    /**
     * 获取节日标志（例如：中秋 、圣诞）
     *
     * @return lk_tags - 节日标志（例如：中秋 、圣诞）
     */
    public String getLkTags() {
        return lkTags;
    }

    /**
     * 设置节日标志（例如：中秋 、圣诞）
     *
     * @param lkTags 节日标志（例如：中秋 、圣诞）
     */
    public void setLkTags(final String lkTags) {
        this.lkTags = lkTags;
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

    /**
     * 获取创建人id
     *
     * @return creator_id - 创建人id
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人id
     *
     * @param creatorId 创建人id
     */
    public void setCreatorId(final Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取创建时间
     *
     * @return creator_time - 创建时间
     */
    public Date getCreatorTime() {
        return creatorTime;
    }

    /**
     * 设置创建时间
     *
     * @param creatorTime 创建时间
     */
    public void setCreatorTime(final Date creatorTime) {
        this.creatorTime = creatorTime;
    }

    /**
     * 获取最后修改人id
     *
     * @return last_update_id - 最后修改人id
     */
    public Long getLastUpdateId() {
        return lastUpdateId;
    }

    /**
     * 设置最后修改人id
     *
     * @param lastUpdateId 最后修改人id
     */
    public void setLastUpdateId(final Long lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    /**
     * 获取最后更新时间
     *
     * @return last_update_time - 最后更新时间
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param lastUpdateTime 最后更新时间
     */
    public void setLastUpdateTime(final Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}