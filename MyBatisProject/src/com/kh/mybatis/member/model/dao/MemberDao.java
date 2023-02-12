package com.kh.mybatis.member.model.dao;


import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, Member m) {
		
//		int result = 0;
//		PreparedStatement psmt = null;
//		String sql = prop.getProperty("insertMember");
//		
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, m.getUserId());
//			...
//			result = psmt.excuteUpdate();
//		} finally{
//			close();		
//	}
		/*
		 * sqlSession에서 제공하는 메소드를 통해서 sql문을 찾아서 실행하고 결과를 바로 받아볼수 있다.
		 * 
		 * sqlSession.sql문 종류에 맞는 메소드("mapper파일의 namespace.해당sql문의 고유한id", sql문을 완성시킬 객체);
		 * => 해당 sql문이 미완성된 상태가 아니라면 sql문을 완성시킬 객체는 생략 가능.
		 * 
		 */
		return sqlSession.insert("memberMapper.insertMember", m);
	}
	
	public Member loginMember(SqlSession sqlSession, Member m ) {
		// selectOne 메소드 : 조회결과가 없다면 null 반환.
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
}
