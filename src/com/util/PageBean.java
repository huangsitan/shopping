package com.util;

import java.util.List;

public class PageBean {

	private List list;//翻页数据
	private int currpage;//当期页
	private int pageSize=6;//一页显示的条数
	private int totalRow;//总行数
	private int totalPage;//总页数
	
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
		//算总页数
		totalPage=totalRow%pageSize==0?totalRow/pageSize:totalRow/pageSize+1;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
	
}
