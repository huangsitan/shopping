package com.dao;

import java.util.List;

import com.entity.ProdutType;

public interface IPTypeDao {

	public List<ProdutType> getAll();
	
	public int add(ProdutType pt);
	
	public int del(int id);
	
	public int mod(ProdutType pt);
}
