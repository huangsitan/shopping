package com.dao;

import java.util.List;

import com.entity.ProductImg;

public interface ProductImgDao {

	public int addImg(ProductImg img);
	
	
	public List<ProductImg> getImg(int pid);
}
