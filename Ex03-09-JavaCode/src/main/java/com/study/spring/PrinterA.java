package com.study.spring;

import org.springframework.stereotype.Component;

@Component("printerA") //이 이름으로 빈에 등록하겠다는 뜻
public class PrinterA implements Printer{
	@Override
	public void print(String message) {
		
		System.out.println("Printer A : "+message);
	}
}
