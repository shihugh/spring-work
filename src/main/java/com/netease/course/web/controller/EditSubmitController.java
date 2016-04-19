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
public class EditSubmitController {
	@Autowired
	private ContentMapper contentMapper;
	
	@RequestMapping("/editSubmit")
	public String editSubmit(@RequestParam("id") int id,
			@RequestParam("title") String title,
			@RequestParam("image") String image,
			@RequestParam("detail") String detail,
			@RequestParam("price") int price,
			@RequestParam("summary") String summary,
			ModelMap map,HttpSession session) throws IOException {
		if (id!=0) {
			try {
				contentMapper.update(id, title, image, detail.getBytes("UTF8"), price, summary);
				Content content = contentMapper.select(id);
				map.addAttribute("product",new Product(
						id,
						content.getTitle(),
						content.getIcon(),
						content.getText(),
						content.getPrice(),
						content.getCabstract()
						));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		User user = (User) session.getAttribute("user");
		if (user!=null) {
			map.addAttribute("user",user);
		}
		return "editSubmit";
	}
}
