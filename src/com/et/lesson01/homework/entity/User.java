package com.et.lesson01.homework.entity;
/**
 * �û�ʵ����
 * @author Administrator
 *
 */
public class User {
	private int id;
	private String sname;
	public User(){
		
	}
	public User(int id, String sname) {
		super();
		this.id = id;
		this.sname = sname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
}
