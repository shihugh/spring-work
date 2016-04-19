package com.netease.course.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.course.dao.ContentMapper;
import com.netease.course.service.impl.Product;
import com.netease.course.service.impl.User;

@Controller
public class PublicSubmitController {
	@Autowired
	private ContentMapper contentMapper;
	
	@RequestMapping("/publicSubmit")
	public String publicSubmit(@RequestParam("title") String title,
			@RequestParam("image") String image,
			@RequestParam("detail") String detail,
			@RequestParam("price") int price,
			@RequestParam("summary") String summary,
			ModelMap map,HttpSession session) throws IOException {
		try {
			contentMapper.insert(title, image, detail.getBytes("UTF8"), price, summary);
			map.addAttribute("product",new Product(
					contentMapper.getByTitle(title).getId(),title,image,detail,price,summary
					));
		} catch (Exception e) {
			e.printStackTrace();
		}
		User user = (User) session.getAttribute("user");
		if (user!=null) {
			map.addAttribute("user",user);
		}
		return "publicSubmit";
	}
}
