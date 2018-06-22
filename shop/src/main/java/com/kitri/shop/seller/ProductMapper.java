package com.kitri.shop.seller;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
	
	void insert(Product p);
	Product selectByNum(int num);
	List selectByName(String name);
	List selectByPrice(Map map);
	List selectBySellerId(String seller_id);
	List selectByC1(int c1);
	List selectByC2(int c2);
	List selectByC3(int c3);
	List selectAll();
	void update(Product p);
	void delete(int num);
	int getNum();
}
