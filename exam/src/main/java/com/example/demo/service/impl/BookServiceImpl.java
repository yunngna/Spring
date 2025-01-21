package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookDTO;
import com.example.demo.service.BookService;
import com.example.demo.service.RentDTO;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
	private final BookMapper bookMapper;
	@Override
	public void register(BookDTO book) {
		bookMapper.insert(book);
		
	}

	@Override
	public List<BookDTO> getlist() {
		return bookMapper.getlist();
	}

	@Override
	public List<RentDTO> rentGetlist() {
		return bookMapper.rentGetlist();
	}

}
