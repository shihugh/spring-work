package com.netease.course.service.impl;

public class User {
	private String username;
	private int usertype;
	public User(String username, int usertype) {
		this.username = username;
		this.usertype = usertype;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
}
