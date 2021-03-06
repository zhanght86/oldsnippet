package com.sunrise.boss.business.cms.bbc.operation.persistent;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.bbc.operationlog.persistent.BBCoperationlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class BBCoperationVO implements OperationLog {

    /** identifier field */
    private String opnid;
    
    private String parentid;
    
    /** nullable persistent field */
    private String name;
    
    private Short state;

    /** nullable persistent field */
    private String remark;
    
    private Date startdate;
    
    private Date enddate;
    
    private Short isbusi;
    
    private Short opnlevel;
    
    private Short busikind;
    
    private String busibelong;

    /** full constructor */
    public BBCoperationVO( java.lang.String opnid, java.lang.String parentid, java.lang.String name, java.lang.String remark) {
    	this.opnid = opnid;
    	this.parentid = parentid;
        this.name = name;
        this.remark = remark;
    }

    /** default constructor */
    public BBCoperationVO() {
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }
    
    public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("opnid", getOpnid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BBCoperationVO) ) return false;
        BBCoperationVO castOther = (BBCoperationVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .toHashCode();
    }
    
    public Class logVOClass() {
    	return BBCoperationlogVO.class;
    }

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String getBusibelong() {
		return busibelong;
	}

	public void setBusibelong(String busibelong) {
		this.busibelong = busibelong;
	}

	public Short getBusikind() {
		return busikind;
	}

	public void setBusikind(Short busikind) {
		this.busikind = busikind;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Short getIsbusi() {
		return isbusi;
	}

	public void setIsbusi(Short isbusi) {
		this.isbusi = isbusi;
	}

	

	public Short getOpnlevel() {
		return opnlevel;
	}

	public void setOpnlevel(Short opnlevel) {
		this.opnlevel = opnlevel;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	
}
