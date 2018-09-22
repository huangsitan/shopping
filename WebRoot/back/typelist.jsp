<%@page import="com.entity.ProdutType"%>
<%@page import="com.biz.PTypeBizImpl"%>
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
    
    <title>My JSP 'typelist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	  #types{width:500px;}
	  #types li{height:40px;border-bottom:1px dotted grey;margin-bottom:5px;}
	  #types li span{float:right; margin:10dp}
	</style>
   <script>
     function delType(op){
        if(confirm('你真的要删除吗'))
        {
           location='back/do/dodeltype.jsp?id='+op;
        }
     }
   </script>
  </head>
  
  <body>
  <div id="show">
    <h1 style="text-align: center;">管理商品类别</h1>
    <a href="back/add_type.jsp">增加商品类别</a>
    <form action="back/do/dodelMany.jsp" method="post">
       <ul id="types">
       
         <li>类别名称    <span>创建人</span></li>
           <%
             List<ProdutType> list=new PTypeBizImpl().getAll();
             for(ProdutType tt:list)
             {
             %>
               <li><%=tt.getName() %>  
                <span>  <%=tt.getCreator() %>
                <a href="back/mod_type.jsp?id=<%=tt.getId()%>&tname=<%=tt.getName()%> ">修改</a> 
                <a href="javascript:delType(<%=tt.getId() %>)">删除</a> </span> </li>
             <% 
             }
            %>
         
       </ul>
      
        
    <input type="submit" value="删除" >
    </form>
    </div>
  </body>
</html>
