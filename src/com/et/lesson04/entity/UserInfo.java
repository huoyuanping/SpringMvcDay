package com.et.lesson04.entity;



import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



public class UserInfo { 
	/**
	 * NotNull ��������=null
	 * NotEmpty ��������=null && ��������.equals("")
	 */
	@NotEmpty(message="{userErro}")
	private String userName;//�û���
	
	@NotEmpty(message="{psswordErro}")
	private String password;//����
	
	@NotEmpty(message="{reErro}")
	private String repassword;//ȷ������
	
	//xxx@126.com 
	@Pattern(message="{emailErro}",regexp=".+@.+\\..+")

	private String email;//�ʼ�
	
	@NotEmpty(message="{ageErro}")
	@Min(value=1,message="{minErro}")
	@Max(value=100,message="{maxErro}")
	private String age;//����
	
	@Size(min=11,max=11,message="{phoneErro}")
	private String phone;//�ֻ�����
	
	@NotEmpty(message="{netErro}")
	@Pattern(message="{cuoErro}",regexp="(http://|ftp://|https://|www){0,1}[^\u4e00-\u9fa5\\s]*?\\.(com|net|cn|me|tw|fr)[^\u4e00-\u9fa5\\s]*")
	private String net;//������ַ
	
	@Past(message="{dateErro}")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dates;//����
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNet() {
		return net;
	}
	public void setNet(String net) {
		this.net = net;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	

	
	
}
