package com.kitri.shop.seller;

import java.util.List;

public interface Service {
	
	void addProduct(Product p);
	Product getProductByNum(int num);
	List getProductByName(String name);
	List getProductByPrice(int min, int max);
	List getProductBySellerId(String seller_id);
	List getProductByC1(int c1);
	List getProductByC2(int c2);
	List getProductByC3(int c3);
	List getProductAll();
	void editProduct(Product p);
	void delProduct(int num);
	int getNum();
	
}
