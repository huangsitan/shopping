package com.biz;

import java.util.List;

import com.dao.IShopcartDao;
import com.dao.ShopCartDaoImpl;
import com.entity.ShopCart;

public class ShopCartBizImpl implements IShopCartBiz {

	private IShopcartDao dao = new ShopCartDaoImpl();
	@Override
	public int addCart(ShopCart cart) {
		// TODO Auto-generated method stub
		boolean flag =dao.isExist(cart.getPid(),cart.getUid());
		int n=0;
		if(flag)
		{
			//ÐÞ¸Ä
			n=dao.modShopCart(cart);
			
		}else
		{
			n=dao.addCart(cart);
		}
		return n;
	}
	@Override
	public List<ShopCart> getUserCarts(int uid) {
		// TODO Auto-generated method stub
		return dao.getAll(uid);
	}
	@Override
	public int delCarts(int id) {
		// TODO Auto-generated method stub
		String[] ids={id+""};
		return dao.delCarts(ids);
	}
	@Override
	public int delCarts(String[] ids) {
		// TODO Auto-generated method stub
		return dao.delCarts(ids);
	}

}
