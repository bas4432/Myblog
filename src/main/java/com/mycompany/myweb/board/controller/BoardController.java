package com.mycompany.myweb.board.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.myweb.board.model.BoardVO;
import com.mycompany.myweb.board.service.BoardService;
import com.mycompany.myweb.commons.Pagination;


@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	

	@Inject
	private BoardService boardService;
	
	@RequestMapping(value ="/getboardList" ,method = RequestMethod.GET) 
	public String getboardList(Model model, 
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range
//			@RequestParam(required = false, defaultValue = "title") String searchType,
//			@RequestParam(required = false) String Keyword
			) throws Exception                                                    
	 {
		
		logger.info("보트리스트");
		
		//전체 게시글 개수
		int listCnt = boardService.getBoardListCnt();
		
		logger.info("listCNT" + listCnt);
		
		//pagination 객체 생성
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);
		
		model.addAttribute("pagination" , pagination);
	   
		model.addAttribute("boardList",boardService.getBoardList(pagination)); // 게시판 리스트를 boards에 담는다.
		return "board/index"; 
			   
	}
	
	@RequestMapping(value = "/boardForm", method = RequestMethod.GET)
	public String writeGET() {

		logger.info("write GET...");

		return "/board/boardForm";
	}
	
	@RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
    public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO , RedirectAttributes rttr) throws Exception {
		
		//@ModelAttribute("BoardVO")생략가능

		boardService.insertBoard(boardVO);
		logger.info("save GET...");
       
		return "redirect:/board/getboardList";

	}
	
	@RequestMapping(value = "/getboardContent", method = RequestMethod.GET)
    public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception {
		
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
	   
		return "board/boardContent";

	}
	
	@RequestMapping(value = "/getboardModify", method = RequestMethod.GET)
    public String getBoardModify(BoardVO boardVO ,Model model, @RequestParam("bid") int bid) throws Exception {
		logger.info("값 확인::" + boardVO.content);
		
		
		model.addAttribute("boardContent", boardService.getBoardContent(bid));
	   
		return "board/boardModify";

	}
	
	@RequestMapping(value = "/postboardModify", method = RequestMethod.POST)
    public String getBoardModify(BoardVO boardVO, RedirectAttributes rttr) throws Exception {
		
		
		
		boardService.updateBoard(boardVO);
		
		
	   
		return "redirect:/board/getboardList";

	}
	
	@RequestMapping(value = "/deleteboard", method = RequestMethod.POST)
    public String getBoardDelete(@RequestParam("bid") int bid, RedirectAttributes rttr) throws Exception {
		
		logger.info("삭제");
		boardService.deleteBoard(bid);
		logger.info("삭제2");
	   
		return "redirect:/board/getboardList";

	}
	
	
	
	








	

}
