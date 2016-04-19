package com.netease.course.service.impl;

import com.netease.course.dao.PersonMapper;
import com.netease.course.dao.TrxMapper;
import com.netease.course.meta.Trx;

public class Work {
	
	public static boolean login(String userName, String password, PersonMapper personMapper) throws Exception {
		if (personMapper.select(userName).getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isBuyorSell(int contentId, TrxMapper trxMapper) throws Exception {
		Trx trx = null;
		try {
			trx = trxMapper.getByContentId(contentId);
		} catch (Exception e) {
		}
		if (trx!=null) {
			return true;
		} else {
			return false;
		}
	}
}
