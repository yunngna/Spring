package com.example.demo.securing.mapper;

import java.util.List;

import com.example.demo.securing.service.RoleDTO;
import com.example.demo.securing.service.UserDTO;

public interface UserMapper {
	
	//단건 조회
	UserDTO getUser(String loginId);
	
	//권한 조회
	List<RoleDTO> getRole(Long id);

}
