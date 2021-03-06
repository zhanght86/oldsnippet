package com.gmcc.pboss.biz.info.lowsalesCardsTotal.support;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.util.DateUtil;

public class SalescardsTotalQueryParamProcessor extends
		DefaultHqlQueryProcessor implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		SalesCardsTotalQueryParameter p=(SalesCardsTotalQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();		
		hql.append(" SELECT WAYID,COUNTYID,EMPLOYEEID, EMPLOYEENAME,OFFICETEL,BRAND,to_char(COUNT(*)) as CNT FROM ( ");//OPNID,OPNNAME,
		hql.append(" SELECT DISTINCT r.WAYID,r.SEQID,r.OPRCODE,w.WAYNAME,w.WAYMAGCODE," +
				"w.COUNTYID,w.STARLEVEL,w.SVCCODE,e.EMPLOYEEID,e.EMPLOYEENAME," +
				"e.OFFICETEL,r.MOBILE,r.BRAND,r.OPRTIME,n.ACTIVEDATE ");//,r.OPNID,o.OPNNAME
		hql.append(" FROM CH_PW_REGISTERSIM r,CH_PW_WAY w,CH_PW_EMPLOYEE e,");//FX_SN_NOACTINFO n
		
		hql.append(" (select mobileno, activedate from fx_sn_noactinfo ");
		hql.append(" where activedate>=to_date(:active3month,'yyyy-mm-dd hh24:mi:ss')");//使用命名参数更高效
		if (p.getStartactivedate()!=null) {
			hql.append(" and activedate >= to_date(:startactivedate, 'yyyy-MM-dd HH24:MI:SS') ");
		}
		if (p.getEndactivedate()!=null) {
			hql.append(" and activedate <= to_date(:endactivedate, 'yyyy-MM-dd HH24:MI:SS') ");
		}
		hql.append("  ) n");
		
		hql.append(" WHERE r.WAYID = w.WAYID ");
		hql.append(" AND r.OPRCODE = e.EMPLOYEEID ");
		hql.append(" AND n.MOBILENO(+) = r.MOBILE ");
		
		if(StringUtils.isNotEmpty(p.getCityid())){
			hql.append(" and r.cityid = :cityid ");
		}
		if(StringUtils.isNotEmpty(p.getOprcode())){
			hql.append(" and r.oprcode = :oprcode ");
		}
		if(StringUtils.isNotEmpty(p.getWayid())){
			hql.append(" and r.wayid = :wayid ");
		}
		if(StringUtils.isNotEmpty(p.getCountyid())){
			hql.append(" and w.countyid =:countyid ");
		}
		if(StringUtils.isNotEmpty(p.getSvccode())){
			hql.append(" and w.svccode =:svccode ");
		}
		if(StringUtils.isNotEmpty(p.getBrand())){
			hql.append(" and r.brand =:brand ");
		}
		if (p.getStartoprtime()!=null) {
			hql.append(" and r.oprtime >= to_date(:startoprtime, 'yyyy-MM-dd HH24:MI:SS') ");
		}
		if (p.getEndoprtime()!=null) {
			hql.append(" and r.oprtime <= to_date(:endoprtime, 'yyyy-MM-dd HH24:MI:SS') ");
		}
		if (p.getStartactivedate()!=null) {
			hql.append(" and n.activedate >= to_date(:startactivedate, 'yyyy-MM-dd HH24:MI:SS') ");
		}
		if (p.getEndactivedate()!=null) {
			hql.append(" and n.activedate <= to_date(:endactivedate, 'yyyy-MM-dd HH24:MI:SS') ");
		}
		hql.append(" ) group by  wayid,countyid,employeeid,employeename,officetel,brand ");//,opnid,opnname
		
		return hql.toString();
		
	}


	
	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub
SalesCardsTotalQueryParameter p = (SalesCardsTotalQueryParameter)parameter;
		
		if(StringUtils.isNotEmpty(p.getCityid())){
			query.setString("cityid", p.getCityid());
		}
		
		if(StringUtils.isNotEmpty(p.getWayid())){
			query.setString("wayid", p.getWayid());
		}
		if(StringUtils.isNotEmpty(p.getCountyid())){
			query.setString("countyid", p.getCountyid());
		}
		if(StringUtils.isNotEmpty(p.getSvccode())){
			query.setString("svccode", p.getSvccode());
		}
		if(StringUtils.isNotEmpty(p.getBrand())){
//		if(StringUtils.isNotEmpty(p.getBranddtl())){
			query.setString("brand", p.getBrand());
		}
		if(StringUtils.isNotEmpty(p.getStarlevel())){
			query.setString("starlevel", p.getStarlevel());
		}
		if(p.getStartoprtime()!=null){
			query.setString("startoprtime", DateUtil.convertDateToString(p.getStartoprtime())+" 00:00:00 ");
		}
		if(p.getEndoprtime()!=null){
			query.setString("endoprtime", DateUtil.convertDateToString(p.getEndoprtime())+" 23:59:59 ");
		}
		
		//激活时间不早于当前时间按3个月
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date(System.currentTimeMillis());		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH)-3);
		query.setString("active3month", sdf.format(c.getTime()));
		
		if (p.getStartactivedate()!=null) {
			query.setString("startactivedate", DateUtil.convertDateToString(p.getStartactivedate())+" 00:00:00 ");
		}
		if (p.getEndactivedate()!=null) {
			query.setString("endactivedate", DateUtil.convertDateToString(p.getEndactivedate())+" 23:59:59 ");
		}
		if (StringUtils.isNotEmpty(p.getOprcode())) {
			query.setString("oprcode", p.getOprcode());
		}
		//if (StringUtils.isNotEmpty(p.getOpnid())) {
//		if (StringUtils.isNotEmpty(p.getOpniddtl())) {
		//	query.setString("opnid", p.getOpnid());
		//}
	}

}
