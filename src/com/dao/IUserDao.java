package com.dao;

import java.util.List;

import com.entity.UserInfo;

public interface IUserDao {

	//�����û�
	/**
	 * ��ڣ�ʵ����
	 * ���ڣ�int
	 * */
	public int addUser(UserInfo us);
	
	//��ѯ�û� ���ݸ�����Ϣ
	/**
	 * ��� UserInfo
	 * ���� UserInfo
	 * */
	public UserInfo getUser(String name,String pwd);
	
	
	public List<UserInfo> getAll();
}
