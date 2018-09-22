package com.biz;

import java.util.List;

import com.dao.AddressDaoImpl;
import com.dao.IAddressDao;
import com.entity.Address;

public class AddressBizimpl implements IAddressBiz {

	private IAddressDao dao = new AddressDaoImpl();
	
	@Override
	public int addAddress(Address address) {
		// TODO Auto-generated method stub
		return dao.addAddress(address);
	}

	@Override
	public List<Address> getAddressByUser(int uid) {
		// TODO Auto-generated method stub
		return dao.getAddressByUser(uid);
	}

	@Override
	public int delAddress(String[] ids) {
		// TODO Auto-generated method stub
		return dao.delAddress(ids);
	}

	@Override
	public Address getAddressById(int id) {
		// TODO Auto-generated method stub
		return dao.getAddressById(id);
	}

	@Override
	public int modAddress(Address address) {
		// TODO Auto-generated method stub
		return dao.modAddress(address);
	}

}
