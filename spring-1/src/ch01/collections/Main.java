package ch01.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) ctx.getBean("person5");
		System.out.println(person);
		NewPerson newPerson = (NewPerson) ctx.getBean("NewPerson");
		System.out.println(newPerson);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getProperties());
	}
}
