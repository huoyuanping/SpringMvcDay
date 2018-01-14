package com.et.lesson01.homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.et.lesson01.homework.dao.MyDao;
import com.et.lesson01.homework.entity.User;

@Controller
public class UserContronller {
	
	@Autowired
	private MyDao dao;
	/**
	 * 查询
	 */
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String queryUser(HttpServletResponse response) throws IOException{
		//设置字符集
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<User> list=dao.queryUser();
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<th>用户id</th>");
		out.println("<th>用户名称</th>");
		out.println("</tr>");
		for (User user : list) {
			out.printf("<tr>");
			out.print("<td>");
			out.print(user.getId());
			out.print("</td>");
			out.print("<td>");
			out.print(user.getSname());
			out.print("</td>");
			out.printf("</tr>");
		}
		out.println("</table>");
		return null;
	}
	/**
	 * 添加
	 */
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String addUser(String sname,HttpServletResponse response,HttpServletRequest request) throws IOException{
		//设置字符集
		response.setContentType("text/html;charset=UTF-8");
	
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		dao.addUser(sname);
	
		out.println(sname+"====添加成功");
		return null;
	
	}
	/**
	 * 删除
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable(value="id") int id,HttpServletResponse response,HttpServletRequest request) throws IOException{
		//设置字符集
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		
		int sum = dao.deleteUser(id);
		if(sum !=0){
			out.print("删除成功!");
		}
	
		return null;
	
	}
	/**
	 * 修改
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable(value="id") int id,String sname,HttpServletResponse response,HttpServletRequest request) throws IOException{
		//设置字符集
		response.setContentType("text/html;charset=UTF-8");
	
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		
		int sum = dao.updateUser(sname, id);
		if(sum !=0){
			out.print("修改成功!");
		}
	
		return null;
	
	}
}
