package com.asisinfo.common.jdbc;

/**
 * <p>�й��ƶ��㶫ʡ�ƶ���˾BOSSϵͳ</p>
 * <p>���ֶ��쳣</p>
 * <p>Copyright (c) 2004</p>
 * <p>�й����ݴ��˵��ӿ������޹�˾</p>
 * @author BOSSǰ̨�� <a href = "mailto:wudi@exchange.ricsson.com">���</a>
 * @version 1.0
 */
public class NoColumnException
    extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5714143285649169959L;

	public NoColumnException()
    {
    }

    /**
     * ���췽��
     * @param errMsg ������Ϣ
     */
    public NoColumnException(String errMsg)
    {
        super(errMsg);
    }
}