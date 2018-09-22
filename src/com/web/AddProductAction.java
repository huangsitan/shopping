package com.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.biz.ProductServiceImpl;
import com.entity.Product;

@WebServlet("/back/product/doadd")
public class AddProductAction extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		ServletContext  application=this.getServletContext();
		//ServletContext  application=request.getSession().getServletContext();
		 Product p = new Product();
		 List<String> listimg = new ArrayList<String>();
		 //1
		  FileItemFactory fac = new DiskFileItemFactory();
		  //2
		  ServletFileUpload upload = new ServletFileUpload(fac);
		  //3
		  if(upload.isMultipartContent(request))
		  {
			  
			  try {
				List<FileItem> list=upload.parseRequest(request);
				for(FileItem item:list)
				{
					if(item.isFormField())
					{
						 String val = item.getString("utf-8");
				     	 String name = item.getFieldName();
				     	 if(name.equals("pname"))p.setName(val);
				     	 if(name.equals("price"))p.setPrice(Double.parseDouble(val));
				     	 if(name.equals("type"))p.setCateid(Integer.parseInt(val));
				     	 if(name.equals("store"))p.setStore(Integer.parseInt(val));
				     	 if(name.equals("info"))p.setInfo(val);
					}
					else
					{
						String path=application.getRealPath("img");
						String name=new File(item.getName()).getName();
						File savefile = new File(path+"/"+name);
						try {
							item.write(savefile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						listimg.add("img/"+name);
					}
				}
				
				int n=new ProductServiceImpl().addProduct(p, listimg);
				if(n==0)
				{
				   out.print("<script>alert('增加失败了');</script>");
				}
				out.print("<script>location='../index.jsp';</script>");
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  
		  }else
		  {
			  out.print("请求类型不是multipart/form-data");
		  }
		  
		  out.flush();
		  out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
	}

}
