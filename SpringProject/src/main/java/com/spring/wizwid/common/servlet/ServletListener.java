package com.spring.wizwid.common.servlet;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class ServletListener implements ServletContextListener, ServletContextAttributeListener {
	Logger log = Logger.getLogger(this.getClass());
	public void contextInitialized(ServletContextEvent e) {
		// 톰캣이 구동될 때 실행된다.
		log.debug("ServletContext 가 초기화 되었습니다.");
		log.debug("init context = " + e.getServletContext());
	}
	public void contextDestroyed(ServletContextEvent e) {
		// 톰캣이 종료될 때 실행된다.		
		log.debug("ServletContext 가 소멸 되었습니다.");
		log.debug("dest context = " + e.getServletContext());
	}
	public void attributeAdded(ServletContextAttributeEvent e) {
        // ServletContext 객체에 속성이 새로 추가될 때 실행된다.
		log.debug("Context 영역에 값이 추가 되었습니다.");
		log.debug("added = " + e.getName() + " : " + e.getValue());
	}
	public void attributeRemoved(ServletContextAttributeEvent e) {
        // ServletContext 객체의 속성이 삭제될 때 실행된다.
		log.debug("Context 영역에 값이 삭제 되었습니다.");
		log.debug("removed = " + e.getName() + " : " + e.getValue());
	}
	public void attributeReplaced(ServletContextAttributeEvent e) {
        // ServletContext 객체의 속성이 수정될 때 수정 직전에 실행된다.
		log.debug("Context 영역에 값이 변경 되었습니다.");
		log.debug("replaced = " + e.getName() + " : " + e.getValue());		
	}	
}
