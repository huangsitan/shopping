package com.biz;

import java.util.List;

import com.entity.ProdutType;

public interface IPTypeBiz {
   public List<ProdutType> getAll();
	
	public int add(ProdutType pt);
	
	public int del(int id);
	
	public int mod(ProdutType pt);
}
