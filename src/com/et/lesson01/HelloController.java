package com.et.lesson01;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	/**
	 * ӳ��ֻ���ڷ���ǰ��@RequestMapping
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
	 * ����� ֱ�ӼӲ���
	 * ����������������ö���ķ�ʽ ���磺Uesr user
	 * springMVC��һ��·���ͷ�����ӳ���action��������
	 * return "/index.jsp"��ʾһִ���������jspҳ�� Ĭ��������ת��
	 * return "forwar d:/index.jsp";����ת��
	 * return "redict:/index.jsp";�ض���
	 * @param request
	 * @param response
	 * @return ������ͼ·��
	 * @throws IOException
	 */
	@RequestMapping("/param")
	public String param(User user,HttpServletResponse response ) throws IOException{
		response.getWriter().println(user.getId()+"---"+user.getName());
		return null;
	}
	@RequestMapping("/mvc")
	public String mvc(User user,HttpServletRequest request) throws IOException{
		request.setAttribute("name", "����");
		
		return "/index.jsp";
	}
}
