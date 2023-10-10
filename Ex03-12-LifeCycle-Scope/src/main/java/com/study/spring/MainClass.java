package com.study.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:beans.xml");
		
		//싱글톤 student를 부름
		Student student1 = ctx.getBean("student",Student.class);
		System.out.println(student1.toString());
		
		System.out.println("==========================");
		
		//싱글톤 student를 다른 변수로 부름
		Student student2 = ctx.getBean("student",Student.class);
		
		//이후 value 변경
		student2.setName("전우치");
		student2.setAge(25);
		
		//변경된 value값 나옴
		System.out.println(student2.toString());
		//student1의 값도 변경됨(싱글톤이므로-같은객체)
		System.out.println(student1.toString());
		
		//객체가 저장하는 value
		if (student1.equals(student2)) {
			System.out.println("student1==student2");
		} else {
			System.out.println("student1!=student2");
		}
		//객체 자체 비교
		System.out.println(student1==student2);
		
		ctx.close();
		
		
		//이니셜라이징을 bean.xml로 두고 싱글톤으로 둔뒤
		//이후 값변경하면서 사용할수 있다. static과 비슷
		
		/*
		 	type을 prototype으로 두면 getBean할때마다
		 	새로운 객체를 선언.
		 	초기값을 설정한 객체로 쓸 수 있다.
		*/
		
	}
}
