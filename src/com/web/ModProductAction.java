package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.ProductServiceImpl;
import com.entity.Product;

@WebServlet("/back/product/domod")
public class ModProductAction extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		//1
		 
		  String id=request.getParameter("id");
		  String na=request.getParameter("pname");
		  String price=request.getParameter("price");
		  String store=request.getParameter("store");
		   String type=request.getParameter("type");
		   String info=request.getParameter("info");
		  //2
		   Product p = new Product();
		   p.setId(Integer.parseInt(id));
		   p.setName(na);
		   p.setPrice(Double.parseDouble(price));
		   p.setStore(Integer.parseInt(store));
		   p.setCateid(Integer.parseInt(type));
		   p.setInfo(info);
		   int n=new ProductServiceImpl().modProduct(p);
		//3
		   if(n==0)
		   {
			   out.print(" <script>alert('修改失败');</script>");
			   out.print(" <script>location='../modProduct.jsp';</script>");
		   }else
		   {
			   
			   out.print(" <script>alert('修改成功');</script>");
			   out.print(" <script>location='../index.jsp';</script>");
		   }
		
		   
		out.flush();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
