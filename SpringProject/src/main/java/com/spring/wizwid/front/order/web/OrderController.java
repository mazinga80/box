package com.spring.wizwid.front.order.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.wizwid.front.order.service.OrderService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Resource(name="orderService")
    private OrderService orderService;
     
    @RequestMapping(value="/order/openSampleBoardList.wiz")
    public ModelAndView openSampleBoardList(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/order/boardList");
         
        List<Map<String,Object>> list = orderService.selectBoardList(commandMap);
        mv.addObject("list", list);
         
        //throw new RuntimeException("¿À·ù´å!!!!!!!!");
        return mv;
    }

	
}

