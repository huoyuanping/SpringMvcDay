package com.et.lesson01.homework.dao;

import java.util.List;

import com.et.lesson01.homework.entity.User;


public interface MyDao {
	//É¾³ý
	public int deleteUser(int id);
	//Ìí¼Ó
	public void addUser(String sname);
	//ÐÞ¸Ä
	public int updateUser(String sname,int id);
	//²éÑ¯
	public List<User> queryUser();
}
