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
	 * 请求转发(默认 请求方式不改变   一次请求)forward:不需要任何处理
	 * 请求重定向（两次请求）redirect: 使用SessionAttributes用于在重定向中传值将值存在session中用完记住清除
	 * @SessionAttributes("要共享的模型对象")共享数据
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(@ModelAttribute("user") User user ){
		//模型层的数据不可共享
		//map.put("age", 15);
		//return "forward:/s2";
		return "redirect:/s2";
	}
	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2(String id ,Map map,HttpServletResponse response,SessionStatus status) throws IOException{
		User user= (User)map.get("user");
		response.getWriter().println(user.getId());
		//关闭session
		status.setComplete();
		return null;
	}
}
