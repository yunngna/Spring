package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ObjectMapperTest {
	@Test
	public void test() throws JsonMappingException, JsonProcessingException {
		//string ==> vo   == @RequesBody
		String str = "{\"name\":\"홍\",\"age\":20}";
		
		ObjectMapper om = new ObjectMapper();
		MemVO vo = om.readValue(str, MemVO.class); //readValue : str을 MemVO.class 타입으로 변환 
		assertThat(vo.getName()).isEqualTo("홍");
		
		//vo (객체) => string  == @ResponseBody
		vo.setAge(30);
		String data = om.writeValueAsString(vo); // writeValueAsString : vo(객체) ->  string 으로 변환 
		log.info(data);
		
	}
}
