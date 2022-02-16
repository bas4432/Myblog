package com.mycompany.myweb.board.service;

import java.util.List;
import java.util.Map;

import com.mycompany.myweb.board.model.BoardVO;

public interface BoardService {
   
	
	public List<BoardVO> getBoardList() throws Exception; //게시글 조회
	
	public void insertBoard(BoardVO boardVO) throws Exception;
	 
	
}
