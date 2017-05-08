package com.niukun.junit;

public class PrivateClass {
	@SuppressWarnings("unused")
	private String echoRequest(String request) {
		System.out.println("wobuzhidaomima");
		return "Hello!" + request;
	}

	@SuppressWarnings("unused")
	private String echoRequest() {
		return "Hello!";
	}
}
