package com.example.demo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data // 없는 경우 406 Not Acceptable 오류 발생 
public class CompVO {
	

//{
//  "list" : [ {"tno":100 , "owner":"홍길동", "grade": "best"},
//             {"tno":101 , "owner":"김길동", "grade": "best"}
//            ]
//  ,"sample" : { "mno" : 1004 , "firstName" : "유신" , "lastName" : "김"}
//  ,"cnt" : 1100
//  ,"regdate" : "2024-10-10"
//}

	
	private List<Ticket> list;
	private SampleVO sample;
	private int cnt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date regdate;

}
