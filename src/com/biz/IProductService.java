package com.biz;
import java.util.List;

import com.entity.Product;
import com.util.PageBean;
public interface IProductService {

	//���������Ʒ
	public List<Product> showProducts();
	//������Ʒ
	public int addProduct(Product p,List<String> list);
	//�޸���Ʒ
	public int modProduct(Product p);
	//������Ʒ
	public Product getById(int id);
	//ɾ����Ʒ
	public int delProduct(int id);
	
	//ɾ�������Ʒ
	public int delMany(String[] ids);
	
	//ģ����ѯ
	public List<Product> queryByKey(String key);
	
	//��ҳ
	public PageBean queryByKey_page(String key,int page);
}
