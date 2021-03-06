<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="empconfirm_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="base"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

	<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="center"><s:text name="employeeid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_employeeid" />
                </td>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._se_wayid" />
                </td>
                <td align="center"><s:text name="empstatus"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_empstatus" />
                </td>
                <td align="center"><s:text name="confirmid"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_confirmid" />
                </td>
                <td align="center"><s:text name="smsstatus"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._ne_smsstatus" />
                </td>
                <td align="center"><s:text name="smscreattime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnm_smscreattime" />
                </td>
                <td align="center"><s:text name="smscreattime"/>:</td>
                <td align="left">
                    <s:textfield cssStyle="style_input" name="param._dnl_smscreattime" />
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/empconfirm_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/channel/empconfirm_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/channel/empconfirm_delete.do')">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<s:i18n name="public">
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('employeeid')"><s:text name="employeeid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('oprcode')"><s:text name="oprcode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('employeename')"><s:text name="employeename"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('birthday')"><s:text name="birthday"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('sex')"><s:text name="sex"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('edulevel')"><s:text name="edulevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('nativehome')"><s:text name="nativehome"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('polivisage')"><s:text name="polivisage"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('department')"><s:text name="department"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('servoffice')"><s:text name="servoffice"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('station')"><s:text name="station"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('joblevel')"><s:text name="joblevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('intime')"><s:text name="intime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('worktime')"><s:text name="worktime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('hereworktime')"><s:text name="hereworktime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('employtype')"><s:text name="employtype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('company')"><s:text name="company"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('telephone')"><s:text name="telephone"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('officetel')"><s:text name="officetel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('outtime')"><s:text name="outtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('outresult')"><s:text name="outresult"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('homeaddr')"><s:text name="homeaddr"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cardid')"><s:text name="cardid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('waytype')"><s:text name="waytype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('pvtemail')"><s:text name="pvtemail"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ofcphone')"><s:text name="ofcphone"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ofcemail')"><s:text name="ofcemail"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('speciality')"><s:text name="speciality"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('svccode')"><s:text name="svccode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('posittype')"><s:text name="posittype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('contacttype')"><s:text name="contacttype"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('empstatus')"><s:text name="empstatus"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actbank')"><s:text name="actbank"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actno')"><s:text name="actno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actname')"><s:text name="actname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actpid')"><s:text name="actpid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('bail')"><s:text name="bail"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('gradschool')"><s:text name="gradschool"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('gradtime')"><s:text name="gradtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('ismarried')"><s:text name="ismarried"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('outreason')"><s:text name="outreason"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('trainlevel')"><s:text name="trainlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('hobby')"><s:text name="hobby"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('character')"><s:text name="character"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('asses')"><s:text name="asses"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('workhistry')"><s:text name="workhistry"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('prizeorpunish')"><s:text name="prizeorpunish"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('empass')"><s:text name="empass"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('right')"><s:text name="right"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isnet')"><s:text name="isnet"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('netpass')"><s:text name="netpass"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('isopen')"><s:text name="isopen"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('selectmobile')"><s:text name="selectmobile"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('subname')"><s:text name="subname"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('regdate')"><s:text name="regdate"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('empattr')"><s:text name="empattr"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('empattrmemo')"><s:text name="empattrmemo"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('confirmid')"><s:text name="confirmid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsstatus')"><s:text name="smsstatus"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smscreattime')"><s:text name="smscreattime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('smsconfirmtime')"><s:text name="smsconfirmtime"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="confirmid"/>" onclick="checkOne();">
                     </td>
                     <td><s:property value="employeeid" /></td>
                     <td><s:property value="oprcode" /></td>
                     <td><s:property value="employeename" /></td>
                     <td><s:property value="birthday" /></td>
                     <td><s:property value="sex" /></td>
                     <td><s:property value="edulevel" /></td>
                     <td><s:property value="nativehome" /></td>
                     <td><s:property value="polivisage" /></td>
                     <td><s:property value="department" /></td>
                     <td><s:property value="servoffice" /></td>
                     <td><s:property value="station" /></td>
                     <td><s:property value="joblevel" /></td>
                     <td><s:property value="intime" /></td>
                     <td><s:property value="worktime" /></td>
                     <td><s:property value="hereworktime" /></td>
                     <td><s:property value="employtype" /></td>
                     <td><s:property value="company" /></td>
                     <td><s:property value="telephone" /></td>
                     <td><s:property value="officetel" /></td>
                     <td><s:property value="outtime" /></td>
                     <td><s:property value="outresult" /></td>
                     <td><s:property value="homeaddr" /></td>
                     <td><s:property value="cardid" /></td>
                     <td><s:property value="wayid" /></td>
                     <td><s:property value="waytype" /></td>
                     <td><s:property value="pvtemail" /></td>
                     <td><s:property value="ofcphone" /></td>
                     <td><s:property value="ofcemail" /></td>
                     <td><s:property value="speciality" /></td>
                     <td><s:property value="cityid" /></td>
                     <td><s:property value="countyid" /></td>
                     <td><s:property value="svccode" /></td>
                     <td><s:property value="posittype" /></td>
                     <td><s:property value="contacttype" /></td>
                     <td><s:property value="empstatus" /></td>
                     <td><s:property value="actbank" /></td>
                     <td><s:property value="actno" /></td>
                     <td><s:property value="actname" /></td>
                     <td><s:property value="actpid" /></td>
                     <td><s:property value="bail" /></td>
                     <td><s:property value="gradschool" /></td>
                     <td><s:property value="gradtime" /></td>
                     <td><s:property value="ismarried" /></td>
                     <td><s:property value="outreason" /></td>
                     <td><s:property value="trainlevel" /></td>
                     <td><s:property value="hobby" /></td>
                     <td><s:property value="character" /></td>
                     <td><s:property value="asses" /></td>
                     <td><s:property value="workhistry" /></td>
                     <td><s:property value="prizeorpunish" /></td>
                     <td><s:property value="empass" /></td>
                     <td><s:property value="right" /></td>
                     <td><s:property value="isnet" /></td>
                     <td><s:property value="netpass" /></td>
                     <td><s:property value="isopen" /></td>
                     <td><s:property value="selectmobile" /></td>
                     <td><s:property value="subname" /></td>
                     <td><s:property value="regdate" /></td>
                     <td><s:property value="empattr" /></td>
                     <td><s:property value="empattrmemo" /></td>
                     <td><a href='<s:url action="empconfirm_edit.do">
	                         <s:param name="param._pk" value="confirmid"/>
	                     	</s:url>'>
							<s:property value="confirmid"/>
                         </a>
					 </td>
                     <td><s:property value="smsstatus" /></td>
                     <td><s:property value="smscreattime" /></td>
                     <td><s:property value="smsconfirmtime" /></td>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
</div>
</body>
</html>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
<script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._se_employeeid', '<s:text name="employeeid"/>', 'c', true, '15');
		addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._ne_empstatus', '<s:text name="empstatus"/>', 'f', true, '2');
		addfield('param._ne_confirmid', '<s:text name="confirmid"/>', 'f', true, '14');
		addfield('param._ne_smsstatus', '<s:text name="smsstatus"/>', 'f', true, '3');
		addfield('param._dnm_smscreattime', '<s:text name="smscreattime"/>', 't', true, '7');
		addfield('param._dnl_smscreattime', '<s:text name="smscreattime"/>', 't', true, '7');
		return checkval(window);
	}
</script>
