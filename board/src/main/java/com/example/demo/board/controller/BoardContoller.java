package com.example.demo.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardService;

//import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@Slf4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardContoller {
	private final BoardService service;
	
	//등록, 수정 => post
	// 삭제, 조회, 전체조회 => get
	
	//전체 조회
//	@GetMapping("/list")
//	@ResponseBody
//	public List<BoardDTO> list(Model model) {
//		log.info("list");
//		//model.addAttribute("list", service.getList());
//		return service.getList(); 
//		// vue 페이지로 이동이 아니라 객체가 return 하려면 @ResponseBody을 추가 해주어야한다. 
//	}
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	//등록페이지로 이동 
	@GetMapping("/register")
	public void register() {
		
	}
	//등록  (등록 기능 실행 )
	@PostMapping("/register")
	public String register(BoardDTO board,RedirectAttributes rttr) {
		log.info("register:" + board);
		service.register(board);
		//addAttribute <-> addFlashAttribute 한번만 실행
		rttr.addFlashAttribute("result",true);
		//만약 return "/board/list"; 이렇게 목록 리스트 페이지로 이동 하면 변경된 데이터를 가지고 가지 못하기 때문에 redirect 해줘야 한다. 
		return "redirect:/board/list";
	}
	
	//수정페이지이동 (여러개의 url 처리)
	@GetMapping({"/modify","/get"})
	public void modify(@RequestParam(name="bno")Long bno, Model model) {
		BoardDTO board = service.get(bno);
		model.addAttribute("board",board);
	}
	
	//수정  (수정 기능 실행 )
	@PostMapping("/modify")
	public String modify(BoardDTO board,RedirectAttributes rttr) {
		log.info("modify:" + board);
		service.modify(board);
		//addAttribute <-> addFlashAttribute 한번만 실행
		rttr.addFlashAttribute("result",true);
		//만약 return "/board/list"; 이렇게 목록 리스트 페이지로 이동 하면 변경된 데이터를 가지고 가지 못하기 때문에 redirect 해줘야 한다. 
		return "redirect:/board/list";
	}
	
	//삭제 
		@GetMapping("/remove")
		public String remove(@RequestParam(name="bno")Long bno, RedirectAttributes rttr) {
			
			service.remove(bno);
			rttr.addFlashAttribute("result",true);
			//만약 return "/board/list"; 이렇게 목록 리스트 페이지로 이동 하면 변경된 데이터를 가지고 가지 못하기 때문에 redirect 해줘야 한다. 
			return "redirect:/board/list";
			
	}
	
	
	
}