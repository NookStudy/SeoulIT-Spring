package com.study.spring;

import org.springframework.stereotype.Component;


//검색된 클래스를 빈으로 등록할 때, 
//클래스의 첫 글자를 소문자로 바꾼 이름을 빈의 이름으로 등록한다.
@Component
public class Hello {
	private String name;
	private String nickname;
	private Printer printer;
	
	
	//사용할 수 있으므로 놔둔다.
	public Hello() {
		// TODO Auto-generated constructor stub
	}
	
	public Hello(String name, String nickname, Printer printer) {
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	public String sayHello() {
		return "Hello "+name+" : "+nickname ;
	}
	public void print() {
		printer.print(sayHello());
	}
}
