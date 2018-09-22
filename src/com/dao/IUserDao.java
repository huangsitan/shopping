package com.dao;

import java.util.List;

import com.entity.UserInfo;

public interface IUserDao {

	//增加用户
	/**
	 * 入口：实体类
	 * 出口：int
	 * */
	public int addUser(UserInfo us);
	
	//查询用户 根据给的信息
	/**
	 * 入口 UserInfo
	 * 出口 UserInfo
	 * */
	public UserInfo getUser(String name,String pwd);
	
	
	public List<UserInfo> getAll();
}
