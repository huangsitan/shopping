package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CounterDao extends BaseDao {

	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	public int addCount(int num){
		String sql="INSERT INTO counter VALUES(NULL,?,NOW())";
		Object[]arr={num};
		return this.execUpdate(sql, arr);
		
	}
	
	public int selectNum()
	{
		String sql="SELECT num FROM counter WHERE id=(SELECT MAX(id) FROM counter)";
		conn=this.getConn();
		int n=0;
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next())
			{
				n=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			this.closeAll(conn, pst, rs);
		}
		
		return n;
	}
}
