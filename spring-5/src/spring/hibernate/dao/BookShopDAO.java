package spring.hibernate.dao;

public interface BookShopDAO {
	// 根據書的編號(isbn)獲取單價
	public int findBookPriceByIsbn(String isbn);

	// 更新庫存內的數量，使書號對應的庫存減1
	public void updateBookStock(String isbn);

	// 更新用戶的帳戶餘額:使Username的balence-price
	public void updateUserAccount(String username, int price);
}
