package com.spring.wizwid.front.order.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.wizwid.common.dao.AbstractDAO;

@Repository("orderDAO")
public class OrderDAO extends AbstractDAO
{
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String,Object> map)
	{
		return (List<Map<String, Object>>)selectList("order.selectBoardList", map);
	}
}
