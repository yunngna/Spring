package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;
import com.example.demo.board.service.BoardService;

import lombok.RequiredArgsConstructor;

//필드가 하나 인 경우 @AllArgsConstructor 해도 되지만 특정 필드를 생성 하는 경우 @RequiredArgsConstructor 해준다. 
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper boardMapper;
	
	

	@Override
	public void register(BoardDTO board) {
		boardMapper.insert(board);
		
	}

	@Override
	public boolean modify(BoardDTO board) {
		return boardMapper.update(board) == 1 ? true : false;
	}

	@Override
	public boolean remove(Long bno) {
		return boardMapper.delete(bno) == 1 ? true : false;
	}

	@Override
	public BoardDTO get(Long bno) {
		return boardMapper.read(bno);
	}

	@Override
	public List<BoardDTO> getList(BoardSearchDTO searchDTO) {
		return boardMapper.getList(searchDTO);
	}

	@Override
	public int getcount(BoardSearchDTO searchDTO) {
		return boardMapper.getcount(searchDTO);
	}

}
