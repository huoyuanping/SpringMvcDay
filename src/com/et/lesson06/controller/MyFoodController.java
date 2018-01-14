package com.et.lesson06.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.et.lesson06.dao.MyFoodDaoImpl;

@Controller
public class MyFoodController {
	/**
	 * ��ѯ����
	 * ԭʼ�����json��ʽ
	 * ͨ��OutputStream os
	 * os.write��ͨ��������json-libת����json�ַ���.getBytes��
	 */
	@Autowired
	MyFoodDaoImpl mdi;
	@RequestMapping(value="/queryAll",method={RequestMethod.GET})
	public String myfood(String foodname,OutputStream os,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		//response.setContentType("text/html;charset=UTF-8");
		List<Map<String, Object>> queryFood=mdi.queryAllFood(foodname);
		JSONArray arr=JSONArray.fromObject(queryFood);
		//��ȡjson���ַ���
		String str=arr.toString();
		os.write(str.getBytes("UTF-8"));
		return null;
	
	}
	
	/**
	 *�ڶ���ֱ�ӷ����ֽ����飨byte Ĭ��֧����Ϣת������ 
	 *���ע��@ResponseBody
	 *����������Ķ��� os.write(str.getBytes("UTF-8"));
	 */
	@ResponseBody
	@RequestMapping(value="/queryAllReturn",method={RequestMethod.GET})
	public byte[] myfoodReturn(String foodname) throws UnsupportedEncodingException, IOException{
		//response.setContentType("text/html;charset=UTF-8");
		List<Map<String, Object>> queryFood=mdi.queryAllFood(foodname);
		JSONArray arr=JSONArray.fromObject(queryFood);
		//��ȡjson���ַ���
		String str=arr.toString();
		return str.getBytes("UTF-8");
	
	}
	
	/**
	 *������ֱ�ӷ��ض���  springmvc�Զ�ת��json(Ĭ���ǲ����� ��Ҫ��Ϣת����(MappingJackson2HttpMessageConverter)
	 *�Ḳ���ֽ��������Ϣת��������ͬʱ���ֽ��������Ϣת����ByteArrayHttpMessageConverter)
	 *���ע��@ResponseBody
	 */
	@ResponseBody
	@RequestMapping(value="/queryAllList",method={RequestMethod.GET})
	public List<Map<String, Object>> foodMap(String foodname) throws UnsupportedEncodingException, IOException{
		List<Map<String, Object>> queryFood=mdi.queryAllFood(foodname);
		return queryFood;
	
	}
	/**
	 * ɾ������
	 */
	@RequestMapping(value="/food/{foodid}",method=RequestMethod.DELETE)
	public String deleteFood(@PathVariable String foodid,OutputStream os,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		try {
			mdi.deleteFood(foodid);
			os.write("1".getBytes("UTF-8"));
			
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * ��ӷ���
	 */
	@RequestMapping(value="/food",method={RequestMethod.POST})
	public String saveFood(String foodName,String price,OutputStream os,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		try {
			mdi.saveFood( foodName, price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * �޸ķ���
	 */
	@RequestMapping(value="/food/{foodid}",method={RequestMethod.PUT})
	public String updateFood(@PathVariable String foodid,String foodName,String price,OutputStream os,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		try {
			mdi.updateFood(foodid, foodName, price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}

}
