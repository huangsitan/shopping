package com.biz;

import java.util.List;

import com.entity.UserInfo;

public interface IUserBiz {

	//ע��
	/**
	 * ��ڣ�ʵ����
	 * ���ڣ�int
	 * */
	public int reg(UserInfo us);
	
	/**
	 * ��¼
	 * */
	public UserInfo log(String name,String pwd);
	
	public List<UserInfo> getAll();
}
