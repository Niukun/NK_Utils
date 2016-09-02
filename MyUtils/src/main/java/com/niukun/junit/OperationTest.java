package com.niukun.junit;

import org.junit.Ignore;
import org.junit.Test;

public class OperationTest {

	@Test
	public void testAdd() {
		Operation o = new Operation();
		int i = o.add(3, 5);
		System.out.println(i);
	}

	@Test
	public void testSub() {
		Operation o = new Operation();
		int i = o.sub(3, 5);
		System.out.println(i);
	}

}
