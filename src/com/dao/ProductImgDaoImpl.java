package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.ProductImg;

public class ProductImgDaoImpl extends BaseDao implements ProductImgDao {
	
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public int addImg(ProductImg img) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO product_img VALUES(NULL,?,?,?)";
		Object[] arr={img.getPath(),img.getPid(),img.getIsmain()};
		return this.execUpdate(sql, arr);
	}

	@Override
	public List<ProductImg> getImg(int pid) {
		// TODO Auto-generated method stub
		List<ProductImg> list = new ArrayList<ProductImg>();
		String sql="SELECT * FROM product_img WHERE pid=?";
		conn = this.getConn2();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				ProductImg img = new ProductImg();
				img.setId(rs.getInt(1));
				img.setPath(rs.getString(2));
				img.setPid(rs.getInt(3));
				img.setIsmain(rs.getInt(4));
				list.add(img);
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

}
