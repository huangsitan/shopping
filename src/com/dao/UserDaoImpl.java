package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.UserInfo;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl extends BaseDao implements IUserDao {

	Connection conn=null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	@Override
	public int addUser(UserInfo us) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO userinfo(username,pwd,phone,sex) VALUES(?,?,?,?)";
		Object[]arr={us.getName(),us.getPwd(),us.getPhone(),us.getSex()};
		return this.execUpdate(sql, arr);
	}
	
	public List<UserInfo> getAll()
	{
		List<UserInfo> list = new ArrayList<UserInfo>();
		String sql="SELECT * FROM userinfo";
		
		conn= this.getConn();
		try {
			pst= (PreparedStatement) conn.prepareStatement(sql);
			
			rs=pst.executeQuery();
			while(rs.next())
			{
				UserInfo cc= new UserInfo();
				cc.setId(rs.getInt(1));
				cc.setName(rs.getString(2));
				cc.setPwd(rs.getString(3));
				cc.setPhone(rs.getString(4));
				cc.setSex(rs.getString(5));
				cc.setIsadmin(rs.getInt(6));
				list.add(cc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.closeAll(conn, pst, rs);
		}
		return list;
	}

	@Override
	public UserInfo getUser(String name,String pwd) {
		// TODO Auto-generated method stub
		UserInfo curr=null;
		
		String sql="SELECT * FROM userinfo WHERE (username=? OR  phone=?) AND pwd=?";
		
		conn= this.getConn();
		try {
			pst= (PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, name);
			pst.setString(3, pwd);
			rs=pst.executeQuery();
			if(rs.next())
			{
				curr= new UserInfo();
				curr.setId(rs.getInt(1));
				curr.setName(rs.getString(2));
				curr.setPwd(rs.getString(3));
				curr.setPhone(rs.getString(4));
				curr.setSex(rs.getString(5));
				curr.setIsadmin(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.closeAll(conn, pst, rs);
		}
		
		
		
		return curr;
	}

}
