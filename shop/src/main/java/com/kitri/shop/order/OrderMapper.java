package com.kitri.shop.order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
	
	void insert(Order o);
	Order select(int num);
	List selectAll(Map map);
	void update(Map map);
	void delete(int num);
}
