//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	//var o = oRecord.employeeid;
	//if(oColumnSet.key=="oper"){
	//	rtn = "<a href=\"javascript:doLoadEmployee('"+ o +"')\"><font color=\"#0000FF\">查看</font></a>" ;
	//}
	return rtn;
}

function f_exportExcel(){
	sumbitExportExcel("exportExcelRegNew.do","content");
}

function f_exportTxt(){
	sumbitExportExcel("exportTxtRegNew.do","content");
}

function f_clearSvccode(){
	document.getElementById("svccode").value="";
}

function f_opnSelect(content){
	var url="/magSaleDetail/opnselect.do?opntype=2";
	var rtn=window.showModalDialog(url , content , "dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("opnid").value = rtn;
	   return rtn;
	}
}

function f_waySelect(content){
	document.getElementById("oprcode").value = "";
	document.getElementById("employeename").value = "";
	var url="/magSaleDetail/waySelect.do";
	var rtn=window.showModalDialog(url , content , "dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("wayid").value = rtn;
	   return rtn;
	}
}

function f_employeeSelect(content){
	var wayid = document.getElementById("wayid").value;
	var url;
	if(wayid == null||wayid==""){
		url="/magSaleDetail/employeeSelect.do";
	}
	else{
		url="/magSaleDetail/employeeSelect.do?wayid="+wayid;
	}
	var rtn=window.showModalDialog(url , content , "dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("oprcode").value = rtn[0];
	   document.getElementById("employeename").value = rtn[1];
	   return rtn;
	}
}

function showSvccode(control) {
	var countyid = document.getElementById('countyid').value;
	if (countyid == "") {
		alert('请先输入分公司！');
		document.getElementById('svccode').value = "";
		return;
	}
	var url = "/servcent/list.do?_se_countyid="+countyid;
	var rtn = window.showModalDialog(url, control, "dialogWidth=530px;dialogHeight=430px;status:no;scroll=yes;");
	if (rtn != null) {
		document.getElementById('svccode').value = rtn;
		return rtn;
	}
}

function  DateDiff(sDate1, sDate2){  //sDate1 and sDate2 is 2006-12-18model
    var aDate, oDate1, oDate2, iDays  
    //aDate = sDate1.split("-") 
    aDate = sDate1.replace(/-/g,"/");
    oDate1 = new Date(aDate) //change to 12-18-2006model  
    //aDate = sDate2.split("-")  
    aDate = sDate2.replace(/-/g,"/");
    //oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0])  
    oDate2 = new Date(aDate)  
    //alert(oDate2);
    iDays = parseInt(Math.abs(oDate1 - oDate2)/1000/60/60/24)  //day  
    return iDays  
} 
//调用查询
var doQuery = function() {
	var timeFrom = $('#timeFrom').val();
	var timeTo = $('#timeTo').val();
	if(timeFrom == "" && timeTo != ""){
		alert("登记起始时间不能为空!");
		return;
	}
	if(timeFrom != "" && timeTo==""){
		alert("登记结束时间不能为空!");
		return;
	}
	if (timeFrom > timeTo) {
		alert("登记起始时间不能大于登记结束时间!");
		return;
	}
	var differ1 = DateDiff(timeFrom, timeTo);
	if (differ1 > 30) {
		alert("登记起始时间＆登记结束时间不能超出31天!");
		return;
	}
	
	$("#showTbl").queryTable(optin);
};
//页面初始化完成时调用
$(document).ready(function() {
	//生成日期下拉
	initDate("timeFrom");
	initDate("timeTo");
	
	//导出文件
	$("#btnExportExcel").click(f_exportExcel);
	$("#btnExportTxt").click(f_exportTxt);
	
	//f_showMenu(4,2,0);
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	$("#showTbl").queryTable(optin);
});