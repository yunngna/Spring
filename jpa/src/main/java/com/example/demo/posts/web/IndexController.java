package com.example.demo.posts.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
	@GetMapping("/")
	public String index() {
		//목록조회
		return "index";
	}
	
	@GetMapping("/save")
	public String save() {
		return "posts-insert";
	}
	
	@GetMapping("/update")
	public String update() {
		//단건조회
		return "posts-update";
	}
	
	
	
}
