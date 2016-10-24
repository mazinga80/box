package com.spring.wizwid.front.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
	
	//글 목록
	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;
		
	//글 등록
	void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception;
	
	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;

	void updateBoard(Map<String, Object> map, HttpServletRequest request) throws Exception;

	void deleteBoard(Map<String, Object> map) throws Exception;

}
