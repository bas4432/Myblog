package com.mycompany.myweb.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mycompany.myweb.board.dao.BoardDAO;
import com.mycompany.myweb.board.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	
	@Inject //의존성 주입
	private BoardDAO boardDAO;
	
	//게시글 리스트
	@Override
	public List<BoardVO> getBoardList() throws Exception {
		// TODO Auto-generated method stub
	    return boardDAO.getBoardList();
	}

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		
		boardDAO.insertBoard(boardVO);
		
	}

	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		// TODO Auto-generated method stub
		       boardDAO.updateViewCnt(bid);//조회수 증가
		return boardDAO.getBoardContent(bid);
	}


	
}
