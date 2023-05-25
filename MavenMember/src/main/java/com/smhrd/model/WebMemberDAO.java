package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

public class WebMemberDAO {
	//manager가 factory 생성, factory가 session 생성
	//SqlSessionFactory 생성 : DB 관련된 기능을 직접 사용할 수 있는 세션을 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	
	//회원가입
	public int join(WebMember member) {
		//Factory를 사용해서 실제 db 관련 기능을 수행해주는 session을 생성
		//true : auto commit - jdbc는 자동 commit이었음. myBatis는 자동커밋이 아니므로 설정해줘야 함
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			//sqlSession으로 member를 db에 넘겨줘야 함
			//삽입 : insert, 삭제 : delete, 호출 : select
			//insert(실제 실행할 sql문 - xml파일 namespace.id , sql 실행할 때 넘겨줄 값 - ?)
			//?에 채워질 값은 member에 담겨있음
			cnt = sqlSession.insert("WebMemberDAO.join",member);
			System.out.println(cnt);
			//반환값 : sql 실행 성공 여부 (삽입 성공 - 1, 실패 - 0)
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close(); //자원반환
		}
		return cnt;
	}
	
	public WebMember login(WebMember member) {
		WebMember member2 = null;
		//세션 생성
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		try {
			//selectList : 리스트를 가져오는 것
			//selectOne : 객체 하나만 가지고 오는 것
			member2 = sqlSession.selectOne("WebMemberDAO.login",member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return member2;
	}
	
	public int update(WebMember member) {
		int cntUpdate = 0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		 
		try {
			cntUpdate = sqlSession.update("WebMemberDAO.update",member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cntUpdate;
	}
	
	
	}
