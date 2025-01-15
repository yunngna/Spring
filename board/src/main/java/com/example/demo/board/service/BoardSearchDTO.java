package com.example.demo.board.service;

import lombok.Data;

@Data
public class BoardSearchDTO {
	int start;
	int end;
	
	int pageUnit;
	String keyword;
	String type;
	
	//배열 타입으로 변환 TypeArr을 체크 
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	
	
}
