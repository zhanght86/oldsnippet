package com.sunrise.boss.business.cms.chpwwaybusicirclelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPwWaybusicirclelogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String buscno;

    /** nullable persistent field */
    private Float waymod;

    /** nullable persistent field */
    private Short rewardkind;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String wayattr;

    /** full constructor */
    public ChPwWaybusicirclelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String wayid, java.lang.String buscno, java.lang.Float waymod, java.lang.Short rewardkind, java.util.Date createtime, java.lang.String wayattr) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.wayid = wayid;
        this.buscno = buscno;
        this.waymod = waymod;
        this.rewardkind = rewardkind;
        this.createtime = createtime;
        this.wayattr = wayattr;
    }

    /** default constructor */
    public ChPwWaybusicirclelogVO() {
    }

    /** minimal constructor */
    public ChPwWaybusicirclelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprtype) {
        this.logid = logid;
        this.optime = optime;
        this.oprtype = oprtype;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getBuscno() {
        return this.buscno;
    }

    public void setBuscno(java.lang.String buscno) {
        this.buscno = buscno;
    }

    public java.lang.Float getWaymod() {
        return this.waymod;
    }

    public void setWaymod(java.lang.Float waymod) {
        this.waymod = waymod;
    }

    public java.lang.Short getRewardkind() {
        return this.rewardkind;
    }

    public void setRewardkind(java.lang.Short rewardkind) {
        this.rewardkind = rewardkind;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getWayattr() {
        return this.wayattr;
    }

    public void setWayattr(java.lang.String wayattr) {
        this.wayattr = wayattr;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPwWaybusicirclelogVO) ) return false;
        ChPwWaybusicirclelogVO castOther = (ChPwWaybusicirclelogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
