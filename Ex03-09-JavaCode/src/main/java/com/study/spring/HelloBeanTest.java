package com.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloBeanTest {
	public static void	main(String[] args) {
		
		//1.IoC 컨테이너 생성
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		//2. Hello Bean 가져오기
		Hello helloA = (Hello)context.getBean("hello"); 
		helloA.print();
		
		//3. Hello Bean 가져오기
		Hello helloB = (Hello)context.getBean("hello1"); 
		helloB.print();
		
		//4.PrinterB Bean 가져오기
		Printer printer = context.getBean("printerB",Printer.class);
		helloA.setPrinter(printer);
		helloA.print();
	
		//5.싱글톤확인
		System.out.println(helloA==helloB);
		
		//6.Nook hello1 가져오기
		Hello hello1 = (Hello)context.getBean("hello1");
		hello1.print();
		
//		context.close();
	}
}
