package com.biz;

import java.util.List;

import com.entity.Message;
import com.util.PageBean;

public interface IMessageBiz {

   public int addMessage(Message mm);
	
	public List<Message> getAll_receive(int uid);
	
	public List<Message> getAll_send(int uid);
	
	public Message getById(int id);
	public int modMessage(Message mm) ;
	
	//·ÖÒ³
	public PageBean queryBypage(int uid,int page);
}
