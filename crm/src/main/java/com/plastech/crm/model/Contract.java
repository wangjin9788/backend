package com.plastech.crm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="contract")
public class Contract implements Serializable {
    /**
     * 合同id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long coid;

    /**
     * 集团id
     */
    private Long gid;

    /**
     * 客户id
     */
    private Long cuid;

    /**
     * 销售经理表id
     */
    private Long uid;

    /**
     * 合同编号
     */
    private String number;

    /**
     * 总毛利
     */
    @Column(name = "gross_profit")
    private BigDecimal grossProfit;

    /**
     * 总销售额
     */
    @Column(name = "gross_sales")
    private BigDecimal grossSales;

    /**
     * 总净利
     */
    @Column(name = "total_net_profit")
    private BigDecimal totalNetProfit;

    /**
     * 签署时间
     */
    @Column(name = "signing_time")
    private String signingTime;

    /**
     * 状态（-1：删除，0：正常）
     */
    private Integer status;

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
     * 修改人名称
     */
    @Column(name = "update_id")
    private Long updateId;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    private String note;

    private static final long serialVersionUID = 1L;

    /**
     * 获取合同id
     *
     * @return coid - 合同id
     */
    public Long getCoid() {
        return coid;
    }

    /**
     * 设置合同id
     *
     * @param coid 合同id
     */
    public void setCoid(final Long coid) {
        this.coid = coid;
    }

    /**
     * 获取集团id
     *
     * @return gid - 集团id
     */
    public Long getGid() {
        return gid;
    }

    /**
     * 设置集团id
     *
     * @param gid 集团id
     */
    public void setGid(final Long gid) {
        this.gid = gid;
    }

    /**
     * 获取客户id
     *
     * @return cuid - 客户id
     */
    public Long getCuid() {
        return cuid;
    }

    /**
     * 设置客户id
     *
     * @param cuid 客户id
     */
    public void setCuid(final Long cuid) {
        this.cuid = cuid;
    }

    /**
     * 获取销售经理表id
     *
     * @return smid - 销售经理表id
     */
    public Long getUid() {
        return uid;
    }

    /**
     * 设置销售经理表id
     *
     * @param smid 销售经理表id
     */
    public void setUid(final Long uid) {
        this.uid = uid;
    }

    /**
     * 获取合同编号
     *
     * @return number - 合同编号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置合同编号
     *
     * @param number 合同编号
     */
    public void setNumber(final String number) {
        this.number = number;
    }

    /**
     * 获取总毛利
     *
     * @return gross_profit - 总毛利
     */
    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    /**
     * 设置总毛利
     *
     * @param grossProfit 总毛利
     */
    public void setGrossProfit(final BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    /**
     * 获取总销售额
     *
     * @return gross_sales - 总销售额
     */
    public BigDecimal getGrossSales() {
        return grossSales;
    }

    /**
     * 设置总销售额
     *
     * @param grossSales 总销售额
     */
    public void setGrossSales(final BigDecimal grossSales) {
        this.grossSales = grossSales;
    }

    /**
     * 获取总净利
     *
     * @return total_net_profit - 总净利
     */
    public BigDecimal getTotalNetProfit() {
        return totalNetProfit;
    }

    /**
     * 设置总净利
     *
     * @param totalNetProfit 总净利
     */
    public void setTotalNetProfit(final BigDecimal totalNetProfit) {
        this.totalNetProfit = totalNetProfit;
    }

    /**
     * 获取签署时间
     *
     * @return signing_time - 签署时间
     */
    public String getSigningTime() {
        return signingTime;
    }

    /**
     * 设置签署时间
     *
     * @param string 签署时间
     */
    public void setSigningTime(final String string) {
        this.signingTime = string;
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
     * 获取修改人名称
     *
     * @return update_id - 修改人名称
     */
    public Long getUpdateId() {
        return updateId;
    }

    /**
     * 设置修改人名称
     *
     * @param updateId 修改人名称
     */
    public void setUpdateId(final Long updateId) {
        this.updateId = updateId;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(final Date updateTime) {
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
    public void setNote(final String note) {
        this.note = note;
    }
}