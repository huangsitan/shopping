package com.web.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent env) {
		// TODO Auto-generated method stub
       System.out.println("RequestAttributeListener  attributeAdded"+env.getName()+"------"+env.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent env) {
		// TODO Auto-generated method stub
		 System.out.println("RequestAttributeListener  attributeRemoved"+env.getName()+"------"+env.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent env) {
		// TODO Auto-generated method stub
		Object val=env.getServletRequest().getAttribute(env.getName());
		System.out.println("RequestAttributeListener  attributeReplaced"+env.getName()+"------"+env.getValue());
		System.out.println("RequestAttributeListener  attributeReplaced new"+val);
	}

}
