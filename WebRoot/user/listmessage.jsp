<%@page import="com.util.PageBean"%>
<%@page import="com.entity.Message"%>
<%@page import="com.entity.UserInfo"%>
<%@page import="com.biz.MessageBizImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../back/checklogin.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
      #tab li:first-child{background:#FF9D6F;}
       #mess{
         width: 600px;
         border:1px solid grey;
         box-shadow:2px 4px 2px grey;
         background:#ECF5FF;
          margin: 0 auto;
      }
      
      #mess tr{
        height:50px;
      }
      tr:nth-of-type(even){
         background:#DEDEBE;
      }
   </style>
  </head>
  
  <body>
    <h1 style="text-align: center;">我的消息</h1>
    <ul id="tab">
       <li><a href="user/listmessage.jsp">收到的消息</a></li>
       <li><a href="user/listmessage2.jsp">发送的消息</a></li>
    </ul>
    <p><a href='user/sendmessage.jsp'>发送消息</a></p>
    <table id="mess">
      <tr>
              <td>状态</td>
              <td>编号</td>
              <td>标题</td>
              <td>发送人</td>
              <td>发送时间</td>
          </tr>
       <%
         UserInfo log=(UserInfo)session.getAttribute("loger");
         //页码
         String pagex =request.getParameter("page");
         if(pagex==null)pagex="1";
         
         PageBean bean=new MessageBizImpl().queryBypage(log.getId(), Integer.parseInt(pagex));
         
         pageContext.setAttribute("pbean", bean);
         %>
        <%--  for(Message mess:list)
         {
         %>
          <tr>
               <td><img src=<%=mess.getIsread()==1?"images/open3.png":"images/close3.png"%> style="width: 40px;"/></td>
              <td><%=mess.getId() %></td>
              <td><a href="user/readmessage.jsp?id=<%=mess.getId()%>"><%=mess.getTitle() %></a></td>
              <td><%=mess.getSendid() %></td>
              <td><%=mess.getSendtime()%></td>
          </tr>
         <% 
         } --%>
        <c:forEach items="${pbean.list}" var="mess">
             <tr>
               <td><img src=${mess.isread==1?"images/open3.png":"images/close3.png"} style="width: 40px;"/></td>
              <td>${mess.id}</td>
              <td><a href="user/readmessage.jsp?id=${mess.id}">${mess.title}</a></td>
              <td>${mess.sendid}</td>
              <td>${mess.sendtime}</td>
          </tr>
           
        </c:forEach>
       
    </table>
   <p style="text-align: center;  "> 
     
      <a href="user/listmessage.jsp?page=1">首页</a>
      <a href="user/listmessage.jsp?page=${pbean.currpage-1}">&lt;</a>
     
      <c:forEach begin="1" end="${pbean.totalPage}" var="nn">
         <span style="border:${nn eq pbean.currpage?'1px solid grey':'none'}"><a href="user/listmessage.jsp?page=${nn}">${nn}</a></span>
      </c:forEach>
      
      <a href="user/listmessage.jsp?page=${pbean.currpage+1}">&gt;</a>
      <a href="user/listmessage.jsp?page=${pbean.totalPage}">尾页</a>
    </p>
  </body>
</html>
