package com.plastech.crm.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "permission_purl")
public class PermissionPurl implements Serializable {
    @Id
    private Long pmid;

    @Id
    private Long puid;

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
     * @return puid
     */
    public Long getPuid() {
        return puid;
    }

    /**
     * @param puid
     */
    public void setPuid(Long puid) {
        this.puid = puid;
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