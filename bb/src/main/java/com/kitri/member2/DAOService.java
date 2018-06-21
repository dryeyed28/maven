package com.kitri.member2;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("memService")//빈 등록
public class DAOService implements Dao {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	private MemberMapper memberMapper;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	@Override
	public void insert(Member m) {
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember(m);
	}

	@Override
	public void delete(String id) {
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteMembe(id);
	}
	
	@Override
	public Member select(String id) {
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		Member m = memberMapper.getMember(id);
		return m;
	}

	@Override
	public void update(Member m) {
		
	}

	

	
}
