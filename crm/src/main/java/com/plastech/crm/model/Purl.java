package com.plastech.crm.model;

import java.io.Serializable;
import javax.persistence.*;

public class Purl implements Serializable {
    @Id
    private Long puid;

    /**
     * 模块的url
     */
    private String module;

    /**
     * 接口的url
     */
    private String inface;

    /**
     * 請求方式
     */
    private String method;

    /**
     * 参数校验规则
     */
    @Column(name = "param_check")
    private String paramCheck;

    private String note;

    /**
     * 0：校验token且必须校验通过，1：校验token但允许校验不通过，2：不会去校验token
     */
    private Integer permissive;

    private static final long serialVersionUID = 1L;

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
     * 获取模块的url
     *
     * @return module - 模块的url
     */
    public String getModule() {
        return module;
    }

    /**
     * 设置模块的url
     *
     * @param module 模块的url
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * 获取接口的url
     *
     * @return inface - 接口的url
     */
    public String getInface() {
        return inface;
    }

    /**
     * 设置接口的url
     *
     * @param inface 接口的url
     */
    public void setInface(String inface) {
        this.inface = inface;
    }

    /**
     * 获取請求方式
     *
     * @return method - 請求方式
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置請求方式
     *
     * @param method 請求方式
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取参数校验规则
     *
     * @return param_check - 参数校验规则
     */
    public String getParamCheck() {
        return paramCheck;
    }

    /**
     * 设置参数校验规则
     *
     * @param paramCheck 参数校验规则
     */
    public void setParamCheck(String paramCheck) {
        this.paramCheck = paramCheck;
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

    /**
     * 获取0：校验token且必须校验通过，1：校验token但允许校验不通过，2：不会去校验token
     *
     * @return permissive - 0：校验token且必须校验通过，1：校验token但允许校验不通过，2：不会去校验token
     */
    public Integer getPermissive() {
        return permissive;
    }

    /**
     * 设置0：校验token且必须校验通过，1：校验token但允许校验不通过，2：不会去校验token
     *
     * @param permissive 0：校验token且必须校验通过，1：校验token但允许校验不通过，2：不会去校验token
     */
    public void setPermissive(Integer permissive) {
        this.permissive = permissive;
    }
}