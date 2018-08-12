package com.niukun.spring.anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {

	private ApplicationContext context;

	@Test
	public void testUser() {
		context = new ClassPathXmlApplicationContext("bean.xml");
		User user = (User) context.getBean("user");
		user.add();
		
	}
	
	@Test
	public void testService() {
		context = new ClassPathXmlApplicationContext("bean.xml");
		UserService userService = (UserService) context.getBean("userService");
		userService.add();
		
	}
}
