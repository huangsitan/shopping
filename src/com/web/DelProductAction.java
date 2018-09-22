package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ProductServiceImpl;

/**
 * Servlet implementation class DelProductAction
 */
@WebServlet("/back/product/dodel")
public class DelProductAction extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//1
		String id=request.getParameter("id");
		//2
		int n=new ProductServiceImpl().delMany(new String[]{id});
		//3
		if(n==0)
		{
		  	out.print("<script>alert('É¾³ýÊ§°Ü');</script>");
			
		}
		out.print("<script>location='../index.jsp'</script>");
		out.flush();
		out.close();
		
	}

}
