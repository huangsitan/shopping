<%@page import="com.biz.ShopCartBizImpl"%>
<%@page import="com.entity.ShopCart"%>
<%@page import="com.entity.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
//1
 
  String pid=request.getParameter("pid");
  String price=request.getParameter("price");
  String note=request.getParameter("note");
  String num=request.getParameter("num");
  
  UserInfo  us=(UserInfo)session.getAttribute("loger");
  if(us==null)
  {
     response.sendRedirect("../login.jsp");
  }
  else
  {
  ShopCart cart=new ShopCart();
  cart.setPid(Integer.parseInt(pid));
  cart.setUid(us.getId());
  cart.setNum(Integer.parseInt(num));
  cart.setPrice(Double.parseDouble(price));
  cart.setNote(note);
  
  //2
  int n=new ShopCartBizImpl().addCart(cart);
  
  %>
  <script>alert('加入购物车成功');history.back();</script>
 <%
  
   }
%>