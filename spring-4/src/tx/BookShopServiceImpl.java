package tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDAO bookShopDAO;

	// 將該方法交由Spring TransactionManager管控
	// 思考:菜市場買菜，到魚店買魚裝一個袋子，到水果攤買水果裝一個袋子。
	// 請問應該是要兩個袋子同一隻手拿，還是分成兩隻手拿，還是裝成一個袋子一隻手拿?
	// 在TransactionManager管控下(方法A)如何去呼叫(方法B)

	// (一)Transactional提供一個屬性propagation說明交易的方式
	// 1.REQUIRED :不是全部方法都成功，就是全部方法都失敗(不是0就是1沒別的)!!預設值!!
	// 2.REQUIRES_NEW : 為每個方法都設中斷點，某方法異常不會影響其他方法(斷尾求生)
	// 3.SUPPORTS
	// 4.NOT_SUPPORTED
	// 5.MANDATORY
	// 6.NEVER
	// 7.NESTED
	// (二)Transactional提供一個屬性isolation來說明該交易的級別,最常使用為READ_COMMITTED

	// (三)Transactional當發生例外事件時，Spring預設會進行RollBack,也可以通過設置來取消RollBack
	// @Transactional(propagation = Propagation.REQUIRES_NEW, isolation =
	// Isolation.READ_COMMITTED, noRollbackFor = {
	// UserAccountException.class })

	// (四)Transactional使用readOnly,可以省去寫入的部分優化執行的效率(不會更新數據就只是看看而已)
	// 應設置 readOnly=true
	// (五)Transactional的timeout指的是在開始執行該方法到完成或碰上例外事件之前最多可以占用多常時間單位為秒
	// 即使該方法未丟出例外事件,Transactional會因為該時間內無法完成而Rollback
	@Transactional(propagation = Propagation.REQUIRED,
			         isolation = Isolation.READ_COMMITTED,
			          readOnly = false,
			           timeout = 3)

	@Override
	public void purchase(String username, String isbn) {
		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e) { }
		// 1.先取得書的單價
		int price = bookShopDAO.findBookPriceByIsbn(isbn);
		// 2.更新書的庫存
		bookShopDAO.updateBookStock(isbn);
		// 3.更新用戶的餘額
		bookShopDAO.updateUserAccount(username, price);
	}

}
