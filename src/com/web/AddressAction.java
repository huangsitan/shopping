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
			//�б�
			list(request,response);
			
		}else if(act.equals("add"))
		{
		     //����
			add(request,out);
			
		}else if(act.equals("del"))
		{
		    //ɾ��
			del(request,out);
			
		}else if(act.equals("getbyid"))
		{
		   //����
			getByid(request,response);
			
		}else if(act.equals("mod"))
		{
		    //�޸�
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
	
	
	//���ӷ���
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
			out.print("<script>alert('����ʧ��');location='addressAction'</script>");
			
		}else
		{
			out.print("<script>alert('���ӳ¹�');location='addressAction'</script>");
		}
	}
	
	
	/**
	 * ɾ��
	 * */
	public  void del(HttpServletRequest request,PrintWriter out){
		
		String id=request.getParameter("id");
		
		int n=biz.delAddress(new String[]{id});
		
		if(n==0)
		{
			out.print("<script>alert('ɾ��ʧ��');location='addressAction'</script>");
			
		}else
		{
			out.print("<script>alert('ɾ���¹�');location='addressAction'</script>");
		}
		
	}
	
	
	/**
	 * ����
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
			out.print("<script>alert('�޸�ʧ��');location='addressAction'</script>");
			
		}else
		{
			out.print("<script>alert('�޸ĳ¹�');location='addressAction'</script>");
		}
	}
	
	

}
