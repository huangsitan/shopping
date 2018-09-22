<%@page import="com.entity.Product"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testel.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <%
    /*int n=10;
    pageContext.setAttribute("num", n);
    request.setAttribute("num", 500);
    session.setAttribute("num", 5000);
     application.setAttribute("numx", 2000);*/
      pageContext.setAttribute("num", 10);
     request.setAttribute("num", 500);
     session.setAttribute("num", 5000);
     application.setAttribute("num", 2000);
     Product p = new Product();
     p.setId(1);
     p.setName("毛巾");
     p.setPrice(20);
     
     Product p2 = new Product();
     p2.setId(2);
     p2.setName("水杯");
     p2.setPrice(20);
     //request.setAttribute("pro", p);
     
     String[] arr={"悟空","八戒","唐僧","白骨精"};
     List<String> emps =  Arrays.asList(arr);
     
    /* HashMap<String,Product> map = new HashMap<String,Product>();
     map.put(p.getName(), p);
     map.put(p.getName(), p2);*/
     HashMap<String,String> map = new HashMap<String,String>();
     map.put("apple", "苹果");
     map.put("orange", "橘子");
     
      
     request.setAttribute("mapx", map);
     
     session.setAttribute("emps", emps);
   %>
  </head>
  
  <body>
  <%=request.getAttribute("num") %><br>
   ${applicationScope.num}
   <hr>
   <%--  <%=((Product)request.getAttribute("pro")).getName() %><br>
   ${pro.name}
    ${pro["price"]} --%>
    <hr>
    ${emps[1]}<br>
    <hr>****
    ${mapx.apple}  ${mapx["orange"]}
    <hr>
    ${"aa" eq "aa"}<br>
    ${56 gt 9}<br>
    ${100 eq 100 }<br>
    ${56 le 45 }<br>
    <hr>
    ${ not empty emps}
    
    
  </body>
</html>
