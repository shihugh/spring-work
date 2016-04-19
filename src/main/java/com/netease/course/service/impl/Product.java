package com.netease.course.service.impl;

public class Product {
	private int id;
	private String title;
	private String summary;
	private String detail;
	private int price;
	private int buyPrice;
	private String image;
	private boolean isBuy;
	private boolean isSell;
//	index
	public Product(int id, String title, int price, String image, boolean isBuy, boolean isSell) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.image = image;
		this.isBuy = isBuy;
		this.isSell = isSell;
	}
//	show
	public Product(int id, String title, String summary, String detail, String image, int price, int buyPrice,
			boolean isBuy, boolean isSell) {
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.detail = detail;
		this.image = image;
		this.price = price;
		this.buyPrice = buyPrice;
		this.isBuy = isBuy;
		this.isSell = isSell;
	}
//	submit, edit
	public Product(int id, String title, String image, String detail, int price, String summary) {
		this.id = id;
		this.title = title;
		this.image = image;
		this.detail = detail;
		this.price = price;
		this.summary = summary;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean getIsBuy() {
		return isBuy;
	}
	public void setIsBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}
	public boolean getIsSell() {
		return isSell;
	}
	public void setIsSell(boolean isSell) {
		this.isSell = isSell;
	}
}
