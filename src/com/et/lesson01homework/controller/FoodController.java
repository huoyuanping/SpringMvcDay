package com.et.lesson01homework.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.et.lesson01homework.service.FoodService;
import com.et.lesson01homework.utils.PageTools;

@Controller
public class FoodController {
	/**
	 * 查询菜品
	 */
	@Autowired
	FoodService service;
	@RequestMapping(value="/showFood",method=RequestMethod.GET)
	public String queryFoodAll(String foodName,Integer curPage,Model model){
		if(curPage==null){
			curPage=1;
		}
		PageTools list=service.queryFoodAll(foodName,curPage);
		//request.setAttribute("","",)
		model.addAttribute("foodList", list);
		return "/detail/foodList.jsp";
	}
	/**
	 * 查询详细信息
	 */

	@RequestMapping(value="/food/{foodId}",method=RequestMethod.GET)
	public String queryFoodById(@PathVariable String foodId,Model model){
		
		model.addAttribute("myFood",service.FoodById(foodId));
		return "/detail/detailFood.ftl";
	}
	/**
	 * 添加菜品
	 * @param foodId
	 * @return
	 */
	@RequestMapping(value="food",method=RequestMethod.POST)
	public String addFood(String foodName, String price,MultipartFile imageUrl,Model model){
		//获取文件名
		String fileName="/"+imageUrl.getOriginalFilename();
	
		//获取绝对路径
		String absPath="E:\\数据库\\5.JSP&SRV\\教学软件\\apache-tomcat-6.0.45\\webapps\\SpringMvcDay\\image";
		try {
			imageUrl.transferTo(new File(absPath+"\\"+fileName));
			service.saveFood(foodName, price, fileName);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return queryFoodAll(foodName, 1, model);
	}
	/**
	 * 删除菜品
	 * @param foodId
	 * @return
	 */
	@RequestMapping(value="food",method=RequestMethod.GET)
	public String deleteFood(String foodId,Model model){
		
		service.deleteFood(foodId);
		return "/showFood";
	}
	/**
	 * 修改菜品
	 */

	@RequestMapping(value="/food/{foodId}",method=RequestMethod.POST)
	public String updateFood(@PathVariable String foodId,String foodName,String price,MultipartFile imageUrl,Model model){
		//获取文件名
		String fileName="/"+imageUrl.getOriginalFilename();
		//获取绝对路径
		String absPath="E:\\数据库\\5.JSP&SRV\\教学软件\\apache-tomcat-6.0.45\\webapps\\SpringMvcDay\\image";
		try {
			imageUrl.transferTo(new File(absPath+"\\"+fileName));
			service.updateFood(foodId, foodName, price, fileName);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return queryFoodAll(foodName, 1, model);
	}
	/**
	 * 下载图片
	 * @throws IOException 
	 */

	@RequestMapping(value="/download",method=RequestMethod.GET)
	public ResponseEntity<byte[]>  downFood(String imagePath) throws IOException{
		String absPath="E:\\数据库\\5.JSP&SRV\\教学软件\\apache-tomcat-6.0.45\\webapps\\SpringMvcDay\\image"+imagePath;
		
	    String fileName=imagePath;
	       //需要下载的目标文件
	       File file=new File(absPath);
	       //设置响应头
	       HttpHeaders hh=new HttpHeaders();
	       //设置下载的文件的名称
	       hh.setContentDispositionFormData("attachment", URLEncoder.encode(fileName, "UTF-8"));
	       //读取目标文件为二进制数组
	       byte[] fileByte=FileCopyUtils.copyToByteArray(file);
	       //构建ResponseEntity对象
	       ResponseEntity<byte[]> re=new ResponseEntity<byte[]>(fileByte, hh, HttpStatus.CREATED);
	       return re;

	}
}
