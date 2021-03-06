/**
* auto-generated code
* Fri Oct 20 14:08:21 CST 2006
*/
package com.sunrise.boss.business.zifee.plandiscodlo.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: PlandiscodloListVO</p>
 * <p>Description: Query Params Object for PlandiscodloDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public class PlandiscodloListVO extends BaseListVO {
	private String _dnl_optime;
	
	private String _dnm_optime;
	
	private String _sk_oprcode;
	
	private String _se_oprtype;
	
	private String _se_success;

	public String get_dnl_optime() {
		return _dnl_optime;
	}

	public void set_dnl_optime(String _dnl_optime) {
		this._dnl_optime = _dnl_optime;
	}

	public String get_dnm_optime() {
		return _dnm_optime;
	}

	public void set_dnm_optime(String _dnm_optime) {
		if(null!=_dnm_optime && _dnm_optime.length()>0){
	    	String _dnm_optime_end = _dnm_optime + " 23:59:59";
			this._dnm_optime = _dnm_optime_end;
		}else{
			this._dnm_optime = _dnm_optime;
		}
	}

	public String get_se_oprtype() {
		return _se_oprtype;
	}

	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}

	public String get_se_success() {
		return _se_success;
	}

	public void set_se_success(String _se_success) {
		this._se_success = _se_success;
	}

	public String get_sk_oprcode() {
		return _sk_oprcode;
	}

	public void set_sk_oprcode(String _sk_oprcode) {
		this._sk_oprcode = _sk_oprcode;
	}


}
