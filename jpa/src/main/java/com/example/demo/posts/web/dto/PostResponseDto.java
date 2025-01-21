package com.example.demo.posts.web.dto;

import com.example.demo.posts.domain.Posts;

import lombok.Getter;

@Getter

//단건조회dto
public class PostResponseDto {
	private Long id;
	private String title;
	private String content;
	private String author;
	
	//생성자 만들기 ([단건조회 entity] entity 조회 한것을 변환해서 dto 필드에 변환해서 넣어준다)
	public PostResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.author = entity.getAuthor();
	}
}
