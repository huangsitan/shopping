package com.entity;

public class Order {
	private int id;
	private String uid;
	private String addressid;
	private String dotime;
	private String note;
	private String shipname;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getDotime() {
		return dotime;
	}
	public void setDotime(String dotime) {
		this.dotime = dotime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getShipname() {
		return shipname;
	}
	public void setShipname(String shipname) {
		this.shipname = shipname;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	
	
}
