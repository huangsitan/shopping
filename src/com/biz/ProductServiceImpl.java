package com.biz;

import java.util.List;

import com.dao.IProductDao;
import com.dao.ProductDaoImpl;
import com.dao.ProductImgDao;
import com.dao.ProductImgDaoImpl;
import com.entity.Product;
import com.entity.ProductImg;
import com.util.PageBean;

public class ProductServiceImpl implements IProductService {

	private IProductDao dao = new  ProductDaoImpl();
	private ProductImgDao idao = new ProductImgDaoImpl();
	
	@Override
	public List<Product> showProducts() {
		// TODO Auto-generated method stub
		return dao.showProduct();
	}

	@Override
	public int addProduct(Product p,List<String> list) {
		// TODO Auto-generated method stub
		int n=dao.addProduct(p);
		int id= dao.getNewProductid(p.getUid());
		//Ôö¼ÓÍ¼Æ¬
		for(int i=0;i<list.size();i++)
		{
			ProductImg img = new ProductImg();
			if(i==0) img.setIsmain(1);
			else img.setIsmain(0);

			img.setPath(list.get(i));
			img.setPid(id);
			idao.addImg(img);
		}
		return 1;
	}

	@Override
	public int modProduct(Product p) {
		// TODO Auto-generated method stub
		return dao.modProduct(p);
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return dao.getProductById(id);
	}

	@Override
	public int delProduct(int id) {
		// TODO Auto-generated method stub
		return dao.delProductById(id);
	}

	@Override
	public int delMany(String[] ids) {
		// TODO Auto-generated method stub
		return dao.delManyProduct(ids);
	}

	@Override
	public List<Product> queryByKey(String key) {
		// TODO Auto-generated method stub
		return dao.QueryByKey(key);
	}

	@Override
	public PageBean queryByKey_page(String key, int page) {
		// TODO Auto-generated method stub
		PageBean bean = new PageBean();
		
		bean.setCurrpage(page);
		bean.setList(dao.QueryByKey_page(page, bean.getPageSize(), key));
		bean.setTotalRow(dao.getRowCount(key));
		
		return bean;
	}


}
