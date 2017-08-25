package spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.hibernate.dao.BookShopDAO;
import spring.hibernate.service.BookShopService;

@Service
public class BookShopServiceimpl implements BookShopService {
	@Autowired
	private BookShopDAO bookShopDAO;

	// Spring hibernate Transaction的流程
		// 1.在方法開始之前
			// i.獲取Session
			// ii.把Session和當前線程綁定,這樣就可以在DAO中使用SessionFactory的getCurrentSession()方法,來取得Session了
			// iii.開啟Transaction
		// 2.若方法正常結束,即沒出現異常,則
			// i.提交事物
			// ii.和當前線程綁定的Session解除綁定
			// iii.關閉Session
		// 3.若方法出現異常,則:
			// i.RollBack 
			// ii.和當前線程綁定的Session解除綁定
			// iii.關閉Session

	@Override
	public void purchase(String username, String isbn) {
		int price = bookShopDAO.findBookPriceByIsbn(isbn);
		bookShopDAO.updateBookStock(isbn);
		bookShopDAO.updateUserAccount(username, price);
	}

}
