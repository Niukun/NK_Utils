package com.niukun.test;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;

public class test {
	ArrayList<Person> list = new ArrayList<Person>();

	@Test
	public void testUUID() throws InterruptedException {
		for (int i = 0; i < 1000000; i++) {
			UUID uuid = new UUID(12312313123L, 123123123L);
			String a = new String("Hello world!");
			Person p = new Person();
			list.add(p);
			Thread.sleep(10);
//			System.out.println(uuid.toString());
		}
	}

}

class Person {
	String name;
	String addr;
	int age;
	
	
	
	public Person() {
		super();
	}
	public Person(String name, String addr, int age) {
		super();
		this.name = name;
		this.addr = addr;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}