<%@page import="com.biz.PTypeBizImpl"%>
<%@page import="com.entity.ProdutType"%>
<%@page import="com.entity.Product"%>
<%@page import="com.biz.ProductServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addProduct.jsp' starting page</title>
    
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
    <h1>增加商品</h1>
    <form action="back/product/domod" method="post">
     <input type="hidden" name="id" value="${modp.id}"/>
      名称:<input type="text" name="pname" value="${modp.name}"/><br>
      价格:<input type="text" name="price" value="${modp.price}"/><br>
      库存:<input type="text" name="store" value="${modp.store}"/><br>
  商品类别:<select name="type">
           <% 
             List<ProdutType> list=new PTypeBizImpl().getAll();
             pageContext.setAttribute("list", list);
             %>
           <%--   %>
             for(ProdutType pt:list)
             {
             %>
               <option value="<%=pt.getId()%>"  <%=pt.getId()==p.getCateid()?"selected":""%> >  <%=pt.getName()%></option>
             <% 
             }
            %> --%>
            <c:forEach items="${list}" var="pt">
                <option value="${pt.id}"  ${pt.id==modp.cateid?"selected":""} >  ${pt.name}</option>
            </c:forEach>
        </select>
        
        <br>
     介绍: <textarea name="info" style="width: 360px;height: 100px;" >${modp.info}</textarea><br>
     <input type="submit" value="修改">
    </form>
  </body>
</html>
