package com.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownAction extends HttpServlet {

	String pathxx=null;
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

		doPost(request, response);
	}
	
	
	@Override  
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		pathxx=config.getInitParameter("downpath");
		
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

	   //1
	  String fname=request.getParameter("filename");
		
	  
	  ServletContext application= request.getSession().getServletContext();//this.getServletContext();
	
	  String mtype=application.getMimeType(fname);
	  System.out.println("mimetype:"+mtype);
	  response.setContentType(mtype);
	  
	  response.setHeader("Content-Disposition", "attchment;filename="+fname);
	  
	  
	  String path = application.getRealPath(pathxx);
	  InputStream is = new FileInputStream(path+"/"+fname);
	  OutputStream os = response.getOutputStream();
	  
	  byte[] arr= new byte[10];
	  int len=0;
	  while((len=is.read(arr))!=-1)
	  {
		  os.write(arr,0,len);
	  }
	  
	  is.close();
	  os.close();
	}

}
