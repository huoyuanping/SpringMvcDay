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
	 * 查询方法
	 * 原始的输出json方式
	 * 通过OutputStream os
	 * os.write（通过第三方json-lib转换的json字符串.getBytes）
	 */
	@Autowired
	MyFoodDaoImpl mdi;
	@RequestMapping(value="/queryAll",method={RequestMethod.GET})
	public String myfood(String foodname,OutputStream os,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		//response.setContentType("text/html;charset=UTF-8");
		List<Map<String, Object>> queryFood=mdi.queryAllFood(foodname);
		JSONArray arr=JSONArray.fromObject(queryFood);
		//获取json的字符串
		String str=arr.toString();
		os.write(str.getBytes("UTF-8"));
		return null;
	
	}
	
	/**
	 *第二种直接返回字节数组（byte 默认支持消息转换器） 
	 *添加注解@ResponseBody
	 *减少流输出的动作 os.write(str.getBytes("UTF-8"));
	 */
	@ResponseBody
	@RequestMapping(value="/queryAllReturn",method={RequestMethod.GET})
	public byte[] myfoodReturn(String foodname) throws UnsupportedEncodingException, IOException{
		//response.setContentType("text/html;charset=UTF-8");
		List<Map<String, Object>> queryFood=mdi.queryAllFood(foodname);
		JSONArray arr=JSONArray.fromObject(queryFood);
		//获取json的字符串
		String str=arr.toString();
		return str.getBytes("UTF-8");
	
	}
	
	/**
	 *第三种直接返回对象  springmvc自动转成json(默认是不可以 需要消息转换器(MappingJackson2HttpMessageConverter)
	 *会覆盖字节数组的消息转换器所有同时加字节数组的消息转换器ByteArrayHttpMessageConverter)
	 *添加注解@ResponseBody
	 */
	@ResponseBody
	@RequestMapping(value="/queryAllList",method={RequestMethod.GET})
	public List<Map<String, Object>> foodMap(String foodname) throws UnsupportedEncodingException, IOException{
		List<Map<String, Object>> queryFood=mdi.queryAllFood(foodname);
		return queryFood;
	
	}
	/**
	 * 删除方法
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
	 * 添加方法
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
	 * 修改方法
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
