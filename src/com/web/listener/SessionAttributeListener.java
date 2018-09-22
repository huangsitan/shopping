package com.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent env) {
		// TODO Auto-generated method stub
		System.out.println("SessionAttributeListener attributeAdded"+env.getName()+","+env.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent env) {
		// TODO Auto-generated method stub
		System.out.println("SessionAttributeListener attributeRemoved"+env.getName()+","+env.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent env) {
		// TODO Auto-generated method stub
		System.out.println("SessionAttributeListener attributeReplaced"+env.getName()+","+env.getValue());
		System.out.println(env.getSession().getAttribute(env.getName()));
	
	}

}
