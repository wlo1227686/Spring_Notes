package ch02.aop.Impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// 1.創建spring的ioc容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		// 2.從ioc容器獲得bean的實例
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
		// 3.使用bean
		int result = 0;
		System.out.println(arithmeticCalculator.getClass().getName());
		result = arithmeticCalculator.add(3, 6);
		System.out.println(result);
		result = arithmeticCalculator.div(12, 3);
		System.out.println(result);
		result = arithmeticCalculator.mul(12, 6);
		System.out.println(result);
		result = arithmeticCalculator.sub(12, 6);
		System.out.println(result);
	}
}
