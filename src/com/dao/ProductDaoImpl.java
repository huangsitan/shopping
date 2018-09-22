package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Product;

public class ProductDaoImpl extends BaseDao implements IProductDao {

	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	@Override
	public List<Product> showProduct() {
		// TODO Auto-generated method stub
		
		
		List<Product> list=new ArrayList<Product>();
		try {
			conn=this.getConn2();
			pst=conn.prepareStatement("SELECT pp.*,g.imgpath FROM "
					+ "(SELECT p.*,t.tname FROM product p ,product_type t "
					+ "WHERE p.type=t.id) pp LEFT JOIN "
					+ "(SELECT * FROM product_img WHERE ismain=1) g "
					+ "ON pp.pid=g.pid order by pp.addptime desc");
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				Product pro=new Product();
				pro.setId(rs.getInt("pid"));
				pro.setName(rs.getString("pname"));
				pro.setPrice(rs.getDouble("price"));
				pro.setStore(rs.getInt("store"));
				pro.setCateName(rs.getString("tname"));
				pro.setImg(rs.getString("imgpath"));
				list.add(pro);
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
	public int addProduct(Product p) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO product VALUES(NULL,?,?,?,now(),?,?,?)";
		Object arr[]={p.getName(),p.getPrice(),p.getStore(),p.getCateid(),p.getInfo(),p.getUid()};
		return this.execUpdate(sql, arr);
		
	}

	@Override
	public int modProduct(Product p) {
		// TODO Auto-generated method stub
		
		String sql="UPDATE product SET pNAME=?,price=?,store=?,type=?,info=? WHERE pid=?";
		Object[]arr={p.getName(),p.getPrice(),p.getStore(),p.getCateid(),p.getInfo(),p.getId()};
		return this.execUpdate(sql, arr);
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Product p =null;
		try {
			
			conn=this.getConn2();
			pst=conn.prepareStatement("select * from product where pid=?");
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
			if(rs.next())
			{
			    p=new Product();
			    
				p.setId(rs.getInt("pid"));
				p.setName(rs.getString("pname"));
				p.setPrice(rs.getDouble("price"));
				p.setCateid(rs.getInt("type"));
				p.setStore(rs.getInt("store"));
				p.setInfo(rs.getString("info"));
			}
			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			this.closeAll(conn, pst, rs);
		}
		
		
		return p;
	}

	@Override
	public int delProductById(int id) {
		// TODO Auto-generated method stub
		String sql="delete from product where pid=?";
		Object[]arr={id};
		return this.execUpdate(sql, arr);
		
	}

	@Override
	public int delManyProduct(String[] ids) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder("DELETE FROM product WHERE pid IN (");
		for(String id:ids)
		{
			sql.append(id+",");
		}
		//DELETE FROM product WHERE pid IN ('7','8','9',
		//aaa
		String sqlss=sql.toString();
		sqlss=sqlss.substring(0, sqlss.length()-1)+")";
		return this.execUpdate(sqlss, null);
	}

	@Override
	public int getNewProductid(int uid) {
		// TODO Auto-generated method stub
		String sql="SELECT MAX(pid) FROM product WHERE adduser=?";
		int n=0;
		conn = this.getConn2();
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, uid);
			rs=pst.executeQuery();
			rs.next();
			n=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			this.closeAll(conn, pst, rs);
		}
		
		return n;
	}

	@Override
	public List<Product> QueryByKey(String key) {
		// TODO Auto-generated method stub
		List<Product> list=new ArrayList<Product>();
		StringBuilder sql=new StringBuilder("SELECT pp.*,g.imgpath FROM "
				+ "(SELECT p.*,t.tname FROM product p ,product_type t "
				+ "WHERE p.type=t.id) pp LEFT JOIN "
				+ "(SELECT * FROM product_img WHERE ismain=1) g "
				+ "ON pp.pid=g.pid ");
		
		if(key!=null){
			sql.append("where pp.pname LIKE ? OR pp.tname LIKE ? OR pp.info LIKE ?");	
		}
		try {
			conn=this.getConn2();
			pst=conn.prepareStatement(sql.toString());
			if(key!=null)
			{
				pst.setString(1, "%"+key+"%");
				pst.setString(2, "%"+key+"%");
				pst.setString(3, "%"+key+"%");
			}
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				Product pro=new Product();
				pro.setId(rs.getInt("pid"));
				pro.setName(rs.getString("pname"));
				pro.setPrice(rs.getDouble("price"));
				pro.setStore(rs.getInt("store"));
				pro.setCateName(rs.getString("tname"));
				pro.setImg(rs.getString("imgpath"));
				list.add(pro);
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
	public List<Product> QueryByKey_page(int page, int pageSize, String key) {
		// TODO Auto-generated method stub
		List<Product> list=new ArrayList<Product>();
		StringBuilder sql=new StringBuilder("SELECT pp.*,g.imgpath FROM "
				+ "(SELECT p.*,t.tname FROM product p ,product_type t "
				+ "WHERE p.type=t.id) pp LEFT JOIN "
				+ "(SELECT * FROM product_img WHERE ismain=1) g "
				+ "ON pp.pid=g.pid ");
		//"null"
		if(key!=null&&!key.equals("null")){
			sql.append("where pp.pname LIKE ? OR pp.tname LIKE ? OR pp.info LIKE ?");	
		}
		sql.append(" limit ?,?");
		
		try {
			conn=this.getConn2();
			pst=conn.prepareStatement(sql.toString());
			int n=1;
			if(key!=null&&!key.equals("null"))
			{
				pst.setString(1, "%"+key+"%");
				pst.setString(2, "%"+key+"%");
				pst.setString(3, "%"+key+"%");
				n=4;
			}
			int begin=(page-1)*pageSize;
			pst.setInt(n, begin);
			pst.setInt(n+1, pageSize);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				Product pro=new Product();
				pro.setId(rs.getInt("pid"));
				pro.setName(rs.getString("pname"));
				pro.setPrice(rs.getDouble("price"));
				pro.setStore(rs.getInt("store"));
				pro.setCateName(rs.getString("tname"));
				pro.setImg(rs.getString("imgpath"));
				list.add(pro);
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
	public int getRowCount(String key) {
		// TODO Auto-generated method stub
		int row=0;
		
		StringBuilder sql=new StringBuilder("SELECT count(1) FROM "
				+ "(SELECT p.*,t.tname FROM product p ,product_type t "
				+ "WHERE p.type=t.id) pp LEFT JOIN "
				+ "(SELECT * FROM product_img WHERE ismain=1) g "
				+ "ON pp.pid=g.pid ");
		
		if(key!=null&&!key.equals("null")){
			sql.append("where pp.pname LIKE ? OR pp.tname LIKE ? OR pp.info LIKE ?");	
		}
		
		try {
			conn=this.getConn2();
			pst=conn.prepareStatement(sql.toString());
			
			if(key!=null&&!key.equals("null"))
			{
				pst.setString(1, "%"+key+"%");
				pst.setString(2, "%"+key+"%");
				pst.setString(3, "%"+key+"%");
			
			}
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
