package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "middle_customer_linkman")
public class MiddleCustomerLinkman implements Serializable {
    @Id
    private Long cuid;

    @Id
    private Long lkid;

    /**
     * 创建时间
     */
    @Column(name = "creator_time")
    private Date creatorTime;

    /**
     * 备注
     */
    private String note;

    private static final long serialVersionUID = 1L;

    /**
     * @return cuid
     */
    public Long getCuid() {
        return cuid;
    }

    /**
     * @param cuid
     */
    public void setCuid(final Long cuid) {
        this.cuid = cuid;
    }

    /**
     * @return lkid
     */
    public Long getLkid() {
        return lkid;
    }

    /**
     * @param lkid
     */
    public void setLkid(final Long lkid) {
        this.lkid = lkid;
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