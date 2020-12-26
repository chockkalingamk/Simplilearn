package com.simplilearn.shoppingcart.model;

import com.simplilearn.shoppingcart.entity.Product;

public class ProductInfo {
	private String code;
	private String name;
	private double price;
	
	
	
	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ProductInfo(String code, String name, double price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	public ProductInfo(Product product) {
		super();
		this.code = product.getCode();
		this.name = product.getName();
		this.price = product.getPrice();
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
