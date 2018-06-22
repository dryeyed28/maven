package com.kitri.shop.member;

public interface MemberMapper {
	
	void insert(Member m);
	Member select(String id);
	void update(Member m);
	void delete(String id);
}
