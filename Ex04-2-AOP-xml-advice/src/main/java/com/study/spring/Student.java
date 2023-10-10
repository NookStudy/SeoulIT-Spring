package com.study.spring;

public class Student {
	
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
	
	public String getStudentInfo() {
		System.out.println("이름 : " +getName());
		System.out.println("나이 : " +getAge());
		
		try {
			System.out.println(10/0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "end";
	}
	
}
