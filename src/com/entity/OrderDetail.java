package com.entity;

public class OrderDetail {

	private int id;
	private int oid;
	private int pid;
	private int num;
	private double price;
	private String colorsize;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColorsize() {
		return colorsize;
	}
	public void setColorsize(String colorsize) {
		this.colorsize = colorsize;
	}
	
}
