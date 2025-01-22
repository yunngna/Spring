package com.example.demo.posts.domain;

import java.time.LocalDateTime;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
@Getter
@EntityListeners(AuditingEntityListener.class) //등록인 경우 등록일자, 수정인 경우 수정일자 들어감
@MappedSuperclass // 아래의 컬럼이 posts에 자동 추가 
public class BaseTimeEntity {
	@CreatedDate
	private LocalDateTime createdDate;
	
	@LastModifiedDate
	private LocalDateTime modifyDateDate;
}
