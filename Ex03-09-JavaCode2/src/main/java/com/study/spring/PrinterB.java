package com.study.spring;

import org.springframework.stereotype.Component;

@Component("printerB") //이 이름으로 빈에 등록하겠다는 뜻
public class PrinterB implements Printer{
	@Override
	public void print(String message) {
		
		System.out.println("Printer B : "+message);
	}
}
