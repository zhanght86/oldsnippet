package com.sunrise.boss.business.cms.reward.busiwayrellog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BusiwayrellogVO implements Serializable {

	/** identifier field */
	private Long logid;

	/** nullable persistent field */
	private java.util.Date optime;

	/** nullable persistent field */
	private String oprcode;

	/** nullable persistent field */
	private String oprtype;

	/** nullable persistent field */
	private String success;

	/** nullable persistent field */
	private String opnid;

	/** nullable persistent field */
	private String wayid;

	/** full constructor */
	public BusiwayrellogVO(java.util.Date optime, java.lang.String oprcode,
			java.lang.String oprtype, java.lang.String success,
			java.lang.String opnid, java.lang.String wayid) {
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
		this.opnid = opnid;
		this.wayid = wayid;
	}

	/** default constructor */
	public BusiwayrellogVO() {
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

	public java.lang.String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(java.lang.String opnid) {
		this.opnid = opnid;
	}

	public java.lang.String getWayid() {
		return this.wayid;
	}

	public void setWayid(java.lang.String wayid) {
		this.wayid = wayid;
	}

	public String toString() {
		return new ToStringBuilder(this).append("logid", getLogid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof BusiwayrellogVO))
			return false;
		BusiwayrellogVO castOther = (BusiwayrellogVO) other;
		return new EqualsBuilder()
				.append(this.getLogid(), castOther.getLogid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getLogid()).toHashCode();
	}

}
