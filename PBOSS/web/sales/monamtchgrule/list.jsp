<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_cityid', '<s:text name="cityid"/>', 'c', true, '10');
            addfield('param._ne_starlevel', '<s:text name="starlevel"/>', 'f', true, '2');
            addfield('param._se_brand', '<s:text name="brand"/>', 'c', true, '16');
            addfield('param._ne_effective', '<s:text name="effective"/>', 'f', true, '3');
            return checkval(window);
        }
    </script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="monamtchgrule_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
    <aa:zone name="hiddenZone"><s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/></aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
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
                <td align="center"><s:text name="cityid"/>:</td>
                <td align="left">
                    <j:selector definition="#CITYCOMPANY" name="param._se_cityid" mode="selector" condition="citycompid:${dBAccessUser.cityid }" value="%{dBAccessUser.cityid}" disabled="true"/>
                </td>
                <td align="center"><s:text name="starlevel"/>:</td>
                <td align="left">
                    <j:selector name="param._ne_starlevel" definition="$CH_STARLEVEL" />
                </td>
            </tr>
            <tr>
                <td align="center"><s:text name="brand"/>:</td>
                <td align="left">
                    <p:smpBrand name="param._se_brand" mode="of" cssStyle="style_input" />
                </td>
                <td align="center"><s:text name="effective"/>:</td>
                <td align="left">
                    <j:selector name="param._ne_effective" definition="$CH_VALIDFLAG" condition="dictid:0,1" />
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
                        value="<s:text name="button_search"/>" onClick="doQuery('/sales/monamtchgrule_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/sales/monamtchgrule_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/sales/monamtchgrule_delete.do')">
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
                    <j:orderByImg href="javascript:doOrderby('ruleid')"><s:text name="ruleid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('cityid')"><s:text name="cityid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('starlevel')"><s:text name="starlevel"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('brand')"><s:text name="brand"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actratelow')"><s:text name="actratelow"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('actrateup')"><s:text name="actrateup"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('times')"><s:text name="times"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('effective')"><s:text name="effective"/></j:orderByImg>                 
                </td>
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                         <input type="checkbox" name="param._selectitem" value="<s:property value="ruleid"/>" onclick="checkOne();">
                     </td>
                     <td><a href='<s:url action="monamtchgrule_edit.do">
	                         <s:param name="param._pk" value="ruleid"/>
	                     	</s:url>'>
							<s:property value="ruleid"/>
                         </a>
					 </td>
                     <td><j:code2Name definition="#CITYCOMPANY" code="cityid" /></td>
                     <td><j:code2Name definition="$CH_STARLEVEL" code="starlevel" /></td>
                     <td><j:code2Name definition="$FX_SMPBRAND" code="brand" /></td>
                     <td><s:property value="actratelow" /></td>
                     <td><s:property value="actrateup" /></td>
                     <td><s:property value="times" /></td>
                     <td><j:code2Name definition="$CH_VALIDFLAG" code="effective" /></td>
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
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
</body>
</html>
