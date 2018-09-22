<%@page import="com.biz.ProductServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
//1
 String id=request.getParameter("id");
//2
 int n=new ProductServiceImpl().delProduct(Integer.parseInt(id));
//3
 if(n==0)
 {
 %>
  <script>alert('删除失败');</script>
 <%
 }
%>
<script>location='../index.jsp';</script>

