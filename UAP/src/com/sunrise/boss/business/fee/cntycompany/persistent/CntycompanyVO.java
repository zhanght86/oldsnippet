package com.sunrise.boss.business.fee.cntycompany.persistent;

import org.apache.commons.lang.builder.*;

import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.ManageLog;

/** @author Hibernate CodeGenerator */
public class CntycompanyVO extends BaseVO implements ManageLog{

    /** identifier field */
    private String countycompid;

    /** nullable persistent field */
    private String citycompid;

    /** nullable persistent field */
    private String countycompname;

    /** nullable persistent field */
    private Short countycomptype;

    /** nullable persistent field */
    private String agent;

    /** nullable persistent field */
    private String billingcode;
    
    /** nullable persistent field */
    private String adacode;

    /** nullable persistent field */
    private String longitude;

    /** nullable persistent field */
    private String latitude;

    /** full constructor */
    public CntycompanyVO(java.lang.String countycompid, java.lang.String citycompid, java.lang.String countycompname, java.lang.Short countycomptype, java.lang.String agent, java.lang.String billingcode,java.lang.String adacode, java.lang.String longitude, java.lang.String latitude) {
        this.countycompid = countycompid;
        this.citycompid = citycompid;
        this.countycompname = countycompname;
        this.countycomptype = countycomptype;
        this.agent = agent;
        this.billingcode = billingcode;
        this.adacode = adacode;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /** default constructor */
    public CntycompanyVO() {
    }

    /** minimal constructor */
    public CntycompanyVO(java.lang.String countycompid) {
        this.countycompid = countycompid;
    }

    public java.lang.String getCountycompid() {
        return this.countycompid;
    }

    public void setCountycompid(java.lang.String countycompid) {
        this.countycompid = countycompid;
    }

    public java.lang.String getCitycompid() {
        return this.citycompid;
    }

    public void setCitycompid(java.lang.String citycompid) {
        this.citycompid = citycompid;
    }

    public java.lang.String getCountycompname() {
        return this.countycompname;
    }

    public void setCountycompname(java.lang.String countycompname) {
        this.countycompname = countycompname;
    }

    public java.lang.Short getCountycomptype() {
        return this.countycomptype;
    }

    public void setCountycomptype(java.lang.Short countycomptype) {
        this.countycomptype = countycomptype;
    }

    public java.lang.String getAgent() {
        return this.agent;
    }

    public void setAgent(java.lang.String agent) {
        this.agent = agent;
    }

    public java.lang.String getBillingcode() {
        return this.billingcode;
    }

    public void setBillingcode(java.lang.String billingcode) {
        this.billingcode = billingcode;
    }

    public String getAdacode() {
		return adacode;
	}

	public void setAdacode(String adacode) {
		this.adacode = adacode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("countycompid", getCountycompid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CntycompanyVO) ) return false;
        CntycompanyVO castOther = (CntycompanyVO) other;
        return new EqualsBuilder()
            .append(this.getCountycompid(), castOther.getCountycompid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCountycompid())
            .toHashCode();
    }
 
}
