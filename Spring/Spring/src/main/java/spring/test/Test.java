package spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.HelloWorld;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld helloworld = (HelloWorld) ac.getBean("niukun");
		helloworld.say();
	}

}
