<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<head>
		<title><bean:message bundle="orderdetailquery" key="orderdetailquerytitle" /></title>
		<script language="JavaScript" type="text/JavaScript">
        function checkProcess(){
			var filename = formItem.filename.value;
			if(filename != null || filename != ""){
        		formItem.buttonProcess.disabled=true;
    			window.location.href="<%=contextPath%>/cms/rewardranlog/batch.do?CMD=BATCH&filename="+filename+"&beanname=com.sunrise.boss.ui.cms.rewardranlog.RewardranlogTaskBean";
    		}
		}
        //function getpath(){
    		//var url = formList.file.value;
    		//document.getElementById("savePath").value = url.substr(0,url.lastIndexOf("\\")+1);
    	//}
    	function doReturn(cmdReturn) {
    	formItem.action = contextPath + cmdReturn;
    	formItem.submit();
		}
    </script>
		<script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	</head>

	<body  onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/rewardranlog/batch.do?CMD=UPLOAD" enctype="multipart/form-data" styleId="formItem">
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td width="210" class="AreaName" align="left" valign=middle>
								酬金发放日志管理导入
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="error_text" width="100%">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<div class="table_div">
					<table class="form_table">
						<tr>
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="rewardranlog" key="selectfile" />
								:
							</td>
							<td class="form_table_left">
								<input type="file" class="form_input_files" name="theFile" ID="File1" />
							</td>
						</tr>
						<c:choose>
							<c:when test="${!empty requestScope.ITEM.inFile}">
								<tr class="table_style_content">
									<td align=right height=25>
										<bean:message bundle="upload" key="existfile" />
									</td>
									<td align=left>
										<a href='<%=contextPath%>/commons/batch/download.jsp?filename=<c:out
						value="${requestScope.ITEM.inFile}" />'> <c:out value="${requestScope.ITEM.fileName}" /> </a>
									</td>
								</tr>
							</c:when>
						</c:choose>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="filetype" />
							</td>
							<td align=left>
								<bean:message bundle="upload" key="typevalue" />
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="filestyle" />
							</td>
							<td align=left>
								<bean:message bundle="rewardranlog" key="typevalue" />
						</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="upload" key="example" />
							</td>
							<td align=left>
								JF00210|<font color=red>5988061401101003118933</font>|<font color=red>44001708401053000638</font>|<font color=red>200802</font>|<font color=red>100.01</font>|2011-07-28 10:22:11|备注|
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="rewardranlog" key="supplement" />
							</td>
							<td align=left>
								渠道编码可以为空，系统会根据【社会渠道网点信息管理】录入的【酬金支付银行账号】进行关联渠道编码。
							</td>
						</tr>
						
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="rewardranlog" key="redirect" />
							</td>
							<td align=left>
								<a href="<%= contextPath %>/cms/common/importguide.htm">填写指南</a>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="rewardranlog" key="excelexample" />
							</td>
							<td align=left>
								<a href="<%= contextPath %>/cms/rewardranlog/rewardranlog.xls">酬金发放日志管理导入模版.xls</a>&nbsp;&nbsp;
								<bean:message bundle="rewardranlog" key="excelinfo" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td align=right>

							<input type="submit" value="<bean:message bundle="upload" key="upload" />" class="button_2"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonUpload" NAME="buttonUpload">

							<input type="button" value="<bean:message bundle="upload" key="process"/>" class="button_2"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="checkProcess()" />
								
							<input type="button" value="返回" class="back"
								onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
								ID="buttonProcess" NAME="buttonProcess" onClick="doReturn('/cms/rewardranlog.do?CMD=SHOW')" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
			<iframe src="<%=contextPath%>/commons/batch/commonStatus.jsp?beanname=com.sunrise.boss.ui.cms.rewardranlog.RewardranlogTaskBean" frameborder="0" class="loadframe" id="loadframe" scrolling="no">
			</iframe>
		</div>
	</body>
</html>