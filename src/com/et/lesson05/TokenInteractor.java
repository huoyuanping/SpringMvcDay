package com.et.lesson05;
/**
 * 拦截器必须实现接口HandlerInterceptor
 * 防止重复提交
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TokenInteractor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		

	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//获取参数myToken
		String myToken=request.getParameter("myToken");
		//从session中获取myToken
		Object myToken1=request.getSession().getAttribute("myToken");
		//需要验证重复提交
		if(myToken!=null){
			//重复提交
			if(myToken1==null){
				return false;
			}else{
				if(myToken.equals(myToken1)){//第一次提交
					//成功之后清除session中myToken
					request.getSession().removeAttribute("myToken");
					return true;
				}else {
					return false;
				}
			}
			
		}else{
			return true;
		}
	}

}
