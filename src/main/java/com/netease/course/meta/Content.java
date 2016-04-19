package com.netease.course.meta;

import java.io.UnsupportedEncodingException;

public class Content {
	private int id;
	private int price;
	private String title;
	private String icon;
	private String cabstract;
	private byte[] text;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getCabstract() {
		return cabstract;
	}
	public void setCabstract(String cabstract) {
		this.cabstract = cabstract;
	}
	public String getText() throws UnsupportedEncodingException {
		return new String(text,"UTF-8");
	}
	public void setText(byte[] text) {
		this.text = text;
	}
}
