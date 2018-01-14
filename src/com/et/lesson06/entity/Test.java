package com.et.lesson06.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 模拟数据库
 * @author Administrator
 *
 */
public class Test {
	
	/**
	 * map转成json对象
	 * 结果：{"id":1,"username":"A"}
	 * @param args
	 */
	public static void parseObject(){
		//一个map一行数据
		Map map=new HashMap();
		map.put("id", 1);
		map.put("username", "A");
		JSONObject jo=JSONObject.fromObject(map);
		System.out.println(jo.toString());
	}
	
	/**
	 * 集合转成json数组
	 * json字符串的键必须带" " 例:"key":1 值如果是数字可以不带 字符串必须带
	 * 结果：[{"id":1,"username":"A"},{"id":2,"username":"B"}]
	 * @param args
	 */
	public static void parseArray(){
		//一个map一行数据
		Map map=new HashMap();
		map.put("id", 1);
		map.put("username", "A");
		
		Map map1=new HashMap();
		map1.put("id", 2);
		map1.put("username", "B");
		
		List list=new ArrayList();
		list.add(map);
		list.add(map1);
		JSONArray ja=JSONArray.fromObject(list);
		System.out.println(ja.toString());
	}
	/**
	 * 多层嵌套
	 * {  
		"name":"张三", 属性:值
		"url":"http://www.baidu.com",
		"address":{
			"street":"观澜",
			"city":	"深圳",
			"country":"中国",
		}
	 */
	public static void parseJsonArray(){
		//一个map一行数据
		Map map=new HashMap();
		map.put("id", 1);
		map.put("username", "A");
		
		Map  address=new HashMap();
		address.put("city", "深圳");
		address.put("country","中国");
		map.put("addss", address);
		
	
		JSONObject jo=JSONObject.fromObject(map);
		System.out.println(jo.toString());
	}
	public static void main(String[] args) {
		
		//parseObject();
		//parseArray();
		parseJsonArray();
	}
}
