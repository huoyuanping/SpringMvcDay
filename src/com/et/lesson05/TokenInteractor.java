package com.et.lesson05;
/**
 * ����������ʵ�ֽӿ�HandlerInterceptor
 * ��ֹ�ظ��ύ
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
		//��ȡ����myToken
		String myToken=request.getParameter("myToken");
		//��session�л�ȡmyToken
		Object myToken1=request.getSession().getAttribute("myToken");
		//��Ҫ��֤�ظ��ύ
		if(myToken!=null){
			//�ظ��ύ
			if(myToken1==null){
				return false;
			}else{
				if(myToken.equals(myToken1)){//��һ���ύ
					//�ɹ�֮�����session��myToken
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
