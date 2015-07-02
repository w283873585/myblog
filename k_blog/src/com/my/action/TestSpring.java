package com.my.action;

import org.apache.catalina.core.ApplicationContext;

public class TestSpring {
	public static void test(ApplicationContext context) {
		System.out.println(context.getAttribute("hello"));
	}
}
