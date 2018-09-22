<%@page import="com.entity.ShopCart"%>
<%@page import="com.entity.UserInfo"%>
<%@page import="com.biz.ShopCartBizImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'mycart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
    #carttab{
      border:1px solid grey;
      width:900px;
      margin:0 auto;
      padding:5px;
    }
    tr{
      height:40px;
      
    }
    tr:first-child{
      background:#008080;
      color:white;
      text-align:center;
    }
   tr:not(:last-child) td{
       border-bottom:1px dotted black;
    }
    td{text-align:center}
    #showinfo,#op{
      width:900px;
      height:60px;
      margin:0 auto;
      padding:5px;
      background:#DFFFDF;
    }
    #showinfo span{float:right;}
    #op a{
    display:inline-block;
    width:120px; 
    heigth:80px;
    border:1px solid blue;
    text-align: center;
    background: #97CBFF;
    float:right;
    margin:10px;
    }
    
  </style>
  
  <script src="js/jquery-1.12.4.js"></script>
  <script>
 
    function checkall()
    {
       var all=document.getElementById("all");
       var flag=all.checked;
       var arr=document.getElementsByName("cartid");
       for( var i in arr)
       {
         arr[i].checked=flag;
       }
       sums();
    }
    
    
    function sums()
    {
      var arr=document.getElementsByName("cartid");
      var sum=0;
       for( var i=0;i<arr.length;i++)
       {
          if(arr[i].checked){
              var cc=$(arr[i]); //把javascript对象转成jquery对象
            //累加价格
            var price=cc.parents("tr").find("td[name=data4]").html();
            var num=cc.parents("tr").find("td[name=data5]").find("input").val();
            sum=sum+price*num;
          }
          
       }
      
       $("#totalprice").html("总价："+sum+"￥");
    }
    
    
    $(function(){
     $("input[name=cartid]").click(function(){
        sums();
     });
     $("td[name=data5] input").change(function(){
        sums();
     });
    });
    
    function confdel(id){
       
       if(confirm('你真的要删除吗'))
       {
         location='do/dodelcart.jsp?id='+id;
       }
    }
    
    function confdelmany()
    {
       if(confirm('你真的要删除吗'))
       {
         $("#cartform").submit();
       }
    }
    
  </script>
  </head>
   <iframe src="top.jsp" style="width: 100%;height: 80px;" frameborder="0"></iframe>
 
  
     <h1 style="text-align: center;">我的购物车</h1>
  <body>
  <form action="do/dodelcarts.jsp" method="post" id="cartform">
   <table id="carttab">
     <tr>
       <td><input type="checkbox" id="all" onclick="checkall()">全选</td>
       <td>图片</td>
       <td>商品名</td>
       <td>价格</td>
       <td>个数</td>
       <td>备注</td>
       <td>操作</td>
     </tr>
     <%
        UserInfo us=(UserInfo)session.getAttribute("loger");
          List<ShopCart> list=new ShopCartBizImpl().getUserCarts(us.getId());
          for(ShopCart cc:list)
          {
         
      %>
      <tr name="datacart">
       <td name="data1"><input type="checkbox" name="cartid" value="<%=cc.getId()%>" ><%=cc.getPid() %></td>
       <td name="data2"><img  src="images/fre_b2.jpg" style="width: 100px"/></td>
       <td name="data3"><%=cc.getPname()%></td>
       <td name="data4"><%=cc.getPrice()%></td>
       <td name="data5"><input type="text"  value="<%=cc.getNum() %>" style="width: 50px"/></td>
       <td name="data6"><%=cc.getNote()%></td>
       <td name="data6"><a href="javascript:confdel(<%=cc.getId()%>)">删除</a></td>
     </tr>
      
      <% 
          }   
        
      %>
     
   </table>
   </form>
   <p id="showinfo"><span id="totalprice">总价：0￥ </span></p>
   <p id="op"><a href="javascript:confdelmany()">删除</a>   <a  href="">结算</a><p>
   
   <%-- <jsp:include page="../showcart.jsp"/> --%>
   <iframe src="showcart.jsp" style="width: 100%;height: 250px;" frameborder="0"></iframe>
  </body>
</html>
