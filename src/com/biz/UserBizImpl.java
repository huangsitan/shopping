package com.biz;

import java.util.List;

import com.dao.IUserDao;
import com.dao.UserDaoImpl;
import com.entity.UserInfo;

public class UserBizImpl implements IUserBiz {

	private IUserDao dao = new UserDaoImpl();
	
	@Override
	public int reg(UserInfo us) {
		// TODO Auto-generated method stub
		return dao.addUser(us);
	}

	@Override
	public UserInfo log(String name, String pwd) {
		// TODO Auto-generated method stub
		return dao.getUser(name, pwd);
	}

	@Override
	public List<UserInfo> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
