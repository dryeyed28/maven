package com.kitri.shop.order;

import com.kitri.shop.seller.Product;

public class Order {

	private int num;
	private String consumer_id;
	private int pro_num;
	private int quantity;
	private String tel ;
	private String address;
	private int result;
	private Product p = new Product();
	
	public Order() {}

	public Order(int num, String consumer_id, int pro_num, int quantity, String tel, String address, int result,
			Product p) {
		super();
		this.num = num;
		this.consumer_id = consumer_id;
		this.pro_num = pro_num;
		this.quantity = quantity;
		this.tel = tel;
		this.address = address;
		this.result = result;
		this.p = p;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getConsumer_id() {
		return consumer_id;
	}

	public void setConsumer_id(String consumer_id) {
		this.consumer_id = consumer_id;
	}

	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Order [num=" + num + ", consumer_id=" + consumer_id + ", pro_num=" + pro_num + ", quantity=" + quantity
				+ ", tel=" + tel + ", address=" + address + ", result=" + result + ", p=" + p + "]";
	}
	
}
