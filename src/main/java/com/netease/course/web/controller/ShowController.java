package com.netease.course.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.course.dao.ContentMapper;
import com.netease.course.dao.TrxMapper;
import com.netease.course.meta.Content;
import com.netease.course.service.impl.Product;
import com.netease.course.service.impl.User;
import com.netease.course.service.impl.Work;

@Controller
public class ShowController {
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private TrxMapper trxMapper;
	
	@RequestMapping("/show")
	public String show(@RequestParam("id") int id,ModelMap map,HttpSession session) throws Exception {
		if (id!=0) {
			Content content = contentMapper.select(id);
			if (Work.isBuyorSell(id, trxMapper)) {
				map.addAttribute("product",new Product(
					id,
					content.getTitle(),
					content.getCabstract(),
					content.getText(),
					content.getIcon(),
					content.getPrice(),
					trxMapper.getByContentId(id).getPrice(),
					true,
					true
					));
			} else {
				map.addAttribute("product",new Product(
						id,
						content.getTitle(),
						content.getCabstract(),
						content.getText(),
						content.getIcon(),
						content.getPrice(),
						0,
						false,
						false
						));
			}
			
		}
		User user = (User) session.getAttribute("user");
		if (user!=null) {
			map.addAttribute("user",user);
		}
		
		return "show";
	}
}
