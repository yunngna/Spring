package com.example.demo.posts.web;

import org.hibernate.dialect.function.array.PostgreSQLArrayConcatElementFunction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.posts.service.PostsService;
import com.example.demo.posts.web.dto.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;

//postAPI컨트롤러는 데이터만 넘기는 컨트롤러  = restController

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
	//수정
	@PutMapping("/api/v1/posts/{id}")
	public PostsSaveRequestDto update(
					   @PathVariable (name="id")Long id, 
					   @RequestBody PostsSaveRequestDto dto) {
		//postsService.update(id, dto);
		return dto;
	}
	
	//삭제
//		@PutMapping("/api/v1/posts/{id}")
//		public Long delete(@PathVariable (name="id")Long id) {
//			//postsService.delete(id);
//			return id;
//		}
//	
	
	
	
}
