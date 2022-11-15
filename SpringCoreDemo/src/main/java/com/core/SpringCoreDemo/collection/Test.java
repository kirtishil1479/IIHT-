package com.core.SpringCoreDemo.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("CollectionConfig.xml");
		Employee emp1 =(Employee) context.getBean("employee1");
		System.out.println(emp1.getEmployeename());
		System.out.println(emp1.getPhones());
		System.out.println(emp1.getAddress());
		System.out.println(emp1.getCourses());
		System.out.println(emp1.getProps());
		
	}
	

}
