package com.kitri.member2;

import java.util.ArrayList;

public interface MemberMapper {
	
	ArrayList<Member> getMember();
	Member getMember(String id);
	void insertMember(Member member);
	void updateMember(Member member);
	void deleteMembe(String id);
}
