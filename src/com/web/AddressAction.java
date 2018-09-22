package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.AddressBizimpl;
import com.biz.IAddressBiz;
import com.entity.Address;
import com.entity.UserInfo;

@WebServlet("/user/addressAction")
public class AddressAction extends HttpServlet {
	IAddressBiz biz = new AddressBizimpl();
	UserInfo log=null;
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
		
		String act=request.getParameter("act");
		log=(UserInfo)request.getSession().getAttribute("loger");
		if(act==null)
		{
			//列表
			list(request,response);
			
		}else if(act.equals("add"))
		{
		     //增加
			add(request,out);
			
		}else if(act.equals("del"))
		{
		    //删除
			del(request,out);
			
		}else if(act.equals("getbyid"))
		{
		   //查找
			getByid(request,response);
			
		}else if(act.equals("mod"))
		{
		    //修改
			mod(request,out);
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
	
	
	//增加方法
	public void add(HttpServletRequest request,PrintWriter out){
		
		String contactman=request.getParameter("contactman");
		String contactphone=request.getParameter("contactphone");
		String country=request.getParameter("country");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String detail=request.getParameter("detail");
		String postcode=request.getParameter("postcode");
		Address address= new Address();
		address.setCity(city);
		address.setContactman(contactman);
		address.setContactphone(contactphone);
		address.setDetail(detail);
		address.setPostcode(postcode);
		address.setProvince(province);
		address.setCountry(country);
		address.setUid(log.getId());
		
		int n=biz.addAddress(address);
		if(n==0)
		{
			out.print("<script>alert('增加失败');location='addressAction'</script>");
			
		}else
		{
			out.print("<script>alert('增加陈功');location='addressAction'</script>");
		}
	}
	
	
	/**
	 * 删除
	 * */
	public  void del(HttpServletRequest request,PrintWriter out){
		
		String id=request.getParameter("id");
		
		int n=biz.delAddress(new String[]{id});
		
		if(n==0)
		{
			out.print("<script>alert('删除失败');location='addressAction'</script>");
			
		}else
		{
			out.print("<script>alert('删除陈功');location='addressAction'</script>");
		}
		
	}
	
	
	/**
	 * 查找
	 * @throws IOException 
	 * @throws ServletException 
	 * */
	public void getByid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		  String id=request.getParameter("id");
		  Address address=biz.getAddressById(Integer.parseInt(id));
		  request.setAttribute("address", address);
		  request.getRequestDispatcher("modAddress.jsp").forward(request, response);
	}
	
	public void list(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		List<Address> list = biz.getAddressByUser(log.getId());
		request.getSession().setAttribute("list", list);
		response.sendRedirect("listAddress.jsp");
	}
	
	public void mod(HttpServletRequest request,PrintWriter out){
		
		String id=request.getParameter("id");
		String contactman=request.getParameter("contactman");
		String contactphone=request.getParameter("contactphone");
		String country=request.getParameter("country");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String detail=request.getParameter("detail");
		String postcode=request.getParameter("postcode");
		Address address= new Address();
		address.setCity(city);
		address.setContactman(contactman);
		address.setContactphone(contactphone);
		address.setDetail(detail);
		address.setPostcode(postcode);
		address.setProvince(province);
		address.setCountry(country);
		address.setUid(log.getId());
		address.setId(Integer.parseInt(id));
		
		int n=biz.modAddress(address);
		if(n==0)
		{
			out.print("<script>alert('修改失败');location='addressAction'</script>");
			
		}else
		{
			out.print("<script>alert('修改陈功');location='addressAction'</script>");
		}
	}
	
	

}
