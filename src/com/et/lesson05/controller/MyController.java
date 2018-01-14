package com.et.lesson05.controller;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MyController {
	@RequestMapping(value="/inter",method=RequestMethod.GET)
	public String reg(OutputStream os) throws IOException{
		os.write("hello".getBytes());
		return null;
	}
}
