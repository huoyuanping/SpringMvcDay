package com.et.lesson01homework.service;

import java.util.List;
import java.util.Map;

import com.et.lesson01homework.utils.PageTools;

public interface FoodService {
	/**
	 * ��ѯ���ԵĲ�Ʒ�������ַ�ҳ
	 * @param foodName��Ʒ����
	 * @return
	 */
	public PageTools queryFoodAll(String foodName,int curPage);
	/**
	 * ��Ӳ�Ʒ
	 * @param foodName��Ʒ����
	 * @param price ��Ʒ�۸�
	 * @param imagePath ��ƷͼƬ
	 */
	public void saveFood(String foodName, String price, String imagePath);
	/**
	 * �޸Ĳ�Ʒ
	 * @param foodId ��Ʒ���
	 * @param foodName��Ʒ����
	 * @param price��Ʒ�۸�
	 * @param imagePath��ƷͼƬ
	 */
	public void updateFood(String foodId,String foodName,String price,String path);
	
	/**
	 * ɾ����Ʒ
	 * @param foodId��Ʒ���
	 */
	public void deleteFood(String foodId);
	/**
	 * �鿴��ϸ��Ʒ
	 * @param foodId��Ʒ���
	 */
	public Map<String, Object> FoodById(String foodId);
}
