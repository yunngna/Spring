package com.example.demo.mapper;

import java.util.List;

import com.example.demo.service.BookDTO;
import com.example.demo.service.RentDTO;

public interface BookMapper {
	//등록
	int insert (BookDTO bookDTO);
	
	//조회
	List<BookDTO> getlist();
	
	//대여조회
	List<RentDTO> rentGetlist();
}
