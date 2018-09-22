<%@page import="com.entity.UserInfo"%>
<%@page import="com.biz.UserBizImpl"%>
<%@page import="com.biz.IUserBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
   //获得请求数据
   request.setCharacterEncoding("utf-8");
   String name=request.getParameter("uname");
   String pwd=request.getParameter("pwd");
   String phone=request.getParameter("phone");
   String sex=request.getParameter("sex");
   
   UserInfo us = new UserInfo();
   us.setName(name);
   us.setPwd(pwd);
   us.setPhone(phone);
   us.setSex(sex);
   
   IUserBiz biz= new UserBizImpl();
   int n=biz.reg(us);
   if(n>0)
   {
     response.sendRedirect("regsucc.jsp");
   }else
   {
       response.sendRedirect("reg.jsp");
   }
%>
