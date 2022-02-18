package com.mycompany.myweb.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mycompany.myweb.board.model.BoardVO;
import com.mycompany.myweb.commons.Pagination;
import com.mycompany.myweb.commons.Search;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final String NAMESPACE = "com.mycompany.myweb.mappers.board.boardMapper";
	
	@Inject
	private SqlSession sqlSession;

	

	@Override
	public List<BoardVO> getBoardList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".getBoardList" , search);
	}

	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getBoardContent", bid);
    }

	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE +".insertBoard", boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE +".updateBoard" , boardVO);
	}

	@Override
	public int deleteBoard(int bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+ ".deleteBoard" , bid);
	}

	@Override
	public int updateViewCnt(int bid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+".updateViewCnt" , bid);
	}

	@Override
	public int getBoardListCnt(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getBoardListCnt" , search);
	}

}
