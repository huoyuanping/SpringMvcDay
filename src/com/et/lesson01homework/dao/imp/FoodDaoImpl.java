package com.et.lesson01homework.dao.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.et.lesson01homework.dao.FoodDao;
@Repository
public class FoodDaoImpl implements FoodDao {
	@Autowired
	JdbcTemplate jdbc;
	public void deleteFood(String foodId) {
		String sql="delete from food where foodid="+foodId;
		jdbc.execute(sql);
		
	}

	public List<Map<String, Object>> queryFoodAll(String foodName,int startIndex,int length) {
		
		String sql="select * from food where foodname like '%"+foodName+"%' limit " +startIndex+ "," +length;
		List<Map<String, Object>> result=jdbc.queryForList(sql);
		return result;
	}
	public void saveFood(String foodName, String price, String imagePath) {
		String sql="insert into food values((select IFNULL(max(foodid),0)+1 from food f),'"+foodName+"','"+price+"','"+imagePath+"')";
		jdbc.execute(sql);
		
	}

	public void updateFood(String foodId, String foodName, String price,String path) {
		String sql="update food set foodname='"+foodName+"',price='"+price+"' ,imagepath='"+path+"' where foodid="+foodId;
		jdbc.execute(sql);
	}

	public Map<String, Object> FoodById(String foodId) {
		String sql="select * from food  where foodid ="+foodId;
	
		List<Map<String, Object>> result=jdbc.queryForList(sql);
		return result.get(0);
	}

	public Integer getTableListCount(String name) {
		String sql="select count(*) as cr from food where foodname like '%"+name+"%'";
		List<Map<String, Object>> result=jdbc.queryForList(sql);
		return Integer.parseInt(result.get(0).get("cr").toString());
	}

	
	

}
