package com.sunrise.boss.ui.cms.zjty.zjtyddtreward.upload;

import java.text.SimpleDateFormat;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.pub.tools.StringSplit;

public class AddZjtyDdtrewardCheck extends BaseCheckFormat {

	public AddZjtyDdtrewardCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	/**
	 * 文件行的内容检查
	 */
	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line.trim())) {
			return;
		}

		String[] items = StringSplit.split(line, "|");
		WayDelegate waydelegate = new WayDelegate();
		// 检查列数
//		if (items.length < 5){
//			if(items.length ==4){
//				
//			}else{
//			throw new Exception("上传数据列数不对,至少为4列,说明字段可不填!");
//			}
//		}
		//if (items[4].trim().equals(null)){
			
		//}
		if (items.length != 5) {
			throw new Exception("上传数据列数不对,应该为5列,请查看说明帮助!");
		}

		if (!doCheckLong(items[0]) || items[0].length() > 3) {
			throw new BusinessException("", "第1列[扣减类型]必须为数字且长度不能大于3");
		}
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "第1列[扣减类型]不能为空");
		}
		if (items[0].trim().equals("1")){
		} else {
			throw new Exception("第1列[扣减类型]不对，只能为 1 - 全球通扣减");
		}
		
		// 渠道代码
		if (StringUtils.isEmpty(items[1])) {
			throw new BusinessException("", "第2列[渠道代码]不能为空");
		}
		WayVO wayvo = waydelegate.doFindByPk(items[1], user);
		if (wayvo == null) {
			throw new BusinessException("", "第2列[渠道代码]不存在");
		}
		
		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage dp1;
		waylistvo.set_se_wayid(items[1]);
		waylistvo.set_se_waytype("AG");
		waylistvo.set_se_waysubtype("ZJTY");
		waylistvo.set_ne_runmode("1");
		waylistvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		dp1 = wayDelegate.doQuery(waylistvo, user);
		if (dp1.getDatas().size()<=0){
			throw new BusinessException("", "上传失败,第2列["+items[1]+"]不是本地市的自建他营渠道!");
		}
		
		//结算月份校验
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "第3列[结算月]不能为空.");
		}
		if (items[2].length() != 6){
			throw new BusinessException("", "第3列[结算月]长度必须为6位.");
		}
		try {
			format.parse(items[2]);
		} catch (Exception e) {
			throw new BusinessException("", "第3列[结算月]格式不正确，正确的格式应该为YYYYMM.");
		}
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		if (!items[2].matches(regex)) {
			throw new BusinessException("", "作用结算月不合法,月份范围应为[01-12]!");
		}
		
		//检查[扣减金额]是否为合法
		if (StringUtils.isEmpty(items[3]) || !NumberUtils.isNumber(items[3])) {
			throw new BusinessException("", "第4列[扣减金额]不能为空并且必须为数字");
		}
		try {
			if (!(checkAmtFormat(items[3], 14)))
				throw new Exception("第4列[扣减金额]格式不对(" + items[3]
						+ "),整数部分最多14位，如有小数部分则一定是2位!");
		} catch (Exception e) {
			throw new Exception("第4列[扣减金额]格式不对(" + items[3]
					+ "),整数部分最多14位，如有小数部分则一定是2位!");
		}
		
		//说明校验
		//if (items.length == 4){
		//}else if (items[4].getBytes().length > 255){
		 if (items[4].getBytes().length > 255){
			throw new BusinessException("", "第5列[说明]长度不能超过255位. 注：字母和数字占长度1位，中文字符占长度2位.");
		}
	}

	public static boolean checkDate(String date) {
		boolean ret = true;
		if (date.length() != 8)
			return false;
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
			sd.parse(date);
		} catch (Exception e) {
			return false;
		}
		return ret;
	}

	public boolean doCheckLong(String number) {
		try {
			Long.parseLong(number);
		} catch (NumberFormatException exception) {
			return false;
		}
		return true;
	}

	public boolean checkAmtFormat(String amt, int length) {
		amt = amt.trim();
		if (amt.indexOf(".") != -1) {
			if (amt.indexOf(".") == 0) {
				return false;
			}
			if (amt.indexOf(".") > length) {
				return false;
			}
			if ((amt.length() - amt.indexOf(".")) != 3) {
				return false;
			}
		} else {
			if (amt.length() > length) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		AddZjtyDdtrewardCheck check = new AddZjtyDdtrewardCheck();

	}

}
