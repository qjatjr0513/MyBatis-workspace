package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){
		
		//sqlSession.selectList("??.??", ??);
		// 마이바티스에서는 페이징 처리를 위해 RowBounds라는 클래스를 제공함.
		
		// offset : 몇개의 게시글을 건너뛰고, 조회할것인지에 대한 값.
		// limit  : 조회할 숫자.
		
		int limit  = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() -1) * limit;
		/*
		 * ex) boardLimit가 5일경우
		 * 								offset(건너뛸 숫자)	limit(조회할 숫자)
		 * currentPage : 1 => 1~5			0					5
		 * currentPage : 2 => 6~10			5					5
		 * currentPage : 3 => 11~15			10					5
		 * ...
		 * 
		 * 
		 * 
		 * 
		 */
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		/*
		 * RowBounds 객체를 넘겨야 할경우
		 * selectList메소드의 오버로딩된 형태 중 매개변수가 3개인 메소드를 사용해야함.
		 * 딱히 두번째 매개변수자리에 넘길값이 없다면, null을 넘기면 된다.
		 * 
		 */
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("boardMapper.selectList", null ,rowBounds);
		return list;
		
	}
	
	public Board selectBoard(SqlSession sqlSession, String boardNo){
		 
		return (Board) sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public int increaseCount(SqlSession sqlSession, String boardNo) {
		
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, String boardNo){
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map){
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi){
		
		int limit  = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() -1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
	}
}
