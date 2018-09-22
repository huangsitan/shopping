package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.ShopCart;

public class ShopCartDaoImpl extends BaseDao implements IShopcartDao {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public int addCart(ShopCart cart) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO shopcart VALUES(NULL,?,?,?,?,?,1)";
		Object[]arr={cart.getPid(),cart.getUid(),cart.getNum(),cart.getPrice(),cart.getNote()};
		
		return this.execUpdate(sql, arr);
	}

	@Override
	public List<ShopCart> getAll(int uid) {
		// TODO Auto-generated method stub
		List<ShopCart> list = new ArrayList<ShopCart>();
		String sql="SELECT * FROM cartview  WHERE uid=?";
		conn = this.getConn();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				ShopCart cart = new ShopCart();
				cart.setId(rs.getInt(1));
				cart.setPid(rs.getInt(2));
				cart.setUid(rs.getInt(3));
				cart.setNum(rs.getInt(4));
				cart.setPrice(rs.getDouble(5));
				cart.setNote(rs.getString(6));
				cart.setOnline(rs.getInt(7));
				cart.setPname(rs.getString(8));
				
				list.add(cart);
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
	public boolean isExist(int pid,int uid) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM shopcart where pid=? and uid=?";
		conn =this.getConn();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.setInt(2, uid);
			rs=pst.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.closeAll(conn, pst, rs);
		}
		
		return false;
	}

	@Override
	public int modShopCart(ShopCart cc) {
		// TODO Auto-generated method stub
		String sql="UPDATE shopcart SET num=num+? WHERE pid=? and uid=?";
		Object[] arr={cc.getNum(),cc.getPid(),cc.getUid()};
		return this.execUpdate(sql, arr);
	}

	@Override
	public int delCarts(String[] ids) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder("DELETE FROM shopcart WHERE id IN (");
		for(String id:ids)
		{
			sql.append(id);
			sql.append(",");
		}	
		String sqlstr=sql.toString();
		//DELETE FROM shopcart WHERE id IN ( 2,3,4,
		sqlstr=sqlstr.substring(0, sqlstr.length()-1)+")";
		
		return this.execUpdate(sqlstr, null);
	}

}
