package com.sunrise.boss.ui.cms.zjty.zjtybusyxplan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class ZjtyBusyxplanCheck extends BaseCheckFormat {
	public ZjtyBusyxplanCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content =StringUtils.splitPreserveAllTokens(line, "|");
		
		if (content.length != 5) {
			throw new Exception("�ϴ�������������,ӦΪ4��,��鿴˵������!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","ҵ����벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","ӳ�����Ͳ���Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","��Ʒ���벻��Ϊ��");
		}
		
		// �����·�
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
		for (int i = 0; i < content.length-1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[ҵ�����]���ܴ���18λ");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 32,true)) {
					throw new Exception("[ӳ������]���ܴ���32λ");
				}
				break;
			case 2:
				if (!CheckUtil.checkString(content[i], 32,true)) {
					throw new Exception("[��Ʒ����]���ܴ���32λ");
				}
				break;
			case 3:
				if (!"".equals(content[i].trim()) && !CheckUtil.checkDouble(content[i], 8, 2)) {
					throw new Exception("[�ײ�ֵ]���ֻ��8λ������2λС��");
				}
				break;
			}
		}
	}
	
	
}