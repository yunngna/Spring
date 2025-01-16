package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplySearchDTO;

public interface ReplyMapper {
	
	int insert(ReplyDTO reply);
	
	int update(ReplyDTO reply);
	
	int delete(Long rno);
	
	ReplyDTO read(Long bno);
	
	List<ReplyDTO> getList(@Param("cri") ReplySearchDTO cri,
			               @Param("bno") Long bno);
	
	int getCountByBno (Long bno);

}
