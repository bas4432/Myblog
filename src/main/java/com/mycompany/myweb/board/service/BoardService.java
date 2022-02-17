package com.mycompany.myweb.board.service;

import java.util.List;
import java.util.Map;

import com.mycompany.myweb.board.model.BoardVO;
import com.mycompany.myweb.commons.Pagination;

public interface BoardService {
   
	
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception; //게시글 조회
	
	public void insertBoard(BoardVO boardVO) throws Exception; //글 작성
	
	public BoardVO getBoardContent(int bid) throws Exception; //글 상세 내용
	
	public void updateBoard(BoardVO boardVO) throws Exception; //글 수정 
    
	public void deleteBoard(int bid) throws Exception; // 글 삭제
	
	public int getBoardListCnt() throws Exception; //총 게시글 수 확인
	
	
	
	
	 
	
}
