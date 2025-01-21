package com.example.demo.posts.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.posts.service.PostsService;
import com.example.demo.posts.web.dto.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostsAPIController {
	final PostsService postsService;
	
	//등록 컨트롤러 
	@PostMapping("/api/v1/posts")
	public PostsSaveRequestDto save(@RequestBody PostsSaveRequestDto dto) {
		postsService.save(dto);
		return dto;
	}
	
}
