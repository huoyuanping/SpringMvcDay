package com.et.lesson01homework.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.lesson01homework.dao.FoodDao;
import com.et.lesson01homework.service.FoodService;
import com.et.lesson01homework.utils.PageTools;
@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodDao dao;
	public void deleteFood(String foodId) {
		dao.deleteFood(foodId);

	}

	public PageTools queryFoodAll(String foodName,int curPage) {
		if(foodName==null){
			foodName="";
		}
		//×ÜºÍ
		int totalCount= dao.getTableListCount(foodName);
		PageTools pt=new PageTools(curPage, totalCount, null);
		List<Map<String, Object>> tablePager=dao.queryFoodAll(foodName, pt.getStartIndex()-1, pt.getPageCount());
		pt.setData(tablePager);
		return pt;
	}

	public void saveFood(String foodName, String price, String imagePath) {
		dao.saveFood(foodName, price, imagePath);

	}

	public void updateFood(String foodId, String foodName, String price,String path) {
		dao.updateFood(foodId, foodName, price,path);

	}

	public Map<String, Object> FoodById(String foodId) {
		
		return dao.FoodById(foodId);
	}

}
