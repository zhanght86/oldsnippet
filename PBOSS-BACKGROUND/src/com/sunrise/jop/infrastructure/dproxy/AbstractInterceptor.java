package com.sunrise.jop.infrastructure.dproxy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * AbstractInterceptor
 * <br> Description: class AbstractInterceptor
 * <br> Company: Maywide,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-4-19
 */
public class AbstractInterceptor implements Interceptor {

	public static Log log = LogFactory.getLog(AbstractInterceptor.class);
	
	private static Map excludeMethods = new HashMap();
	
	static {
		excludeMethods.put("toString","toString");
		excludeMethods.put("hashCode","hashCode");
		excludeMethods.put("clone","clone");
		excludeMethods.put("equals","equals");
		excludeMethods.put("getClass","getClass");				
	}
		
	/**
	 * 有些方法不能使用代理机制进行拦截。遇到此方法时，直接调用。
	 * @param info
	 */
	public boolean isIncludeMethod(InvokeInfo info) {
		return !isExcludeMethod(info);
	}
	
	/**
	 * 
	 * @param info
	 * @return
	 */
	public boolean isExcludeMethod(InvokeInfo info) {
		Method method = info.getMethod();
		
		//忽略void方法
		if( "void".equals(method.getReturnType().getName())) {
			if(log.isDebugEnabled()) log.debug("忽略void方法 " + method.getName());
			info.setStopProxy(true);
			return true;
		}
		//忽略非public ， protected 方法
		if(  !Modifier.isPublic(method.getModifiers()) && !Modifier.isProtected(method.getModifiers()))  {
			if(log.isDebugEnabled()) log.debug("忽略静态方法 " + method.getName());
			info.setStopProxy(true);
			return true;
		}
		
		//忽略Object类基本 方法
		if(excludeMethods.containsKey(method.getName())) {
			if(log.isDebugEnabled()) log.debug("忽略Object基本方法 " + method.getName());
			info.setStopProxy(true);
			return true;
		}
		
		return false;
	}
	
	public void before(InvokeInfo info) throws Throwable {		
	}
	
	public void after(InvokeInfo info) throws Throwable {		
	}

	public void exceptionThrow(InvokeInfo info) throws Throwable {		
		throw info.getException();
	}

}
