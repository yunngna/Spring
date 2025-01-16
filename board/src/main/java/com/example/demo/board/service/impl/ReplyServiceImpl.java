package com.example.demo.board.service.impl;

import org.springframework.stereotype.Service;


import com.example.demo.board.mapper.ReplyMapper;

import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyPageDTO;
import com.example.demo.board.service.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyMapper replyMapper;

	@Override
	public void register(ReplyDTO vo) {
		replyMapper.insert(vo);
		
	}

	@Override
	public boolean modify(ReplyDTO vo) {
		return replyMapper.update(vo) == 1 ? true : false;
	}

	@Override
	public boolean remove(Long rno) {
		return replyMapper.delete(rno) == 1 ? true : false;
	}

	@Override
	public ReplyDTO get(Long rno) {
		return replyMapper.read(rno);
	}

	@Override
	public ReplyPageDTO getList(ReplySearchDTO replySearch , Long bno) {
		return new ReplyPageDTO(
			replyMapper.getCountByBno(bno),
			replyMapper.getList(replySearch, bno)
		);
	}

	
}
