<%@page import="com.entity.UserInfo"%>
<%@page import="com.biz.UserBizImpl"%>
<%@page import="com.biz.IUserBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
   //获得请求数据
   request.setCharacterEncoding("utf-8");
   String name=request.getParameter("uname");
   String pwd=request.getParameter("pwd");
   //验证
   IUserBiz biz = new UserBizImpl();
   UserInfo us=biz.log(name, pwd);
   //根据结果跳转
   if(us==null)
   {
   %>
     <script>alert('用户名密码有错，登录失败');location="../login.jsp";</script>
    <% 
    // request.getRequestDispatcher("login.jsp").forward(request, response);
   }else
   {
   
     /******************存cookie**********************/
     Cookie ck = new Cookie("logname",name);
     ck.setPath("/");
     ck.setMaxAge(60*60*24*7);
     response.addCookie(ck);
     /****************************************/
   
      session.setAttribute("loger", us);
      
      if(us.getIsadmin()==1)
      {
         //request.getRequestDispatcher("../back/main.jsp").forward(request, response);
    %>
     <jsp:forward page="../back/main.jsp"></jsp:forward>
    
    <% 
      }else
      {
        request.getRequestDispatcher("../index.jsp").forward(request, response);
       //response.sendRedirect("index.jsp");
       }
   }
%>

