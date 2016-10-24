package com.spring.wizwid.front.order.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.spring.wizwid.front.order.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="orderDAO")
	private OrderDAO orderDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String,Object> map) throws Exception
	{
		return orderDAO.selectBoardList(map);
	}
}
