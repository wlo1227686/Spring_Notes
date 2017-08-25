package ch01.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch01.autowire.Address;
import ch01.autowire.Person;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
		// 抽象類別是不能被實例化
		Address address = (Address) ctx.getBean("address3");
		System.out.println(address);

		address = (Address) ctx.getBean("address2");
		System.out.println(address);

		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
	}
}
