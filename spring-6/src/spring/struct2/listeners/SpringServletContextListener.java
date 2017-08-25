package spring.struct2.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.struct2.bean.Person;

/**
 * Application Lifecycle Listener implementation class
 * SpringServletContextListener
 *
 */
@WebListener
public class SpringServletContextListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public SpringServletContextListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {

		// 1.獲取Spring配置文件的名稱
		ServletContext servletContext = sce.getServletContext();
		String config = servletContext.getInitParameter("configLocation");

		// 1.創建IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

		// 2.把IOC容器放在ServletContext的一個屬性中
		servletContext.setAttribute("ApplicationContext", ctx);
	}

}
