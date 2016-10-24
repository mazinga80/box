package com.spring.wizwid.common.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


public class LoginSuccessHandler implements AuthenticationSuccessHandler
{
	private static final Logger log = LoggerFactory.getLogger(LoginSuccessHandler.class);
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException
    {
    	//성공시 처리하는 핸들러는 AuthenticationSuccessHandler 인터페이스를 구현한다. 
    	//Spring Security에서 인증 과정을 거친 후 인증이 성공하면 onAuthenticationSuccess() 를 호출한다. 
    	//여기에서는 단순히 /index 로 리다이렉트 하지만 일반적인 경우에는 계정에 대한 초기화 작업이나 로그 기록등의 작업을 진행하게 된다.
    	log.debug("auth--" + auth.getName());;
    	log.debug("auth--" + auth);;
    	response.sendRedirect(request.getContextPath() + "/boardlist.wiz");
    }
}
