package com.example.demo.service;

import java.util.List;

public interface BookService {
	//등록
	public void register(BookDTO book);
	
	//조회
	public List<BookDTO> getlist();
	
	//대여 조회
	public List<RentDTO> rentGetlist();
}
