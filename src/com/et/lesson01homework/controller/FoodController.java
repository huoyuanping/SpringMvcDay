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
	 * ��ѯ��Ʒ
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
	 * ��ѯ��ϸ��Ϣ
	 */

	@RequestMapping(value="/food/{foodId}",method=RequestMethod.GET)
	public String queryFoodById(@PathVariable String foodId,Model model){
		
		model.addAttribute("myFood",service.FoodById(foodId));
		return "/detail/detailFood.ftl";
	}
	/**
	 * ��Ӳ�Ʒ
	 * @param foodId
	 * @return
	 */
	@RequestMapping(value="food",method=RequestMethod.POST)
	public String addFood(String foodName, String price,MultipartFile imageUrl,Model model){
		//��ȡ�ļ���
		String fileName="/"+imageUrl.getOriginalFilename();
	
		//��ȡ����·��
		String absPath="E:\\���ݿ�\\5.JSP&SRV\\��ѧ���\\apache-tomcat-6.0.45\\webapps\\SpringMvcDay\\image";
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
	 * ɾ����Ʒ
	 * @param foodId
	 * @return
	 */
	@RequestMapping(value="food",method=RequestMethod.GET)
	public String deleteFood(String foodId,Model model){
		
		service.deleteFood(foodId);
		return "/showFood";
	}
	/**
	 * �޸Ĳ�Ʒ
	 */

	@RequestMapping(value="/food/{foodId}",method=RequestMethod.POST)
	public String updateFood(@PathVariable String foodId,String foodName,String price,MultipartFile imageUrl,Model model){
		//��ȡ�ļ���
		String fileName="/"+imageUrl.getOriginalFilename();
		//��ȡ����·��
		String absPath="E:\\���ݿ�\\5.JSP&SRV\\��ѧ���\\apache-tomcat-6.0.45\\webapps\\SpringMvcDay\\image";
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
	 * ����ͼƬ
	 * @throws IOException 
	 */

	@RequestMapping(value="/download",method=RequestMethod.GET)
	public ResponseEntity<byte[]>  downFood(String imagePath) throws IOException{
		String absPath="E:\\���ݿ�\\5.JSP&SRV\\��ѧ���\\apache-tomcat-6.0.45\\webapps\\SpringMvcDay\\image"+imagePath;
		
	    String fileName=imagePath;
	       //��Ҫ���ص�Ŀ���ļ�
	       File file=new File(absPath);
	       //������Ӧͷ
	       HttpHeaders hh=new HttpHeaders();
	       //�������ص��ļ�������
	       hh.setContentDispositionFormData("attachment", URLEncoder.encode(fileName, "UTF-8"));
	       //��ȡĿ���ļ�Ϊ����������
	       byte[] fileByte=FileCopyUtils.copyToByteArray(file);
	       //����ResponseEntity����
	       ResponseEntity<byte[]> re=new ResponseEntity<byte[]>(fileByte, hh, HttpStatus.CREATED);
	       return re;

	}
}
