package com.web.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.entity.UserInfo;
import com.util.Online;

public class SessionBoundListener implements HttpSessionBindingListener {

	private UserInfo info;
	
	
	
	public UserInfo getInfo() {
		return info;
	}

	public void setInfo(UserInfo info) {
		this.info = info;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent env) {
		// TODO Auto-generated method stub
		
         Online.list.add(info);
         Online.count++;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent env) {
		// TODO Auto-generated method stub
		 Online.list.remove(info);
		  Online.count--;
	}

}
