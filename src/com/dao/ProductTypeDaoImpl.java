package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.ProdutType;

public class ProductTypeDaoImpl extends BaseDao implements IPTypeDao {

	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public List<ProdutType> getAll() {
		// TODO Auto-generated method stub
		List<ProdutType> list = new ArrayList<ProdutType>();
		
		conn = this.getConn();
		try {
			pst = conn.prepareStatement("select * from product_type");
			rs= pst.executeQuery();
			while(rs.next())
			{
				ProdutType tt = new ProdutType();
				tt.setId(rs.getInt(1));
				tt.setName(rs.getString(2));
				tt.setCreator(rs.getString(3));
				tt.setAddtime(rs.getString(4));
				list.add(tt);
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
	public int add(ProdutType pt) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO product_type VALUES(NULL,?,?,NOW())";
		Object[] arr={pt.getName(),pt.getCreator()};
		return this.execUpdate(sql, arr);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		String sql="DELETE  FROM product_type WHERE id=?";
		Object[] arr={id};
		return this.execUpdate(sql, arr);
	}

	@Override
	public int mod(ProdutType pt) {
		// TODO Auto-generated method stub
		String sql="UPDATE product_type SET tname=? WHERE id=?";
		Object[] arr={pt.getName(),pt.getId()};
		return this.execUpdate(sql, arr);
	}

}
