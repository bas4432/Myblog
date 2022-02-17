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

	
	@Inject //������ ����
	private BoardDAO boardDAO;
	
	//�Խñ� ����Ʈ
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
		       boardDAO.updateViewCnt(bid);//��ȸ�� ����
		return boardDAO.getBoardContent(bid);
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		System.out.println("��������");
		
		boardDAO.updateBoard(boardVO);
		
		System.out.println("��������1");
		
	}

	@Override
	public void deleteBoard(int bid) throws Exception {
		
		System.out.println("����");
		
		boardDAO.deleteBoard(bid);
		
	}

	@Override
	public int getBoardListCnt() throws Exception {
		
		System.out.println("����Ʈ����");
		// TODO Auto-generated method stub
		return boardDAO.getBoardListCnt();
	}


	
}
