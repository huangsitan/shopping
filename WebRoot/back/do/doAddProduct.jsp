<%@page import="com.entity.UserInfo"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="com.entity.Product"%>
<%@page import="com.biz.ProductServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
//1
  /* request.setCharacterEncoding("utf-8");
  String na=request.getParameter("pname");
  String price=request.getParameter("price");
  String store=request.getParameter("store");
  String type=request.getParameter("type");
  String info=request.getParameter("info");
  
  Product p = new Product();
  p.setName(na);
  p.setPrice(Double.parseDouble(price));
  p.setStore(Integer.parseInt(store));
  p.setCateid(Integer.parseInt(type));
  p.setInfo(info); */
  Product p = new Product();
  
  UserInfo us=(UserInfo)session.getAttribute("loger");
  p.setUid(us.getId());
  
  List<String> listxx = new ArrayList<String>();
  //1
  FileItemFactory fac = new DiskFileItemFactory();
  //2
  ServletFileUpload upload = new ServletFileUpload(fac);
  //3
  if(upload.isMultipartContent(request))
  {
   
   //4
   List<FileItem> list=upload.parseRequest(request);
   //5
   for(FileItem item:list){
     //6
     if(item.isFormField())
     {
     	 String val = item.getString("utf-8");
     	 String name = item.getFieldName();
     	 if(name.equals("pname"))p.setName(val);
     	 if(name.equals("price"))p.setPrice(Double.parseDouble(val));
     	 if(name.equals("type"))p.setCateid(Integer.parseInt(val));
     	 if(name.equals("store"))p.setStore(Integer.parseInt(val));
     	 if(name.equals("info"))p.setInfo(val);
     	 
     }else
     {
       String path=application.getRealPath("img");
       String fname=new File(item.getName()).getName();
       File savefile=new File(path+"/"+fname);
       item.write(savefile);
       listxx.add("img/"+fname);
     }
   }
   
   //2
 int n=new ProductServiceImpl().addProduct(p,listxx);
//3
 if(n==0)
 {
 %>
  <script>alert('增加失败');</script>
 <%
 }
%>
<script>location='../index.jsp';</script>
<%    
  }else
  {
     out.println("请求不是multipart-formdata");
  }
  
%>
