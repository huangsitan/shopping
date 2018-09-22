<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   
  </head>
  
  <body>
  <%=application.getInitParameter("up") %>
  <hr>
   <%
      Context ct = new InitialContext();
      DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/shopping");
      Connection conn=ds.getConnection();
      out.println("连接池可以使用");
    %>
  
   <%
      Integer n=(Integer)pageContext.getAttribute("num1");
      if(n==null) n=0;
      //改
      n++;
      //存
      pageContext.setAttribute("num1", n);
      
      
      /**********************************/
      
        Integer n2=(Integer)request.getAttribute("num2");
       if(n2==null) n2=0;
      //改
      n2++;
      //存
      request.setAttribute("num2", n2);
      
       /**********************************/
      
      Integer n3=(Integer)session.getAttribute("num3");
       if(n3==null) n3=0;
      //改
      n3++;
      //存
      session.setAttribute("num3", n3);
      
        /**********************************/
      
      Integer n4=(Integer)application.getAttribute("num4");
       if(n4==null) n4=0;
      //改
      n4++;
      //存
      application.setAttribute("num4", n4);
    %>
    页面范围内的数字:<%=n%><br>
     请求范围内的数字:<%=n2%><br>
    会话范围内的数字:<%=n3%><br>
  applicaiton范围内的数字:<%=n4%><br>
  </body>
</html>
