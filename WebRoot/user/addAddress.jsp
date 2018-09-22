<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addAddress.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <style>
    #addemp{width:600px;border:1px dotted blue;padding:10px 0px;background:#DCDCDC;margin:0 auto;}
    #addemp table{width:100%}
    tr{height:40px;}
    tr:nth-of-type(even){background:#E0FFFF;}
    tr td:nth-of-type(1){text-align:right;}
  </style>
  <script src="js/jquery-1.12.4.js"></script>
  <script src="js/area.js"></script>
  <script>
     $(function(){
       for(var ss in arr)
       {
          $("#prov").append("<option value="+ss+">"+ss+"</option>");
       }
       //选省份，城市下拉框中加城市
       $("#prov").change(function(){
          var pp=$("#prov").val();
          $("#cityx option:gt(0)").remove();
          for(var cc in arr[pp])
          {
              $("#cityx").append("<option value="+arr[pp][cc]+">"+arr[pp][cc]+"</option>");
          }
       });
     })
  </script>
 </head>
  
  <body>
    <h1  style="text-align: center;">新增地址</h1>
    <div id="addemp">
    <form action="user/addressAction" method="post" id="addform" >
    <input type="hidden" name="act" value="add">
       <table>
         <tr>
             <td>联系人</td>
             <td><input type="text" name="contactman"><span></span></td>
         </tr>
         
         <tr>
             <td>联系电话</td>
             <td><input type="text" name="contactphone"><span></span></td>
         </tr>
         
           <tr>
             <td>国家</td>
             <td><input type="text" name="country"></td>
         </tr>
         
         <tr>
             <td>省份</td>
             <td>
               <select name="province" id="prov">
                 <option>-请选择-</option>
               </select>
             </td>
         </tr>
         
          <tr>
             <td>城市</td>
             <td>
               <select name="city" id="cityx">
                 <option>-请选择-</option>
               </select>
             </td>
         </tr>
         
         <tr>
             <td>详细住址</td>
             <td><input type="text" name="detail" ></td>
         </tr>
         <tr>
             <td>邮编</td>
             <td><input type="text" name="postcode" ></td>
         </tr>
          <tr>
             <td> </td>
             <td><input type="submit" value="增加" ></td>
         </tr>
         
       </table>
     </form>
    </div>
  </body>
</html>
