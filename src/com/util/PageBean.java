package com.util;

import java.util.List;

public class PageBean {

	private List list;//��ҳ����
	private int currpage;//����ҳ
	private int pageSize=6;//һҳ��ʾ������
	private int totalRow;//������
	private int totalPage;//��ҳ��
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
		//����ҳ��
		totalPage=totalRow%pageSize==0?totalRow/pageSize:totalRow/pageSize+1;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
	
}
