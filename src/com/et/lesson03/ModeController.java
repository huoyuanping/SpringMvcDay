package com.et.lesson03;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * springmvc中Model相关对象 的处理和数据相关的对象
 * @ModelAttribute 重命名 参数数据
 * Model 传递数据到视图（request.setAttribute）
 * ModelMap 传递数据到视图
 * Map传递数据到视图
 * ModelAndView 绑定数据到视图。（ModelMap）
 * @author Administrator
 *
 */
@Controller
public class ModeController {
	@RequestMapping(value="/case",method=RequestMethod.GET)
	public String case1(Map map ){
		map.put("hello", "你好");
		return "/lesson03/test.jsp";
	}
	@RequestMapping(value="/case2",method=RequestMethod.GET)
	public ModelAndView case2( ){
		ModelAndView mav=new ModelAndView("/lesson03/test.jsp");
	//	mav.setViewName("/lesson03/test.jsp");
		mav.addObject("sex", "男");
		return mav;
	}
}
