<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	   a{text-decoration:none;}
       p a{
       width:90px;
       height:28px;
       display:inline-block;
       font-weight:900;
       font-size:12px;
       background:#FF8F59;
       border:1px solid #708090;
       color:white;
       text-align:center;
       padding-top:8px;
       float:right;
       }
       
       p a:hover{background:#FFBD9D;box-shadow: 2px 5px 3px grey;font-size:16px;}
    </style>
  </head>
  
  <body>
   <p> <a href="index.jsp" target="_parent">首页</a>
    <a href="user/mycart.jsp" target="_parent">我的购物车</a> 
    <a href="user/addressAction" target="_parent">我的收货地址</a>   
    <a href="user/mycart.jsp" target="_parent">我的订单</a>
     <a href="user/listmessage.jsp" target="_parent">我的消息</a>
     <c:if test="${ empty loger}">
     <a href="login.jsp" target="_parent">登录</a>
     </c:if>
    <c:if test="${not empty loger}">
     <a href="doexit" target="_parent">退出登录</a>
    </c:if>
    </p>
  </body>
</html>
