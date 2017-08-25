package tx;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {
	private ApplicationContext ctx = null;
	private BookShopDAO bookShopDAO = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
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

	@Test
	public void testBookShopDAOUpdateUserAccount() {
		// 更新用戶餘額
		bookShopDAO.updateUserAccount("AA", 100);
	}

	@Test
	public void testBookShopDAOUpdateBookStock() {
		// 更新庫存
		bookShopDAO.updateBookStock("1001");
	}

	@Test
	public void testBookShopDAOFindPriceByIsbn() {
		// 用isbn查價格
		System.out.println(bookShopDAO.findBookPriceByIsbn("1001"));
	}

}
