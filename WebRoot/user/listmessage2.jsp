<%@page import="com.entity.Message"%>
<%@page import="com.entity.UserInfo"%>
<%@page import="com.biz.MessageBizImpl"%>
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
    
    <title>My JSP 'listmessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <style type="text/css">
      #tab{
         width: 260px;
         height: 100px;
         margin: 0 auto;
      }
      #tab li{float:left;margin:2px; background:#ACD6FF;padding:8px;box-shadow:2px 4px 2px grey}
      #tab li:last-child{background:#FF9D6F;}
      #mess{
         width: 600px;
         border:1px solid grey;
         box-shadow:2px 4px 2px grey;
         background:#ECF5FF;
          margin: 0 auto;
      }
   </style>
  </head>
  
  <body>
    <h1 style="text-align: center;">我的消息</h1>
    <ul id="tab">
        <li><a href="user/listmessage.jsp">收到的消息</a></li>
       <li><a href="user/listmessage2.jsp">发送的消息</a></li>
       </ul>
    <table id="mess">
      <tr>
              <td>编号</td>
              <td>标题</td>
              <td>发送人</td>
              <td>发送时间</td>
          </tr>
       <%
         UserInfo log=(UserInfo)session.getAttribute("loger");
         List<Message> list=new MessageBizImpl().getAll_send(log.getId());
         for(Message mess:list)
         {
         %>
          <tr>
              <td><%=mess.getId() %></td>
              <td><%=mess.getTitle() %></td>
              <td><%=mess.getSendid() %></td>
              <td><%=mess.getSendtime()%></td>
          </tr>
         <% 
         }
        %>
    </table>
  </body>
</html>
