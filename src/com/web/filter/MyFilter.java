package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class MyFilter implements Filter {

	
	public MyFilter()
	{
		System.out.println("---ʵ����----");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("---����----");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("---ִ�й���----");
		
		chain.doFilter(req, res);//�����������
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("---��ʼ��----");
		
	}
}
