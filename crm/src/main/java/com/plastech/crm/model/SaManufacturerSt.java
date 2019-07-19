package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sa_manufacturer_st")
public class SaManufacturerSt implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long smsid;

    /**
     * 生产商id
     */
    private Long mfid;

    /**
     * 年份（如：2019）
     */
    private String year;

    /**
     * 月份（如：02代表2月，若为全年的统计数据，月份值为13）
     */
    private String month;

    /**
     * 销售量（单位：QT）
     */
    @Column(name = "sales_total")
    private Double salesTotal;

    /**
     * 客户数
     */
    @Column(name = "group_count")
    private Integer groupCount;

    /**
     * 品类数
     */
    @Column(name = "commodity_count")
    private Integer commodityCount;

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
     * @return smsid
     */
    public Long getSmsid() {
        return smsid;
    }

    /**
     * @param smsid
     */
    public void setSmsid(final Long smsid) {
        this.smsid = smsid;
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
     * 获取销售量（单位：QT）
     *
     * @return sales_total - 销售量（单位：QT）
     */
    public Double getSalesTotal() {
        return salesTotal;
    }

    /**
     * 设置销售量（单位：QT）
     *
     * @param salesTotal 销售量（单位：QT）
     */
    public void setSalesTotal(final Double salesTotal) {
        this.salesTotal = salesTotal;
    }

    /**
     * 获取客户数
     *
     * @return group_count - 客户数
     */
    public Integer getGroupCount() {
        return groupCount;
    }

    /**
     * 设置客户数
     *
     * @param groupCount 客户数
     */
    public void setGroupCount(final Integer groupCount) {
        this.groupCount = groupCount;
    }

    /**
     * 获取品类数
     *
     * @return commodity_count - 品类数
     */
    public Integer getCommodityCount() {
        return commodityCount;
    }

    /**
     * 设置品类数
     *
     * @param commodityCount 品类数
     */
    public void setCommodityCount(final Integer commodityCount) {
        this.commodityCount = commodityCount;
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