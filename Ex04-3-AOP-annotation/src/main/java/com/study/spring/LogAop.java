package com.study.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	
	@Pointcut("within(com.study.spring.*)")
	private void pointcutMethod() {
	}

//	
//	@Pointcut("within(com.study.spring.*)")
//	private void pointcutMethod() {}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		String sinatureStr = joinPoint.getSignature().toShortString();
		System.out.println(sinatureStr+" is start.");
		
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			
			System.out.println(sinatureStr+" is finished");
			System.out.println(sinatureStr+" 경과시간 : "+(et-st));
		}
	}
	
	
	@Before("pointcutMethod()")
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
}
