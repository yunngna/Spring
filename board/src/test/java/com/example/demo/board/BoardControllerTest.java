package com.example.demo.board;



import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.ui.ModelMap;

import lombok.extern.slf4j.Slf4j;
@Slf4j
//MockMvc 가상의 브라우저를 만들어 url 테스트 용으로 사용 
@AutoConfigureMockMvc
@SpringBootTest
public class BoardControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	//전체조회
	
	//@Test
//	@DisplayName("조회 컨트롤러")
//	void list() throws Exception {
//		mvc.perform(get("/board/list"))
//			.andExpect(status().isOk());
//			//.andDo(MockMvcResultHandlers.print());
//	}
	
	@Test
    @DisplayName("조회 컨트롤러")
    void list() throws Exception {
    	ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/board/list")
    			.param("page","100"))
    	   .andReturn()
    	   .getModelAndView()
    	   .getModelMap();

    	log.debug(map.getAttribute("list").toString());
    	log.debug(map.getAttribute("paging").toString());

    }
	
	//등록 
	//@Test
    @DisplayName("등록 컨트롤러")
    void register() throws Exception  {
    	String param = "title=mockTest&content=시험용내용&writer=kim";
    	mvc.perform(post("/board/register")
    	   .content(param)
    	   .contentType(MediaType.APPLICATION_FORM_URLENCODED)
    	)//.andExpect(status().isOk())
         //.andExpect((ResultMatcher) content().string("main"))
         //.andDo(MockMvcResultHandlers.print());
         ;  
    }
	

}
