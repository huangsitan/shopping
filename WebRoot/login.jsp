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
	 <script src="js/jquery-1.12.4.js"></script>
   <script>
     function checkform()
     {
        var na=$("#un").val();
        var pwd = $("#pwd").val();
        if(na=='')
        {
           alert("用户名不能为空");
           return false;
        }
         if(pwd=='')
        {
           alert("密码不能为空");
           return false;
        }
        
        return true;
     }
     
     
     $(function(){
      /* $("#but").click(function(){
          return checkform();
       });*/
       $("#form1").submit(function(){
          return checkform();
       });
     })
   </script>
  </head>
  <%
    //取cookie
    String name="";
    Cookie[] cks=request.getCookies();
    if(cks!=null)
    {
       for(Cookie ck:cks)
       {
         
          if(ck.getName().equals("logname"))
          {
             name=ck.getValue();
          }
       }
    }
  
   %>
  <body>
    <h1>登录</h1>
   <form action="dolog" method="post" id="form1">
     登录名:<input type="text" name="uname"  id="un" value="<%=name%>"/><br>
      密码:<input type="password" name="pwd" id="pwd"/><br>
   <input type="submit" value="登录" id="but"/>
   </form>
  </body>
</html>
