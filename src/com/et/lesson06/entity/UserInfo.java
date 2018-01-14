package com.et.lesson06.entity;
/**
 * 用户实体
 * 通过java模拟JSON
 * @author Administrator
 *
 */
public class UserInfo {
	String name="张三";
	String url="http://www.baidu.com";
	Address address;
	
	
	/* JSON中
	 * 普通数据   属性:值
	 * 键:{
	 * 
	 * }
	 * 
	 * 数组
	 * 键:[
	 * 
	 * ]
	 * {}代表一个对象   多个对象用[] 数组
	 * 
	 * {  
		"name":"张三", 属性:值
		"url":"http://www.baidu.com",
		"address":[{
			"street":"观澜",
			"city":	"深圳",
			"country":"中国",
		},{
			"street":"观澜",
			"city":	"深圳",
			"country":"中国",
		}]
	}*/



}	
