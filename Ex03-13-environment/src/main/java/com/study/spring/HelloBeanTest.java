package com.study.spring;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class HelloBeanTest {
	public static void	main(String[] args) {
//		String configLocation = "classpath:bean.xml";
		
		ConfigurableApplicationContext context1 = new GenericXmlApplicationContext();
		ConfigurableEnvironment environment = context1.getEnvironment();
		MutablePropertySources propertySources = environment.getPropertySources();
		
		try {
			propertySources.addLast(
					new ResourcePropertySource("classpath:config/database.properties")
			);
			
			System.out.println(environment.getProperty("db.username"));
			System.out.println(environment.getProperty("db.password"));
		} catch (IOException e) {}
			GenericXmlApplicationContext context2 =(GenericXmlApplicationContext)context1;
			context2.load("classpath:bean.xml");
			context2.refresh();
			
			//2. Hello Bean 가져오기
			Hello hello = (Hello)context2.getBean("hello"); 

			System.out.println(hello.getDriverClass());
			System.out.println(hello.getUrl());
			System.out.println(hello.getUsername());
			System.out.println(hello.getPassword());
			
			System.out.println("--------------------------------");
			
			System.out.println(environment.getProperty("db.username"));
			System.out.println(environment.getProperty("db.password"));
			
			context1.close();
			context2.close();
		
		
	}
}
