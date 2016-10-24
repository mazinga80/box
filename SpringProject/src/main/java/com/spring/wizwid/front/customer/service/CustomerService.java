package com.spring.wizwid.front.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public interface CustomerService {
	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;
	
	Map<String, Object> getCustomer(Map<String, Object> map) throws Exception;
}
