package com.et.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	@RequestMapping(value="/viewResover",method=RequestMethod.GET)
	public String view(){
		return "lesson04/result";
	}

}
