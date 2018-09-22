package com.entity;

public class Product {
    private int id;
    private String name;  //名字
    private int cateid;   //类别
    private double price;  //价格
    private int store;  //库存
    private String info;//商品的说明
    private int uid;
  //商品类型名
    private String cateName;
    //图片
    private String img;
    

    
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCateName() {
		return cateName;
	}
	
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Product p=(Product)obj;
		if(this.getId()==p.getId())return true;
		else return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+"-"+this.name+"-"+this.getPrice();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
    
    
}
