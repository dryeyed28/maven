package com.kitri.member2;

public interface Dao {

	void insert(Member m);
	Member select(String id);
	void update(Member m);
	void delete(String id);
}
