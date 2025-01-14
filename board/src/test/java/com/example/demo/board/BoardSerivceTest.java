package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@SpringBootTest
public class BoardSerivceTest {
	
	@Autowired
	BoardService boardService;
	
	@Test
	@DisplayName("게시글 수정")
	public void update() {
		//given
		//실행 전 존재하는 번호인지 확인
		BoardDTO board = BoardDTO.builder()
				.title("고구마맛아이스크림")
				.content("고구마맛내용")
				.writer("고구마")
				.bno(3L)
				.build();
		//when
		boolean result = boardService.modify(board);
		//then 
		assertThat(result).isEqualTo(true);
	}
}
