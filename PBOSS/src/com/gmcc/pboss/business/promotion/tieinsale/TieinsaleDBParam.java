/**
 * auto-generated code
 * Mon Sep 14 16:46:42 CST 2009
 */
package com.gmcc.pboss.business.promotion.tieinsale;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: TieinsaleDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class TieinsaleDBParam extends DBQueryParam {
	private String _se_comcategory;

	private String _se_tcomcategory;

	private String _ne_ruleid;

	private String _sk_rulename;

	private String pid;

	private String queryRuleid;

	public String getQueryRuleid() {
		return queryRuleid;
	}

	public void setQueryRuleid(String queryRuleid) {
		this.queryRuleid = queryRuleid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String get_ne_ruleid() {
		return _ne_ruleid;
	}

	public void set_ne_ruleid(String _ne_ruleid) {
		this._ne_ruleid = _ne_ruleid;
	}

	/**
	 * @return Returns the _se_comcategory.
	 */
	public String get_se_comcategory() {
		return this._se_comcategory;
	}

	/**
	 * @param _sk_companyname The _se_comcategory to set.
	 */
	public void set_se_comcategory(String _se_comcategory) {
		this._se_comcategory = _se_comcategory;
	}

	/**
	 * @return Returns the _se_tcomcategory.
	 */
	public String get_se_tcomcategory() {
		return this._se_tcomcategory;
	}

	/**
	 * @param _sk_companyname The _se_tcomcategory to set.
	 */
	public void set_se_tcomcategory(String _se_tcomcategory) {
		this._se_tcomcategory = _se_tcomcategory;
	}

	public String get_sk_rulename() {
		return _sk_rulename;
	}

	public void set_sk_rulename(String _sk_rulename) {
		this._sk_rulename = _sk_rulename;
	}

}
