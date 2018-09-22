package com.biz;

import java.util.List;

import com.entity.UserInfo;

public interface IUserBiz {

	//注册
	/**
	 * 入口：实体类
	 * 出口：int
	 * */
	public int reg(UserInfo us);
	
	/**
	 * 登录
	 * */
	public UserInfo log(String name,String pwd);
	
	public List<UserInfo> getAll();
}
