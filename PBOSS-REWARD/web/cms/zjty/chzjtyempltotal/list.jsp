<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="chzjtyempltotal" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_snm_yearmonth', '<bean:message bundle="chzjtyempltotal" key="yearmonth"/>', 'd', true, '6');
            addfield('_snl_yearmonth', '<bean:message bundle="chzjtyempltotal" key="yearmonth"/>', 'd', true, '6');
            addfield('_se_wayid', '<bean:message bundle="chzjtyempltotal" key="wayid"/>', 'c', true, '32');
            return checkval(window);
        }
        function doBatch()
        {
        	var url="<%=contextPath%>/cms/zjty/chzjtyempltotal/batch.jsp";
        	formList.action=url;
        	formList.submit();
        	formList.action="<%=contextPath%>/cms/zjty/empltotal.do?CMD=LIST";
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/empltotal.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/EmpltotalForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chzjtyempltotal" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzjtyempltotal" key="yearmonth"/>>=</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snl_yearmonth" onclick="this.value=selectDateYYYYMM();"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzjtyempltotal" key="yearmonth"/><=</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snm_yearmonth" onclick="this.value=selectDateYYYYMM();"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chzjtyempltotal" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                     <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    			<input type="button" value="..." class="clickbutton"
								onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY','1');this.value='...';" />
                </td>
                <td colspan=2>
                	&nbsp;
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		<s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/zjty/empltotal.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/zjty/empltotal.do')">
                        </s:PurChk>
                       	 <input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doBatch();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="批量导入" />
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('yearmonth')"><bean:message bundle="chzjtyempltotal" key="yearmonth"/></a>
                    <s:OrderImg form="/cms/zjty/EmpltotalForm" field="yearmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="chzjtyempltotal" key="wayid"/></a>
                    <s:OrderImg form="/cms/zjty/EmpltotalForm" field="wayid"/>
                </td>
                <td>
                	渠道名称
                </td>
                <td>
                    <a href="javascript:doOrderby('amount')"><bean:message bundle="chzjtyempltotal" key="amount"/></a>
                    <s:OrderImg form="/cms/zjty/EmpltotalForm" field="amount"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="chzjtyempltotal" key="memo"/></a>
                    <s:OrderImg form="/cms/zjty/EmpltotalForm" field="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/empltotal.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.wayid}|${item.yearmonth}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}|${item.yearmonth}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                     <a href='<c:out value="${urlContent}"/>'><c:out value="${item.yearmonth}"/>
                     </a>
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
	                 <td><s:Code2Name code="${item.wayid}" definition="#WAY" />
                     </td>
                     <td><fmt:formatNumber pattern="0.##" value="${item.amount}" /></td>
                     <td><c:out value="${item.memo}"/></td>
                 </tr>
             </c:forEach>
        </table>
   </div>
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
