package com.plastech.crm.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "role_permission")
public class RolePermission implements Serializable {
    @Id
    private Long roleid;

    @Id
    private Long pmid;

    @Column(name = "create_time")
    private Date createTime;

    private String note;

    private static final long serialVersionUID = 1L;

    /**
     * @return roleid
     */
    public Long getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

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
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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