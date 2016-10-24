package com.spring.wizwid.common.servlet;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class ServletListener implements ServletContextListener, ServletContextAttributeListener {
	Logger log = Logger.getLogger(this.getClass());
	public void contextInitialized(ServletContextEvent e) {
		// ��Ĺ�� ������ �� ����ȴ�.
		log.debug("ServletContext �� �ʱ�ȭ �Ǿ����ϴ�.");
		log.debug("init context = " + e.getServletContext());
	}
	public void contextDestroyed(ServletContextEvent e) {
		// ��Ĺ�� ����� �� ����ȴ�.		
		log.debug("ServletContext �� �Ҹ� �Ǿ����ϴ�.");
		log.debug("dest context = " + e.getServletContext());
	}
	public void attributeAdded(ServletContextAttributeEvent e) {
        // ServletContext ��ü�� �Ӽ��� ���� �߰��� �� ����ȴ�.
		log.debug("Context ������ ���� �߰� �Ǿ����ϴ�.");
		log.debug("added = " + e.getName() + " : " + e.getValue());
	}
	public void attributeRemoved(ServletContextAttributeEvent e) {
        // ServletContext ��ü�� �Ӽ��� ������ �� ����ȴ�.
		log.debug("Context ������ ���� ���� �Ǿ����ϴ�.");
		log.debug("removed = " + e.getName() + " : " + e.getValue());
	}
	public void attributeReplaced(ServletContextAttributeEvent e) {
        // ServletContext ��ü�� �Ӽ��� ������ �� ���� ������ ����ȴ�.
		log.debug("Context ������ ���� ���� �Ǿ����ϴ�.");
		log.debug("replaced = " + e.getName() + " : " + e.getValue());		
	}	
}
