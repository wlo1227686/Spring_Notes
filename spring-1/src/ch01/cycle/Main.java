package ch01.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// 基本寫法
		// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("beans-cycle.xml");

		// 此寫法包含close方法
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");

		Car car = ctx.getBean(Car.class);
		System.out.println("[main]"+car);

		// 關閉IOC容器
		ctx.close();
	}
}
