package spring.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.hibernate.dao.BookShopDAO;
import spring.hibernate.exception.BookStockException;
import spring.hibernate.exception.UserAccountException;

@Repository
public class BookShopDAOimpl implements BookShopDAO {
	// 因為這邊是dao所以在使用Hibernate時,不能用openSession的方法,而是改用getCurrentSession
	@Autowired
	private SessionFactory sessionFactory;

	// 部推薦使用 hibernateTemplate 和 HibernateDaoSupport
	// 這會導致 DAO 和 Spring 的API 發生耦合降低可移植性
	// private HibernateTemplate hibernateTemplate;

	// 獲取跟當前線程綁定的Session
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int findBookPriceByIsbn(String isbn) {
		String hql = "SELECT b.price FROM Book b WHERE b.isbn = ?";
		// Query query = getSession().createQuery(hql).setString(0, isbn);
		// (since 5.2)
		Query query = getSession().createQuery(hql).setParameter(0, isbn);
		return (Integer) query.uniqueResult();
	}

	@Override
	public void updateBookStock(String isbn) {
		// 驗證書的庫存是否充足(mysql 語法不支持檢查元素,你必須自行增加驗證機制)
		String hql2 = "SELECT b.stock FROM Book b WHERE b.isbn=?";
		int stock = (int) getSession().createQuery(hql2).setParameter(0, isbn).uniqueResult();
		if (stock == 0) {
			throw new BookStockException("庫存不足!");
		}

		String hql = "UPDATE Book b SET b.stock = b.stock -1 WHERE b.isbn=?";
		getSession().createQuery(hql).setParameter(0, isbn).executeUpdate();
	}

	@Override
	public void updateUserAccount(String username, int price) {
		// 驗餘額是否足夠
		String hql2 = "SELECT a.balance FROM Account a WHERE a.username=?";
		int balance = (int) getSession().createQuery(hql2).setParameter(0, username).uniqueResult();
		if (balance < price) {
			throw new UserAccountException("餘額不足!");
		}
		String hql = "UPDATE Account a set a.balance = a.balance - ? WHERE a.username=?";
		getSession().createQuery(hql).setParameter(0, price).setParameter(1, username).executeUpdate();
	}

}
