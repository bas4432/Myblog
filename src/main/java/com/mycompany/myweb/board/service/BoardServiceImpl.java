package com.mycompany.myweb.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mycompany.myweb.board.dao.BoardDAO;
import com.mycompany.myweb.board.model.BoardVO;
import com.mycompany.myweb.commons.Pagination;

@Service
public class BoardServiceImpl implements BoardService{

	
	@Inject //의존성 주입
	private BoardDAO boardDAO;
	
	//게시글 리스트
	@Override
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
	    return boardDAO.getBoardList(pagination);
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

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		System.out.println("수정서비스");
		
		boardDAO.updateBoard(boardVO);
		
		System.out.println("수정서비스1");
		
	}

	@Override
	public void deleteBoard(int bid) throws Exception {
		
		System.out.println("삭제");
		
		boardDAO.deleteBoard(bid);
		
	}

	@Override
	public int getBoardListCnt() throws Exception {
		
		System.out.println("리스트개수");
		// TODO Auto-generated method stub
		return boardDAO.getBoardListCnt();
	}


	
}
