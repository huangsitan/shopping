package com.dao;

import java.util.List;

import com.entity.Message;

public interface IMessageDao {

	public int addMessage(Message mm);
	
	public List<Message> getAll_receive(int uid);
	
	public List<Message> getAll_send(int uid);
	
	public Message getById(int id);
	
	public int modMessage(Message mm);
	
	//·ÖÒ³
	public List<Message> getAll_receive(int page,int pageSize, int uid);
	public int getRowCount(int uid);
	
}
