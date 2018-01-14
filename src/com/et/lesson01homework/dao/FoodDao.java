package com.et.lesson01homework.dao;

import java.util.List;
import java.util.Map;

public interface FoodDao {
	/**
	 * 查询所以的菜品根据名字分页
	 * @param foodName菜品名称
	 * @return
	 */
	public List<Map<String, Object>> queryFoodAll(String foodName,int startIndex,int length);
	/**
	 * 添加菜品
	 * @param foodName菜品名称
	 * @param price 菜品价格
	 * @param imagePath 菜品图片
	 */
	public void saveFood(String foodName, String price, String imagePath);
	/**
	 * 修改菜品
	 * @param foodId 菜品编号
	 * @param foodName菜品名称
	 * @param price菜品价格
	 * @param imagePath菜品图片
	 */
	public void updateFood(String foodId,String foodName,String price,String path);
	
	/**
	 * 删除菜品
	 * @param foodId菜品编号
	 */
	public void deleteFood(String foodId);
	/**
	 * 查看详细菜品
	 * @param foodId菜品编号
	 */
	public Map<String, Object> FoodById(String foodId);
	/**
	 * 统计总条数
	 * @param name
	 * @return
	 */
	public Integer getTableListCount(String name);
}