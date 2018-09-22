<%@page import="com.entity.UserInfo"%>
<%@page import="com.entity.Message"%>
<%@page import="com.biz.MessageBizImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
//1
//当前登录人
 UserInfo log=(UserInfo)session.getAttribute("loger");

 String recid=request.getParameter("recid");
 String title=request.getParameter("title");
 String content=request.getParameter("content");
 
 
 Message message = new Message();
 message.setTitle(title);
 message.setContent(content);
 message.setSendid(log.getId());
 message.setReceivid(Integer.parseInt(recid));
//2
  int n=new MessageBizImpl().addMessage(message);

//3
if(n==0)
{
%>
<script>alert('增加失败');</script>
<% 
}
%>
<script>location='../user/listmessage.jsp'</script>