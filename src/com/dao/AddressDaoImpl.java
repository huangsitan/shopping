package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Address;

public class AddressDaoImpl extends BaseDao implements IAddressDao {

	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public int addAddress(Address address) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO address VALUES(NULL,?,?,?,?,?,?,?,?,0)";
		Object[] arr={address.getUid(),address.getContactman(),address.getContactphone(),address.getCountry(),address.getProvince(),address.getCity(),address.getDetail(),address.getPostcode()};
		return this.execUpdate(sql, arr);
	}

	@Override
	public List<Address> getAddressByUser(int uid) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM address WHERE uid=?";
		List<Address> list = new ArrayList<Address>();
		conn = this.getConn();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				Address address = new Address();
				address.setId(rs.getInt(1));
				address.setUid(rs.getInt(2));
				address.setContactman(rs.getString(3));
				address.setContactphone(rs.getString(4));
				address.setCountry(rs.getString(5));
				address.setProvince(rs.getString(6));
				address.setCity(rs.getString(7));
				address.setDetail(rs.getString(8));
				address.setPostcode(rs.getString(9));
				address.setIsdefault(rs.getInt(10));
				list.add(address);
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
	public int delAddress(String[] ids) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder("DELETE FROM address WHERE id in (");
		for(String id:ids)
		{
			sql.append(id);
			sql.append(",");
		}
		String sqlstr=sql.toString();
		sqlstr=sqlstr.substring(0, sqlstr.length()-1)+")";
		
		return this.execUpdate(sqlstr, null);
	}

	@Override
	public Address getAddressById(int id) {
		// TODO Auto-generated method stub
		Address address =null;
		String sql="SELECT * FROM address WHERE id=?";
		conn = this.getConn();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next())
			{
				 address = new Address();
				address.setId(rs.getInt(1));
				address.setUid(rs.getInt(2));
				address.setContactman(rs.getString(3));
				address.setContactphone(rs.getString(4));
				address.setCountry(rs.getString(5));
				address.setProvince(rs.getString(6));
				address.setCity(rs.getString(7));
				address.setDetail(rs.getString(8));
				address.setPostcode(rs.getString(9));
				address.setIsdefault(rs.getInt(10));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.closeAll(conn, pst, rs);
		}
		
		return address;
	}

	@Override
	public int modAddress(Address address) {
		// TODO Auto-generated method stub
		String sql="UPDATE address SET contactman=?,contactphone=?,country=?,province=?,city=?,detail=?,postcode=?,ismain=? WHERE id=?";
		Object[] arr={address.getContactman(),address.getContactphone(),address.getCountry(),address.getProvince(),address.getCity(),address.getDetail(),address.getPostcode(),address.getIsdefault(),address.getId()};
		return this.execUpdate(sql, arr);
	}

}
