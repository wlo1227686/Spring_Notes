package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDAO")
public class BookShopDAOImpl implements BookShopDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = "SELECT price FROM book WHERE isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}

	@Override
	public void updateBookStock(String isbn) {
		// 檢查庫存是否足夠，若不夠則拋出例外事件
		String sql2 = "SELECT stock FROM book_stock WHERE isbn = ?";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
		if (stock == 0) {
			throw new BookStockException("庫存不足");
		}
		String sql = "UPDATE book_stock SET stock = stock -1 WHERE isbn = ?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateUserAccount(String username, int price) {
		// 檢查帳戶餘額是否足夠，若不夠則拋出例外事件
		String sql2 = "SELECT balance FROM account WHERE username = ?";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
		if (balance < price) {
			throw new UserAccountException("餘額不足");
		}

		String sql = "UPDATE account SET balance = balance - ? WHERE username = ?";
		jdbcTemplate.update(sql, price, username);
	}

}
