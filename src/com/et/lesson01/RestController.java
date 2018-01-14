package com.et.lesson01;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * rest设计风格
 * @author Administrator
 *
 */
@Controller
public class RestController {
	/**
	 * 	@RequestMapping("/user/1")可以将1认为是一个参数
	 * 通过{}定义变量
	 * public String index(String userId) 这种传参是获取user/?id 这种方式的
	 * public String index(@PathVariable String userId) 这种获取user/2这种方式
	 * GET:查询
	 */
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public String index(@PathVariable String userId) throws IOException{
		
		return "/lesson01/user.jsp";
	}
	/**
	 * 新增
	 * @return
	 * @throws IOException
	 * 浏览器的提交方式必须和@RequestMapping的指定的资源动作method=RequestMethod.POST一致，不一致会抛出405异常
	 */
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String addUser(String name,HttpServletResponse response) throws IOException{
	
		response.getWriter().println(name+"==add success");
		return null;
	
	}
	/**
	 * 修改
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable String id,HttpServletResponse response) throws IOException{
	
		response.getWriter().println(id+"==update success");
		return null;
	
	}
	/**
	 * 删除
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable String id,HttpServletResponse response) throws IOException{
	
		response.getWriter().println(id+"==delete success");
		return null;
	
	}
}
