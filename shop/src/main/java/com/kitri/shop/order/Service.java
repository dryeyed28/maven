package com.kitri.shop.order;

import java.util.List;

public interface Service {
	
	void addOrder(Order o);
	Order getOrder(int num);
	List getOrderAll(String consumer_id, int result);
	void editResult(int num, int result);
	void delOrder(int num);
}
