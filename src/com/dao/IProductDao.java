package com.dao;

import java.util.List;

import com.entity.Product;

public interface IProductDao {
  /**
   * ��ѯ������Ʒ
   * ���:��
   * ����:list
   * */
	public List<Product> showProduct();
	
	/**
	 * ������Ʒ
	 * ���:Product p
	 * ����:
	 * */
	public int addProduct(Product p);
	/**
	 * �޸���Ʒ
	 * ��ڣ�Product p
	 * ���ڣ�int
	 * */
	public int modProduct(Product p);
	
	/**
	 * ����id ������Ʒ
	 * ��ڣ�id
	 * ���ڣ���Ʒ
	 * */
	public Product getProductById(int id);
	
	/**
	 * ����idɾ����Ʒ
	 * ��ڣ�id
	 * ���ڣ�int
	 * */
	public int delProductById(int id);
	
	/**
	 * ����һ��idɾ����Ʒ
	 * ��ڣ�String[]
	 * ���ڣ�int
	 * */
	public int delManyProduct(String[] ids);
	
	/**
	 * �ҵ��ռӵ���Ʒid
	 * ��ڣ��û�
	 * ���ڣ��ռӵ�int id
	 * */
	public int getNewProductid(int uid);
	/**
	 * ֧��ģ����ѯ�ķ���
	 * ��ڣ��ؼ���
	 * ���ڣ�List<Product>
	 * */
	public List<Product> QueryByKey(String key);
	
	/**
	 * ֧��ģ����ѯ�ķ���
	 * ��ҳ����ҳ����Ҹ�ҳ����List
	 * */
	public List<Product> QueryByKey_page(int page,int pageSize,String key);
	/**
	 * ������
	 * */
	public int getRowCount(String key);
	
}
