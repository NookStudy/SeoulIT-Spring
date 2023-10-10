package com.study.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class OtherStudent {
	private String name;
	private String age;
	
	public OtherStudent(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("OhterSutdent : initMethod()");
	}
	
	@PreDestroy
	public void destoryMethod() {
		System.out.println("OhterStudent : destoryMethod()");
	}

	@Override
	public String toString() {
		return "OtherStudent [name=" + name + ", age=" + age + "]";
	}
	
}
