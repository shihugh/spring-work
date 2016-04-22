package com.netease.course.meta;

import java.io.UnsupportedEncodingException;

public class Content {
	private int id;
	private int price;
	private byte[] title;
	private byte[] icon;
	private byte[] cabstract;
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
	public String getTitle() throws UnsupportedEncodingException {
		return new String(title, "UTF-8");
	}
	public void setTitle(byte[] title) {
		this.title = title;
	}
	public String getIcon() throws UnsupportedEncodingException {
		return new String(icon,"UTF-8");
	}
	public void setIcon(byte[] icon) {
		this.icon = icon;
	}
	public String getCabstract() throws UnsupportedEncodingException {
		return new String(cabstract,"UTF-8");
	}
	public void setCabstract(byte[] cabstract) {
		this.cabstract = cabstract;
	}
	public String getText() throws UnsupportedEncodingException {
		return new String(text,"UTF-8");
	}
	public void setText(byte[] text) {
		this.text = text;
	}
}
