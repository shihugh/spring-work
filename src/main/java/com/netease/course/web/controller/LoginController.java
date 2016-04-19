package com.netease.course.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.course.dao.PersonMapper;
import com.netease.course.service.impl.User;
import com.netease.course.service.impl.Work;

@Controller
public class LoginController {
	@Autowired
	private PersonMapper personMapper;
	
	@RequestMapping("/api/login")
	public void alogin(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			ModelMap map,HttpSession session) throws Exception {
		if (userName!=null && (Work.login(userName, password, personMapper))) {
			User user = new User(userName, personMapper.select(userName).getUserType());
			session.setAttribute("user", user);
			
			map.addAttribute("code",200);
			map.addAttribute("message","登陆成功");
			map.addAttribute("result",true);
		} else {
			map.addAttribute("code",401);
			map.addAttribute("message","用户不存在或密码错误");
			map.addAttribute("result",false);
		}
	}
}
