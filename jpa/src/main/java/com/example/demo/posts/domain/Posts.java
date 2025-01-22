package com.example.demo.posts.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
	//entity 자체를 건들면 값이 변화하기 때문에 각 기능 별로 dto를 만들어서 처리 해준다 . 즉 enity -> dto , dto -> entity 과정 필요 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "clob", nullable = false)
    private String content;

    private String author;
    
    //업데이트 (수정) = setter 대신의 생성자 (수정)
    public void update(String title, String content) {
    	this.title = title;
    	this.content = content;
    }
    @Builder // 등록 = setter대신의 생성자(등록)
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
