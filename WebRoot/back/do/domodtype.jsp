<%@page import="com.entity.UserInfo"%>
<%@page import="com.entity.ProdutType"%>
<%@page import="com.biz.PTypeBizImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
//1
request.setCharacterEncoding("utf-8");
String name=request.getParameter("tname");
String id=request.getParameter("id");
 ProdutType tt = new ProdutType();
 //取出会话中的登录人
 UserInfo us=(UserInfo)session.getAttribute("loger");
 
 tt.setName(name);
 tt.setId(Integer.parseInt(id));
//2
int n=new PTypeBizImpl().mod(tt);
//3
if(n==0)
 {
 %>
  <script>alert('修改失败');</script>
 <%
 }
%>
<script>location='../typelist.jsp';</script>
