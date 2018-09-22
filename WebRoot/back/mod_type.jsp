<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="checklogin.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add_type.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <%
      String name=request.getParameter("tname");
       String id=request.getParameter("id");
    %>
  </head>
  
  <body>
    <h1>修改商品类别</h1>
    <form action="back/do/domodtype.jsp" method="post">
      <input type="hidden" name="id" value="<%=id%>"/>
      名称:<input type="text" name="tname" value="<%=name%>"/><br>
      
     <input type="submit" value="修改">
    </form>
  </body>
</html>
