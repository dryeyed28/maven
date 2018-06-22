package com.kitri.shop.member;

public interface Service {
	
	void addMember(Member m);
	Member getMember(String id);
	void editMember(Member m);
	void delMember(String id);
}
