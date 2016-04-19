package com.netease.course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.netease.course.meta.Trx;

public interface TrxMapper {
	@Select("select * from Trx where id=#{0}")
	public Trx select(int trxId);
	
	@Select("select * from Trx where contentId=#{0}")
	public Trx getByContentId(int contentId);
	
	@Insert("insert into Trx (contentId,personId,price,time) values (#{0},#{1},#{2},#{3})")
	public void insert(int contentId,int personId,int price,long time);
	
	@Select("select * from Trx")
	public List<Trx> getTrxList();
}
