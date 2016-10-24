package com.spring.wizwid.front.board.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.wizwid.common.common.CommandMap;
import com.spring.wizwid.front.board.service.BoardService;

@Controller
public class BoardController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="boardService")
    private BoardService boardService;
	
	//글 목록
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/boardlist.wiz")
	public ModelAndView getBoardList(Map<String, Object> map) throws Exception
	{
		ModelAndView mv = new ModelAndView("/board/boardList");
		 
		return mv;
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/boardlistjson.wiz")
	public ModelAndView selectBoardList(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("jsonView");
	     
	    List<Map<String,Object>> list = boardService.selectBoardList(commandMap.getMap());
	    mv.addObject("list", list);
	    if(list.size() > 0){
	        mv.addObject("TOTAL", list.get(0).get("TOTAL_COUNT"));
	    }
	    else{
	        mv.addObject("TOTAL", 0);
	    }
	     
	    return mv;
	}
	
	//글 쓰기 페이지로 이동
	@RequestMapping(value="/boardwrite.wiz")
	public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/board/boardWrite");
	     
	    return mv;
	}
	
	//글 등록 페이지
	@RequestMapping(value="/insertboard.wiz")
	public ModelAndView insertBoard(CommandMap commandMap, HttpServletRequest request) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/boardlist.wiz");
	     
	    boardService.insertBoard(commandMap.getMap(), request);
	    
	    return mv;
	}
	
	@RequestMapping(value="/boarddetail.wiz")
	public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		
		/* map 값을 찍어보기 위해 ...
		Set<String> keySet = commandMap.getMap().keySet();
		Iterator<String> iterator = keySet.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object value = commandMap.getMap().get(key);
			System.out.printf("key : %s , value : %s %n", key, value);
		}
		*/
		
		Map<String,Object> map = boardService.selectBoardDetail(commandMap.getMap());
		mv.addObject("map", map.get("map"));
		mv.addObject("list", map.get("list"));
		
		return mv;
	}
	
	@RequestMapping(value="/boardupdate.wiz")
	public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardUpdate");
		
		Map<String,Object> map = boardService.selectBoardDetail(commandMap.getMap());
		mv.addObject("map", map.get("map"));
		mv.addObject("list", map.get("list"));
		
		return mv;
	}
	
	@RequestMapping(value="/updateboard.wiz")
	public ModelAndView updateBoard(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/boarddetail.wiz");
		
		boardService.updateBoard(commandMap.getMap(), request);
		
		mv.addObject("IDX", commandMap.get("IDX"));
		return mv;
	}
	
	@RequestMapping(value="/deleteboard.wiz")
	public ModelAndView deleteBoard(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("redirect:/boardlist.wiz");
		
		boardService.deleteBoard(commandMap.getMap());
		
		return mv;
	}
	



}
