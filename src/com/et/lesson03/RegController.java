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
	 * ע��
	 * @return
	 */
	@RequestMapping(value="/regs",method=RequestMethod.POST)
	public String regist(@ModelAttribute("user") @Valid UserInfo user,BindingResult errors){
		if(!user.getPassword().equals(user.getRepassword())){
			errors.addError(new FieldError("user", "password", "�����������벻һ��"));
		}
		/*if(user.getAge()==null || "".equals(user.getAge().trim())){
			errors.addError(new FieldError("userInfo", "age", "���䲻��Ϊ��"));
		}else{
			Integer age;
			try {
				age = Integer.parseInt(user.getAge());
				if(age<1 || age>100){
					errors.addError(new FieldError("userInfo", "age", "���������1-100֮��"));
				}
			} catch (Exception e) {
				errors.addError(new FieldError("userInfo", "age", "�������������"));
			}
			
		}*/
		if(errors.hasErrors()){
			return "/lesson03/reg.jsp";
		}
		return "/lesson03/suc.jsp";
	
	}
}
