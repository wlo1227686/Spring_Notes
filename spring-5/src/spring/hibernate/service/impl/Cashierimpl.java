package spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.hibernate.service.BookShopService;
import spring.hibernate.service.Cashier;

@Service
public class Cashierimpl implements Cashier {
	@Autowired
	private BookShopService bookShopService;

	@Override
	public void checkout(String username, List<String> isbns) {
		for (String isbn : isbns) {
			bookShopService.purchase(username, isbn);
		}
	}

}
