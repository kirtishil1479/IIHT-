package com.core.SpringCoreDemo.reflectionInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefTest {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/core/SpringCoreDemo/reflectionInjection/Reflection.xml");	
		Object1 temp = (Object1) context.getBean("object1");
		System.out.println(temp.getX());
		
		
	}

}
