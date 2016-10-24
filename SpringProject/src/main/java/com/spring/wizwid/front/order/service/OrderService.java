package com.spring.wizwid.front.order.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public interface OrderService {
	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;
}
