package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.JobsDTO;

public interface EmployeesMapper {
	
	//사원전체조회
	List<EmployeesDTO>getList();
	
	//직업전체조회
	List<JobsDTO>getJobList();

}
