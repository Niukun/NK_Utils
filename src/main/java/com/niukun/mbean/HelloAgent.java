package com.niukun.mbean;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class HelloAgent {
	
	public static void main(String[] args) throws Exception {
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		ObjectName helloName = new ObjectName("Niukun:name=niu");
		// create mbean and	 register mbean
		server.registerMBean(new Hello(), helloName);

	}
	
}
