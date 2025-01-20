package com.example.demo.securing.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.securing.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

//import lombok.Setter;

//@Setter
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
	private final UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		//단건조회
		UserDTO userDTO = userMapper.getUser(username);
		if(userDTO == null) {
			throw new UsernameNotFoundException("id check plz");
		}
		//List<GrantedAuthority> role = new ArrayList<>();
		//userDTO.getRoles().forEach(r -> role.add(new SimpleGrantedAuthority(r.getRoleName())));
		//return new User(userDTO.getLoginId(), userDTO.getPassword(), role);
		
		System.out.println("userDTO:"+ userDTO);
		//1. UserDTO implements UserDetails 을 한경우 
		//return userDTO;
		
		//2. CustomerUser implements UserDetails 따로 클래스 만들어서 한 경우 
		return new CustomerUser(userDTO);
		
		
	}

}
