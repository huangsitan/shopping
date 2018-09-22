<%@page import="com.entity.Product"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="back/checklogin.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showcart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
      #lookul{border:1px solid blue;position:fixed;bottom: 10px;width:60%;height:230px;
       overflow-y:scroll;
      }
      #lookul li{display:inline-block;list-style-type:none;border:1px solid orange;margin:10px;}
    </style>
  </head>
  
  <body>
   <div id="lookul">
     <table>
       <%-- <%
         List<Product> listx=( List<Product>)session.getAttribute("looklist");
         if(listx==null) return;
         for(Product px:listx)
         {
        %>
         <li>
           <img alt="" src="images/hot2.jpg"/>
           <p><%=px.getName()%> [<%=px.getPrice()%> ]</p> 
        </li>
        <%  
         }
        %> --%>
        <tr>
        <%
           Cookie[] cks=request.getCookies();
           if(cks!=null)
           {
               for(Cookie ck:cks)
               {
                 if(ck.getName().startsWith("lookss_")) 
                 {
                   String val = ck.getValue();
                   String[] arr=val.split("-");
                 %>
                 <td>
           		<img alt="" src="<%=arr[3]%>" style="width: 100px"/>
           			<p><%=arr[1]%> [<%=arr[2]%> ]</p> 
        		</td>
                 <% 
                 }
               }
           }
         %>
        </tr>
     </table>
   </div>
  </body>
</html>
