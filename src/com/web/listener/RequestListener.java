package com.web.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent env) {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)env.getServletRequest();
		 String path2=req.getRequestURI();
		 System.out.println(path2+"���������");
	}

	@Override
	public void requestInitialized(ServletRequestEvent env) {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)env.getServletRequest();
	    //String path=req.getContextPath();//�������������Ŀ��
	    String path2=req.getRequestURI(); //��Ŀ��/web��Դ
	   // StringBuffer path3=req.getRequestURL();
	  System.out.println(path2+"���󴴽���");
	}

}
