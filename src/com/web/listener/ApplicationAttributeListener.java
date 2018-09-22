package com.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent env) {
		// TODO Auto-generated method stub
		ServletContext context=env.getServletContext();
        System.out.println("ApplicationAttributeListener attributeAdded"+env.getName()+","+env.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent env) {
		// TODO Auto-generated method stub
		 System.out.println("ApplicationAttributeListener attributeRemoved"+env.getName()+","+env.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent env) {
		// TODO Auto-generated method stub
		ServletContext context=env.getServletContext();
		 System.out.println("ApplicationAttributeListener attributeReplaced"+env.getName()+","+env.getValue());
		 System.out.println(context.getAttribute(env.getName()));
	}

}
