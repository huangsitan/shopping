package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class BaseDao {

	public static final String DRIVER="com.mysql.jdbc.Driver";
	public static final String URL="jdbc:mysql://localhost:3306/taobao";
	public static final String USERNAME="shoper";
	public static final String PWD="1234";
	public static  DataSource ds=null;
	
	static{
		
		 
		try {
			Context ct = new InitialContext();
		   ds=(DataSource)ct.lookup("java:comp/env/jdbc/shopping");  
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}
	/**
	 * 获得数据库连接
	 * 入口：
	 * 出口：连接对象
	 * */
	public Connection getConn()
	{
		Connection conn=null;
		try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public Connection getConn2()
	{
		Connection conn=null;
		try {
			  
		    conn=ds.getConnection();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭资源
	 * 入口：Connection ,Statement ,ReulstSet 
	 * 出口：无
	 * */
	public void closeAll(Connection conn,Statement st,ResultSet rs){
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 执行增，删，改
	 * 入口：sql(insert into userinfo values(?,?,?))  Object[] arr
	 * 出口：int
	 * */
	public int execUpdate(String sql,Object[] arr)
	{
		int x=0;
		Connection conn =this.getConn2();
		PreparedStatement pst =null;
		try {
			 pst = conn.prepareStatement(sql);
			if(arr!=null)
			{
				int n=1;
				for(Object param:arr)
				{
					pst.setObject(n, param);
					n++;
				}
			}
			x=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			this.closeAll(conn, pst, null);
		}
		return x;
	}
}
