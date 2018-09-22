package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class EncodingFilter implements Filter {

	private String encoding=null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
        
		//往请求中添加功能
		request.setCharacterEncoding(encoding);
		System.out.println("Encoding过滤器进来了");
		chain.doFilter(request, response);//请求传递给后面的web资源
		System.out.println("Encoding过滤器响应出来了");
		//响应中添加功能
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding=filterConfig.getServletContext().getInitParameter("encodingxx");
	
	}

}
