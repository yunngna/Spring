package com.example.demo.insa.service;

import java.util.List;

public interface EmployeesService {

	//사원전체조회
	public List<EmployeesDTO> getList();
	
	//직업 전체조회
	public List<JobsDTO> getJobList();
	
	//부서 전체 조회
	public List<DeptDTO> getDepList();
	
	//사원등록
	public void register(EmployeesDTO employee);
	
	
	
}
