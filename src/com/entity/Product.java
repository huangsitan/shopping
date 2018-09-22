package com.entity;

public class Product {
    private int id;
    private String name;  //����
    private int cateid;   //���
    private double price;  //�۸�
    private int store;  //���
    private String info;//��Ʒ��˵��
    private int uid;
  //��Ʒ������
    private String cateName;
    //ͼƬ
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
