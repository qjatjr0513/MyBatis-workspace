package com.kh.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public interface BoardService {
	
	// 게시글 리스트 조회
	int selectListCount();
	
	ArrayList<Board> selectList(PageInfo pi);
	
	Board selectBoard(String boardNo);
	
	int increaseCount(String boardNo);
	
	ArrayList<Reply> selectReplyList(String boardNo);
	
	int selectSearchCount(HashMap<String, String> map);
	ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);
}
