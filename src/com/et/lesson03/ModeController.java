package com.et.lesson03;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * springmvc��Model��ض��� �Ĵ����������صĶ���
 * @ModelAttribute ������ ��������
 * Model �������ݵ���ͼ��request.setAttribute��
 * ModelMap �������ݵ���ͼ
 * Map�������ݵ���ͼ
 * ModelAndView �����ݵ���ͼ����ModelMap��
 * @author Administrator
 *
 */
@Controller
public class ModeController {
	@RequestMapping(value="/case",method=RequestMethod.GET)
	public String case1(Map map ){
		map.put("hello", "���");
		return "/lesson03/test.jsp";
	}
	@RequestMapping(value="/case2",method=RequestMethod.GET)
	public ModelAndView case2( ){
		ModelAndView mav=new ModelAndView("/lesson03/test.jsp");
	//	mav.setViewName("/lesson03/test.jsp");
		mav.addObject("sex", "��");
		return mav;
	}
}
