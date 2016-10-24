package com.spring.wizwid.front.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.wizwid.common.dao.AbstractDAO;

@Repository("boardDAO")
public class BoardDAO extends AbstractDAO
{
	//글목록
	/*
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String,Object> map)
	{
		return (List<Map<String, Object>>)selectList("board.selectBoardList", map);
	}
	*/
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception{
	    return (List<Map<String, Object>>)selectPagingList("board.selectBoardList", map);
	}

	
	//글등록
	public void insertBoard(Map<String, Object> map) throws Exception{
	    insert("board.insertBoard", map);
	}
	
	//첨부파일등록
	public void insertFile(Map<String, Object> map) throws Exception{
		insert("board.insertFile", map);
	}
	
	public void updateHitCnt(Map<String, Object> map) throws Exception{
		update("board.updateHitCnt", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectOne("board.selectBoardDetail", map);
	}

	public void updateBoard(Map<String, Object> map) throws Exception{
		update("board.updateBoard", map);
	}

	public void deleteBoard(Map<String, Object> map) throws Exception{
		update("board.deleteBoard", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("board.selectFileList", map);
	}

	public void deleteFileList(Map<String, Object> map) throws Exception{
		update("board.deleteFileList", map);
	}

	public void updateFile(Map<String, Object> map) throws Exception{
		update("board.updateFile", map);
	}
}
