package xml.service.impl;

import xml.BookShopDAO;
import xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

	private BookShopDAO bookShopDAO;

	public void setBookShopDAO(BookShopDAO bookShopDAO) {
		this.bookShopDAO = bookShopDAO;
	}

	@Override
	public void purchase(String username, String isbn) {

		// 1.先取得書的單價
		int price = bookShopDAO.findBookPriceByIsbn(isbn);
		// 2.更新書的庫存
		bookShopDAO.updateBookStock(isbn);
		// 3.更新用戶的餘額
		bookShopDAO.updateUserAccount(username, price);
	}

}
