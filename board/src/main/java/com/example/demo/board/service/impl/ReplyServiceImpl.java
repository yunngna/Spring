package com.example.demo.board.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.ReplyMapper;

import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyPageDTO;
import com.example.demo.board.service.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;


import groovy.util.logging.Log4j;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyMapper replyMapper;
	private final BoardMapper boardMapper;
	
	
	@Override
	@Transactional
	public void register(ReplyDTO vo) {
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		
		replyMapper.insert(vo);
	}

	@Override
	public boolean modify(ReplyDTO vo) {
		return replyMapper.update(vo) == 1 ? true : false;
	}
	
	
	@Override
	@Transactional
	public boolean remove(Long rno) {
		ReplyDTO vo = replyMapper.read(rno);
		
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		
		return replyMapper.delete(rno) == 1 ? true : false;
	}

	@Override
	public ReplyDTO get(Long rno) {
		return replyMapper.read(rno);
	}

	@Override
	public ReplyPageDTO getList(ReplySearchDTO replySearch , Long bno) {
		Paging paging = new Paging();
		int cnt = replyMapper.getCountByBno(bno);
		
		//paging = 안에 전체 건수, pageUnit,현재 페이지 번호 
		paging.setPage(replySearch.getPage());
		paging.setPageUnit(replySearch.getAmount());
		paging.setTotalRecord(cnt);
		
		return new ReplyPageDTO(
			cnt,
			paging,
			replyMapper.getList(replySearch, bno)
		);
	}

	
}
