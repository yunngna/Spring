package com.example.demo.securingweb;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
//error 403 controller 
	
	private Logger log = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);


    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.error("No Authorities", accessDeniedException);
        log.error("Request Uri : {}", request.getRequestURI());

        //ApiResponse<ErrorResponse> apiResponse = ApiResponse.createAuthoritiesError();
        //String responseBody = objectMapper.writeValueAsString(apiResponse);
        
        //sendRedirect, forward ,json 타입 모두 가능하다. 
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("접근권한 오류"); // 페이지에 나타날 내용
    }


}