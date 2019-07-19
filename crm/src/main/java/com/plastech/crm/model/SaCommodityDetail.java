package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sa_commodity_detail")
public class SaCommodityDetail implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long scdid;

    /**
     * 品类id
     */
    private Long ctid;

    /**
     * 生产商id
     */
    private Long mfid;

    /**
     * 最终客户id
     */
    private Long gid;

    /**
     * 客户名称
     */
    @Column(name = "cu_name")
    private String cuName;

    /**
     * 采购量
     */
    @Column(name = "purchase_quantity")
    private Double purchaseQuantity;

    /**
     * 年份（如：2019）
     */
    @Column(name = "scd_year")
    private String scdYear;

    /**
     * 月份（如：02代表2月，若为全年的统计数据，月份值为13）
     */
    @Column(name = "scd_month")
    private Integer scdMonth;

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
     * @return scdid
     */
    public Long getScdid() {
        return scdid;
    }

    /**
     * @param scdid
     */
    public void setScdid(final Long scdid) {
        this.scdid = scdid;
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
     * 获取客户名称
     *
     * @return cu_name - 客户名称
     */
    public String getCuName() {
        return cuName;
    }

    /**
     * 设置客户名称
     *
     * @param cuName 客户名称
     */
    public void setCuName(final String cuName) {
        this.cuName = cuName;
    }

    /**
     * 获取采购量
     *
     * @return purchase_quantity - 采购量
     */
    public Double getPurchaseQuantity() {
        return purchaseQuantity;
    }

    /**
     * 设置采购量
     *
     * @param purchaseQuantity 采购量
     */
    public void setPurchaseQuantity(final Double purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    /**
     * 获取年份（如：2019）
     *
     * @return scd_year - 年份（如：2019）
     */
    public String getScdYear() {
        return scdYear;
    }

    /**
     * 设置年份（如：2019）
     *
     * @param scdYear 年份（如：2019）
     */
    public void setScdYear(final String scdYear) {
        this.scdYear = scdYear;
    }

    /**
     * 获取月份（如：02代表2月，若为全年的统计数据，月份值为13）
     *
     * @return scd_month - 月份（如：02代表2月，若为全年的统计数据，月份值为13）
     */
    public Integer getScdMonth() {
        return scdMonth;
    }

    /**
     * 设置月份（如：02代表2月，若为全年的统计数据，月份值为13）
     *
     * @param scdMonth 月份（如：02代表2月，若为全年的统计数据，月份值为13）
     */
    public void setScdMonth(final Integer scdMonth) {
        this.scdMonth = scdMonth;
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

    /**
     * @return the gid
     */
    public Long getGid() {
      return gid;
    }

    /**
     * @param gid the gid to set
     */
    public void setGid(final Long gid) {
      this.gid = gid;
    }


}