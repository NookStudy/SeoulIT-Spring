package com.study.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		
		context.load("classpath:beans.xml");
		System.out.println("aaaaa");
		//refresh 전에는 못불러옴... 왜지?
		context.refresh();
		//1.afterPropertiesSet() 실행
		//2.(postconstruct)initMethod() 실행
		
		Student student = context.getBean("student",Student.class);
		System.out.println(student.toString());
		System.out.println("bbbbb");
//		Student student = context.getBean("student",Student.class);
//		System.out.println(student.toString());
		
		OtherStudent otherStudent = context.getBean("otherStudent",OtherStudent.class);
		System.out.println(otherStudent.toString());
		context.close();
		
		//3.predestroy 실행 <-- 이부분에 서버를 종료합니다 따위를 쓸수 있다.
		//4.destroy() 실행
		System.out.println("cccc");
		
	}
}
