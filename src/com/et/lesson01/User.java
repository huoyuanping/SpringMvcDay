package com.et.lesson01;
/**
 * 用户实体类
 * @author Administrator
 *
 */
public class User {
	private String id;
	private String name;
	public User(){
		
	}
	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
