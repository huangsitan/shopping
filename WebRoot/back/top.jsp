<%@page import="com.entity.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
     #loginfo{
       position: relative;
       top:80px;
       left:10px;
     }
      #loginfo span:last-child{float:right;margin-right:100px}
   </style>
   
   <script>
     function exitconf()
     {
        if(confirm('你确定要退出吗?'))
        {
           location='back/do/doexit.jsp';
        }
     }
   </script>
   
  </head>
  
  <body>
    <h1>欢迎你来到后台</h1>
    <p id="loginfo">
    <span>当前登陆人:<%=((UserInfo)session.getAttribute("loger")).getName()%></span>
    <span><a href="javascript:exitconf()">退出登陆</a></span>
    </p>
  </body>
</html>
