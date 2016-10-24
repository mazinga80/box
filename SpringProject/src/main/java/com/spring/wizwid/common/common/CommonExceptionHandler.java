package com.spring.wizwid.common.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.spring.wizwid.front.customer.web.CustomerController;
 
// com.spring �Ʒ����� �߻��ϴ� ��� Exception�� �ްڴ�.
@ControllerAdvice
public class CommonExceptionHandler 
{
	private static final Logger log = LoggerFactory.getLogger(CommonExceptionHandler.class);
    //�޾ƿ� exception�� RuntimeException�϶� �Ʒ� �޼ҵ带 �����ϰڴ�.
    //�����ϴ� ������ MVC�� �����ϴ�.
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView getRuntimeExceptionHandler(RuntimeException exception){
        ModelAndView view = new ModelAndView();
        view.setViewName("common/error");
        view.addObject("message", exception.getMessage());
        
        log.error("exception.getMessage() : " + exception.getMessage());
        
        return view;
    }

}