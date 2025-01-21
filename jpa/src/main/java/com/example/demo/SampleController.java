package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SampleController {
	@GetMapping("/hello")
	@ResponseBody
	public String main() {
		return "hello"; 
		//@ResponseBody 이게 없거나 @RestContoller 가 아닌 경우는 hello라는 페이지를 찾게 된다.
		//hello를 문자로 인식 하려면 @ResponseBody 나 @RestContoller 로 추가 혹은 변경이 필요 
	}
	
}
