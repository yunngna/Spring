package com.example.demo.board.service;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder 

public class BoardDTO {
	  private Long bno;
	  private String title;
	  private String content;
	  private String writer;
	  private Date regdate;
	  
	  // Long 와 long의 차이 
	  // Long 경우 객체 형성 이지만, long은 한개의 값만 가진다.
	  //e.g Int 의 경우  null값을 가지지만, int 는 null 값이 아닌 정수 값만 가진다. 
	  
	
}
