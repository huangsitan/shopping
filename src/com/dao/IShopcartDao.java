package com.dao;

import java.util.List;

import com.entity.ShopCart;

public interface IShopcartDao {

	public int addCart(ShopCart cart);
	
	/**
	 * �г���¼�û��Ĺ��ﳵ��Ϣ
	 * ��ڣ��û�id
	 * ���ڣ�List<ShopCart>
	 * */
	public List<ShopCart> getAll(int uid);
	
	/**
	 * ������Ʒid��鹺�ﳵ���Ƿ���ڸ���Ʒ
	 * ��ڣ���Ʒid
	 * ���ڣ�boolean
	 * */
	public boolean isExist(int pid,int uid);
	
	/**
	 * �޸Ĺ��ﳵ����
	 * */
	public int modShopCart(ShopCart cc);
	/**
	 * ɾ�����ﳵ
	 * ��ڣ�String[] ids
	 * ����:int
	 * */
	public int delCarts(String []ids);
	
	
}
