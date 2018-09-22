<%@page import="com.biz.ShopCartBizImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  //1
  String[] ids=request.getParameterValues("cartid");
  //2
  int n=new ShopCartBizImpl().delCarts(ids);
  //3
  if(n==0)
 {
 %>
  <script>alert('删除失败');</script>
 <%
 }
%>
<script>location='../user/mycart.jsp';</script>


