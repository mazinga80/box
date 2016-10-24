package com.spring.wizwid.front.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.wizwid.common.util.FileUtils;
import com.spring.wizwid.front.board.service.BoardService;

@Service("boardService")
public class BoardServiceImpl  implements BoardService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	//글목록
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String,Object> map) throws Exception
	{
		return boardDAO.selectBoardList(map);
	}
	
	//글등록
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		boardDAO.insertBoard(map);
		
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map, request);
		for(int i=0, size=list.size(); i<size; i++){
        	log.debug("list.get(i)===>"+list.get(i));
        	boardDAO.insertFile(list.get(i));
        }
		
		/*
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		while(iterator.hasNext()){
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false){
				log.debug("------------- file start -------------");
				log.debug("name : "+multipartFile.getName());
				log.debug("filename : "+multipartFile.getOriginalFilename());
				log.debug("size : "+multipartFile.getSize());
				log.debug("-------------- file end --------------\n");
		    }
		}
		*/
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		boardDAO.updateHitCnt(map);
		Map<String, Object> resultMap = new HashMap<String,Object>();
		Map<String, Object> tempMap = boardDAO.selectBoardDetail(map);
		resultMap.put("map", tempMap);
		
		List<Map<String,Object>> list = boardDAO.selectFileList(map);
		resultMap.put("list", list);
		
		return resultMap;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updateBoard(Map<String, Object> map, HttpServletRequest request) throws Exception{
		boardDAO.updateBoard(map);
		
		boardDAO.deleteFileList(map);
		
		List<Map<String,Object>> list = fileUtils.parseUpdateFileInfo(map, request);
		Map<String,Object> tempMap = null;
		for(int i=0, size=list.size(); i<size; i++){
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")){
				boardDAO.insertFile(tempMap);
			}
			else{
				boardDAO.updateFile(tempMap);
			}
		}
	}

	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
		boardDAO.deleteBoard(map);
	}

}
