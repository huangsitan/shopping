package com.dao;

import java.util.List;

import com.entity.Address;

public interface IAddressDao {

	public int addAddress(Address address);
	
	public List<Address> getAddressByUser(int uid);
	
	public int delAddress(String[] ids);
	
	public Address getAddressById(int id);
	
	public int modAddress(Address address);
	
	
}
