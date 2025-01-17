package com.example.demo.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
//@Aspect
public class LogAdvice {
	 @Pointcut("execution(* com.example..*Impl.*(..))")
	 public void allpointcut() {}
	 
	 @Pointcut("execution(* com.example..*Impl.get*(..))")
	 public void getpointcut() {}
	 
	 @Before("allpointcut()")
	 public void log(JoinPoint jp) {
		 //메서드 이름 출력
		 String methdname = jp.getSignature().getName();
		 log.info("[before]"+ methdname);
		 
		 //파라미터 출력
		 Object[] obj = jp.getArgs();
		 if(obj != null) {
			 log.info("parameter:");
			 Arrays.asList(obj).forEach(p -> log.info(p.toString()));
		 }
	 }
	 
	 @AfterReturning(value = "getpointcut()",returning = "result")
	 public void after(JoinPoint jp, Object result) {
		 //메서드 이름 출력
		 String methdname = jp.getSignature().getName();
		 log.info("[after returning]"+ methdname);
		 
		 //서비스 리턴값 출력 
		 log.info("return :" + result);
	 }
}
