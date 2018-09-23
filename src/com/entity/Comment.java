package com.entity;

public class Comment {

	private int id;
	private int uid;
	private String uname;
	private String dotime;
	private String content;
	private int pid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getDotime() {
		return dotime;
	}
	public void setDotime(String dotime) {
		this.dotime = dotime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	
	
	
}
