package com.netease.course.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.course.dao.ContentMapper;
import com.netease.course.meta.Content;
import com.netease.course.service.impl.Product;
import com.netease.course.service.impl.User;

@Controller
public class EditController {
	@Autowired
	private ContentMapper contentMapper;
	
	@RequestMapping("/edit")
	public String edit(@RequestParam("id") int id,ModelMap map,HttpSession session) throws IOException {
		if (id!=0) {
			Content content = contentMapper.select(id);
			map.addAttribute("product",new Product(
					id,
					content.getTitle(),
					content.getIcon(),
					content.getText(),
					content.getPrice(),
					content.getCabstract()
					));
		}
		User user = (User) session.getAttribute("user");
		if (user!=null) {
			map.addAttribute("user",user);
		}
		return "edit";
	}
}
