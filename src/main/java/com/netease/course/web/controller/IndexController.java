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
import com.netease.course.meta.Content;
import com.netease.course.service.impl.Product;
import com.netease.course.service.impl.User;
import com.netease.course.service.impl.Work;

@Controller
public class IndexController {
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private TrxMapper trxMapper;
	
	static List<Product> productList = null;
	
	@RequestMapping("/index")
	public String index(ModelMap map,HttpSession session) throws Exception {
		List<Content> contentList = contentMapper.getContentList();
		if (contentList.size()!=0) {
			productList = new ArrayList<>();
			for (Content content : contentList) {
				productList.add(new Product(
						content.getId(),
						content.getTitle(),
						content.getPrice(),
						content.getIcon(),
						Work.isBuyorSell(content.getId(), trxMapper),
						Work.isBuyorSell(content.getId(), trxMapper)
						));
			}
			map.addAttribute("productList", productList);
		}
		User user = (User) session.getAttribute("user");
		if (user!=null) {
			map.addAttribute("user",user);
		}
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() throws IOException {
		return "login";
	}
}
