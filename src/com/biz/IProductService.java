package com.biz;
import java.util.List;

import com.entity.Product;
import com.util.PageBean;
public interface IProductService {

	//获得所有商品
	public List<Product> showProducts();
	//增加商品
	public int addProduct(Product p,List<String> list);
	//修改商品
	public int modProduct(Product p);
	//查找商品
	public Product getById(int id);
	//删除商品
	public int delProduct(int id);
	
	//删除多个商品
	public int delMany(String[] ids);
	
	//模糊查询
	public List<Product> queryByKey(String key);
	
	//分页
	public PageBean queryByKey_page(String key,int page);
}
