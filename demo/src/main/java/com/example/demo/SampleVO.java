package com.example.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SampleVO {
	
	@JsonIgnore //화면으로 데이터를 전송 하지 원하지 않는 (빼고 싶은 필드)에 지정 
	private int mno;
	
	//@JsonProperty("fname") // Getter/setter의 이름을 property와 다른 이름을 사용할 수 있도록 설정
	private String firstName;
	private String lastName;
	
	@JsonFormat(pattern = "yyyy-MM-dd") // 날짜 포맷 지정 ( pattern, timezone 많이 사용)
	private Date regDate;
	
}
