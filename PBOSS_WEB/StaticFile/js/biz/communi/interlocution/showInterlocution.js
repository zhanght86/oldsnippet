//表格配置数组
var optin = {
	showCols:showCols,//显示列
	pageSize:5,//页内大小
	fmtLink:fmtLink,
	navigation:$("#navigation"),//翻页位置 jq对象
	width:"100%",
	showTable:false,
	queryFrom: $("#queryReply")//查询表单
};

function doQuery(){
	$("#showTbl").queryTable(optin);
}

$(document).ready(function() {
	doQuery();
});

var _o_li = null;
var doReply=function(){
	if($.trim($("#content").val())==""){
		f_showEMsg("回复内容为必填项。");
		return;
	}
	$('#saveFrm').attr("action","reply.do");
	_o_li = f_showPlan("处理中，请稍候。");
	var a = {dataType:'json',success:handleResponse};
	$('#saveFrm').ajaxSubmit(a);
}

var doClose=function(){
	$('#saveFrm').attr("action","close.do");
	_o_li = f_showPlan("处理中，请稍候。");
	var a = {dataType:'json',success:handleResponse};
	$('#saveFrm').ajaxSubmit(a);
	$('#saveFrm').hide();
	$('#submit').hide();
	$('#close').hide();
}

function handleResponse(json){
	if(!json.isSuccess){
		if(_o_li != null)
			_o_li.close();
		f_showMsg(json.message);
	}
	else{
		_o_li.close();
		$("#replyContent").val("");
		doQuery();
	}
}