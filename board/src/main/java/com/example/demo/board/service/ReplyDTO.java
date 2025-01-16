package com.example.demo.board.service;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ReplyDTO {
	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private Date replydate;
}
