package com.spring.wizwid.front.customer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.wizwid.common.dao.AbstractDAO;

@Repository("customerDAO")
public class CustomerDAO extends AbstractDAO
{
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String,Object> map)
	{
		return (List<Map<String, Object>>)selectList("order.selectBoardList", map);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getCustomer(Map<String,Object> map)
	{
		return (Map<String, Object>)selectOne("customer.getCustomer", map);
	}
}
