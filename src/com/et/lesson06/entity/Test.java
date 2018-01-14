package com.et.lesson06.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * ģ�����ݿ�
 * @author Administrator
 *
 */
public class Test {
	
	/**
	 * mapת��json����
	 * �����{"id":1,"username":"A"}
	 * @param args
	 */
	public static void parseObject(){
		//һ��mapһ������
		Map map=new HashMap();
		map.put("id", 1);
		map.put("username", "A");
		JSONObject jo=JSONObject.fromObject(map);
		System.out.println(jo.toString());
	}
	
	/**
	 * ����ת��json����
	 * json�ַ����ļ������" " ��:"key":1 ֵ��������ֿ��Բ��� �ַ��������
	 * �����[{"id":1,"username":"A"},{"id":2,"username":"B"}]
	 * @param args
	 */
	public static void parseArray(){
		//һ��mapһ������
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
	 * ���Ƕ��
	 * {  
		"name":"����", ����:ֵ
		"url":"http://www.baidu.com",
		"address":{
			"street":"����",
			"city":	"����",
			"country":"�й�",
		}
	 */
	public static void parseJsonArray(){
		//һ��mapһ������
		Map map=new HashMap();
		map.put("id", 1);
		map.put("username", "A");
		
		Map  address=new HashMap();
		address.put("city", "����");
		address.put("country","�й�");
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
