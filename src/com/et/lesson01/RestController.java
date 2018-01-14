package com.et.lesson01;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * rest��Ʒ��
 * @author Administrator
 *
 */
@Controller
public class RestController {
	/**
	 * 	@RequestMapping("/user/1")���Խ�1��Ϊ��һ������
	 * ͨ��{}�������
	 * public String index(String userId) ���ִ����ǻ�ȡuser/?id ���ַ�ʽ��
	 * public String index(@PathVariable String userId) ���ֻ�ȡuser/2���ַ�ʽ
	 * GET:��ѯ
	 */
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public String index(@PathVariable String userId) throws IOException{
		
		return "/lesson01/user.jsp";
	}
	/**
	 * ����
	 * @return
	 * @throws IOException
	 * ��������ύ��ʽ�����@RequestMapping��ָ������Դ����method=RequestMethod.POSTһ�£���һ�»��׳�405�쳣
	 */
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String addUser(String name,HttpServletResponse response) throws IOException{
	
		response.getWriter().println(name+"==add success");
		return null;
	
	}
	/**
	 * �޸�
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable String id,HttpServletResponse response) throws IOException{
	
		response.getWriter().println(id+"==update success");
		return null;
	
	}
	/**
	 * ɾ��
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable String id,HttpServletResponse response) throws IOException{
	
		response.getWriter().println(id+"==delete success");
		return null;
	
	}
}
