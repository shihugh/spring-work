package com.netease.course.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.course.dao.ContentMapper;
import com.netease.course.dao.PersonMapper;
import com.netease.course.dao.TrxMapper;
import com.netease.course.service.impl.User;

@Controller
public class BuyController {
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private PersonMapper personMapper;
	@Autowired
	private TrxMapper trxMapper;
	
	@RequestMapping("/api/buy")
	public void buy(@RequestParam("id") int id,ModelMap map,HttpSession session) throws IOException {
		if (id!=0) {
			User user = (User) session.getAttribute("user");
			if (user.getUsertype()==0) {
				try {
					trxMapper.insert(id,
							personMapper.select(user.getUsername()).getId(),
							contentMapper.select(id).getPrice(),
							System.currentTimeMillis()
							);
					map.addAttribute("code",200);
					map.addAttribute("message","购买成功");
					map.addAttribute("result",true);
				} catch (Exception e) {
					e.printStackTrace();
					map.addAttribute("code",500);
					map.addAttribute("message","系统正忙，请稍后再试~");
					map.addAttribute("result",false);
				}
			}
			
		}
	}
}
