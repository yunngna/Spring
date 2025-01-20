package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.EmployeesDTO;
import com.example.demo.insa.service.JobsDTO;

public interface EmployeesMapper {
	
	//사원전체조회
	List<EmployeesDTO>getList();
	
	//직업전체조회
	List<JobsDTO>jobList() ;
	
	//부서전체 조회
	List<DeptDTO>deptList();
	
	//사원등록 
	int insert(EmployeesDTO employeesDTO);

}
