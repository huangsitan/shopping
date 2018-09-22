package com.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SesssionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent env) {
		// TODO Auto-generated method stub
		
         System.out.println( env.getSession().getId()+",会话创建了");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent env) {
		// TODO Auto-generated method stub
		  System.out.println( env.getSession().getId()+",会话销毁了");
	}

}
