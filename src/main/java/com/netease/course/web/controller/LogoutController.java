package com.netease.course.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netease.course.service.impl.User;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public String logout(HttpSession session) throws IOException {
		User user = (User) session.getAttribute("user");
		if (user!=null) {
			session.removeAttribute("user");
		}
		return "login";
	}
}
