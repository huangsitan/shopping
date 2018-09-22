package com.biz;

import java.util.List;

import com.dao.IPTypeDao;
import com.dao.ProductTypeDaoImpl;
import com.entity.ProdutType;

public class PTypeBizImpl implements IPTypeBiz {

	private IPTypeDao  dao = new ProductTypeDaoImpl();
	@Override
	public List<ProdutType> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public int add(ProdutType pt) {
		// TODO Auto-generated method stub
		return dao.add(pt);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return dao.del(id);
	}

	@Override
	public int mod(ProdutType pt) {
		// TODO Auto-generated method stub
		return dao.mod(pt);
	}

}
