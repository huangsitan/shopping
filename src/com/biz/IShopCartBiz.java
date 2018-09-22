package com.biz;

import java.util.List;

import com.entity.ShopCart;

public interface IShopCartBiz {

	public int addCart(ShopCart cart);
	
	public List<ShopCart> getUserCarts(int uid);
	
	public int delCarts(int id);
	
	public int delCarts(String[] ids);
}
