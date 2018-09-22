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
        
		//����������ӹ���
		request.setCharacterEncoding(encoding);
		System.out.println("Encoding������������");
		chain.doFilter(request, response);//���󴫵ݸ������web��Դ
		System.out.println("Encoding��������Ӧ������");
		//��Ӧ����ӹ���
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding=filterConfig.getServletContext().getInitParameter("encodingxx");
	
	}

}
