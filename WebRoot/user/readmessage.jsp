<%@page import="com.biz.IMessageBiz"%>
<%@page import="com.entity.Message"%>
<%@page import="com.biz.MessageBizImpl"%>
<%@page import="com.entity.UserInfo"%>
<%@page import="com.biz.UserBizImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../back/checklogin.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sendmessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%
  String id=request.getParameter("id");
  IMessageBiz biz=new MessageBizImpl();
  Message mm=biz.getById(Integer.parseInt(id));
  mm.setIsread(1);
  biz.modMessage(mm);
  
 %>
  </head>
  
  <body>
  <h1>发送消息</h1>
  
  发送人:<%=mm.getSendid() %>  发送时间<%=mm.getSendtime() %><br>
     标题:<%=mm.getTitle() %>  <br>
     内容:<%=mm.getContent() %><br>
     
  </body>
</html>
