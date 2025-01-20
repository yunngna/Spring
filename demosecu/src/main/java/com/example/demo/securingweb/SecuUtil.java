package com.example.demo.securingweb;

import org.apache.ibatis.io.ResolverUtil.IsA;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.securing.service.CustomerUser;
import com.example.demo.securing.service.UserDTO;

public class SecuUtil {
 
//	public static UserDTO getUser() {
//		
//		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		CustomerUser userDetails = null;
//		System.out.println(obj);
////		if(! obj instanceof IsAno) {
////			userDetails = ((CustomerUser)obj).getUserDTO();
////		}else {
////			userDetails = new UserDTO();
////		}
//			
//		return userDetails;
//	}
}
