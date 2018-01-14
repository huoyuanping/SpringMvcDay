package com.et.lesson03;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.et.lesson03.entity.UserInfo;

@Controller
public class RegController {
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping(value="/regs",method=RequestMethod.POST)
	public String regist(@ModelAttribute("user") @Valid UserInfo user,BindingResult errors){
		if(!user.getPassword().equals(user.getRepassword())){
			errors.addError(new FieldError("user", "password", "两次输入密码不一致"));
		}
		/*if(user.getAge()==null || "".equals(user.getAge().trim())){
			errors.addError(new FieldError("userInfo", "age", "年龄不能为空"));
		}else{
			Integer age;
			try {
				age = Integer.parseInt(user.getAge());
				if(age<1 || age>100){
					errors.addError(new FieldError("userInfo", "age", "年龄必须在1-100之间"));
				}
			} catch (Exception e) {
				errors.addError(new FieldError("userInfo", "age", "年龄必须是数字"));
			}
			
		}*/
		if(errors.hasErrors()){
			return "/lesson03/reg.jsp";
		}
		return "/lesson03/suc.jsp";
	
	}
}
