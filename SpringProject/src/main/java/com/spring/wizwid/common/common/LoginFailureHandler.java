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
    	//���н� ó���ϴ� �ڵ鷯�� AuthenticationFailureHandler �������̽��� �����Ѵ�. 
    	//Spring Security���� ���� ������ ��ģ �� ������ �����ϸ� onAuthenticationFailure() �� ȣ���Ѵ�. 
    	//���⿡���� �ܼ��� /login �� �����̷�Ʈ ������ �Ϲ����� ��쿡�� �α��� ���п� ���� �α� ��ϵ��� �ϰ� �ȴ�.
    	log.debug("auth--fail" + auth.getMessage());;
    	log.debug("auth--fail" + auth);;
    	response.sendRedirect(request.getContextPath() + "/login.wiz");
    }
}
