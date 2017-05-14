package com.kk.util;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {

	public static<T>  T convertFromBean(Class<T> clazz,HttpServletRequest request){
		T t =null;
		try {
			t  = clazz.newInstance();
			System.out.println("map"+request.getParameterMap());
			BeanUtils.populate(t, request.getParameterMap());
		} catch (InstantiationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(InvocationTargetException e){
			e.printStackTrace();
		}
		return t;
	}
}
