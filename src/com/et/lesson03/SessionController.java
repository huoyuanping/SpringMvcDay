package com.et.lesson03;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.et.lesson01.User;
@SessionAttributes("user")
@Controller
public class SessionController {
	@ModelAttribute("user")
	public User getUser(){
		User user=new User();
		return user;
	}
	/**
	 * http://localhost:8080/SpringMvcDay/s1?id=1
	 * ����ת��(Ĭ�� ����ʽ���ı�   һ������)forward:����Ҫ�κδ���
	 * �����ض�����������redirect: ʹ��SessionAttributes�������ض����д�ֵ��ֵ����session�������ס���
	 * @SessionAttributes("Ҫ�����ģ�Ͷ���")��������
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(@ModelAttribute("user") User user ){
		//ģ�Ͳ�����ݲ��ɹ���
		//map.put("age", 15);
		//return "forward:/s2";
		return "redirect:/s2";
	}
	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2(String id ,Map map,HttpServletResponse response,SessionStatus status) throws IOException{
		User user= (User)map.get("user");
		response.getWriter().println(user.getId());
		//�ر�session
		status.setComplete();
		return null;
	}
}
