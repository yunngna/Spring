package com.example.demo.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class AroundAdvice {
   //pointcut은 LogAdivce에서 참조해서 사용 
  // LogAdvice.allpointcut()가 실행될 때 해당 메소드 실행
  // ex) 트랜젝션 처리할 때
	
  @Around("LogAdvice.allpointcut()")
  public Object logTime(ProceedingJoinPoint proceedingJoinPoint) {
    
    Object obj = null;
    
    // service method (서비스메서드) 실행 전
    long start = System.currentTimeMillis();

    // service method (서비스메서드)calling(호출)
    try {
      obj = proceedingJoinPoint.proceed();
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }


    // after calling service method (서비스메서드) 실행 후 
    long end = System.currentTimeMillis();
    log.info("time:{}", end - start);
    return obj;

  }
}
