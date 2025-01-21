package com.example.demo.service;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	private Long bookNo;
	@NotBlank(message="도서명이 입력되지 않았습니다.")
    private String bookName;       
    private String bookCoverimg;   
    private Date bookDate;       
    private Long bookPrice;      
    private String bookPublisher;
    private String bookInfo;
}
