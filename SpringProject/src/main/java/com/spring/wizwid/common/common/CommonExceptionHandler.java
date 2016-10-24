package com.spring.wizwid.common.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.spring.wizwid.front.customer.web.CustomerController;
 
// com.spring 아래에서 발생하는 모든 Exception을 받겠다.
@ControllerAdvice
public class CommonExceptionHandler 
{
	private static final Logger log = LoggerFactory.getLogger(CommonExceptionHandler.class);
    //받아온 exception이 RuntimeException일때 아래 메소드를 실행하겠다.
    //동작하는 구조는 MVC와 동일하다.
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView getRuntimeExceptionHandler(RuntimeException exception){
        ModelAndView view = new ModelAndView();
        view.setViewName("common/error");
        view.addObject("message", exception.getMessage());
        
        log.error("exception.getMessage() : " + exception.getMessage());
        
        return view;
    }

}