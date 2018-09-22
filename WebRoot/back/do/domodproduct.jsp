<%@page import="com.biz.ProductServiceImpl"%>
<%@page import="com.entity.Product"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
//1
  request.setCharacterEncoding("utf-8");
  String id=request.getParameter("id");
  String na=request.getParameter("pname");
  String price=request.getParameter("price");
  String store=request.getParameter("store");
   String type=request.getParameter("type");
   String info=request.getParameter("info");
  
  Product p = new Product();
  p.setId(Integer.parseInt(id));
  p.setName(na);
  p.setPrice(Double.parseDouble(price));
  p.setStore(Integer.parseInt(store));
  p.setCateid(Integer.parseInt(type));
  p.setInfo(info);
//2
 int n=new ProductServiceImpl().modProduct(p);
//3
 if(n==0)
 {
 %>
  <script>alert('修改失败');</script>
 <%
 }
%>
<script>location='../index.jsp';</script>

%>
