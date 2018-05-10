package com.niukun.bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.junit.Test;


public class PersonTest {

	@Test
	public void test() throws Exception {
		BeanInfo info = Introspector.getBeanInfo(Person.class,Object.class);
		PropertyDescriptor[]  pds= info.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
		}
	}

}
