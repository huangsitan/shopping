package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.UserBizImpl;
import com.entity.UserInfo;
import com.web.listener.SessionBoundListener;

@WebServlet("/dolog")
public class LoginAction extends HttpServlet {

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

		//1

		String name=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		HttpSession session=request.getSession();
		//2
		UserInfo us=new UserBizImpl().log(name, pwd);
		
		//3
		if(us==null)
		{
			response.sendRedirect("login.jsp");
		}else
		{
			
			 /******************存cookie**********************/
		     Cookie ck = new Cookie("logname",name);
		     ck.setPath("/");
		     ck.setMaxAge(60*60*24*7);
		     response.addCookie(ck);
		     /****************************************/
		     
			
		     
			session.setAttribute("loger", us);
			
			/**********在线人数统计*****************/
			SessionBoundListener lis=new  SessionBoundListener();
			lis.setInfo(us);
			session.setAttribute("xx", lis);
			
			/***************************/
			
			if(us.getIsadmin()==0)
			{
			   response.sendRedirect("index.jsp");
			}
			else
			{
			   response.sendRedirect("back/main.jsp");
			}
		}
		
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
