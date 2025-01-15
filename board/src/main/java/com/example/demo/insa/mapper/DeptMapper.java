package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.DeptDTO;

public interface DeptMapper {
	
	//전체조회
	List<DeptDTO>getList(DeptDTO searchDTO);
	
	//단건조회
	DeptDTO read(Long departmentId);

}
