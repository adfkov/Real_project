package com.example.demo.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect // 부가 기능 정의(advice) + 어디에 적용(pointcut) => 합친 것 
@Component
public class TimeTraceAop { // Singleton 객체로 생성됨
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@Around("execution(* com.example.demo..*(..))") // 적용방식 2가지 1. 패키지 범위를 "" 사이에 => 어디에 적용?(pointcut)
	@Around("@annotation(TimeTrace)") // 어느 어노테이션이 붙어있을 때 사용할 것인지를 지정할 수 있다.
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		// 타겟이 적용하는 메소드 - joinPoint(어느 메소드에 껴넣을 것?)
		
		// 시간 측정
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// 원래 해야 하는 일 ex) 회원가입
		Object proceedObj = joinPoint.proceed(); // 회원가입 수행,실패하면 상위로 던진다(throws)
		
		stopWatch.stop();
		logger.info("#####실행 시간(ms): " +stopWatch.getTotalTimeMillis());
		logger.info(stopWatch.prettyPrint()); // 예쁘게 출력
		
		return proceedObj;
		
	}
	
}
