<%@page import="com.entity.Product"%>
<%@page import="com.biz.ProductServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>



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
  <script type="text/javascript">
     function delconf(idx){
        var flag=confirm("你真的要删除吗？");
        if(flag){
            location='back/product/dodel?id='+idx;
        }
     }
  </script>
  
  
   <style>
      tr{height:50px}
      table{border:1px solid blue;width:900px;}
      #show{width:800px;margin:0 auto;}
       
       tr:nth-of-type(even){background:#C2DFFF;}
       tr:nth-of-type(odd){background:#A0CFEC;}
       tr:first-of-type{background:#307D7E;color:white;}
       </style>
  
  </head>
  <script src="js/jquery-1.12.4.js"></script>
  <script>
 
    function checkall()
    {
       var all=document.getElementById("all");
       var flag=all.checked;
       var arr=document.getElementsByName("proid");
       for( var i in arr)
       {
         arr[i].checked=flag;
       }
       
       
    }
  </script>
  
  <%
    int n=10;
     List<Product> list=new ProductServiceImpl().showProducts();
     
   %>
  <body>
  <div id="show">
    <h1 style="text-align: center;">管理商品</h1>
    <a href="back/addProduct.jsp">增加商品</a>
    <form action="back/do/dodelMany.jsp" method="post">
    <table>
      <tr>
        
         <td><input type="checkbox" id="all" onclick="checkall()">全选</td>
         <td>图片</td>
         <td>名称</td>
         <td>价格</td>
         <td>库存</td>
         <td>类别</td>
         <td>操作</td>
      </tr>
      
        <%
         for(Product p:list)
         {
         %>
          <tr>
       
         <td><input type="checkbox" name="proid" value="<%=p.getId()%>"><%=p.getId() %></td>
         <td><img src="<%=p.getImg()==null?"images/fre_b2.jpg":p.getImg()%>" style="width:200px"></td>
         <td><%=p.getName() %></td>
         <td><%=p.getPrice() %></td>
         <td><%=p.getStore()%></td>
         <td><%=p.getCateName()%></td>
         <td><a href="javascript:delconf(<%=p.getId() %>)">删除</a>  | <a href="back/product/getbyid?id=<%=p.getId()%>">修改</a></td>
      </tr>
         
         <% 
         }
       %>
    </table>
    <input type="submit" value="删除" >
    </form>
    </div>
  </body>
</html>
