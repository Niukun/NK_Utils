package com.niukun.test;

import java.util.UUID;

import org.junit.Test;

public class test {

@Test
public void testUUID() {
	for(int i =0;i<100;i++) {
		UUID uuid = new UUID(12312313123L,123123123L);	
		
		System.out.println(uuid.toString());
	}
}
	
	
	
}
