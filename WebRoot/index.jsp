<%@page import="com.entity.UserInfo"%>
<%@page import="com.util.Online"%>
<%@page import="com.util.PageBean"%>
<%@page import="com.util.Counter"%>
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
	<style type="text/css">
	  #show{
	    width:60%;
	    margin:0 auto;
	  }
	  #show div{float:left;width:250px;margin:10px;border:1px solid grey;padding:10px;}
	  #show div:hover{border:1px solid red;box-shadow:2px 5px 2px grey;}
	  #search{border-radius:10px;height:30px; width: 150px;}
	  #xxform{margin:0 auto;width: 100%;text-align: center;}
	  a{text-decoration:none}
	  #line{border: 1px solid grey; width: 180px; 
	  height: 600px;overflow:auto; 
	  position: relative;
	  top: -820px;
	  left:50px;
	  }
	</style>
  </head>
  <script src="js/jquery-1.12.4.js"></script>
  <script>
     $(function(){
       $("#search").focus(function(){
           var vv=$("#search").val();
           if(vv=='电风扇') {
               $("#search").val("");
           }
       });
       
        $("#search").blur(function(){
           var vv=$("#search").val();
           if(vv=='') $("#search").val("电风扇");
       });
     })
  </script>
  <%-- <%!
    int n=0;
  
   %> --%>
  <% 
  
  //取
      Integer n=(Integer)application.getAttribute("num");
      if(n==null)n=0;
   //改   
     n++;
   //存  
       application.setAttribute("num", n);
       
    
   %>
  <body>
  <iframe src="top.jsp" style="width: 100%;height: 80px;" frameborder="0"></iframe>
  <div id="xxform">
    <form action="index.jsp" method="post">
       <input id="search" type="text" name="pname" placeholder="电风扇" value="电风扇"> <input type="submit" value="搜索">
    </form>
   </div>
   
  
   
   
  <div id="show">
   
  
     <%
       //搜索用户需要的商品  
     //1
 	request.setCharacterEncoding("utf-8");
 	String key=request.getParameter("pname");
 	String pagex=request.getParameter("page");
 	if(pagex==null) pagex="1";
 	
 	//2
 	PageBean bean=new ProductServiceImpl().queryByKey_page(key, Integer.parseInt(pagex));
 
    
       for(int i=0;i<bean.getList().size();i++)
       {
        Product p=(Product)bean.getList().get(i);
       %>
       <div>
         <a href="productdetail.jsp?id=<%=p.getId()%>"><img src=<%=p.getImg()==null?"images/fre_b2.jpg":p.getImg() %>   style="height:180px"/></a>
         <p> <a href="productdetail.jsp?id=<%=p.getId()%>">[<%=p.getCateName()%>]<%=p.getName() %></a></p>
         <p><a href="productdetail.jsp?id=<%=p.getId()%>"><%=p.getPrice() %>[<%=p.getStore() %>]</a></p>
      </div>
       
       <% 
       }
      %>
 </div>
 <p style="clear: both;text-align: center;  ">  
 <a href="index.jsp?page=1&pname=<%=key%>">首页 </a>   
 <a href="index.jsp?page=<%=bean.getCurrpage()-1 %>&pname=<%=key%>">&lt; </a> 
 <%
   for(int i=1;i<=bean.getTotalPage();i++)
   {
   %>
     <span style="border:<%=i==bean.getCurrpage()?"1px solid grey":"none" %>"><a href="index.jsp?page=<%=i%>&pname=<%=key%>"><%=i%> </a></span>  
   <% 
   }
  %>
    
 <a href="index.jsp?page=<%=bean.getCurrpage()+1 %>&pname=<%=key%>">&gt; </a> 
 <a href="index.jsp?page=<%=bean.getTotalPage() %>&pname=<%=key%>">尾页 </a></p>
 
 <h1 >网站已经被访问：<%=n%></h1>
 <!-- 在线人数统计 -->
   <div id="line">
     <p>共有<%=Online.count%>人在线</p>
      <ul>
        <%
           for(UserInfo cc:Online.list)
           {
           %>
            <li><%=cc.getName()%></li>
           <% 
           }
         %>
       
      </ul>
   </div>
  </body>
</html>
