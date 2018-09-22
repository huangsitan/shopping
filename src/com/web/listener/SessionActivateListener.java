package com.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class SessionActivateListener implements HttpSessionActivationListener {

	@Override
	public void sessionDidActivate(HttpSessionEvent env) {
		// TODO Auto-generated method stub
		 System.out.println(env.getSession().getId()+"������");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent env) {
		// TODO Auto-generated method stub
        System.out.println(env.getSession().getId()+"�������ۻ�");
	}

}
