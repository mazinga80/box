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
    	//������ ó���ϴ� �ڵ鷯�� AuthenticationSuccessHandler �������̽��� �����Ѵ�. 
    	//Spring Security���� ���� ������ ��ģ �� ������ �����ϸ� onAuthenticationSuccess() �� ȣ���Ѵ�. 
    	//���⿡���� �ܼ��� /index �� �����̷�Ʈ ������ �Ϲ����� ��쿡�� ������ ���� �ʱ�ȭ �۾��̳� �α� ��ϵ��� �۾��� �����ϰ� �ȴ�.
    	log.debug("auth--" + auth.getName());;
    	log.debug("auth--" + auth);;
    	response.sendRedirect(request.getContextPath() + "/boardlist.wiz");
    }
}
