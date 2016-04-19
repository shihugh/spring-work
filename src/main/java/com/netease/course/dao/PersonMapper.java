package com.netease.course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.netease.course.meta.Person;

public interface PersonMapper {
	@Select("select * from Person where userName=#{0}")
	public Person select(String userName);
	
	@Select("select * from Person")
	public List<Person> getPersonList();
}
