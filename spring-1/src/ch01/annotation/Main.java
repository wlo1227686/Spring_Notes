package ch01.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch01.annotation.controller.UserController;
import ch01.annotation.repository.UserRepository;
import ch01.annotation.service.UserService;

public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");

		// 使用註解的方式來標示bean檔

		// TestObject to = (TestObject) ctx.getBean("testObject");
		// System.out.println(to);
		//
		UserController userController = (UserController) ctx.getBean("userController");
		System.out.println(userController);
		userController.execute();

		//
		// UserService userService = (UserService) ctx.getBean("userService");
		// System.out.println(userService);

		// UserRepository userRepository = (UserRepository)
		// ctx.getBean("userRepository");
		// System.out.println(userRepository);

	}
}
