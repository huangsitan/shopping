<%@page import="com.entity.UserInfo"%>
<%@page import="com.entity.ProdutType"%>
<%@page import="com.biz.PTypeBizImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
//1
request.setCharacterEncoding("utf-8");
String name=request.getParameter("tname");
 ProdutType tt = new ProdutType();
 //取出会话中的登录人
 UserInfo us=(UserInfo)session.getAttribute("loger");
 
 tt.setName(name);
 tt.setCreator(us.getName());
//2
int n=new PTypeBizImpl().add(tt);
//3
if(n==0)
 {
 %>
  <script>alert('增加失败');</script>
 <%
 }
%>
<script>location='../typelist.jsp';</script>

