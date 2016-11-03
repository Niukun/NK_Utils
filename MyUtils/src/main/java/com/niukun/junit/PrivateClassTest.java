package com.niukun.junit;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class PrivateClassTest {

	PrivateClass a = null;

	@Before
	public void setUp() throws Exception {
		a = new PrivateClass();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testNoParamEchoRequest() throws Exception {
		// 测试没有参数的echoRequest()方法
		Method testNoParamMethod = a.getClass().getDeclaredMethod("echoRequest", null);
		// Method对象继承自java.lang.reflect.AccessibleObject，父类方法setAccessible可调
		// 将此对象的 accessible 标志设置为指示的布尔值。值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。值为
		// false 则指示反射的对象应该实施 Java 语言访问检查。
		// 要访问私有方法必须将accessible设置为true，否则抛java.lang.IllegalAccessException
		testNoParamMethod.setAccessible(true);
		// 调用
		Object result = testNoParamMethod.invoke(a, null);
		System.out.println(result);
		Assert.assertNotNull(result);

	}

	@Test
	public void testParamEchoRequest() throws Exception {
		// 测试带有参数的echoRequest(String request)方法
		Method testNoParamMethod = a.getClass().getDeclaredMethod("echoRequest", String.class);
		testNoParamMethod.setAccessible(true);
		// 调用
		Object result = testNoParamMethod.invoke(a, "this is a test information");
		System.out.println(result);
		Assert.assertNotNull(result);

	}

}
