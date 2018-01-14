package com.et.lesson01;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	/**
	 * 映射只需在方法前加@RequestMapping
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/test")
	public String index(HttpServletRequest request,HttpServletResponse response ) throws IOException{
		response.getWriter().println("hello"+"---------"+request.getParameter("id"));
		return null;
	}
	/**
	 * 降耦合 直接加参数
	 * 如果参数多的情况下用对象的方式 例如：Uesr user
	 * springMVC中一个路径和方法的映射叫action（动作）
	 * return "/index.jsp"表示一执行完就跳会jsp页面 默认是请求转发
	 * return "forwar d:/index.jsp";请求转发
	 * return "redict:/index.jsp";重定向
	 * @param request
	 * @param response
	 * @return 返回视图路径
	 * @throws IOException
	 */
	@RequestMapping("/param")
	public String param(User user,HttpServletResponse response ) throws IOException{
		response.getWriter().println(user.getId()+"---"+user.getName());
		return null;
	}
	@RequestMapping("/mvc")
	public String mvc(User user,HttpServletRequest request) throws IOException{
		request.setAttribute("name", "张三");
		
		return "/index.jsp";
	}
}
