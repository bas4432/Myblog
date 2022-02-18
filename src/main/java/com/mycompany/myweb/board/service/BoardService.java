package com.mycompany.myweb.board.service;

import java.util.List;
import java.util.Map;

import com.mycompany.myweb.board.model.BoardVO;
import com.mycompany.myweb.commons.Pagination;
import com.mycompany.myweb.commons.Search;

public interface BoardService {
   
	
	public List<BoardVO> getBoardList(Search search) throws Exception; //�Խñ� ��ȸ
	
	public void insertBoard(BoardVO boardVO) throws Exception; //�� �ۼ�
	
	public BoardVO getBoardContent(int bid) throws Exception; //�� �� ����
	
	public void updateBoard(BoardVO boardVO) throws Exception; //�� ���� 
    
	public void deleteBoard(int bid) throws Exception; // �� ����
	
	public int getBoardListCnt(Search search) throws Exception; //�� �Խñ� �� Ȯ��
	
	
	
	
	 
	
}
