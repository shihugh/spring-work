package com.netease.course.service.impl;

public class Buy {
	private int id;
	private String title;
	private String image;
	private int buyPrice;
	private long buyTime;
	
	public Buy(int id, String title, String image, int buyPrice, long buyTime) {
		this.id = id;
		this.title = title;
		this.image = image;
		this.buyPrice = buyPrice;
		this.buyTime = buyTime;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	public long getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Integer buyTime) {
		this.buyTime = buyTime;
	}
}
