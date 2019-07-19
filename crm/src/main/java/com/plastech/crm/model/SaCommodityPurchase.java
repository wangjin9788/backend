package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sa_commodity_purchase")
public class SaCommodityPurchase implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long scpid;

    /**
     * 用户id
     */
    private Long gid;

    /**
     * 品类id
     */
    private Long ctid;

    /**
     * 品类名称
     */
    @Column(name = "ct_name")
    private String ctName;

    /**
     * 生产商id
     */
    private Long mfid;

    /**
     * 生产商名称
     */
    @Column(name = "mf_name")
    private String mfName;

    /**
     * 年份（如：2019）
     */
    private String year;

    /**
     * 月份（如：02代表2月，若为全年的统计数据，月份值为13）
     */
    private String month;

    /**
     * 购买量（单位：QT）
     */
    @Column(name = "purchase_total")
    private Double purchaseTotal;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 备注
     */
    private String note;

    private static final long serialVersionUID = 1L;

    /**
     * @return scpid
     */
    public Long getScpid() {
        return scpid;
    }

    /**
     * @param scpid
     */
    public void setScpid(final Long scpid) {
        this.scpid = scpid;
    }

    /**
     * 获取用户id
     *
     * @return gid - 用户id
     */
    public Long getGid() {
        return gid;
    }

    /**
     * 设置用户id
     *
     * @param gid 用户id
     */
    public void setGid(final Long gid) {
        this.gid = gid;
    }

    /**
     * 获取品类id
     *
     * @return ctid - 品类id
     */
    public Long getCtid() {
        return ctid;
    }

    /**
     * 设置品类id
     *
     * @param ctid 品类id
     */
    public void setCtid(final Long ctid) {
        this.ctid = ctid;
    }

    /**
     * 获取品类名称
     *
     * @return ct_name - 品类名称
     */
    public String getCtName() {
        return ctName;
    }

    /**
     * 设置品类名称
     *
     * @param ctName 品类名称
     */
    public void setCtName(final String ctName) {
        this.ctName = ctName;
    }

    /**
     * 获取生产商id
     *
     * @return mfid - 生产商id
     */
    public Long getMfid() {
        return mfid;
    }

    /**
     * 设置生产商id
     *
     * @param mfid 生产商id
     */
    public void setMfid(final Long mfid) {
        this.mfid = mfid;
    }

    /**
     * 获取生产商名称
     *
     * @return mf_name - 生产商名称
     */
    public String getMfName() {
        return mfName;
    }

    /**
     * 设置生产商名称
     *
     * @param mfName 生产商名称
     */
    public void setMfName(final String mfName) {
        this.mfName = mfName;
    }

    /**
     * 获取年份（如：2019）
     *
     * @return year - 年份（如：2019）
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年份（如：2019）
     *
     * @param year 年份（如：2019）
     */
    public void setYear(final String year) {
        this.year = year;
    }

    /**
     * 获取月份（如：02代表2月，若为全年的统计数据，月份值为13）
     *
     * @return month - 月份（如：02代表2月，若为全年的统计数据，月份值为13）
     */
    public String getMonth() {
        return month;
    }

    /**
     * 设置月份（如：02代表2月，若为全年的统计数据，月份值为13）
     *
     * @param month 月份（如：02代表2月，若为全年的统计数据，月份值为13）
     */
    public void setMonth(final String month) {
        this.month = month;
    }

    /**
     * 获取购买量（单位：QT）
     *
     * @return purchase_total - 购买量（单位：QT）
     */
    public Double getPurchaseTotal() {
        return purchaseTotal;
    }

    /**
     * 设置购买量（单位：QT）
     *
     * @param purchaseTotal 购买量（单位：QT）
     */
    public void setPurchaseTotal(final Double purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
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
    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
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
}