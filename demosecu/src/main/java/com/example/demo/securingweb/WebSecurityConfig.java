package com.example.demo.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	//암호화 된 password 인코딩 
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				//hasAnyRole = 여러 권한들로 접근  =  Spring에서는 role을 앞에 꼭 붙여줘야 한다. 
				//hasRole = 한가지 권한 으로 접근 = 이때는 role 이 자동으로 붙기 때문에 안붙여 줘도 된다.
				
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
			.loginPage("/login")
			.usernameParameter("userid")
			.successHandler(sutheAuthenticationSuccessHandler()) //로그인성공시 
			.permitAll()
			)
			.logout((logout) -> logout.permitAll())
			
			//csrf토큰 발행은 get 방식은 사용 안하고 보통 post 방식에 사용 (따로 지정 하지 않으면 default가 활성화)
			//.csrf(csrf -> csrf.disable()) //csrf 토큰 발행 비활성화
			;  
		
		
		//로그인 실패 시 (error 403)
		//http.exceptionHandling(ex -> ex.accessDeniedPage("/error403.html")); //페이지 이동 
		http.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler())); // 컨트롤러 이동 
		

		return http.build();
	}
	
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler sutheAuthenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	//@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
			 //인증 
				.username("user") // 아이디 
				.password("1111") //비밀번호
			//인가
				.roles("USER") // roles = 권한부여 
				.build();
		
		UserDetails admin =
				 User.withDefaultPasswordEncoder()
				 //인증 
					.username("admin") // 아이디 
					.password("1111") //비밀번호
				//인가
					.roles("ADMIN") // roles = 권한부여 
					.build();

		return new InMemoryUserDetailsManager(user,admin);
	}
}