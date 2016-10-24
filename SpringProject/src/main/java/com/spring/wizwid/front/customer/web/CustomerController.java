package com.spring.wizwid.front.customer.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.wizwid.common.common.CustomUserDetails;

/** 
 * Handles requests for the application home page.
 */
@Controller
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	/**
     * Simply selects the home view to render by returning its name.
     */
	public CustomUserDetails getUser()
    {
        return (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
	 
    //@RequestMapping(value = "/login.wiz")
    //public void login(HttpSession session) {
    // 	log.info("Welcome login! {}", session.getId());
    //}
    
    @RequestMapping(value = "/login.wiz", method = RequestMethod.GET)
    public ModelAndView login()
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("/customer/login");
        
        return view;
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index()
    {
        ModelAndView view = new ModelAndView();
        view.setViewName("home");
        view.addObject("username", getUser().getUsername());
        
        return view;
    }
     
    @RequestMapping(value = "/logout.wiz")
    public void logout(HttpSession session) {
        CustomUserDetails userDetails = (CustomUserDetails)session.getAttribute("userLoginInfo");
         
        log.info("Welcome logout! {}, {}", session.getId(), userDetails.getUsername());
        session.invalidate();
    }
     
    @RequestMapping(value = "/login_success.wiz")
    public void login_success(HttpSession session) {
        CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
         
        log.info("Welcome login_success! {}, {}", session.getId(), userDetails.getUsername() + "/" + userDetails.getPassword());
        session.setAttribute("userLoginInfo", userDetails);
    }
     
    @RequestMapping(value = "page1")
    public void page1() {       
    }
     
    @RequestMapping(value = "/login_duplicate.wiz")
    public void login_duplicate() {     
    	log.info("Welcome login_duplicate!");
    }
}

