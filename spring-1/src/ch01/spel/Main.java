package ch01.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-spel.xml");
		Address address = ctx.getBean(Address.class);
		System.out.println(address);

		Car car = ctx.getBean(Car.class);
		System.out.println(car);

		Person person = ctx.getBean(Person.class);
		System.out.println(person);
	}
}
