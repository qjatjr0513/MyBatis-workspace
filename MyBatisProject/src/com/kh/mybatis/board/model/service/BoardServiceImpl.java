package com.kh.mybatis.board.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

import static com.kh.mybatis.common.template.Template.*;

import java.util.ArrayList;
import java.util.HashMap;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = getSqlSession();
		
		int listCount = boardDao.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}
	
	@Override
	public ArrayList<Board> selectList(PageInfo pi){
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = boardDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
		
		
	}
	@Override
	public Board selectBoard(String boardNo){
		SqlSession sqlSession = getSqlSession();
		
		Board b = boardDao.selectBoard(sqlSession, boardNo);
		
		sqlSession.close();
		
		return b;
	}
	
	@Override
	public int increaseCount(String boardNo) {
		SqlSession sqlSession = getSqlSession();
		
		int result = boardDao. increaseCount(sqlSession, boardNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public ArrayList<Reply> selectReplyList(String boardNo){
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Reply> list = boardDao.selectReplyList(sqlSession, boardNo);
		
		sqlSession.close();
		
		return list;
	}
	
	@Override
	public int selectSearchCount(HashMap map){
		SqlSession sqlSession = getSqlSession();
		
		int count = boardDao.selectSearchCount(sqlSession, map);
		
		sqlSession.close();
		
		return count;
	}
	
	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi){
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = boardDao. selectSearchList(sqlSession, map, pi);
		
		sqlSession.close();
		
		return list;
	}
}
