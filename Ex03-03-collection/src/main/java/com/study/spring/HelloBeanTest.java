package com.study.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanTest {
	public static void	main(String[] args) {
		//xml 설정 파일의 위치를 선언
		/*
			class path의 의미 : 웹애플리케이션을 WAR로 배포했을 때 classes 폴더 하위로 
			패키지와 클래스, XML 설정 파일들이 위치하게 되는데 해당 디렉토리를 가리키는 
			예약어이다.
		 */
		String configLocation = "classpath:bean.xml";
		
		
		//1.IoC 컨테이너 생성, 스프링에서 자동으로 만듬(웹서버)
		//xml설정파일을 기반으로 스프링컨테이너를 생성
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext(configLocation);
		
		//2.Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello"); 
		
		//List출력
		List<String> myList = hello.getNames();
		for (String value : myList) {
			System.out.println("List : "+value);
		}
		
		//Set출력
		Set<Integer> mySet1 = hello.getNums();
		for (Integer value : mySet1) {
			System.out.println("Set : "+value);
		}
		
		//Map출력
		Map<String,Integer> map = hello.getAges();
		
		//방법 01 : entrySet
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Map1 : "+entry.getKey() + " - "+entry.getValue());
		}
		
		//방법 02 : keySet
		for (String key : map.keySet()) {
			Integer value = map.get(key);
			System.out.println("Map2 : "+key+ " - "+ value);
		}
		
		//방법 03 : Iterator
		Iterator<String> iterator = map.keySet().iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			Integer value = map.get(key);
			System.out.println("Map3 : "+key+" - "+value);
		}
		
		context.close();
	}
}
