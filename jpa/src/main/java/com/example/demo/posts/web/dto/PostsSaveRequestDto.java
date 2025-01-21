package com.example.demo.posts.web.dto;

import com.example.demo.posts.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor //기본생성자 
//등록 dto
public class PostsSaveRequestDto {
	//등록시 title, contetn, auther 세 항목 모두 등록 해야 한다.
		private String title;
	    private String content;
	    private String author;

	    @Builder
	    public PostsSaveRequestDto(String title, String content,String author) {
	        this.title = title;
	        this.content = content;
	        this.author = author;
	    }
	    
	    //사용자 입력 파라미터 => dto => entity 로 변환 작업
	    //등록 처리 한후 dto -> entity로 변환 작업 필요 (생성자 형성 )
	    public Posts toEntity() {
	    	return Posts.builder()
	    				.title(title)
	    				.content(content)
	    				.author(author)
	    				.build();
	    }
}
