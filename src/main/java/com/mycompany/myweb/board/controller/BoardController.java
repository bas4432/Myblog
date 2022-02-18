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
import com.mycompany.myweb.commons.Search;


@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	

	@Inject
	private BoardService boardService;
	
	@RequestMapping(value ="/getboardList" ,method = RequestMethod.GET) 
	public String getboardList(Model model, 
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String keyword
			) throws Exception {
		
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		logger.info("��Ʈ����Ʈ");
		
		//��ü �Խñ� ����
		int listCnt = boardService.getBoardListCnt(search);
		
		
		logger.info("listCnt===" + listCnt);
		
		
		
		
		//pagination ��ü ����
		Pagination pagination = new Pagination();
		
	
		
		
		search.pageInfo(page, range, listCnt);
		
		logger.info("pageCnt=��ü ������ ��=" + pagination.getPageCnt());
		logger.info("startPage=���� ������=" + pagination.getStartPage());
		logger.info("endPage=��������=" + pagination.getEndPage());
		logger.info("startList=�Խ��� ���� ��ȣ=" + pagination.getStartList());
		logger.info("range=���� ������ ���� ����=" + pagination.getRange());
		logger.info("getListCnt==" + pagination.getListCnt());
		
		
		
		
		model.addAttribute("pagination" , search);
	   
		model.addAttribute("boardList",boardService.getBoardList(search)); // �Խ��� ����Ʈ�� boards�� ��´�.
		return "board/index"; 
			   
	}
	
	@RequestMapping(value = "/boardForm", method = RequestMethod.GET)
	public String writeGET() {

		logger.info("write GET...");

		return "/board/boardForm";
	}
	
	@RequestMapping(value = "/saveBoard", method = RequestMethod.POST)
    public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO , RedirectAttributes rttr) throws Exception {
		
		//@ModelAttribute("BoardVO")��������

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
		logger.info("�� Ȯ��::" + boardVO.content);
		
		
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
		
		logger.info("����");
		boardService.deleteBoard(bid);
		logger.info("����2");
	   
		return "redirect:/board/getboardList";

	}
	
	
	
	








	

}
