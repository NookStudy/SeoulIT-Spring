package com.study.spring;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class HelloBeanTest2 {
	public static void	main(String[] args) {
		String configLocation = "classpath:bean.xml";
		
		//1.IoC 컨테이너 생성
		ApplicationContext context = new GenericXmlApplicationContext(configLocation);
		ConfigurableEnvironment environment = (ConfigurableEnvironment) context.getEnvironment();
		MutablePropertySources propertySources = environment.getPropertySources();
		
		try {
			propertySources.addLast(
					new ResourcePropertySource("classpath:config/database.properties")
			);
			
			System.out.println(environment.getProperty("db.username"));
			System.out.println(environment.getProperty("db.password"));
		} catch (IOException e) {}
			
			
			//2. Hello Bean 가져오기
			Hello hello = (Hello)context.getBean("hello"); 

			System.out.println(hello.getDriverClass());
			System.out.println(hello.getUrl());
			System.out.println(hello.getUsername());
			System.out.println(hello.getPassword());
			
			System.out.println("--------------------------------");
			
			System.out.println(environment.getProperty("db.username"));
			System.out.println(environment.getProperty("db.password"));
			
		
		
	}
}
