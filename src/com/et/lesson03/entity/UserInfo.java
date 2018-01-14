package com.et.lesson03.entity;



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
	 * NotNull 属性名！=null
	 * NotEmpty 属性名！=null && ！属性名.equals("")
	 */
	@NotEmpty(message="用户名不能为空")
	private String userName;//用户名
	
	@NotEmpty(message="密码不能为空")
	private String password;//密码
	
	@NotEmpty(message="再次输入密码不能为空")
	private String repassword;//确认密码
	
	//xxx@126.com 
	@Pattern(message="邮箱格式错误",regexp=".+@.+\\..+")

	private String email;//邮件
	
	@NotEmpty(message="年龄不能为空")
	@Min(value=1,message="年龄必须大于1")
	@Max(value=100,message="年龄必须小于100")
	private String age;//年龄
	
	@Size(min=11,max=11,message="手机号码必须是11位")
	private String phone;//手机号码
	
	@NotEmpty(message="网址不能为空")
	@Pattern(message="网址格式错误",regexp="(http://|ftp://|https://|www){0,1}[^\u4e00-\u9fa5\\s]*?\\.(com|net|cn|me|tw|fr)[^\u4e00-\u9fa5\\s]*")
	private String net;//个人网址
	
	@Past(message="日期格式不正确，必须是一个过去的日期")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dates;//日期
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
