package com.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.dao.CounterDao;

public class ApplicaitonListener implements ServletContextListener {

	private CounterDao dao = new CounterDao();
	
	@Override
	public void contextDestroyed(ServletContextEvent env) {
		// TODO Auto-generated method stub
		Integer nn= (Integer)env.getServletContext().getAttribute("num");
        dao.addCount(nn);
        String path=env.getServletContext().getContextPath();
        System.out.println(path+"��Ŀ������");
        
	}

	@Override
	public void contextInitialized(ServletContextEvent env) {
		// TODO Auto-generated method stub
		    String path=env.getServletContext().getContextPath();
	        System.out.println(path+"��Ŀ������");
	        int n=dao.selectNum();
	        env.getServletContext().setAttribute("num", n);
	}

}
