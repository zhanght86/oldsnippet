<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<link href="<%=contextPath%>/css/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>

		<div class="table_container">
			

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
					addmenu('<%=contextPath%>/sales/wayfxsworder_list.do', '费用汇总');
					addmenu('<%=contextPath%>/sales/orderresdetwayorder_list.do', '资源汇总');
					<%-- addmenu('<%=contextPath%>/sales/orderresdetwayorderdetail_list.do', '营收明细'); --%>
					addmenuright();
				  addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/sales/wayfxsworder_list.do" height="100%"  scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
