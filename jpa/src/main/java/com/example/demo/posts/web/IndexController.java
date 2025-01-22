package com.example.demo.posts.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.posts.service.PostsService;
import com.example.demo.posts.web.dto.PostResponseDto;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class IndexController {
	
	final PostsService postsService;
	
	@GetMapping("/")
	public String index(Model model) {
		//목록조회
		model.addAttribute("posts",postsService.findAll());
		return "index";
	}
	
	@GetMapping("/posts/save")
	public String save() {
		return "posts-insert";
	}
	
	@GetMapping("/posts/update/{id}")
	public String update(Model model,@PathVariable(name="id")Long id ) {
		//단건조회
		PostResponseDto dto = postsService.findById(id);
		model.addAttribute("posts",dto);
		return "posts-update";
	}
	
	
	
}
