package com.study.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean,DisposableBean{
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception{
		System.out.println("Student : afterPropertiesSet()");
	}
	
	@Override
	public void destroy() throws Exception{
		System.out.println("Student : destroy()");
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
