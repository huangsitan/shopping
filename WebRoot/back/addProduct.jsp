<%@page import="com.entity.ProdutType"%>
<%@page import="com.biz.PTypeBizImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%
      if(session.getAttribute("loger")==null){
        response.sendRedirect("../login.jsp");
      }
    
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
   <script src="js/jquery-1.12.4.js" type="text/javascript"></script>
   <script>
   $(function(){
      $("#addimg").click(function(){
      
       $("p[name=imgfile]:last").after($("p[name=imgfile]:last").clone(true));
        $("p[name=imgfile] span").click(function(){
          $(this).parents("p").remove();
       }); 
      });
   })
   </script>
  </head>
  
  <body>
    <h1>增加商品</h1>
    <form action="back/product/doadd" method="post" enctype="multipart/form-data">
      名称:<input type="text" name="pname" value=""/><br>
      价格:<input type="text" name="price"  value=""/><br>
   商品类别:<select name="type">
           <% 
             List<ProdutType> list=new PTypeBizImpl().getAll();
             for(ProdutType pt:list)
             {
             %>
               <option value="<%=pt.getId()%>"><%=pt.getName()%></option>
             <% 
             }
            %>
        </select><br>
      库存:<input type="text" name="store"  value=""/><br>
     介绍: <textarea name="info" style="width: 360px;height: 100px;"></textarea><br>
    <p name="imgfile">图片:<input type="file" name="img"/>  <span>X</span></p>  
    
    
     
     <input type="submit" value="增加">
      <input type="button" id="addimg" value="增加上传图片">
    </form>
  </body>
</html>
