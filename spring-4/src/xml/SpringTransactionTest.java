package xml;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xml.service.BookShopService;
import xml.service.Cashier;

public class SpringTransactionTest {
	private ApplicationContext ctx = null;
	private BookShopDAO bookShopDAO = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-tx-xml.xml");
		bookShopDAO = ctx.getBean(BookShopDAO.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}

	@Test
	public void testTransactionlPropagation() {
		cashier.checkout("AA", Arrays.asList("1001", "1002"));
	}

	@Test
	public void testBookShopService() {
		bookShopService.purchase("AA", "1001");
	}

}
