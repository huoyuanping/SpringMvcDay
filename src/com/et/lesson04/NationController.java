package com.et.lesson04;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.et.lesson04.entity.UserInfo;

/**
 * 国际化
 * @author Administrator
 *
 */
@Controller
public class NationController {
	//自动装配MessageSource
	@Autowired
	MessageSource ms;
	@RequestMapping(value="/nation",method=RequestMethod.GET)
	public String tes(HttpServletResponse response,OutputStream os,Locale locale) throws NoSuchMessageException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		os.write(ms.getMessage("key", null, locale).getBytes("UTF-8"));
		return null;
	}
	
	/**
	 * 中转
	 * @return
	 */
	@RequestMapping(value="/mid",method=RequestMethod.GET)
	public String mid(){
		
		return "/lesson04/reg.jsp";
	}
	
	@RequestMapping(value="/myregs",method=RequestMethod.POST)
	public String regist(@ModelAttribute("user") @Valid UserInfo user,BindingResult errors){
		if(!user.getPassword().equals(user.getRepassword())){
			errors.addError(new FieldError("user", "password", "两次输入密码不一致"));
		}
		
		if(errors.hasErrors()){
			return "/lesson04/reg.jsp";
		}
		return "/lesson04/suc.jsp";
	
	}

}
