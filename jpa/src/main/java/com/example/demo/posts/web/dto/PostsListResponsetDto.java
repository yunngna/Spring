package com.example.demo.posts.web.dto;

import java.time.LocalDateTime;

import com.example.demo.posts.domain.Posts;

import lombok.Getter;

@Getter
//목록조회 dto
public class PostsListResponsetDto {
	private Long id;
	private String title;
	private String author;
	private LocalDateTime modifyDate;
	
	public PostsListResponsetDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.author = entity.getAuthor();
		this.modifyDate = entity.getModifyDateDate();
	}
}
