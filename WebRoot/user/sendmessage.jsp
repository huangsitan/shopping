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
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
  </head>
  
  <body>
  <h1>发送消息</h1>
   <form action="do/dosendmessage.jsp" method="post">
  发送给:<select name="recid">
        <%
           List<UserInfo> list=new UserBizImpl().getAll();
           for(UserInfo us:list)
           {
           %>
            <option value="<%=us.getId()%>"><%=us.getName() %></option>
           <%
           }
         %>
        
      </select>
     标题:<input type="text" name="title"><br>
     内容:<textarea class="ckeditor"  name="content" style="width: 300px;height: 80px;"></textarea><br>
     <input type="submit" value="发送">
     <input type="reset" value="重置">
   </form>
  </body>
</html>
