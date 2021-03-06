/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.ui.cms.operation;

import java.util.Date;
import java.util.Iterator;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.cms.commons.ApplyResBean;
import com.sunrise.boss.ui.cms.commons.CMSConstant;
import com.sunrise.boss.ui.cms.commons.CMSUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: OperationForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class OperationForm extends BaseActionForm {

	private String _sk_name;
	
	private String _sk_opnid;

	private String _se_opnid;

	private String _se_parentid;

	private String opnid;

	private String parentid;

	private String name;

	private Short state;

	private String remark;

	private Date startdate;

	private Date enddate;

	private Short isbusi;

	private Short opnlevel;

	private String loadinfo;

	private String loadtype;

	private String[] exesyss = CMSUtils.getIDorname("CH_CBEXESYS", "name");

	private String[] exesysvalues = CMSUtils.getIDorname("CH_CBEXESYS", "id");
	

	private String[] selectexesys;

	private String[] citys = CMSUtils.getIDorname("region", "name");

	private String[] cityvalues = CMSUtils.getIDorname("region", "id");

	private String[] selectcity;

	private String[] stars = CMSUtils.getIDorname("CH_STARLEVEL", "name");

	private String[] starvalues = CMSUtils.getIDorname("CH_STARLEVEL", "id");

	private String[] selectstar;

	private Short busikind;

	private String busibelong;

	private String _ne_busikind;

	private String _ne_opnlevel;

	private String queryopn;

	private boolean showendopn;

	private String _dnl_startdate;

	private String _dnm_startdate;

	private String _dnl_enddate;

	private String _dnm_enddate;

	private String _se_busibelong;
	
	private String approveid;
	
	public String get_sk_opnid() {
		return _sk_opnid;
	}

	public void set_sk_opnid(String _sk_opnid) {
		this._sk_opnid = _sk_opnid;
	}
	public boolean isShowendopn() {
		return showendopn;
	}

	public void setShowendopn(boolean showendopn) {
		this.showendopn = showendopn;
	}

	public String get_dnl_enddate() {
		return _dnl_enddate;
	}

	public void set_dnl_enddate(String _dnl_enddate) {
		this._dnl_enddate = _dnl_enddate;
	}

	public String get_dnl_startdate() {
		return _dnl_startdate;
	}

	public void set_dnl_startdate(String _dnl_startdate) {
		this._dnl_startdate = _dnl_startdate;
	}

	public String get_dnm_enddate() {
		return _dnm_enddate;
	}

	public void set_dnm_enddate(String _dnm_enddate) {
		this._dnm_enddate = _dnm_enddate;
	}

	public String get_dnm_startdate() {
		return _dnm_startdate;
	}

	public void set_dnm_startdate(String _dnm_startdate) {
		this._dnm_startdate = _dnm_startdate;
	}

	public String get_se_busibelong() {
		return _se_busibelong;
	}

	public void set_se_busibelong(String _se_busibelong) {
		this._se_busibelong = _se_busibelong;
	}

	public String get_ne_busikind() {
		return _ne_busikind;
	}

	public void set_ne_busikind(String _ne_busikind) {
		this._ne_busikind = _ne_busikind;
	}

	public String get_ne_opnlevel() {
		return _ne_opnlevel;
	}

	public void set_ne_opnlevel(String _ne_opnlevel) {
		this._ne_opnlevel = _ne_opnlevel;
	}

	public String get_sk_name() {
		return _sk_name;
	}

	public void set_sk_name(String _sk_name) {
		this._sk_name = _sk_name;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_parentid() {
		return _se_parentid;
	}

	public void set_se_parentid(String _se_parentid) {
		this._se_parentid = _se_parentid;
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

	public String getQueryopn() {
		return queryopn;
	}

	public void setQueryopn(String queryopn) {
		this.queryopn = queryopn;
	}

	public String getLoadinfo() {
		return loadinfo;
	}

	public void setLoadinfo(String loadinfo) {
		this.loadinfo = loadinfo;
	}

	public String getLoadtype() {
		return loadtype;
	}

	public void setLoadtype(String loadtype) {
		this.loadtype = loadtype;
	}

	public String[] getExesyss() {
		return exesyss;
	}

	

	public void setCitys(String[] citys) {
		this.citys = citys;
	}

	public void setExesyss(String[] exesyss) {
		this.exesyss = exesyss;
	}

	public void setStars(String[] stars) {
		this.stars = stars;
	}

	public String[] getSelectexesys() {

		return selectexesys;
	}

	public void setSelectexesys(String[] selectexesys) {
		this.selectexesys = selectexesys;
	}

	public String[] getExesysvalues() {

		return exesysvalues;
	}

	public void setExesysvalues(String[] exesysvalues) {
		this.exesysvalues = exesysvalues;
	}

	public String[] getCityvalues() {
		return cityvalues;
	}

	public void setCityvalues(String[] cityvalues) {
		this.cityvalues = cityvalues;
	}

	public String[] getSelectcity() {
		return selectcity;
	}

	public void setSelectcity(String[] selectcity) {
		this.selectcity = selectcity;
	}

	public String[] getSelectstar() {
		return selectstar;
	}

	public void setSelectstar(String[] selectstar) {
		this.selectstar = selectstar;
	}

	public String[] getStarvalues() {
		return starvalues;
	}

	public void setStarvalues(String[] starvalues) {
		this.starvalues = starvalues;
	}

	public String[] getCitys() {
		return citys;
	}

	public String[] getStars() {
		return stars;
	}
	
	public String getApproveid() {
		return approveid;
	}

	public void setApproveid(String approveid) {
		this.approveid = approveid;
	}
	
}
