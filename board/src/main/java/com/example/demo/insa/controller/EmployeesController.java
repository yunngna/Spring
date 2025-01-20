package com.example.demo.insa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardService;
import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.EmployeesService;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

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
	
	//드롭박스 정보 
	@GetMapping("register")
	public void register(EmployeesDTO employee,Model model){
		model.addAttribute("list",empService.getJobList());
		model.addAttribute("deptList",empService.getDepList());
	}
	

	
	//등록 
	@PostMapping("register")
	public String registerProc(@Validated EmployeesDTO employee,
							 BindingResult bindingResult,
			                 RedirectAttributes rttr) {
//		if(bindingResult.hasErrors()) {
//			return "emp/register";
//		}
		empService.register(employee);
		rttr.addFlashAttribute("result",true);
		return "redirect:/emp/list";
	}
	
}
