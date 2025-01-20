package com.example.demo.securingweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.securing.service.CustomerUser;
import com.example.demo.securing.service.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			                            HttpServletResponse response,
			                            Authentication auth) 
					throws IOException, ServletException {
		//auth에서 정보 꺼내기 (단건조회)
		UserDTO dto =((CustomerUser)auth.getPrincipal()).getUserDTO();
		//session 에 정보 저장 
		request.getSession().setAttribute("userid",dto.getId());
		request.getSession().setAttribute("deptName",dto.getDeptName());
		
		
		// username, role 정보 받아서 거기에 맞게 처리 
		
		//role 
		// role 정보 추출 => role의 경우 여러개 가능해서 배열로 받음
		List<String> roleNames = new ArrayList<>();
		//getAuthorities() 은 collection 즉 배열 이라 foreach로 role  추출
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		System.out.println("roleName:" + roleNames);
		
		//role 에 따라 다르게 페이지 이동 처리
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin");
			return;
		} else if(roleNames.contains("ROLE_USER")) {
			response.sendRedirect("/hello");
			return;
		}
		response.sendRedirect("/");
	}

}
