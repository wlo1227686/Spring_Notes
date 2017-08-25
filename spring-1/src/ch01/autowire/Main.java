package ch01.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-autowire.xml");
		Person person = ctx.getBean(Person.class);
		System.out.println(person);
	}
}
