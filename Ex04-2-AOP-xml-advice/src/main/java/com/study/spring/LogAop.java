package com.study.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//공통기능을 수행할 클래스를 정의
public class LogAop {
	
	//beans.xml에 등록된 표현식에 의해 Student,Worker 클래스가 조인포인트로 설정되었기에
	//해당 클래스의 모든 메서드는 포인트컷이 되었음
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		 	현재 호출된 메서드명을 문자열로 변환 후  반환해준다.
		 	즉, 실행되는 메서드명을 알 수 있다. 
		 */
		String sinatureStr = joinPoint.getSignature().toShortString();
		//advice를 around로 지정시 공통기능 수행부분
		//핵심기능 수행전 출력된다.
		System.out.println(sinatureStr+" is start.");
		
		//시스템에서 현재 시간을 밀리세컨즈 단위로 가져온다.
		long st = System.currentTimeMillis();
		
		try {
			/*
			 	매개변수를 통해서 핵심기능을 수행한다. proceed() 메서드 호출을 통해 
			 	수행할 수 있고
			 */
			//loggerAop의 파라미터로 전달이 되고 이곳에서 실제 실행된다.
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			//핵심기능 수행 후 시스템 시간을 가져온다.
			long et = System.currentTimeMillis();
			
			System.out.println(sinatureStr+" is finished");
			//핵심기능의 수행된 시간을 로그에 출력한다.
			System.out.println(sinatureStr+" 경과시간 : "+(et-st));
		}
	}
	
	public void beforeAdvice(JoinPoint joinpoint) {
		System.out.println("beforeAdvice()");
	}
	
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice()");
	}
	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}
}
