<%@page import="com.entity.Product"%>
<%@ page import="java.util.*" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testjstl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
    Product p = new Product();
     p.setId(1);
     p.setName("毛巾");
     p.setPrice(20);
     pageContext.setAttribute("pro", p);
     request.setAttribute("num", 10);
     
     
      Product p1 = new Product();
     p1.setId(1);
     p1.setName("三星手机");
     p1.setPrice(3000);
     
     Product p2 = new Product();
     p2.setId(2);
     p2.setName("苹果手机xs");
     p2.setPrice(13000);
     
      Product p3 = new Product();
      p3.setId(3);
     p3.setName("华为手机mate10");
     p3.setPrice(9000);
     
      Product p4 = new Product();
      p4.setId(4);
     p4.setName("小米手机");
     p4.setPrice(1000);
     
      Product p5 = new Product();
      p5.setId(4);
     p5.setName("vivo手机");
     p5.setPrice(1500);
     
     List list = new ArrayList();
     list.add(p1);
     list.add(p2);
     list.add(p3);
     list.add(p4);
     list.add(p5);
     
     pageContext.setAttribute("prolist", list);
      pageContext.setAttribute("now", new Date());
   %>
  <body>
     <c:set var="sname" value="hello6666" scope="session" />
   <%--   <%
        String sname="hello";
        request.setAttribute("sname", sname);
      %> --%>
      
      ${sessionScope.sname}<br>
      <hr>
      <c:remove var="sname" scope="session"/>
      ******
       ${sessionScope.sname}<br>
       
        ${pageScope.pro.name }
        <hr>
    <c:set target="${pageScope.pro}" property="name" value="可乐"/> 
    ${pageScope.pro.name }
    <hr>
    <c:out value="${pageScope.pro}" default="页面作用域中不存在proxx"/> 
    <hr>
    <c:out value="<a href='http://www.baidu.com'>百度</a>" escapeXml="y"/> 
    <hr>
    <c:if test="${requestScope.num ge 10}">
       ssssssssssss******
    </c:if>
    <hr>
    <c:forEach begin="3" end="10" var="num" step="3" >
       <span>${num}</span>
    </c:forEach>
    <hr>
    <table>
    <c:forEach items="${pageScope.prolist}" var="pp" varStatus="sta">
     <tr style="background:${sta.index%2==0?'#DCDCDC':'#ECECEC'}">
        <td>${sta.index}</td>
        <td>${pp.id}</td>
        <td>${pp.name}</td>
        <td>${pp.price}</td>
     </tr>
    </c:forEach>
    </table>
    
    <hr>
    <fmt:formatDate value="${now}" pattern="MM-dd HH:mm"/>
  </body>
</html>
