package com.dao;

import java.util.List;

import com.entity.Product;

public interface IProductDao {
  /**
   * 查询所有商品
   * 入口:无
   * 出口:list
   * */
	public List<Product> showProduct();
	
	/**
	 * 增加商品
	 * 入口:Product p
	 * 出口:
	 * */
	public int addProduct(Product p);
	/**
	 * 修改商品
	 * 入口：Product p
	 * 出口：int
	 * */
	public int modProduct(Product p);
	
	/**
	 * 根据id 查找商品
	 * 入口：id
	 * 出口：商品
	 * */
	public Product getProductById(int id);
	
	/**
	 * 根据id删除商品
	 * 入口：id
	 * 出口：int
	 * */
	public int delProductById(int id);
	
	/**
	 * 根据一组id删除商品
	 * 入口：String[]
	 * 出口：int
	 * */
	public int delManyProduct(String[] ids);
	
	/**
	 * 找到刚加的商品id
	 * 入口：用户
	 * 出口：刚加的int id
	 * */
	public int getNewProductid(int uid);
	/**
	 * 支持模糊查询的方法
	 * 入口：关键字
	 * 出口：List<Product>
	 * */
	public List<Product> QueryByKey(String key);
	
	/**
	 * 支持模糊查询的方法
	 * 分页根据页码查找该页数据List
	 * */
	public List<Product> QueryByKey_page(int page,int pageSize,String key);
	/**
	 * 总条数
	 * */
	public int getRowCount(String key);
	
}
