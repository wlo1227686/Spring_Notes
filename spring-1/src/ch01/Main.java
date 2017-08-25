package ch01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import ch01.collections.NewPerson;

public class Main {
	public static void main(String[] args) {

		// // 1.先new一個類別
		// HelloWord helloWord = new HelloWord();
		// // 2.屬性賦值
		// helloWord.setName("8787");
		// // 3.使用該類別內的一個方法
		// helloWord.hello();

		// ApplicationContext 代表IOC容器<主要有兩個子類別>
		// 1.ClassPathXmlApplicationContext從類別路徑下加載文件
		// 透過這個子類別讓IOC容器提供刷新(Refresh)和關閉(close)方法

		// 2.FileSystemXmlApplicationContext從文件路徑下加載文件
		// 當ApplicationContext初始化時就已經new完所有單例的bean

		// WebApplicationContext是專門為網頁而準備，提供網頁使用IOC容器

		// 1.創建Spring 的IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2.從IOC容器中獲取BEAN類別
		// 直接透過ID來存取IOC控管的BEAN
		// HelloWord helloWord = (HelloWord) ctx.getBean("helloword2");

		// 直接透過類別物件來存與IOC控管的BEAN(使用時要注意，在IOC控管下的BEAN所使用的類別物件必須是唯一的不重複)
		// HelloWord helloWord = ctx.getBean(HelloWord.class);
		HelloWord helloWord = (HelloWord) ctx.getBean("helloword2");
		System.out.println(helloWord);
		// 3.使用該類別內的一個方法
		// helloWord.hello();

		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);

		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		Person person2 = (Person) ctx.getBean("person2");
		System.out.println(person2);
	}
}
