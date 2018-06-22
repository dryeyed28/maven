package com.kitri.shop.member;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("memService")
public class ServiceImpl implements Service {

	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	private MemberMapper memberMapper;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void addMember(Member m) {
		memberMapper = sqlSession.getMapper(MemberMapper.class;
		memberMapper.insert(m);
	}

	@Override
	public Member getMember(String id) {
		memberMapper = sqlSession.getMapper(MemberMapper.class;
		return memberMapper.select(id);
	}

	@Override
	public void editMember(Member m) {
		memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberMapper.update(m);
	}

	@Override
	public void delMember(String id) {
		memberMapper = sqlSession.getMapper(MemberMapper.class)
		memberMapper.delete(id);
	}

}
