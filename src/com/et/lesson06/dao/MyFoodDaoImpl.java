package com.et.lesson06.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyFoodDaoImpl {
	@Autowired
	JdbcTemplate jdbc;
	public List<Map<String, Object>> queryAllFood(String foodname){
		String sql="select * from food where foodname like '%"+foodname+"%'";
		List<Map<String, Object>> list= jdbc.queryForList(sql);
		return list;
	}
	public void deleteFood(String foodId){
		String sql="delete from food where foodid="+foodId;
		jdbc.execute(sql);
		
	}
	
	public void saveFood(String foodName,String price){
		String sql="insert into food(foodid,foodname,price) values((select IFNULL(max(foodid),0)+1 from food f),'"+foodName+"',"+price+")";
		jdbc.execute(sql);
	}
	public void updateFood(String foodId,String foodName,String price){
		String sql="update food set foodname='"+foodName+"',price="+price+" where foodid="+foodId;
		jdbc.execute(sql);
	}
	
	
}
