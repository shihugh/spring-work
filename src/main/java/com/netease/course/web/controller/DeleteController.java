package com.netease.course.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.course.dao.ContentMapper;

@Controller
public class DeleteController {
	@Autowired
	private ContentMapper contentMapper;
	
	@RequestMapping("/api/delete")
	public void delete(@RequestParam("id") int id,ModelMap map,HttpSession session) throws IOException {
		if (id!=0) {
			try {
				contentMapper.delete(id);
				map.addAttribute("code",200);
				map.addAttribute("message","删除成功");
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
