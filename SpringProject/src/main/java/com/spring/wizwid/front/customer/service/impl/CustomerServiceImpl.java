package com.spring.wizwid.front.customer.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.spring.wizwid.front.customer.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="customerDAO")
	private CustomerDAO customerDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String,Object> map) throws Exception
	{
		return customerDAO.selectBoardList(map);
	}
	
	@Override
	public Map<String, Object> getCustomer(Map<String,Object> map) throws Exception
	{
		return customerDAO.getCustomer(map);
	}
}
