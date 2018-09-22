package com.biz;

import java.util.List;

import com.dao.IMessageDao;
import com.dao.MesageDaoImpl;
import com.entity.Message;
import com.util.PageBean;

public class MessageBizImpl implements IMessageBiz {

	private IMessageDao dao = new MesageDaoImpl();
	
	@Override
	public int addMessage(Message mm) {
		// TODO Auto-generated method stub
		return dao.addMessage(mm);
	}

	@Override
	public List<Message> getAll_receive(int uid) {
		// TODO Auto-generated method stub
		return dao.getAll_receive(uid);
	}

	@Override
	public List<Message> getAll_send(int uid) {
		// TODO Auto-generated method stub
		return dao.getAll_send(uid);
	}

	@Override
	public Message getById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public int modMessage(Message mm) {
		// TODO Auto-generated method stub
		return dao.modMessage(mm);
	}

	@Override
	public PageBean queryBypage(int uid, int page) {
		// TODO Auto-generated method stub
	    PageBean bean = new PageBean();
		
		bean.setCurrpage(page);
		bean.setList(dao.getAll_receive(page, bean.getPageSize(), uid));
		bean.setTotalRow(dao.getRowCount(uid));
		
		return bean;
	}

}
