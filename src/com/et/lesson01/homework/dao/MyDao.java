package com.et.lesson01.homework.dao;

import java.util.List;

import com.et.lesson01.homework.entity.User;


public interface MyDao {
	//ɾ��
	public int deleteUser(int id);
	//���
	public void addUser(String sname);
	//�޸�
	public int updateUser(String sname,int id);
	//��ѯ
	public List<User> queryUser();
}
