
<%@page import="com.entity.Address"%>
<%@page import="com.entity.UserInfo"%>
<%@page import="com.biz.AddressBizimpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <style>
      li{height:80px}
      ul{border:1px solid grey;width:600px; box-shadow: 2px 2px 2px grey;padding-left:0px}
      #show{width:800px;margin:0 auto;}
       
       li{border-bottom:1px dotted grey;list-style-type:none;padding:5px 10px; }
       li:nth-of-type(even){background:#C2DFFF;}
      
       tr:first-of-type{background:#307D7E;color:white;}
       .op{float:right}
       </style>
       
       <script>
         function delconf( op ){
           var flag=confirm('你确定要删除吗？');
           if(flag)
           {
              location='user/addressAction?id='+op+'&act=del';
           }
         }
       
       </script>
  </head>
  
  <body>
  <div id="show">
   
    <p><a href="user/addAddress.jsp">新增地址</a></p>
    <ul>
       <c:forEach items="${list}" var="address">
         <li><p><span>${address.contactman}</span> <span>${address.contactphone}</span></p> 
          ${address.province} ${address.city} ${address.detail}   <span class="op"><a href='javascript:delconf(${address.id})'>删除</a> <a href='user/addressAction?id=${address.id}&act=getbyid'>修改</a></span></li>
       
       </c:forEach>
       
       
    </ul>
   </div>
   <c:remove var="list" scope="session"/>
  </body>
</html>
