package com.example.demo.insa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.board.service.BoardService;
import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.EmployeesService;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/emp/*")
public class EmployeesController {
	private final EmployeesService empService;
	
	@GetMapping("list")
	public void list(Model model) {
	log.info("조회",empService.getList());
	
	model.addAttribute("list", empService.getList());
	}
	
	@GetMapping("register")
	public void register(){
		
	}
	
}
