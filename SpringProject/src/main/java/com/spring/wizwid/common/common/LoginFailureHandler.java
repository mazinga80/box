package com.spring.wizwid.common.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


public class LoginFailureHandler implements AuthenticationFailureHandler
{
	private static final Logger log = LoggerFactory.getLogger(LoginFailureHandler.class);
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException auth) throws IOException, ServletException
    {
    	//실패시 처리하는 핸들러는 AuthenticationFailureHandler 인터페이스를 구현한다. 
    	//Spring Security에서 인증 과정을 거친 후 인증이 실패하면 onAuthenticationFailure() 를 호출한다. 
    	//여기에서는 단순히 /login 로 리다이렉트 하지만 일반적인 경우에는 로그인 실패에 대한 로그 기록등을 하게 된다.
    	log.debug("auth--fail" + auth.getMessage());;
    	log.debug("auth--fail" + auth);;
    	response.sendRedirect(request.getContextPath() + "/login.wiz");
    }
}
