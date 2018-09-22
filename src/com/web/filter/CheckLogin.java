package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.UserInfo;

@WebFilter(urlPatterns={"/back/*","/user/*"})
public class CheckLogin implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)request;
		String path =req.getRequestURI();
		if(path.endsWith(".jpg")||path.endsWith(".js")||path.endsWith(".css"))
		{
			 chain.doFilter(request, response);
		}
		
		UserInfo us=(UserInfo)req.getSession().getAttribute("loger");
		
		if(us!=null)
		{
		  System.out.println("login过滤器进来了");
		  chain.doFilter(request, response);
		  System.out.println("login过滤器响应出来了"); 
		}else
		{
			HttpServletResponse res=(HttpServletResponse)response;
			res.sendRedirect("../login.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
