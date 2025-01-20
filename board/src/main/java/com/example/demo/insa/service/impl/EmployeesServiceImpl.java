package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.mapper.EmployeesMapper;
import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.EmployeesService;
import com.example.demo.insa.service.JobsDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeesServiceImpl implements EmployeesService{
	
	private final EmployeesMapper empMapper;
	
	@Override
	public List<EmployeesDTO> getList() {
		
		return empMapper.getList();
	}

	@Override
	public List<JobsDTO> getJobList() {
		return empMapper.jobList();
	}

	@Override
	public List<DeptDTO> getDepList() {
		return empMapper.deptList();
	}

	@Override
	public void register(EmployeesDTO employee) {
		empMapper.insert(employee);
	}

	
	
	
	
}
