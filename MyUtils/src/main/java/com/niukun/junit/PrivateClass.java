package com.niukun.junit;

public class PrivateClass {
	private String echoRequest(String request) {
		System.out.println("wobuzhidaomima");
		return "Hello!" + request;
	}

	private String echoRequest() {
		return "Hello!";
	}
}
