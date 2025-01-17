package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//Rest서버 == data 
@Slf4j
@RestController
//@Controller
public class SampleController {
	
	//produces = 화면에 넘겨주는 contentType을 지정 해준다. 
	//1. 데이터만 넘김
	@GetMapping(value="/getText",produces= "text/plain;charset:UTF-8")
	public String getText(){
		return "안녕하세요";
	}
	//2. 데이터 + 상태값 넘김
	@GetMapping(value="/getTextEntity")
	public ResponseEntity<String> getTextEntity(){
		return new ResponseEntity<String>("안녕하세요",HttpStatus.BAD_GATEWAY);
				
	}
	

	// @Controller 을 넣고 rest방식을 사용 하는 경우 @ResponseBody 을 적어 줘야 한다. 
	
	// @ResponseBody 여기에 적어도 되고 안에 적어줘도 된다.
//	@GetMapping(value="/getText",produces= "text/plain;charset:UTF-8")
//	public @ResponseBody String getText(){
//		return "안녕하세요";
//	}
//	
	//따로 지정 하지 않아도 {},[] 임을 구별해서 자동으로 json 타입으로 화면에 넘겨준다. 
	//1. 데이터만 넘김
	@GetMapping("/getSample")
	public SampleVO getSample() {
		return new SampleVO(100,"길동","김", new Date()) ;
	}
	//2. 데이터 + 상태값 넘김 
	@GetMapping("/getSampleEntity")
	public ResponseEntity<SampleVO> getSampleEntity() {
		SampleVO sample = new SampleVO(100,"길동","김", new Date());
		return new ResponseEntity<SampleVO>(sample,HttpStatus.BAD_REQUEST); // 결과 + 상태값 같이 넘김 
	}
	
	//map을 이용해서 여러값을 담아 보내기 
	@GetMapping("/getMap")
	public Map<String,Object> getMap() {
		//SampleVO ,  "안녕하세요" 모두 다 넘기기 
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sample",new SampleVO(100,"길동","김", new Date()));
		map.put("total",20);
		map.put("success", true);
		
		return map;
	}
	//pathVariable = 파라미터 받기 
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable String cat,
			                @PathVariable(name="pid") Integer pidid) {
		return new String[] {cat,""+pidid}; // 숫자의 경우 json 타입으로 나타내기 위해서 ""을 추가 해 준다. 
		
	}
	
	//post만 json 타입을 파라미터로 받아 원하는데이터 타입으로 변환 가능 
	//RequestBody
	
	//1) json String  -> @RequestBody 커맨드객체
	//2) query String -> 커맨드객체
	
//	@PostMapping("/ticket")
//	public Ticket convert(@RequestBody Ticket ticket) { 
//		log.info("ticket:" + ticket);
//		return ticket;
//	}
	
	//배열의 경우  ( 받는 값이 여러개 = 배열 , 출력 해야 할 값 여러개 = 배열 )
//	[
//	{"tno":100,"owner":"홍길동","grade":"best"},
//	{"tno":101,"owner":"고구마","grade":"middle"},
//	{"tno":102,"owner":"감자","grade":"row"}
//	]
	//대괄호 [] = List
	@PostMapping("/ticket")
	public List<Ticket> convert(@RequestBody List<Ticket> ticket) { 
		log.info("ticket:" + ticket);
		return ticket;
	}
	
	//방법 1 : VO (json node)
	@PostMapping("/comp")
	public CompVO comp(@RequestBody CompVO comp) {
		//첫번째 티켓의 owner 출력 
		log.info("owner:" + comp.getList().get(0).getOwner());
		return comp;
	}
	//방법 2 : map
	// 중괄호 {} = map 
//	@PostMapping("/compMap")
//	public Map<String, Object> compMap(@RequestBody Map<String, Object> map) {
//		
//		//첫번째 티켓의 owner 출력 
//		// map.get("list"); // 필드명(key값) 으로 value 불러 오기 
//		log.info("owner:"+ ((List<Ticket>)map.get("list")).get(0));
//		
//		return map;
//	}
//	
	//방법 3 : jsonNode
	@PostMapping("/compMap")
	public JsonNode compMap(@RequestBody JsonNode node) {
		
		//첫번째 티켓의 owner 출력 
		// map.get("list"); // 필드명(key값) 으로 value 불러 오기 
		log.info("owner:"+ node.get("list").get(0).get("owner").asText());
		return node;
	}
	
	//영화API
	@GetMapping("/movie")
	public String movie(@RequestParam(defaultValue = "20250115")String date) {
		RestTemplate restTemplate = new RestTemplate(); //RestTemplate = Rest 방식 API를 호출할 수 있는 Spring 내장 클래스
		String uri = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt="+date;
		JsonNode node = restTemplate.getForObject(uri, JsonNode.class);
		//첫번째 영화 이름 
		String name = node.get("boxOfficeResult").get("dailyBoxOfficeList").get(0).get("movieNm").asText();
		return name;
	}
	
	
	
	
	
	
	
	
	
}
