package com.example.demo.posts.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

//수정 dto
public class PostsUpdateRequestDto {
	//작성자는 수정 불가 = 내용과 제목만 변경 가능 (변경 가능하나 항목만 추가)
	private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
