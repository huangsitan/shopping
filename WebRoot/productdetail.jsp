<%@page import="com.entity.ProductImg"%>
<%@page import="com.dao.ProductImgDaoImpl"%>
<%@page import="com.dao.ProductImgDao"%>
<%@page import="com.entity.Product"%>
<%@page import="com.biz.ProductServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>MyHtml.html</title>
      <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
       #show{ width:660px;height:400px;margin:0 auto;position:relative;border:1px solid blue;}
       #show img{float:left;margin:20px}
       #info{position: relative; top:30px;}
      #addcart{position:absolute; bottom:10px;left:260px;}
      #addcart{float: right; width:300px;padding-left: 100px;}
      #addcart input{vertical-align: middle; height: 40px;}
      #showimg{position: relative;left: 600px;}
      #showimg li{float:left;border:1px solid grey;list-style-type:none;margin:1px;opacity:0.5}
      #showimg li:hover{opacity:1}
    </style>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script>
     $(function(){
       $("#showimg li").click(function(){
          var imgxx=$(this).find("img").attr("src");
          $("#info").prev().attr("src",imgxx);
       });
     });
    </script>
  </head>
  <%
     String id=request.getParameter("id");
     Product p=new ProductServiceImpl().getById(Integer.parseInt(id));
      List<ProductImg> list=new ProductImgDaoImpl().getImg(p.getId());
     /**********************记录用户浏览过的商品******************************/
  /*   //取
   List<Product> list=(List<Product>)session.getAttribute("looklist");
    if(list==null) list = new LinkedList<Product>();
    //改
     if(list.contains(p))
     {
       list.remove(p);
     }
      list.add(0, p);
     //存
     session.setAttribute("looklist", list); */
     String imgx =list.size()==0?"images/hot2.jpg":list.get(0).getPath();
     Cookie cc=new Cookie("lookss_"+p.getId(),p.toString()+"-"+imgx);
     cc.setMaxAge(60*60*24*7);
     response.addCookie(cc);
     
     
     
     /********************************************************/
   %>
  <body>
   <iframe src="top.jsp" style="width: 100%;height: 80px;" frameborder="0"></iframe>
 
  <div id="show">
  <form action="do/doaddcart.jsp" method="post">
  <input type="hidden" name="pid" value="<%=id%>">
  <input type="hidden" name="price" value="<%=p.getPrice() %>">
    <img  src="<%=list.size()==0?"images/tm_r.jpg":list.get(0).getPath()%>" style="height: 300px;"/>
    <div id="info">
    <h2><%=p.getName() %></h2>
    <p><%=p.getInfo() %></p>
    <p><%=p.getPrice() %>￥</p>
    <p>库存:<%=p.getStore() %><p>
    <p><input type="text" name="note"/><p>
    </div>
     
     <p id="addcart"><input type="number" name="num"  min="1" value="1" style="width: 60px;height: 32px;"/><input  type="image" src="images/j_car.png"></p>
  </form>
   </div> 
   <div>
     <ul id="showimg">
       <%
         
          for(ProductImg img:list)
          {
          %>
            <li><img src="<%=img.getPath()%>" style="width: 80px;"/></li>
          <% 
          }
        %>
      
     </ul>
   </div>
   <jsp:include page="showcart.jsp"/>
  </body>
</html>
