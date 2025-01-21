package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.BookDTO;
import com.example.demo.service.BookService;
import com.example.demo.service.RentDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
@RequiredArgsConstructor

public class BookController {
	private final BookService bookService;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list",bookService.getlist());
	}
	
	@GetMapping("/lendlist")
	public void lendlist( Model model) {
		model.addAttribute("list",bookService.rentGetlist());
	}
	
	@GetMapping("/register")
	public String register(BookDTO book){
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@Validated BookDTO book,
						  BindingResult bindingResult,
						  RedirectAttributes rttr) {
		
		if(bindingResult.hasErrors()) {
			return "/register";
		}
		log.info(book.toString());
		bookService.register(book);
		rttr.addFlashAttribute("result",true);
		return "redirect:/list";
	}
	
	
}
