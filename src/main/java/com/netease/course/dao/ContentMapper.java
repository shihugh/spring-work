package com.netease.course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.netease.course.meta.Content;

public interface ContentMapper {
	@Results({
		@Result(property="id", column="id"),
		@Result(property="price", column="price"),
		@Result(property="title", column="title"),
		@Result(property="icon", column="icon"),
		@Result(property="cabstract", column="abstract"),
		@Result(property="text", column="text")
	})
	@Select("select * from Content where id=#{0}")
	public Content select(int id);
	
	@Results({
		@Result(property="id", column="id"),
		@Result(property="price", column="price"),
		@Result(property="title", column="title"),
		@Result(property="icon", column="icon"),
		@Result(property="cabstract", column="abstract"),
		@Result(property="text", column="text")
	})
	@Select("select * from Content where title=#{0}")
	public Content getByTitle(String title);
	
	@Results({
		@Result(property="id", column="id"),
		@Result(property="price", column="price"),
		@Result(property="title", column="title"),
		@Result(property="icon", column="icon"),
		@Result(property="cabstract", column="abstract"),
		@Result(property="text", column="text")
	})
	@Insert("insert into Content (price,title,icon,abstract,text) values (#{3},#{0},#{1},#{4},#{2})")
	public void insert(String title,String image,byte[] detail,int price,String summary);
	
	@Results({
		@Result(property="id", column="id"),
		@Result(property="price", column="price"),
		@Result(property="title", column="title"),
		@Result(property="icon", column="icon"),
		@Result(property="cabstract", column="abstract"),
		@Result(property="text", column="text")
	})
	@Delete("delete from Content where id=#{0}")
	public void delete(int id);
	
	@Results({
		@Result(property="id", column="id"),
		@Result(property="price", column="price"),
		@Result(property="title", column="title"),
		@Result(property="icon", column="icon"),
		@Result(property="cabstract", column="abstract"),
		@Result(property="text", column="text")
	})
	@Update("update Content set price=#{4},title=#{1},icon=#{2},abstract=#{5},text=#{3} where id=#{0}")
	public void update(int id,String title,String image,byte[] detail,int price,String summary);
	
	@Results({
		@Result(property="id", column="id"),
		@Result(property="price", column="price"),
		@Result(property="title", column="title"),
		@Result(property="icon", column="icon"),
		@Result(property="cabstract", column="abstract"),
		@Result(property="text", column="text")
	})
	@Select("select * from Content")
	public List<Content> getContentList();
}
