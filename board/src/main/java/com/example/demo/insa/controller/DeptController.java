package com.example.demo.insa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
//RestController 의 경우 넘기는 것이 모두 데이터 값만 넘어간다
@Slf4j
@RequiredArgsConstructor


@RequestMapping("/dept/*")
public class DeptController {
	private final DeptService deptService;
	
	@GetMapping("list")
	public List<DeptDTO> list(){
		return deptService.getList(null);
	
	}
	
	@GetMapping("get")
	public DeptDTO get(@RequestParam(name="departmentId")long departmentId) {
		return deptService.read(departmentId);
	
	}
	
	
	
	
}
