<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <script src="js/jquery-1.12.4.js"></script>
   <style type="text/css">
     input+span{color:red;}
   </style>
   
   <script>
     function checkname(){
        var nn=$("#un").val();
        $("#un+span").html("");
        if(nn==''){
          $("#un+span").html("用户名不能为空");
          return false;
        }
        
        return true;
      
     }
     
     
     function checkpwd(){
        var pwd=$("#pwd").val();
        $("#pwd+span").html("");
        if(pwd==''){
          $("#pwd+span").html("密码不能为空");
           return false;
        }else if(pwd.length<6)
        {  
            $("#pwd+span").html("密码不能小于6位");
             return false;
        }
        return true;
     }
     
     
     function checkphone(){
        var ph=$("#phone").val();
        var phss=/^1[3,5,7,8][0-9]{9}$/;
        $("#phone+span").html("");
        if(ph==''){
          $("#phone+span").html("电话不能为空");
           return false;
        }else if(!phss.test(ph))
        {  
            $("#phone+span").html("不是正确的电话");
             return false;
        }
        return true;
     }
     
     $(function(){
       $("#un").blur(function(){
          checkname();
          
       });
       
        $("#pwd").blur(function(){
          checkpwd();
       });
       
          $("#phone").blur(function(){
          checkphone();
       });
       
       //表单提交
       $("#regform").submit(function(){
        
           //if(!checkname()) return false;
           //if(!checkpwd()) return false;
           
           return checkname()&&checkpwd();
       
       });
     })
   </script>
   
  </head>
  
  <body>
   <h1>注册</h1>
   <form action="doreg.jsp" method="post" id="regform">
     用户名:<input type="text" name="uname" id="un"/><span></span><br>
      密码:<input type="password" name="pwd" id="pwd"/><span></span><br>
      电话:<input type="text" name="phone" id="phone"/><span></span><br>
   性别:<input type="radio" name="sex" value="男"/>男 <input type="radio" name="sex" value="女"/>女<br>
   <input type="submit" value="注册">
   </form>
  </body>
</html>
