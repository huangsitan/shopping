package com.dao;

import java.util.List;

import com.entity.ShopCart;

public interface IShopcartDao {

	public int addCart(ShopCart cart);
	
	/**
	 * 列出登录用户的购物车信息
	 * 入口：用户id
	 * 出口：List<ShopCart>
	 * */
	public List<ShopCart> getAll(int uid);
	
	/**
	 * 根据商品id检查购物车中是否存在改商品
	 * 入口：商品id
	 * 出口：boolean
	 * */
	public boolean isExist(int pid,int uid);
	
	/**
	 * 修改购物车数量
	 * */
	public int modShopCart(ShopCart cc);
	/**
	 * 删除购物车
	 * 入口：String[] ids
	 * 出口:int
	 * */
	public int delCarts(String []ids);
	
	
}
