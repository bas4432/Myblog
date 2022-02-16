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

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	

	@Inject
	private BoardService boardService;
	
	@RequestMapping(value ="/getboardList" ,method = RequestMethod.GET) 
	public String getboardList(Model model) throws Exception {
	   
		model.addAttribute("boardList",boardService.getBoardList()); // 게시판 리스트를 boards에 담는다.
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








	

}
