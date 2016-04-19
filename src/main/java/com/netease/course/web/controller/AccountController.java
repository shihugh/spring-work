package com.netease.course.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netease.course.dao.ContentMapper;
import com.netease.course.dao.TrxMapper;
import com.netease.course.meta.Trx;
import com.netease.course.service.impl.Buy;
import com.netease.course.service.impl.User;

@Controller
public class AccountController {
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private TrxMapper trxMapper;
	
	private List<Buy> buyList = null;

	@RequestMapping("/account")
	public String account(ModelMap map,HttpSession session) throws IOException {
		List<Trx> trxList = trxMapper.getTrxList();
		if (trxList.size()!=0) {
			buyList = new ArrayList<>();
			for (Trx trx : trxList) {
				buyList.add(new Buy(
						trx.getContentId(),
						contentMapper.select(trx.getContentId()).getTitle(),
						contentMapper.select(trx.getContentId()).getIcon(),
						trx.getPrice(),
						trx.getTime()
						));
			}
			map.addAttribute("buyList", buyList);
		}
		User user = (User) session.getAttribute("user");
		if (user!=null) {
			map.addAttribute("user",user);
		}
		return "account";
	}
}
