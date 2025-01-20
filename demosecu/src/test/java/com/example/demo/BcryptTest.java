package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest {
//db 에 비밀번호를 암호화 해서 저장 
	@Test
	public void test() {
		// Create an encoder with strength 16 = 보안 강도 (1-30): 16
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		String result = encoder.encode("1234");
		System.out.println(result);
		assertThat(encoder.matches("1234", result));
	}
	
	//여기서 나온 암호화된 패스워드 $2a$16$Lk3aMomSTSaKkCX75ub9aucEMa0yAdR80rvoo33062SmPuK12stzW 을 db에 password update 해준다.
}
