package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Message;

public class MesageDaoImpl extends BaseDao implements IMessageDao {
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public int addMessage(Message mm) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO message VALUES(NULL,?,?,?,?,now(),0)";
		Object[] arr={mm.getTitle(),mm.getContent(),mm.getSendid(),mm.getReceivid()};
		return this.execUpdate(sql, arr);
	}

	@Override
	public List<Message> getAll_receive(int uid) {
		// TODO Auto-generated method stub
		List<Message> list=new ArrayList<Message>();
		String sql="SELECT * FROM message WHERE receive_uid=? order by sendtime desc ";
		
		conn=this.getConn();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				Message ms=new Message();
				ms.setId(rs.getInt(1));
				ms.setTitle(rs.getString(2));
				ms.setContent(rs.getString(3));
				ms.setSendid(rs.getInt(4));
				ms.setReceivid(rs.getInt(5));
				ms.setSendtime(rs.getString(6));
				ms.setIsread(rs.getInt(7));
				list.add(ms);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			this.closeAll(conn, pst, rs);
		}
		
		
		return list;
	}

	@Override
	public List<Message> getAll_send(int uid) {
		// TODO Auto-generated method stub
		List<Message> list=new ArrayList<Message>();
		String sql="SELECT * FROM message WHERE send_uid=?";
		
		conn=this.getConn();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				Message ms=new Message();
				ms.setId(rs.getInt(1));
				ms.setTitle(rs.getString(2));
				ms.setContent(rs.getString(3));
				ms.setSendid(rs.getInt(4));
				ms.setReceivid(rs.getInt(5));
				ms.setSendtime(rs.getString(6));
				ms.setIsread(rs.getInt(7));
				list.add(ms);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			this.closeAll(conn, pst, rs);
		}
		
		
		return list;
	}
	
	public Message getById(int id){
		Message ms=null;
		String sql="SELECT * FROM message WHERE id=?";
		conn=this.getConn();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next())
			{
				 ms=new Message();
				ms.setId(rs.getInt(1));
				ms.setTitle(rs.getString(2));
				ms.setContent(rs.getString(3));
				ms.setSendid(rs.getInt(4));
				ms.setReceivid(rs.getInt(5));
				ms.setSendtime(rs.getString(6));
				ms.setIsread(rs.getInt(7));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			this.closeAll(conn, pst, rs);
		}
		
		return ms;
	}

	@Override
	public int modMessage(Message mm) {
		// TODO Auto-generated method stub
		
		String sql="update message set isread=?,title=?,content=? where id=?";
		Object[] arr={mm.getIsread(),mm.getTitle(),mm.getContent(),mm.getId()};
		
		return this.execUpdate(sql, arr);
	}

	@Override
	public List<Message> getAll_receive(int page, int pageSize, int uid) {
		// TODO Auto-generated method stub
		List<Message> list=new ArrayList<Message>();
		String sql="SELECT * FROM message WHERE receive_uid=? order by sendtime desc limit ?,?";
		
		conn=this.getConn();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			int begin=(page-1)*pageSize;
			pst.setInt(2, begin);
			pst.setInt(3, pageSize);
			rs=pst.executeQuery();
			while(rs.next())
			{
				Message ms=new Message();
				ms.setId(rs.getInt(1));
				ms.setTitle(rs.getString(2));
				ms.setContent(rs.getString(3));
				ms.setSendid(rs.getInt(4));
				ms.setReceivid(rs.getInt(5));
				ms.setSendtime(rs.getString(6));
				ms.setIsread(rs.getInt(7));
				list.add(ms);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			this.closeAll(conn, pst, rs);
		}
		
		
		return list;
	}

	@Override
	public int getRowCount(int uid) {
		// TODO Auto-generated method stub
		String sql="SELECT count(2) FROM message WHERE receive_uid=?";
		conn=this.getConn();
		int row=0;
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			rs=pst.executeQuery();
			rs.next();
			row=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			this.closeAll(conn, pst, rs);
		}	
		return row;
	}

}
