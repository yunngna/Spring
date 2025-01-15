package com.example.demo.board.service;

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

public class BoardDTO {
	 
	  private Long bno;
	  @NotBlank(message="제목을 입력 하시오")
	  private String title;
	  @NotBlank(message="내용을 입력 하시오")
	  private String content;
	  @NotBlank(message="작성자을 입력 하시오")
	  private String writer;
	  private Date regdate;
	  
	  // Long 와 long의 차이 
	  // Long 경우 객체 형성 이지만, long은 한개의 값만 가진다.
	  //e.g Int 의 경우  null값을 가지지만, int 는 null 값이 아닌 정수 값만 가진다. 
	  
	  //@pattern 을 사용해서 정규표현식으로 나타 낼 수 있다. e.g  @Pattern("0\\d{3,4}-")
	  
	
}
