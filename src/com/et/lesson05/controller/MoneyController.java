package com.et.lesson05.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.et.lesson05.dao.MoneyDaoImpl;

@Controller
public class MoneyController {
	/**
	 * ¿ÛÇ®
	 * @return
	 * @throws IOException
	 */
	@Autowired
	MoneyDaoImpl mdi;
	@RequestMapping(value="/tm",method=RequestMethod.GET)
	public String reg(Integer money,OutputStream os,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		mdi.trasnateMoney(money);
		os.write(("Ê£ÓàµÄÇ®Îª £º"+mdi.selectMoney()).getBytes("UTF-8"));
		return null;
	}
}
