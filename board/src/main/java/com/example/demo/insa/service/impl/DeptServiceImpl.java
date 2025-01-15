package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.mapper.DeptMapper;
import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {
	
	private final DeptMapper deptmapper;

	@Override
	public List<DeptDTO> getList(DeptDTO searchDTO) {
		return deptmapper.getList(searchDTO);
	}

	@Override
	public DeptDTO read(Long departmentId) {
		return deptmapper.read(departmentId);
	}

}
