package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;

import lombok.extern.slf4j.Slf4j;

//sysout 대신 로그를 사용 하려면 @Slf4j  추가 
@Slf4j 
@SpringBootTest
public class BoardMapperTests {
	
	@Autowired BoardMapper boardMapper;
	
	//@Test
	@DisplayName("게시글 등록")
	public void register() {
		String title = "등록";
		//given
//		BoardVO board = new BoardVO();
//	    board.setTitle("새로 작성하는 글 select key");
//	    board.setContent("새로 작성하는 내용 select key");
//	    board.setWriter("newbie"); 이거와 밑에 builder사용 (DTO 파일에서 import) 해서 하는 것과 동일 작업 
	    
		BoardDTO board = BoardDTO.builder()
						.title("등록테스트")
						.content("등록내용")
						.writer("작성자")
						.build();		
		//when
		
		//등록된 건수가 넘어 온다
		int cnt = boardMapper.insert(board);
		
		//then 
		log.info("INSERT COUNT:" + cnt);
		//등록된 건수가 1 이 맞는지 체크 
		assertThat(cnt).isEqualTo(cnt);
		//맞는 경우 초록색 으로 성공 , 실패 시 빨간색으로 실패 표시
	}
	//@Test
	@DisplayName("게시글 수정")
	public void update() {
		//given
		//long 타입은 숫자 뒤에 꼭 L붙여줘야 한다. 
		BoardDTO board = BoardDTO.builder()
				.title("수정된타이틀")
				.content("수정내용")
				.writer("감자")
				.bno(2L)
				.build();		
		//when
		
		//등록된 건수가 넘어 온다
		int cnt = boardMapper.update(board);
		
		//then 
		log.info("UPDATE COUNT:"+ cnt);
		//등록된 건수가 1 이 맞는지 체크 
		assertThat(cnt).isEqualTo(cnt);
		
	
	}
	
	//@Test
	@DisplayName("게시글 삭제")
	public void delete() {
		//given
		long bno = 5L;
		//when
		int cnt = boardMapper.delete(bno);
		
		//then
		log.info("DELETE COUNT:"+cnt);
		//등록된 건수가 1 이 맞는지 체크 
		assertThat(cnt).isEqualTo(cnt);
		
	}
	//@Test
	@DisplayName("단건조회")
	public void perSearch() {
		//given
		long bno = 4L;
		
		//when
		BoardDTO board = boardMapper.read(bno);
		
		//then
		log.info(board.toString());
		//assertEquals(board.getBno(),bno);
		//assertThat(bno).isEqualTo(board.getBno());
		assertThat(board).isNotNull();
	}
	@Test
	@DisplayName("전체조회")
	public void search() {
		//given
		BoardSearchDTO search = new BoardSearchDTO();
		search.setStart(1);
		search.setEnd(10);
		//when
		List<BoardDTO> list = boardMapper.getList(search);
		
		//then
		list.forEach(board -> log.info(board.toString()));
		//assertNotNull(list);
		assertThat(list).isNotNull();
		
	}
	

}
